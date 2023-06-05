{{ config(schema='fleets') }}

select ship, weapons from {{ source('federationships', 'uss_ships') }}