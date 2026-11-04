---
id: ft-1
language: C++ (C++17)
status: approved  
---

# Load taxi records into a hashtable grouped by DOLocationID

## General description

- Reads `C:\Users\rodri\Downloads\Taxi Datset.csv` (NYC taxi trips, header + data rows) and loads every record in memory.
- Records are stored in a custom hashtable: key = `DOLocationID` (int), value = all `TaxiRecord`s with that key, in file order.
- hashtable name: tripHash

## Problem size (N)

- N = data rows in the CSV (header excluded). Measured: file is 1,161,502,791 bytes, 11,916,668 lines -> N ≈ 11.9M. Assume max N = 15,000,000.
- K = distinct `DOLocationID` keys. Expected ≤ ~265 (TLC zones); the table must still work for any `int32` key (K ≤ N).
- Element ranges: `DOLocationID` 1..265 (int32 used), `passenger_count` 0..9, money fields small decimals (double), timestamps `MM/DD/YYYY hh:mm:ss AM|PM` (2001..2030 -> int64 epoch seconds, no overflow).
- Input arrives as: text file read line by line (`std::ifstream`, `std::string`), 18 comma-separated columns, no quoted fields. Some fields can be empty (e.g. `passenger_count`, `RatecodeID`, `congestion_surcharge`).
- Target: O(N) time, single pass over the file; table operations O(1) average. Parsing-bound.
- Memory: `sizeof(TaxiRecord)` = 112 bytes after padding -> ~1.3 GB for 11.9M, ~1.7 GB at 15M. Requires a 64-bit build. Per-key `std::vector` growth can transiently need up to 2x of the largest group; accepted.
- The strategy fits max N: one pass, no sorting, no nested scans.

## Data structures

### TaxiRecord (in `model/taxi_record.hpp`)

```cpp
struct TaxiRecord {
    int64_t pickup_datetime_;        // epoch seconds (UTC, no time zone applied)
    int64_t dropoff_datetime_;
    double  trip_distance_;
    double  fare_amount_;
    double  extra_;
    double  mta_tax_;
    double  tip_amount_;
    double  tolls_amount_;
    double  improvement_surcharge_;
    double  total_amount_;
    double  congestion_surcharge_;
    int32_t pu_location_id_;
    int32_t do_location_id_;         // hashtable key
    int16_t vendor_id_;
    int16_t passenger_count_;
    int16_t ratecode_id_;
    int16_t payment_type_;
    char    store_and_fwd_flag_;     // 'Y' | 'N' | '\0' when empty
};
```

- One field per CSV column, same order as the header. Empty numeric field -> 0; empty flag -> `'\0'`.
- Invariant: `do_location_id_` equals the key of the bucket entry that holds the record.

### HashTable (in `utils/hash_table.hpp`, template `HashTable<V>`, key `int32_t`)

```cpp
template <typename V>
class HashTable {
    struct Entry { int32_t key_; V value_; };
    std::vector<std::vector<Entry>> buckets_;  // separate chaining; size is a power of two
    std::size_t size_;                         // number of distinct keys
};
```

- Initial bucket count 512 (power of two); index = `hash(key) & (buckets_.size() - 1)` with `hash(k) = (uint32_t)k * 2654435761u`.
- Invariants: each key appears at most once; `size_ / buckets_.size() <= 0.75` after any insert (rehash doubles the bucket count).
- Operations:
  - `V& get_or_create(int32_t key)` — O(1) average, inserts a default `V` if missing.
  - `const V* find(int32_t key) const` — O(1) average, `nullptr` if missing.
  - `std::size_t size() const` — O(1).
  - `template <class F> void for_each(F f) const` — O(buckets + K).

### Group value: `std::vector<TaxiRecord>`

- Holds all records of one key in file order. `push_back` O(1) amortized.
- The table type is `HashTable<std::vector<TaxiRecord>>`.

## Methods

### `loadTaxiTrips`  (engine/loadTaxiTrips.hpp)

**Signature:** `bool loadTaxiTrips(const std::string& line, TaxiRecord& out);`

