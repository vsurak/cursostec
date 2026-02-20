-- las tablas temporales nos permiten trabajar con datos copiados, 
-- entonce eso nos ayuda mucho a reducir deadlocks y 
-- bloqueos de información innecesarios
-- las puedo tener en @memoria, para cosas pequeñas, como si necesitara un array de unos cuantos
-- registros, digamos máximo cercano a los 1000-2000 registros
-- si se necesita más tamaño, entonces mejor en #disco

-- las temporales son al session, o la conexión
-- eso quiere decir que si Pedro y Ana se conectan a la base de datos y crean
-- #MiTablaDeVentas, Pedro va a ver esta tabla con los datos que en su sesión se hayan cargado,
-- y Ana va a ver su propia versión de esa tabla hasta que se desconecten
-- OJOOOO si uno pool de conexiones, porque entonces no se eliminan las tablas.
-- en caso de usar pool hay que hacer un delete del table manualmente


-- Tabla Temporal Física
CREATE TABLE #tempNames (
    ID INT PRIMARY KEY,
    Nombre VARCHAR(50)
);

INSERT INTO #tempNames VALUES (1, 'Rodrigo'), (2, 'Carlos');

SELECT * FROM #tempNames;

DROP TABLE #tempNames; -- Se elimina cuando ya no se necesita

-- Tabla Temporal en Memoria
DECLARE @tableVariable TABLE (
    ID INT PRIMARY KEY,
    Nombre VARCHAR(50)
);

INSERT INTO @tableVariable VALUES (1, 'Ana'), (2, 'Luis');

SELECT * FROM @tableVariable;

-- los TVP son tablas en memoria 

select * from dbo.fut_matches


SELECT 
    matchid,
    caption,
    homeid,
    visitorid,
    homegoals,
    visitorgoals,
    (homegoals + visitorgoals) AS total_goals,
    RANK() OVER (ORDER BY (homegoals + visitorgoals) DESC) AS rank_position
FROM dbo.fut_matches;

SELECT 
    matchid,
    caption,
    homeid,
    visitorid,
    homegoals,
    visitorgoals,
    (homegoals + visitorgoals) AS total_goals,
    DENSE_RANK() OVER (ORDER BY (homegoals + visitorgoals) DESC) AS rank_position
FROM dbo.fut_matches;

-- ranking de los mejores partidos de un equipo como visitante
SELECT 
    matchid,
    caption,
    teamshome.teamname
    homegoals,
    visitorgoals,
    RANK() OVER (PARTITION BY matches.homeid ORDER BY visitorgoals DESC) AS home_team_rank
FROM dbo.fut_matches matches
inner join dbo.fut_teams teams on matches.visitorid = teams.teamid 
inner join dbo.fut_teams teamshome on matches.homeid = teamshome.teamid 
WHERE teams.teamname = 'LigaYY'

select * from dbo.caipi_users
where name ='johndoe' --> S1, linear search

select * from dbo.caipi_users
where userid = 3 --> S2, binary search por ser clustered y 3 registros
-- salvo que sean muchos registros, donde muchos es un parámetro estadístico de la base de datos


3 registros

3/2 = 1, pivot, lo puede físicamente porque hay un índice clustered y todo está ordenado físcamente



