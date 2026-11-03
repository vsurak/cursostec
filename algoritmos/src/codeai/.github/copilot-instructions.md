# Copilot project instructions

Write C or C++ only. C++ targets the standard declared in `CMakeLists.txt` (default C++17); C targets C11.

Each feature lives in `src/<feature-slug>/`: a header (`.hpp` for C++, `.h` for C), an implementation file, and `main.cpp` or `main.c` as the entrypoint. Tests live in `tests/<feature-slug>/`.
The entrypoint only reads input, calls the algorithm functions, and prints output. Algorithms never read or print.
Use the standard library containers before writing a custom data structure; write one only when the spec defines it.
C++: types `PascalCase`; functions, methods, and variables `snake_case`; constants `UPPER_SNAKE_CASE`; own memory with RAII.
C: structs `snake_case_t`; public functions prefixed with the module name; every allocation checked and freed; arrays passed with their length.
Pick integer types from the problem's N so sums and products cannot overflow. Compile clean with `-Wall -Wextra`.
Prefer the standard library. Add a dependency only when the standard library cannot do the job.

For the spec-driven execution flow and the project maps, follow the repository instructions under `.github/instructions/`.
