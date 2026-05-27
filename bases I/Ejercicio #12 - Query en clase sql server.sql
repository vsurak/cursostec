select * from Projects

**Task #3** por medio de inserts validar que los FK son validados, agregar un check que lo vamos a probar con insert o update,
y un default que vamos a probar con un insert. 

-- intentar insertar con un FK que no existe, solo existen clientid 1,2,3
insert into dbo.Projects (ClientId, Name, LotNumber, LocationId, LotSizeM2, ConstructionSizeM2, BudgetCRC)
values (5, 'Residencias del Pacifico', '322', 4, 2300, 320, 200000000)



EXEC sp_rename 'FK__Projects__Client__5070F446', 'FK_Projects_Clients_ClientId', 'OBJECT';

-- De donde salen los nombres de los constraints:
-- Salían de los diagramadores o los scripts que los programadores hacen, cuando uno establece un FK en el diagramador
-- ponerle el nombre con el standard de nombre que tenga definido la compañía en el naming convention. 
-- También podría estarse generando el script por AI, en cuyo caso en el prompt o en agente indicar el naming convention de los objetos:


-- Check, suponga que los proyectos no pueden ser de un monto inferior a 5 millones, entonces
-- agregamos un check y lo probamos con un insert o un update.

ALTER TABLE dbo.Projects
ADD CONSTRAINT CK_Projects_BudgetCRC_Less5Million
CHECK (BudgetCRC > 5000000)

UPDATE dbo.Projects SET BudgetCRC=3000000 WHERE ProjectId=4

-- dado que el diseño permite nulls en casi todos los campos y el createAt tiene un default getdate(), se lo vamos a
-- eliminar para poder hacer la prueba

SELECT name
FROM sys.default_constraints
WHERE parent_object_id = OBJECT_ID('dbo.Projects')
  AND col_name(parent_object_id, parent_column_id) = 'CreatedAt';

ALTER TABLE dbo.Projects
DROP CONSTRAINT <DF_Projects_CreateAT>;  -- reemplaza con el nombre real

ALTER TABLE dbo.Projects
ALTER COLUMN CreatedAt DATETIME NOT NULL;

-- ahora si este insert debería fallar por no proporcionar un valor para el createdat
insert into dbo.Projects (ClientId, Name, LotNumber, LocationId, LotSizeM2, ConstructionSizeM2, BudgetCRC)
values (2, 'Residencias del Pacifico', '322', 4, 2300, 320, 200000000)

-- agregar de valor default la function getdate()

select getdate()

ALTER TABLE dbo.Projects
ADD CONSTRAINT DF_Projects_CreatedAt
DEFAULT (GETDATE()) FOR CreatedAt;

--  Evaluación de estructura y eficiencia de múltiples consultas que obtienen la misma información 

-- esto para sacar la lista de brands unique que viene de una tabla donde se repiten los nombres
select distinct brand brandname from ProductTransactions 


-------------------------------------------------------------------
-- Algoritmos de Select
-------------------------------------------------------------------

-- Algoritmo S1
-- dado que el campo HoursWorked no tiene ningun atributo especial la búsqueda se hace secuencial,
-- fuerza bruta comparando registro a registro para encontrar cuáles registros cumplen el criterio de selección
-- O(n)
select * from dbo.ExecutionManpowerDetails where HoursWorked=8

-- Algoritmo S2
-- para que haya búsqueda binaria se crea un clustered index o un unique constraint sobre el campo de búsqueda
-- y se hace el select, no aplica si el campo de búsqueda es PK
-- O(log2(n))
ALTER TABLE Clients
ADD CONSTRAINT UQ_Clients_Email UNIQUE (email);

select * from Clients where email = 'contacto@valle.com' 


-- Algoritmo S3a, S3b
-- haciendo un select con una condición de igualdad sobre el PK
-- en el caso de usar árbol B o B* O(n log2n)
-- en el caso de usar un hashtable el O(c) o O(1)
-- la base de datos decide cuál de estos utilizar de forma estadística o algunas veces está decidido por la implementación
-- un criterio importante para decidir si hay un clustered index, un hash o arbol en un PK depende de la cantidad de registros inicialmente
-- se decide estadísticamente, al menos que el programador declare implicitamente el índice primario que quiere 
-- normalmente las variables más importantes son: cantidad de registros, frecuencia de inserts, frecuencia de updates y frecuencia de selects sobre ese campo
select * from dbo.Materials where MaterialId = 8

