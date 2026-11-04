#pragma once
#include <cstddef>

// Invariant: rows_read_ == rows_loaded_ + rows_skipped_
struct LoadStats {
    std::size_t rows_read_ = 0;
    std::size_t rows_loaded_ = 0;
    std::size_t rows_skipped_ = 0;
};
