#include <cassert>
#include <chrono>
#include <cstdint>
#include <fstream>
#include <iostream>
#include <map>
#include <random>
#include <stdexcept>
#include <string>
#include <vector>

#include "engine/taxi_loader.hpp"

static const char* HEADER =
    "VendorID,tpep_pickup_datetime,tpep_dropoff_datetime,passenger_count,trip_distance,"
    "RatecodeID,store_and_fwd_flag,PULocationID,DOLocationID,payment_type,fare_amount,extra,"
    "mta_tax,tip_amount,tolls_amount,improvement_surcharge,total_amount,congestion_surcharge";
static const char* ROW1 =
    "1,01/01/2020 12:28:15 AM,01/01/2020 12:33:03 AM,1,1.2,1,N,238,239,1,6,3,0.5,1.47,0,0.3,11.27,2.5";
static const char* ROW2 =
    "1,01/01/2020 12:35:39 AM,01/01/2020 12:43:04 AM,1,1.2,1,N,239,238,1,7,3,0.5,1.5,0,0.3,12.3,2.5";
static const char* ROW3 =
    "1,01/01/2020 12:47:41 AM,01/01/2020 12:53:52 AM,1,0.6,1,N,238,238,1,6,3,0.5,1,0,0.3,10.8,2.5";

static std::string write_file(const std::string& name, const std::vector<std::string>& lines) {
    std::ofstream f(name, std::ios::binary);
    for (const std::string& l : lines) f << l << '\n';
    return name;
}

static std::string row_with_do(int do_id) {
    return "2,03/15/2020 01:10:00 PM,03/15/2020 01:20:00 PM,2,3.5,1,N,100," + std::to_string(do_id) +
           ",1,10,0.5,0.5,1,0,0.3,12.3,2.5";
}

static void returns_empty_table_when_only_header() {
    LoadStats s;
    auto t = load_taxi_by_do_location(write_file("t_header.csv", {HEADER}), s);
    assert(t.size() == 0);
    assert(s.rows_read_ == 0 && s.rows_loaded_ == 0 && s.rows_skipped_ == 0);
}

static void throws_when_file_is_missing() {
    LoadStats s;
    bool thrown = false;
    try {
        load_taxi_by_do_location("no_such_file.csv", s);
    } catch (const std::runtime_error&) {
        thrown = true;
    }
    assert(thrown);
}

static void groups_sample_rows_by_do_location_in_file_order() {
    LoadStats s;
    auto t = load_taxi_by_do_location(write_file("t_sample.csv", {HEADER, ROW1, ROW2, ROW3}), s);
    assert(t.size() == 2);
    assert(t.find(238)->size() == 2);
    assert(t.find(239)->size() == 1);
    assert((*t.find(238))[0].pu_location_id_ == 239);
    assert((*t.find(238))[1].pu_location_id_ == 238);
    assert(s.rows_read_ == 3 && s.rows_loaded_ == 3 && s.rows_skipped_ == 0);
}

static void parses_first_sample_line_fields() {
    TaxiRecord r;
    assert(parse_taxi_line(ROW1, r));
    assert(r.do_location_id_ == 239);
    assert(r.pu_location_id_ == 238);
    assert(r.trip_distance_ == 1.2);
    assert(r.total_amount_ == 11.27);
    assert(r.pickup_datetime_ == 1577838495);
    assert(r.store_and_fwd_flag_ == 'N');
}

static void converts_12_hour_clock_correctly() {
    TaxiRecord r;
    assert(parse_taxi_line("1,01/01/2020 12:00:00 AM,01/01/2020 12:00:00 PM,1,1,1,N,1,2,1,1,0,0,0,0,0,1,0", r));
    assert(r.pickup_datetime_ == 1577836800);
    assert(r.dropoff_datetime_ == 1577836800 + 12 * 3600);
    assert(parse_taxi_line("1,01/01/2020 01:00:00 PM,01/01/2020 01:00:00 PM,1,1,1,N,1,2,1,1,0,0,0,0,0,1,0", r));
    assert(r.pickup_datetime_ == 1577836800 + 13 * 3600);
}

