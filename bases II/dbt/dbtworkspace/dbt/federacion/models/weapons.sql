{{ config(
  materialized='view',
  depends_on=[
    {'model': 'starships','strategy': 'skip'},
    {'model': 'uss_allships','strategy': 'skip'}
  ]
) }}
with spanweapons as (
  select sships.shipid, 
  weaponssplited.weapontype, 
  CONVERT(INTEGER, weaponssplited.quantity) quantity
  from {{ ref('starships') }} sships
  inner join dbo.uss_ships ships ON ships.ship = sships.name
  cross apply (
    SELECT
        value AS weapon,
        CHARINDEX(':', value) AS colon_position
    FROM
        STRING_SPLIT(ships.weapons, ',')
  ) AS split_weapons
  cross apply (
    SELECT
        SUBSTRING(split_weapons.weapon, 1, split_weapons.colon_position - 1) AS weapontype,
        SUBSTRING(split_weapons.weapon, split_weapons.colon_position + 1, LEN(split_weapons.weapon) - split_weapons.colon_position) AS quantity
  ) AS weaponssplited
)

select
  row_number() over (order by shipid) as weaponid,
  shipid,
  weapontype,
  quantity
from spanweapons;