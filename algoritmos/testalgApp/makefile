CXX       = g++
CXXFLAGS  = -std=c++17 -O2 -Wall -Wextra -I.
TESTDIR   = tests/ft-1-load-taxi-by-dolocation
TESTFLAGS = -std=c++17 -Wall -Wextra -g -fsanitize=address,undefined -I.

all: taxi

taxi: taxi.cpp engine/taxi_loader.cpp
	$(CXX) $(CXXFLAGS) taxi.cpp engine/taxi_loader.cpp -o taxi

test:
	$(CXX) $(TESTFLAGS) $(TESTDIR)/test_hash_table.cpp -o test_hash_table
	$(CXX) $(TESTFLAGS) engine/taxi_loader.cpp $(TESTDIR)/test_taxi_loader.cpp -o test_taxi_loader
	./test_hash_table
	./test_taxi_loader

clean:
	rm -f taxi test_hash_table test_taxi_loader *.exe *.obj
