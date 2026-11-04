# Algorithms

After you change this area, update this file so the next run stays current.

Source: `engine/`

## Implemented
- ft-1 Load taxi records grouped by DOLocationID: `engine/taxi_loader.cpp`

## Entrypoints
- `taxi.cpp` (arg 1 = CSV path; default `C:\Users\rodri\Downloads\Taxi Datset.csv`)

## Functions
### load_taxi_by_do_location
Loads the whole CSV into a hashtable keyed by DOLocationID. `engine/taxi_loader.cpp`
- `HashTable<std::vector<TaxiRecord>> load_taxi_by_do_location(const std::string& csv_path, LoadStats& stats)` — single streaming pass, group by key; O(N) time, O(N) space. Throws `std::runtime_error` if the file is missing.
- Uses: `HashTable`, `TaxiRecord`, `LoadStats`

### parse_taxi_line
Parses one 18-column CSV line (dates `MM/DD/YYYY hh:mm:ss AM|PM` to epoch). `engine/taxi_loader.cpp`
- `bool parse_taxi_line(const std::string& line, TaxiRecord& out)` — field split + per-column conversion; O(L) per line
- Uses: `TaxiRecord`
