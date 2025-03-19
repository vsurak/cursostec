use petsdb;

-- DDL: definition language, alter table
ALTER TABLE pets_visits 
CHANGE COLUMN startime starttime DATETIME;

-- fields projection, en el projection puedo renombrar los campos
select starttime, description, vetname, `condition` from pets_visits;

-- renombrando el nombre de las columnas
select starttime inicio, description descripcion, vetname veterinaria, `condition` salud from pets_visits;

select starttime inicio, MONTHNAME(starttime), DAYNAME(starttime),
description descripcion, vetname veterinaria, `condition` salud from pets_visits;

-- renombrado
select starttime inicio, MONTHNAME(starttime) mes, DAYNAME(starttime) dia,
description descripcion, vetname veterinaria, `condition` salud from pets_visits;


-- este campo artificial que se crea , que no existe en la tabla pero se calcula
-- dinámicamente le llamos "CALCULATED FIELD"
select starttime inicio, MONTHNAME(starttime) mes, DAYNAME(starttime) dia, 
CASE 
	WHEN MONTH(starttime)<4 THEN 'Primer Trimestre' 
    WHEN MONTH(starttime)>3 AND MONTH(starttime)<7  THEN 'Segundo Trimestre' 
    WHEN MONTH(starttime)>6 AND MONTH(starttime)<10  THEN 'Tercer Trimestre' 
    ELSE 'Cuarto Trimestre' 
END AS Trimestre,
description descripcion, vetname veterinaria, `condition` salud from pets_visits;

select starttime inicio, MONTHNAME(starttime) mes, DAYNAME(starttime) dia, 
ELT((CEIL(MONTH(starttime)/3)), 'Primer Trimestre', 'Segundo Trimestre', 'Tercer Trimestre', 'Cuarto Trimestre') as Trimestre,
description descripcion, vetname veterinaria, `condition` salud from pets_visits;

select starttime inicio, MONTHNAME(starttime) mes, DAYNAME(starttime) dia, 
ELT(QUARTER(starttime), 'Primer Trimestre', 'Segundo Trimestre', 'Tercer Trimestre', 'Cuarto Trimestre') as Trimestre,
description descripcion, vetname veterinaria, `condition` salud from pets_visits;

SELECT starttime, TIMESTAMPDIFF(MINUTE,starttime, endtime) TiempoDeConsulta,
vetname veterinaria, `condition` estadoDeLaMascota
FROM pets_visits
INNER JOIN pets_pets ON pets_visits.petid = pets_pets.petid;

SELECT starttime, TIMESTAMPDIFF(MINUTE,starttime, endtime) TiempoDeConsulta,
vetname veterinaria, `condition` estadoDeLaMascota
FROM pets_visits visits
INNER JOIN pets_pets pets ON visits.petid = pets.petid;


SELECT visits.*, pets.*
FROM pets_visits visits
INNER JOIN pets_pets pets ON visits.petid = pets.petid;

-- saco todas las visitas de las mascotas con su respectivo nombre
SELECT starttime, TIMESTAMPDIFF(MINUTE,starttime, endtime) TiempoDeConsulta,
vetname veterinaria, pets.name, pets.race, `condition` estadoDeLaMascota
FROM pets_visits visits
INNER JOIN pets_pets pets ON visits.petid = pets.petid;

-- saco todas las visitas de las mascotas con su respectivo nombre para una mascota especifica
-- en orden de visita
SELECT starttime, TIMESTAMPDIFF(MINUTE,starttime, endtime) TiempoDeConsulta,
vetname veterinaria, pets.name, pets.race, `condition` estadoDeLaMascota
FROM pets_visits visits
INNER JOIN pets_pets pets ON visits.petid = pets.petid
WHERE pets.name = 'Sophie' ORDER BY starttime ASC;

-- saco todas las visitas de las mascotas con su respectivo nombre para una mascota especifica
-- en orden de visita, incluyendo el nombre del dueño
SELECT starttime, TIMESTAMPDIFF(MINUTE,starttime, endtime) TiempoDeConsulta,
vetname veterinaria, pets.name, pets.race, CONCAT(owners.firstname, " ", owners.lastname) dueno, 
`condition` estadoDeLaMascota
FROM pets_visits visits
INNER JOIN pets_pets pets ON visits.petid = pets.petid
INNER JOIN pets_owners owners ON visits.ownerid = owners.ownerid
WHERE pets.name = 'Sophie' ORDER BY starttime ASC;


SELECT COUNT(1) from pets_visits; -- funcion agregada de count
-- se le llaman agregadas porque van agregando datos a subconjuntos 

SELECT MIN(starttime), MAX(starttime), MAX(vetname) from pets_visits; 

-- no quiero ver el total de visitas , si no que quiero saber el total de visitas por mascota, quiero saber cual 
-- es la mascota mas enfermiza
SELECT COUNT(1), petid from pets_visits
group by petid ORDER BY COUNT(1) DESC;

SELECT COUNT(1), pets.name from pets_visits
INNER JOIN pets_pets pets ON pets_visits.petid = pets.petid
group by pets_visits.petid ORDER BY COUNT(1) DESC;

SELECT COUNT(1) visits, pets.name from pets_visits
INNER JOIN pets_pets pets ON pets_visits.petid = pets.petid
group by pets.name ORDER BY COUNT(*) DESC;



