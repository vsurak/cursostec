
{{ config(materialized='table') }}

with shipsdata as (
  select
    row_number() over (order by ship) as shipid,
    ship
  from dbo.uss_ships
)

select
  shipid,
  ship
from shipsdata;
