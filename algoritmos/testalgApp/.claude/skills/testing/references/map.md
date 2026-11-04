# Testing

After you change this area, update this file so the next run stays current.

Tests: `tests/ft-1-load-taxi-by-dolocation/`

## Test files
- ft-1 `test_hash_table.cpp` — empty table, same key reuse, zero/negative keys, 10,000 keys across rehashes, `for_each`
- ft-1 `test_taxi_loader.cpp` — header-only file, missing file, sample grouping and order, field/epoch parsing, 12h clock, empty fields, malformed rows, duplicates, randomized count vs `std::map` (seed 12345), real file at max N (only with `--max`, limit 60 s; real run: 11.9M rows, 30 s)

## Commands
- With g++: `make test`
- With MSVC (after `vcvars64.bat`): `cl /EHsc /W4 /std:c++17 /I. /fsanitize=address /Zi tests\ft-1-load-taxi-by-dolocation\test_hash_table.cpp` and `cl ... engine\taxi_loader.cpp tests\ft-1-load-taxi-by-dolocation\test_taxi_loader.cpp`, then run the `.exe`
- Max-N: build with `/O2` (no sanitizer), run `test_taxi_loader --max`
