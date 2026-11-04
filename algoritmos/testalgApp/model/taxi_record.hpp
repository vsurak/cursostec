#pragma once
#include <cstdint>

// One row of the taxi CSV, fields in header order.
struct TaxiRecord {
    int64_t pickup_datetime_ = 0;   // epoch seconds (no time zone applied)
    int64_t dropoff_datetime_ = 0;
    double trip_distance_ = 0.0;
    double fare_amount_ = 0.0;
    double extra_ = 0.0;
    double mta_tax_ = 0.0;
    double tip_amount_ = 0.0;
    double tolls_amount_ = 0.0;
    double improvement_surcharge_ = 0.0;
    double total_amount_ = 0.0;
    double congestion_surcharge_ = 0.0;
    int32_t pu_location_id_ = 0;
    int32_t do_location_id_ = 0;    // hashtable key
    int16_t vendor_id_ = 0;
    int16_t passenger_count_ = 0;
    int16_t ratecode_id_ = 0;
    int16_t payment_type_ = 0;
    char store_and_fwd_flag_ = '\0';  // 'Y' | 'N' | '\0' when empty
};