static void empty_numeric_fields_become_zero() {
    TaxiRecord r;
    assert(parse_taxi_line("1,01/01/2020 12:28:15 AM,01/01/2020 12:33:03 AM,,1.2,,,238,239,1,6,3,0.5,1.47,0,0.3,11.27,", r));
    assert(r.passenger_count_ == 0);
    assert(r.congestion_surcharge_ == 0.0);
    assert(r.store_and_fwd_flag_ == '\0');
}

static void skips_malformed_lines() {
    TaxiRecord r;
    assert(!parse_taxi_line("1,2,3", r));
    LoadStats s;
    const std::string empty_do =
        "1,01/01/2020 12:28:15 AM,01/01/2020 12:33:03 AM,1,1.2,1,N,238,,1,6,3,0.5,1.47,0,0.3,11.27,2.5";
    const std::string bad_do =
        "1,01/01/2020 12:28:15 AM,01/01/2020 12:33:03 AM,1,1.2,1,N,238,abc,1,6,3,0.5,1.47,0,0.3,11.27,2.5";
    const std::string seventeen = "1,01/01/2020 12:28:15 AM,01/01/2020 12:33:03 AM,1,1.2,1,N,238,239,1,6,3,0.5,1.47,0,0.3,11.27";
    auto t = load_taxi_by_do_location(write_file("t_bad.csv", {HEADER, ROW1, empty_do, bad_do, seventeen}), s);
    assert(t.size() == 1);
    assert(s.rows_read_ == 4 && s.rows_loaded_ == 1 && s.rows_skipped_ == 3);
    assert(s.rows_read_ == s.rows_loaded_ + s.rows_skipped_);
}

static void stores_duplicates_under_same_key() {
    LoadStats s;
    auto t = load_taxi_by_do_location(write_file("t_dup.csv", {HEADER, ROW1, ROW1}), s);
    assert(t.size() == 1 && t.find(239)->size() == 2);
}

static void matches_unordered_count_on_random_input() {
    std::mt19937 rng(12345);
    std::vector<std::string> lines{HEADER};
    std::map<int, std::size_t> expected;
    for (int i = 0; i < 5000; ++i) {
        int id = static_cast<int>(rng() % 265) + 1;
        lines.push_back(row_with_do(id));
        ++expected[id];
    }
    LoadStats s;
    auto t = load_taxi_by_do_location(write_file("t_rand.csv", lines), s);
    assert(t.size() == expected.size());
    std::size_t total = 0;
    for (const auto& kv : expected) {
        const auto* g = t.find(kv.first);
        assert(g != nullptr && g->size() == kv.second);
        for (const TaxiRecord& r : *g) assert(r.do_location_id_ == kv.first);
        total += g->size();
    }
    assert(total == s.rows_loaded_);
}

static void loads_real_file_within_time_limit() {
    const std::string path = "C:\\Users\\rodri\\Downloads\\Taxi Datset.csv";
    if (!std::ifstream(path).good()) {
        std::cout << "  (skipped: real file not found)\n";
        return;
    }
    const auto t0 = std::chrono::steady_clock::now();
    LoadStats s;
    auto t = load_taxi_by_do_location(path, s);
    const auto sec = std::chrono::duration_cast<std::chrono::seconds>(std::chrono::steady_clock::now() - t0).count();
    std::cout << "  real file: read=" << s.rows_read_ << " loaded=" << s.rows_loaded_
              << " skipped=" << s.rows_skipped_ << " keys=" << t.size() << " seconds=" << sec << "\n";
    assert(s.rows_read_ == s.rows_loaded_ + s.rows_skipped_);
    assert(sec <= 60);
}

int main(int argc, char** argv) {
    returns_empty_table_when_only_header();
    throws_when_file_is_missing();
    groups_sample_rows_by_do_location_in_file_order();
    parses_first_sample_line_fields();
    converts_12_hour_clock_correctly();
    empty_numeric_fields_become_zero();
    skips_malformed_lines();
    stores_duplicates_under_same_key();
    matches_unordered_count_on_random_input();
    // The max-N test is slow under sanitizers; run it with `test_taxi_loader --max`.
    if (argc > 1 && std::string(argv[1]) == "--max") loads_real_file_within_time_limit();
    std::cout << "test_taxi_loader: OK\n";
    return 0;
}