**Strategy:** single left-to-right scan splitting on `,` into 18 fields, converting each field in place; O(L) per line, L = line length (~100 chars).

**Input / Output:** receives one CSV data line; fills `out` and returns `true`, or returns `false` for a malformed line. Precondition: line is not the header.

**Complexity:** time O(L), space O(1).

**Steps:**
1. Split `line` into 18 `std::string_view` fields by scanning for `,`. If fewer or more than 18 fields -> return `false`.
2. For integer columns (`VendorID`, `passenger_count`, `RatecodeID`, `PULocationID`, `DOLocationID`, `payment_type`): empty -> 0; otherwise `std::from_chars`; on error return `false`.
3. For double columns (`trip_distance`, `fare_amount`, `extra`, `mta_tax`, `tip_amount`, `tolls_amount`, `improvement_surcharge`, `total_amount`, `congestion_surcharge`): empty -> 0.0; otherwise `std::strtod` on a copy of the field; on error return `false`.
4. `store_and_fwd_flag_` = first char of field 7, or `'\0'` if empty.
5. For both datetime fields call `parse_datetime("MM/DD/YYYY hh:mm:ss AM|PM")`: extract month, day, year, hour (1..12), minute, second, meridiem; convert hour to 24h (12 AM -> 0, 12 PM -> 12, PM adds 12 otherwise); compute days since 1970-01-01 with the civil-from-days formula; epoch = days*86400 + h*3600 + m*60 + s. Invalid format or out-of-range part -> return `false`.
6. Return `true`.

### `load_taxi_by_do_location`  (engine/taxi_loader.hpp)

**Signature:** `HashTable<std::vector<TaxiRecord>> load_taxi_by_do_location(const std::string& csv_path, LoadStats& stats);`

**Strategy:** one streaming pass; for each parsed record, `get_or_create(do_location_id_)` and `push_back` -> grouping by key in O(1) per row, O(N) total.

**Input / Output:** receives the CSV path; returns the filled table and fills `stats`. Precondition: file exists. Throws `std::runtime_error` if the file cannot be opened.

**Complexity:** time O(N · L) (parsing) with O(1) per table operation; space O(N) records + O(K) buckets.

**Steps:**
1. Open `csv_path` with `std::ifstream` (binary mode, 1 MB read buffer via `rdbuf()->pubsetbuf`). If not open -> throw `std::runtime_error`.
2. Initialize `table` as empty `HashTable<std::vector<TaxiRecord>>` and `stats = {0,0,0}`.
3. Read the first line (header) and discard it. If the file is empty, return the empty table.
4. While `std::getline(file, line)` succeeds:
   1. Remove a trailing `'\r'` if present; if the line is empty, continue (not counted).
   2. `stats.rows_read_++`.
   3. If `parse_taxi_line(line, rec)` is `false` -> `stats.rows_skipped_++`, continue.
   4. If `rec.do_location_id_ <= 0` -> `stats.rows_skipped_++`, continue.
   5. `table.get_or_create(rec.do_location_id_).push_back(rec)`; `stats.rows_loaded_++`.
5. Close the file (RAII) and return `table`.

### `HashTable::get_or_create`  (utils/hash_table.hpp)

**Signature:** `V& get_or_create(int32_t key);`

**Strategy:** separate chaining with load-factor-triggered doubling keeps chains O(1) average.

**Input / Output:** receives a key; returns a reference to the value of that key (created when absent). The reference is valid until the next `get_or_create` (rehash may move entries).

**Complexity:** O(1) average, O(K) on rehash (amortized O(1)); space O(K).

**Steps:**
1. Compute `i = hash(key) & (buckets_.size() - 1)`.
2. Scan `buckets_[i]`; if an entry with `key_ == key` exists, return `entry.value_`.
3. If `(size_ + 1) > 0.75 * buckets_.size()`: rehash — allocate `2 * buckets_.size()` empty buckets, move each entry to `hash(key_) & (new_size - 1)`, replace `buckets_`; recompute `i`.
4. Append `Entry{key, V{}}` to `buckets_[i]`, `size_++`.
5. Return `buckets_[i].back().value_`.

