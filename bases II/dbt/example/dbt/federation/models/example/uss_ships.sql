
with uss_ships as (
    select ship, weapons from {{ source('source_ships', 'uss_ships') }}
)


select * from uss_ships
