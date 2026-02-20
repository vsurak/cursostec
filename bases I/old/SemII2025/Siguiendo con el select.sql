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

select * from pets_pets where status = 2;

SELECT AVG(age) AverageDeadAge, pets_pets.race 
FROM pets_pets
WHERE status = 2
GROUP BY race;

ALTER TABLE pets_pets DROP COLUMN racesize;
ALTER TABLE pets_pets ADD COLUMN racesize VARCHAR(10) NOT NULL DEFAULT('Mid');
select * from pets_pets;

ALTER TABLE pets_visits ADD COLUMN checksum VARBINARY(256) DEFAULT(0);
ALTER TABLE pets_visits ADD COLUMN Amount DECIMAL(10,2) DEFAULT(0.0);
select min(visitid), max(visitid) from pets_visits;


DROP PROCEDURE SetMontosCheckSum;
DELIMITER //

CREATE PROCEDURE SetMontosCheckSum()
BEGIN
	SET @visitId = 1001;

	WHILE @visitId > 1 DO

		UPDATE pets_visits set amount = 25000 + ELT(FLOOR(1 + RAND() * 5), 5000, 9000, 12000, 4500, 7000),        
        checksum=SHA2(CONCAT(DATE_FORMAT(starttime, '%Y-%m-%d %H:%i:%s'),DATE_FORMAT(endtime, '%Y-%m-%d %H:%i:%s'), description, ownerid, petid, '6372823rodrigo best database professor ever893838', amount, `condition`, vetname), 512)
        WHERE visitid = @visitId;
        
		SET @visitId = @visitId - 1;
	END WHILE ;
END //

DELIMITER ;

call SetMontosCheckSum();
select * from pets_visits;
update pets_visits set amount = 110000 where visitid = 89;


SELECT * FROM (
	select visitid, vetname, amount, 
	CASE 
		WHEN checksum<>SHA2(CONCAT(DATE_FORMAT(starttime, '%Y-%m-%d %H:%i:%s'),DATE_FORMAT(endtime, '%Y-%m-%d %H:%i:%s'), description, ownerid, petid, amount, `condition`, vetname), 512) THEN 'Invalid'
		ELSE 'Valid'
	END AuditValue
	from pets_visits
) As Result
WHERE AuditValue = 'Invalid';


-- montos por veterinaria por mes del año 2025 ordenados por veterinaria y mes

SELECT vetname, MONTHNAME(starttime) Mes, SUM(amount) montoTotal 
FROM pets_visits
WHERE YEAR(starttime)=2025
GROUP BY vetname, MONTH(starttime), MONTHNAME(starttime) 
ORDER BY vetname, MONTH(starttime), MONTHNAME(starttime);


SELECT VetsPerMonth.vetname, VetsPerMonth.Mes, VetsPerMonth.MontoTotal, totalPerVet.vetTotal,  
(VetsPerMonth.MontoTotal/totalPerVet.vetTotal)*100 PercPerMonth, Total.Total, (totalPerVet.vetTotal/Total.Total)*100 OpePercentage 
FROM 
(
	SELECT vetname, MONTHNAME(starttime) Mes, SUM(amount) montoTotal 
	FROM pets_visits
	WHERE YEAR(starttime)=2025
	GROUP BY vetname, MONTH(starttime), MONTHNAME(starttime) 
) As VetsPerMonth
INNER JOIN (
	SELECT vetname, SUM(amount) vetTotal
	FROM pets_visits
	WHERE YEAR(starttime)=2025
	GROUP BY vetname
) AS totalPerVet ON VetsPerMOnth.vetname = totalPerVet.vetname
INNER JOIN (
	SELECT SUM(amount) Total
	FROM pets_visits
	WHERE YEAR(starttime)=2025
) as Total ON 1=1
ORDER BY vetname, mes, vetTotal DESC;


WITH MonthlySales AS (
    SELECT
        vetname,
        DATE_FORMAT(starttime, '%Y-%m') AS month,
        SUM(Amount) AS monthly_amount
    FROM pets_visits
    WHERE YEAR(starttime) = 2025
    GROUP BY vetname, DATE_FORMAT(starttime, '%Y-%m')
),
VetTotalSales AS (
    SELECT
        vetname,
        SUM(monthly_amount) AS vet_total_amount
    FROM MonthlySales
    GROUP BY vetname
),
OverallTotalSales AS (
    SELECT
        SUM(monthly_amount) AS overall_total_amount
    FROM MonthlySales
)
SELECT
    ms.vetname,
    ms.month,
    ms.monthly_amount,
    ROUND((ms.monthly_amount / vts.vet_total_amount) * 100, 2) AS vet_month_percentage,
    ROUND((ms.monthly_amount / ots.overall_total_amount) * 100, 2) AS overall_month_percentage
FROM MonthlySales ms
JOIN VetTotalSales vts ON ms.vetname = vts.vetname
CROSS JOIN OverallTotalSales ots
ORDER BY ms.vetname, ms.month;


SELECT fut_matches.matchid, fut_matches.matchtime, fut_matches.finishedtime, fut_matches.homeid
FROM  fut_matches, fut_teams visitors, fut_teams homes
WHERE fut_matches.visitorid = visitors.teamid and fut_matches.homeid = homes.teamid  
ORDER BY fut_matches.matchtime

--> lo transforma a un join

SELECT fut_matches.matchid, fut_matches.matchtime, fut_matches.finishedtime, fut_matches.homeid
FROM  fut_matches 
INNER JOIN fut_teams visitors ON fut_matches.visitorid = visitors.teamid
INNER JOIN fut_teams homes ON fut_matches.homeid = homes.teamid 
ORDER BY fut_matches.matchtime


SELECT fut_matches.matchid, fut_matches.matchtime, fut_matches.finishedtime, fut_matches.homeid
FROM  fut_matches 
INNER JOIN fut_teams visitors ON fut_matches.visitorid = visitors.teamid
INNER JOIN fut_teams homes ON fut_matches.homeid = homes.teamid 
WHERE fut_matches.matchid IS NOT NULL
ORDER BY fut_matches.matchtime