## Test criteria

- Empty file (only header) -> table `size() == 0`, `stats` = {0,0,0}.
- Missing file -> throws `std::runtime_error`.
- Sample (first lines of the dataset): rows with DOLocationID 239, 238, 238 -> table has 2 keys; `find(238)->size() == 2`, `find(239)->size() == 1`; records in file order.
- `parse_taxi_line("1,01/01/2020 12:28:15 AM,01/01/2020 12:33:03 AM,1,1.2,1,N,238,239,1,6,3,0.5,1.47,0,0.3,11.27,2.5", r)` -> true; `r.do_location_id_ == 239`, `pu_location_id_ == 238`, `trip_distance_ == 1.2`, `total_amount_ == 11.27`, `pickup_datetime_ == 1577838495` (2020-01-01 00:28:15).
- Datetime: `12:00:00 AM` -> hour 0; `12:00:00 PM` -> hour 12; `01:00:00 PM` -> hour 13.
- Empty `passenger_count` and `congestion_surcharge` -> loaded with 0; line with 17 fields, non-numeric DOLocationID, or empty DOLocationID -> skipped (`stats.rows_skipped_` incremented).
- Duplicates: same record twice -> both stored under the same key.
- `stats.rows_read_ == rows_loaded_ + rows_skipped_` always; sum of all group sizes == `rows_loaded_`; every record in group k has `do_location_id_ == k`.
- HashTable: insert 10,000 distinct keys (forces several rehashes) -> `size() == 10000` and every key is found; negative and zero keys work; `find` of a missing key returns `nullptr`.
- Randomized (seed fixed): generate a CSV with random DOLocationID in 1..265; compare group sizes with a `std::unordered_map<int, size_t>` count.
- Max N: loading the real file (N ≈ 11.9M) finishes within 60 s with `-O2`, no crash, `rows_loaded_` equals the line count - 1 minus skipped.

## Implementation guidelines

- Language: C++17, `-Wall -Wextra`, no `using namespace std;` in headers, `#pragma once`, RAII only (no `new`/`delete`), types `PascalCase`, functions/variables `snake_case`, member fields end with `_`, constants `UPPER_SNAKE_CASE`.
- Layout follows `CLAUDE.md` (it prevails over the generic `src/<feature>` rule in `.claude/rules/cpp-conventions.md`). Files to create:
  - `model/taxi_record.hpp`, `model/load_stats.hpp`
  - `utils/hash_table.hpp` (header-only template)
  - `engine/taxi_loader.hpp`, `engine/taxi_loader.cpp`
  - `logs/logger.hpp` (console log of flow and errors) used by `taxi.cpp` only; algorithms neither read nor print.
  - `taxi.cpp` (root entrypoint): takes the CSV path from `argv[1]`, default `C:\Users\rodri\Downloads\Taxi Datset.csv`; calls the loader, prints rows read/loaded/skipped, number of keys and elapsed time.
  - `makefile` (root) with targets `all`, `test`, `clean`; `.vscode/tasks.json` and `.vscode/settings.json` to run from VS Code.
  - Tests in `tests/ft-1-load-taxi-by-dolocation/`: `test_hash_table.cpp`, `test_taxi_loader.cpp` (plain `<cassert>` with a `main`, small CSV fixtures written to a temp file; the max-N test reads the real file and is skipped when the file is missing).
- Build: `g++ -std=c++17 -O2 -Wall -Wextra taxi.cpp engine/taxi_loader.cpp -o taxi`; 64-bit toolchain required.
- Tests: `g++ -std=c++17 -Wall -Wextra -g -fsanitize=address,undefined engine/taxi_loader.cpp tests/ft-1-load-taxi-by-dolocation/test_taxi_loader.cpp -o test_taxi_loader`, then run each `test_*` binary (non-zero exit = failure). Run the max-N test without sanitizers.
- Do not add the dataset to git (`data/` holds downloaded files).
