#include <chrono>
#include <exception>
#include <string>
#include <vector>

#include "engine/taxi_loader.hpp"
#include "logs/logger.hpp"

int main(int argc, char** argv) {
    const std::string path =
        argc > 1 ? argv[1] : "C:\\Users\\rodri\\Downloads\\Taxi Datset.csv";
    try {
        log_info("loading " + path);
        const auto t0 = std::chrono::steady_clock::now();
        LoadStats stats;
        auto table = load_taxi_by_do_location(path, stats);
        const auto ms = std::chrono::duration_cast<std::chrono::milliseconds>(
                            std::chrono::steady_clock::now() - t0).count();
        log_info("rows read: " + std::to_string(stats.rows_read_));
        log_info("rows loaded: " + std::to_string(stats.rows_loaded_));
        log_info("rows skipped: " + std::to_string(stats.rows_skipped_));
        log_info("DOLocationID keys: " + std::to_string(table.size()));
        log_info("elapsed ms: " + std::to_string(ms));
    } catch (const std::exception& e) {
        log_error(e.what());
        return 1;
    }
    return 0;
}