-- Algoritmo S4
-- Condicion inequality sobre un campo con un PK
-- tenemos que rescatar que este tipo de condicional hace un recorrido secuencial sobre el índice
select * from dbo.Materials where materialid >= 10
select * from dbo.Materials where materialid between 10 and 21

-- Algoritmo S5
-- Hacer una búsqueda por buckets, quiero buscar sobre una igualdad en un campo que no es unique 
-- y  tiene un clustered index
-- ubico el registro inicial y a partir de ahí saco todos los siguientes hasta el valor cambie

-- este índice clustered en sql server no se puede crear dado que por defecto el PK es clustered
CREATE CLUSTERED INDEX IX_ExecutionLogs_ProjectId
ON dbo.ExecutionLogs (ProjectId);

select * from dbo.ExecutionLogs where ProjectId = 6

-- Algoritmo S6
-- Es exactamente el mismo caso que el S5 pero con un índice non clustered, árbol B

CREATE NONCLUSTERED INDEX IX_ExecutionLogs_ProjectId
ON dbo.ExecutionLogs (ProjectId); -- arbol B/B*

select * from dbo.ExecutionLogs where ProjectId = 6



-- Algoritmo S7
-- Hace la seleccion de los registros que cumplen ProjectId = 3, los trae
-- Hace la seleccion de los registros que cumplen materialId = 15
-- Junta los registros y evalua quienes cumplen el AND
-- esto fuerza un S1, porque quantity no tiene ninguna estructura de datos, no tiene access path
select * from dbo.ProjectMaterialBudget where ProjectId = 3 and materialId = 15 and quantity=5

-- si projectid tienen un index non clustered y materialid tiene otro indice non clustered
-- se hacen los dos queries por separado y luego se evalua la condicion
select * from dbo.ProjectMaterialBudget where ProjectId = 3 and materialId = 15

-- Algoritmo S8
-- funciona exactamente igual que S7 pero usando una única estructura de índice compuesta
-- un índice compuesto es aquel que tiene más de una llave indexada
-- en ese caso, si la condicion del where hace uso de ambos campos en el índice compuesto
-- hace una sola extracción y recorrido del índice trayendo los registros que cumplen la condición
-- esto es O(n) porque es conjuntive
CREATE INDEX IX_IntegrationsLog_ConfidenceLevel_Result
ON IntegrationsLog (
    ConfidenceLevel,
    Result
);
GO
-- select * from IntegrationsLog where confidencelevel>0.85 and result=1  , esto lo hace en un solo recorrido O(n)
-- hay que tomar en cuenta si se agregan campos al índice
CREATE INDEX IX_IntegrationsLog_ConfidenceLevel_Result
ON IntegrationsLog (
    ConfidenceLevel,
    Result
)
INCLUDE (
    Model
);
GO
-- select * from IntegrationsLog where confidencelevel>0.85 and result=1 where model='sonet 6.3' 
-- la condicion de model no afecta la estrategia S7 o S8, porque el campo model está incluído en la estructura de datos

-- Task #4: escriba un query sobre ProjectMaterialBudget que haga uso ya sea de S7 o S8. 
-- Si es necesario ponga la declaración de la creación del indice.


-- Algoritmo S9 
-- Se asume que se trabaja sobre indices secundarios en campos que no son únicos y qué no existen punteros de bloque 
-- si no punteros de registro
-- si hay dos campos en la condiciones por ejemplo categoryid = 4 y unitcostCRC>400000
-- se trae los pointer id de categoryid =4 y los pointerid de unitcostCRC>400000 y hace un intersect de los pointerid 


-------------------------------------------------------------------
-- Algoritmos de Join
-------------------------------------------------------------------
-- J1: hacer un join sobre dos campos que no tienen índice alguno esto es for sobre sobre
-- for t1
--    for t2
--         if t1.fieldA = t2.fieldB then se agrega el registro

-- que es mejor cuando se hace un for tener el tamaño más grande afuera o adentro del inner loop????
-- esto sigue el principio de pipelining de arquitectura donde se hace un adelantamiento de instrucciones
-- for until 10
--    for until 100
--         do something
-- o
-- for until 100
--    for until 10
--         do something
-- en selects sucede lo mismo, es mejor recorrer a lo interno las tablas que tienen mayor cantidad de registros , 
-- interno significa más a la derecha del join

