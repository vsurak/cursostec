
{{ config(materialized='view') }}

with shipsdata as (
  select
    row_number() over (order by ship) as shipid,
    recordtime as creationdate, 
    getdate() as posttime, 
    ship as [name],
    capacity
  from dbo.uss_ships
)
select
  shipid,
  creationdate,
  posttime,
  [name],
  capacity
from shipsdata;