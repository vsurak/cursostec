# Data structures

After you change this area, update this file so the next run stays current.

Source: `model/`, `utils/`

## Structures
### TaxiRecord (ft-1)
One CSV row, fields in header order. `model/taxi_record.hpp`
- Fields: `int64_t pickup_datetime_, dropoff_datetime_` (epoch s); `double trip_distance_, fare_amount_, extra_, mta_tax_, tip_amount_, tolls_amount_, improvement_surcharge_, total_amount_, congestion_surcharge_`; `int32_t pu_location_id_, do_location_id_`; `int16_t vendor_id_, passenger_count_, ratecode_id_, payment_type_`; `char store_and_fwd_flag_`
- Invariant: `do_location_id_` equals the key of the group that holds it.

### LoadStats (ft-1)
Load counters. `model/load_stats.hpp`
- Fields: `size_t rows_read_, rows_loaded_, rows_skipped_`
- Invariant: `rows_read_ == rows_loaded_ + rows_skipped_`.

### HashTable<V> (ft-1)
int32-keyed hashtable, separate chaining, doubles buckets at load 0.75. `utils/hash_table.hpp`
- Invariant: each key once; `size_ <= 0.75 * buckets`.
- `V& get_or_create(int32_t key)` — O(1) avg, amortized on rehash
- `const V* find(int32_t key) const` — O(1) avg, `nullptr` if absent
- `size_t size() const` — O(1)
- `template <class F> void for_each(F f) const` — F(key, value); O(buckets + K)