-- Task #5 , escriba un query donde se haga un join que use J1, esto es ninguno de los campos de la condicion
-- del join tiene alguna estructura de datos
select * from [dbo].[ExecutionLogs] logs inner join 
[dbo].[Projects] pj on logs.Date = pj.CreatedAt
-- tengo dos campos que no tienen indice, por lo que se va hacer un fors anidados para poder resolver este join 

-- J2: 
-- Single loop
-- Este tipo de algoritmo es el que más se da porque normalmente el programador no tiene el cuidado 
-- de dar mantenimiento a los FKs, los deja default. 

select dbo.Materials.materialid, name, categoryid from dbo.Materials 
inner join dbo.MaterialCategories on dbo.MaterialCategories.MaterialId = dbo.Materials.MaterialId
-- esto provovca que se barra MaterialCategories sobre materialId secuencialmente O(n) y luego se busque el registro 
-- que hace match usando el indice en Materials, si es un indice hash(x) = O(c), si es un arbol B, entonces voy a tener
-- O(nlogn), en resumen podría ser O(n) o O(n+nlogn)
-- esto sucede porque normalmente no se hacen índices en los FKs
-- NO HAY QUE ENTRAR EN Indicititis, esto no quiere decir, que este bien que todos los FKs tengan índice secundario
-- Si son muy pocos registros, no tiene sentido y puede que el motor de base de datos ignore el índice
-- eso podría pasar mucho por ejemplo: currencies, ordersstatus, roles de usuario,etc elementos de poca cantidad
-- no vale la pena poner el índice

-- Task #6 - escriba un query que haga uso de J2, no puede usar el siguiente:
select dbo.Materials.materialid, name, categoryid from dbo.Materials 
inner join dbo.MaterialCategories on dbo.MaterialCategories.MaterialId = dbo.Materials.MaterialId


-- J4: 
-- Algoritmo de buckets por medio de una función de hash
-- Cuando los atributos de la condición del Join pueden operarse por Hash
-- Se hace un barrio de los elementos de una tabla y se ubican en los buckets por medio de la funcion
-- h(x) -- O(n)
-- se procede hacer lo mismo con la segunda tabla y se prueba si hay match uniendolos
-- el join criteria  f(n) = O(n) + O(n) = O(n)


select  pj.Name, logs.date, logs.notes from  [dbo].[ExecutionLogs] logs inner join 
[dbo].[Projects] pj on DATEPART(month, logs.Date) = DATEPART(month, pj.CreatedAt)


-- J3
-- Exige que ambos atributos de la condicion del join esten ordenados físicamente (en disco, en el buffer o en memoria)
-- Se ubica un puntero en cada tabla al punto de inicio de la condición y se van barriendo 
-- secuencialmente en orden
-- J3
-- una forma de optimizar consultas muy efectiva es obligar a tener sorts en los puntos de join del lado del FK
-- si no no puedo garantizar que el motor de base de datos va hacer el sort y quiero optimizar por sort, 
-- entonces viene CTE a la carga....ahora si puedo hacer un CTE ordenado por el FK ,como ya queda ordenado en memoria
-- me fuerza el merge sort


SELECT 
e.ExecutionManpowerDetailId,
l.ExecutionLogId,
l.Date
FROM ExecutionManpowerDetails AS e
INNER JOIN ExecutionLogs AS l
ON e.ExecutionLogId = l.ExecutionLogId;


SELECT 
e.ExecutionManpowerDetailId,
l.ExecutionLogId,
l.Date
FROM ExecutionLogs AS l
INNER JOIN ExecutionManpowerDetails AS e
ON e.ExecutionLogId = l.ExecutionLogId;


WITH CTE_ExecutionManpowerDetails AS
(
    SELECT  
        e.ExecutionManpowerDetailId,
        e.ExecutionLogId
    FROM ExecutionManpowerDetails AS e
)
SELECT *
FROM CTE_ExecutionManpowerDetails
INNER JOIN dbo.ExecutionLogs logs on logs.ExecutionLogId = CTE_ExecutionManpowerDetails.ExecutionLogId
ORDER BY CTE_ExecutionManpowerDetails.ExecutionLogId



