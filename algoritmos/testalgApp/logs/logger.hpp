#pragma once
#include <iostream>
#include <string>

inline void log_info(const std::string& msg) { std::cout << "[INFO] " << msg << '\n'; }
inline void log_error(const std::string& msg) { std::cerr << "[ERROR] " << msg << '\n'; }
