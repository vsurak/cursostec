{{ config(schema='fleets') }}

select ship, weapons from {{ source('dbo', 'uss_ships') }}
