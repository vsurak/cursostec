#pragma once
#include <cstddef>
#include <cstdint>
#include <utility>
#include <vector>

// Hashtable with int32 keys and separate chaining.
// Invariants: each key appears once; size_ <= 0.75 * buckets_.size() after any insert.
template <typename V>
class HashTable {
public:
    HashTable() : buckets_(INITIAL_BUCKETS), size_(0) {}

    // Returns the value of `key`, creating a default one when absent.
    // The reference is valid until the next get_or_create.
    V& get_or_create(int32_t key) {
        std::size_t i = index_of(key, buckets_.size());
        for (Entry& e : buckets_[i]) {
            if (e.key_ == key) return e.value_;
        }
        if ((size_ + 1) * 4 > buckets_.size() * 3) {
            rehash();
            i = index_of(key, buckets_.size());
        }
        buckets_[i].push_back(Entry{key, V{}});
        ++size_;
        return buckets_[i].back().value_;
    }

    const V* find(int32_t key) const {
        const std::vector<Entry>& chain = buckets_[index_of(key, buckets_.size())];
        for (const Entry& e : chain) {
            if (e.key_ == key) return &e.value_;
        }
        return nullptr;
    }

    std::size_t size() const { return size_; }

    template <class F>
    void for_each(F f) const {
        for (const std::vector<Entry>& chain : buckets_) {
            for (const Entry& e : chain) f(e.key_, e.value_);
        }
    }

private:
    struct Entry {
        int32_t key_;
        V value_;
    };
    static constexpr std::size_t INITIAL_BUCKETS = 512;

    static std::size_t index_of(int32_t key, std::size_t bucket_count) {
        uint32_t h = static_cast<uint32_t>(key) * 2654435761u;
        return static_cast<std::size_t>(h) & (bucket_count - 1);
    }

    void rehash() {
        std::size_t new_size = buckets_.size() * 2;
        std::vector<std::vector<Entry>> next(new_size);
        for (std::vector<Entry>& chain : buckets_) {
            for (Entry& e : chain) {
                next[index_of(e.key_, new_size)].push_back(std::move(e));
            }
        }
        buckets_ = std::move(next);
    }

    std::vector<std::vector<Entry>> buckets_;
    std::size_t size_;
};