select * from dbo.ExecutionLogs

select pj.projectid, clientid, name from Projects pj
inner join dbo.ExecutionLogs logs on pj.ProjectId = logs.ProjectId

CREATE NONCLUSTERED INDEX IX_ExecutionLogs_ProjectId
ON ExecutionLogs(ProjectId ASC);

select pj.projectid, clientid, name from Projects pj
inner join dbo.ExecutionLogs logs on pj.ProjectId = logs.ProjectId

-------------------------------------------------------------
--- Transaction handling 
-------------------------------------------------------------


select * from dbo.MaterialCategories

--- transactions
select * from ExecutionManpowerDetails

UPDATE dbo.ExecutionManpowerDetails SET HourlyRateCRC = 100000 / HourlyRateCRC

UPDATE dbo.ExecutionManpowerDetails SET Total = HourlyRateCRC * HoursWorked


UPDATE dbo.ExecutionManpowerDetails SET Total= 100

UPDATE dbo.ExecutionManpowerDetails SET HourlyRateCRC = HourlyRateCRC * 100


UPDATE dbo.ExecutionManpowerDetails SET HourlyRateCRC = 0 WHERE ExecutionManpowerDetailId =6

select * from dbo.Categories

update dbo.Categories set name = 'Piso' where CategoryId=1


begin tran
	begin try 
		UPDATE dbo.ExecutionManpowerDetails SET Total = HourlyRateCRC * HoursWorked

		UPDATE dbo.ExecutionManpowerDetails SET HourlyRateCRC = 100000 / HourlyRateCRC

		commit
	end try
	begin catch
		rollback
	end catch

--- Por qué es necesario el control de concurrencia?
--- Para que exista el principio de todo o nada de las transacciones
--- es necesario usar un mecanismo de bloqueo, principalmente pero no restrictivamente
--- para las operaciones de escritura
--- este mecanismo de bloqueo, genera dichos bloqueos y esperas que pueden
--- ocasionar ciertos problemas o inconsistencias en los datos
--- segun el comportamiento de las transacciones cuando se ejecutan
--- concurrentemente

---------------------------------
-- The Lost Update Problem
---------------------------------
-- Task #7 - reproducir un lost update problem, 
-- con la tabla Projects o ExecutionMaterialDetails
-- T1
begin tran
    DECLARE @MaterialCost DECIMAL(18,2)

    SELECT @MaterialCost=BaseCostCRC FROM dbo.Materials WHERE MaterialId = 4
    SET @MaterialCost = @MaterialCost + 20000

    WAITFOR DELAY '00:00:06'

    UPDATE dbo.Materials SET BaseCostCRC=@MaterialCost WHERE MaterialId = 4
commit

update dbo.Materials set BaseCostCRC=BaseCostCRC+2000 WHERE materialid =4

-- T2
begin tran
    DECLARE @MaterialCost DECIMAL(18,2)

    SELECT @MaterialCost=BaseCostCRC FROM dbo.Materials WHERE MaterialId = 4
    SET @MaterialCost = @MaterialCost*0.50

    WAITFOR DELAY '00:00:06'

    UPDATE dbo.Materials SET BaseCostCRC=@MaterialCost WHERE MaterialId = 4
commit

--------------------------------------------------------------------------------------------------
-- Task #8 Reproduzca el problema de dirty read (temporary update) con la tabla de Projects
--------------------------------------------------------------------------------------------------
-- T1
begin tran
    begin try
        UPDATE dbo.Materials SET BaseCostCRC=BaseCostCRC+10000 WHERE MaterialId = 5

        WAITFOR DELAY '00:00:06' -- simulando la pausa del calendarizador
    
        UPDATE dbo.ExecutionManpowerDetails SET HourlyRateCRC = 100000 / HourlyRateCRC WHERE
        ExecutionManpowerDetailId=6

        commit
    end try
    begin catch
        rollback
    end catch

-- T2
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED 
begin tran
    DECLARE @MaterialCost DECIMAL(18,2)

    SELECT @MaterialCost=BaseCostCRC FROM dbo.Materials WHERE MaterialId = 5
    SET @MaterialCost = @MaterialCost*2.0

    WAITFOR DELAY '00:00:06'

    UPDATE dbo.Materials SET BaseCostCRC=@MaterialCost WHERE MaterialId = 5
commit

