{{ config(materialized='table') }}

{% macro dbt_utils() %}
  {{ adapter.dispatch('dbt_utils.include') }}
{% endmacro %}
{{ dbt_utils() }}

with splitedweapons as (
  select
    ships.shipid,
    ussships.weapons,
    {% adapter.split(weapon, ':')[1] %} as weapontype,
    {% adapter.split(weapon, ':')[2] %} as quantity,
    from {{ source('dbo', 'uss_ships') }} as ussships
    inner join {{ ref('starships') }} ships on ussships.ship = ships.ship
    inner join STRING_SPLIT(ussships.weapons, ',') as weapon
)


select
  row_number() over () as weaponid,
  shipid,
  weapontype,
  quantity::int
from splitedweapons;