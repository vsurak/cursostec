#include <cassert>
#include <cstdint>
#include <iostream>
#include <vector>

#include "utils/hash_table.hpp"

static void returns_empty_when_nothing_inserted() {
    HashTable<int> t;
    assert(t.size() == 0);
    assert(t.find(1) == nullptr);
}

static void get_or_create_returns_same_value_for_same_key() {
    HashTable<std::vector<int>> t;
    t.get_or_create(5).push_back(1);
    t.get_or_create(5).push_back(2);
    assert(t.size() == 1);
    assert(t.find(5)->size() == 2);
}

static void handles_zero_and_negative_keys() {
    HashTable<int> t;
    t.get_or_create(0) = 10;
    t.get_or_create(-7) = 20;
    assert(*t.find(0) == 10);
    assert(*t.find(-7) == 20);
    assert(t.find(7) == nullptr);
}

static void survives_many_rehashes() {
    HashTable<int> t;
    for (int32_t k = 0; k < 10000; ++k) t.get_or_create(k) = k * 2;
    assert(t.size() == 10000);
    for (int32_t k = 0; k < 10000; ++k) {
        const int* v = t.find(k);
        assert(v != nullptr && *v == k * 2);
    }
    std::size_t visited = 0;
    t.for_each([&](int32_t, const int&) { ++visited; });
    assert(visited == 10000);
}

int main() {
    returns_empty_when_nothing_inserted();
    get_or_create_returns_same_value_for_same_key();
    handles_zero_and_negative_keys();
    survives_many_rehashes();
    std::cout << "test_hash_table: OK\n";
    return 0;
}
