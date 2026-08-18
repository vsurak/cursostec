#include <iostream>
#include <chrono>
#include <algorithm>
#include <cstdlib>
#include <ctime>

class Searcher {
public:
    Searcher(int* pData, int pSize) : data(pData), size(pSize) {}

    int linearSearch(int key) {
        auto start = std::chrono::high_resolution_clock::now();

        int foundIndex = -1;
        for (int i = 0; i < size; ++i) {
            if (data[i] == key) {
                foundIndex = i;
                break;
            }
        }

        auto end = std::chrono::high_resolution_clock::now();
        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();

        std::cout << "[Linear Search] "
                  << "Time: " << duration << " ns, "
                  << "Found: " << (foundIndex != -1 ? "yes" : "no") << ", "
                  << "Index: " << foundIndex << std::endl;

        return foundIndex;
    }

    int binarySearch(int key) {
        auto start = std::chrono::high_resolution_clock::now();

        int foundIndex = -1;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == key) {
                foundIndex = mid;
                break;
            } else if (data[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        auto end = std::chrono::high_resolution_clock::now();
        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();

        std::cout << "[Binary Search]  "
                  << "Time: " << duration << " ns, "
                  << "Found: " << (foundIndex != -1 ? "yes" : "no") << ", "
                  << "Index: " << foundIndex << std::endl;

        return foundIndex;
    }

private:
    int* data;
    int size;
};

int main() {
    const int SIZE = 100;
    int numbers[SIZE];

    std::srand(static_cast<unsigned int>(std::time(nullptr)));
    for (int i = 0; i < SIZE; ++i) {
        numbers[i] = std::rand() % 1000;
    }

    // Binary search requires a sorted array.
    std::sort(numbers, numbers + SIZE);

    int keyIndex = SIZE / 3;
    int key = numbers[keyIndex];

    std::cout << "Searching for key: " << key << " (known at index " << keyIndex << ")" << std::endl;

    Searcher searcher(numbers, SIZE);
    searcher.linearSearch(key);
    searcher.binarySearch(key);

    return 0;
}
