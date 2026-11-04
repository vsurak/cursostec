#include "engine/taxi_loader.hpp"

#include <charconv>
#include <cstdint>
#include <cstdlib>
#include <fstream>
#include <stdexcept>
#include <string_view>

namespace {

constexpr std::size_t COLUMN_COUNT = 18;
constexpr std::size_t READ_BUFFER_SIZE = 1 << 20;

// Days since 1970-01-01 for a civil date.
int64_t days_from_civil(int64_t y, int m, int d) {
    y -= m <= 2;
    const int64_t era = (y >= 0 ? y : y - 399) / 400;
    const int64_t yoe = y - era * 400;
    const int64_t doy = (153 * (m + (m > 2 ? -3 : 9)) + 2) / 5 + d - 1;
    const int64_t doe = yoe * 365 + yoe / 4 - yoe / 100 + doy;
    return era * 146097 + doe - 719468;
}

bool parse_digits(std::string_view s, int& out) {
    if (s.empty()) return false;
    int v = 0;
    for (char c : s) {
        if (c < '0' || c > '9') return false;
        v = v * 10 + (c - '0');
    }
    out = v;
    return true;
}

// "MM/DD/YYYY hh:mm:ss AM|PM"
bool parse_datetime(std::string_view s, int64_t& out) {
    if (s.size() != 22 || s[2] != '/' || s[5] != '/' || s[10] != ' ' || s[13] != ':' ||
        s[16] != ':' || s[19] != ' ' || s[21] != 'M') {
        return false;
    }
    int mo, d, y, h, mi, sec;
    if (!parse_digits(s.substr(0, 2), mo) || !parse_digits(s.substr(3, 2), d) ||
        !parse_digits(s.substr(6, 4), y) || !parse_digits(s.substr(11, 2), h) ||
        !parse_digits(s.substr(14, 2), mi) || !parse_digits(s.substr(17, 2), sec)) {
        return false;
    }
    const char mer = s[20];
    if ((mer != 'A' && mer != 'P') || mo < 1 || mo > 12 || d < 1 || d > 31 || h < 1 || h > 12 ||
        mi > 59 || sec > 59) {
        return false;
    }
    if (h == 12) h = 0;
    if (mer == 'P') h += 12;
    out = days_from_civil(y, mo, d) * 86400 + h * 3600 + mi * 60 + sec;
    return true;
}

template <typename T>
bool parse_int(std::string_view s, T& out) {
    if (s.empty()) {
        out = 0;
        return true;
    }
    int32_t v = 0;
    auto res = std::from_chars(s.data(), s.data() + s.size(), v);
    if (res.ec != std::errc() || res.ptr != s.data() + s.size()) return false;
    out = static_cast<T>(v);
    return true;
}

bool parse_double(std::string_view s, double& out) {
    if (s.empty()) {
        out = 0.0;
        return true;
    }
    if (s.size() > 31) return false;
    char buf[32];
    for (std::size_t i = 0; i < s.size(); ++i) buf[i] = s[i];
    buf[s.size()] = '\0';
    char* end = nullptr;
    out = std::strtod(buf, &end);
    return end == buf + s.size();
}

}  // namespace

bool parse_taxi_line(const std::string& line, TaxiRecord& out) {
    std::string_view fields[COLUMN_COUNT];
    std::size_t count = 0;
    std::size_t start = 0;
    const std::string_view sv(line);
    for (std::size_t i = 0; i <= sv.size(); ++i) {
        if (i == sv.size() || sv[i] == ',') {
            if (count == COLUMN_COUNT) return false;
            fields[count++] = sv.substr(start, i - start);
            start = i + 1;
        }
    }
    if (count != COLUMN_COUNT) return false;

    TaxiRecord r;
    if (!parse_int(fields[0], r.vendor_id_)) return false;
    if (!parse_datetime(fields[1], r.pickup_datetime_)) return false;
    if (!parse_datetime(fields[2], r.dropoff_datetime_)) return false;
    if (!parse_int(fields[3], r.passenger_count_)) return false;
    if (!parse_double(fields[4], r.trip_distance_)) return false;
    if (!parse_int(fields[5], r.ratecode_id_)) return false;
    r.store_and_fwd_flag_ = fields[6].empty() ? '\0' : fields[6][0];
    if (!parse_int(fields[7], r.pu_location_id_)) return false;
    if (!parse_int(fields[8], r.do_location_id_)) return false;
    if (!parse_int(fields[9], r.payment_type_)) return false;
    if (!parse_double(fields[10], r.fare_amount_)) return false;
    if (!parse_double(fields[11], r.extra_)) return false;
    if (!parse_double(fields[12], r.mta_tax_)) return false;
    if (!parse_double(fields[13], r.tip_amount_)) return false;
    if (!parse_double(fields[14], r.tolls_amount_)) return false;
    if (!parse_double(fields[15], r.improvement_surcharge_)) return false;
    if (!parse_double(fields[16], r.total_amount_)) return false;
    if (!parse_double(fields[17], r.congestion_surcharge_)) return false;
    out = r;
    return true;
}

HashTable<std::vector<TaxiRecord>> load_taxi_by_do_location(const std::string& csv_path, LoadStats& stats) {
    std::vector<char> buffer(READ_BUFFER_SIZE);
    std::ifstream file;
    file.rdbuf()->pubsetbuf(buffer.data(), static_cast<std::streamsize>(buffer.size()));
    file.open(csv_path, std::ios::in | std::ios::binary);
    if (!file.is_open()) throw std::runtime_error("cannot open file: " + csv_path);

    HashTable<std::vector<TaxiRecord>> table;
    stats = LoadStats{};

    std::string line;
    if (!std::getline(file, line)) return table;  // empty file: no header

    TaxiRecord rec;
    while (std::getline(file, line)) {
        if (!line.empty() && line.back() == '\r') line.pop_back();
        if (line.empty()) continue;
        ++stats.rows_read_;
        if (!parse_taxi_line(line, rec) || rec.do_location_id_ <= 0) {
            ++stats.rows_skipped_;
            continue;
        }
        table.get_or_create(rec.do_location_id_).push_back(rec);
        ++stats.rows_loaded_;
    }
    return table;
}
