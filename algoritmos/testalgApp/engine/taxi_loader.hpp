#pragma once
#include <string>
#include <vector>

#include "model/load_stats.hpp"
#include "model/taxi_record.hpp"
#include "utils/hash_table.hpp"

// Parses one CSV data line (18 columns). Returns false when malformed.
bool parse_taxi_line(const std::string& line, TaxiRecord& out);

// Loads the whole CSV grouped by DOLocationID. Throws std::runtime_error if the file cannot be opened.
HashTable<std::vector<TaxiRecord>> load_taxi_by_do_location(const std::string& csv_path, LoadStats& stats);
