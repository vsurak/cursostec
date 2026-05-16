# Reducción de redundancia y verbosidad de consultas por medio de VIEWS 

- Las vistas las llamamos vw_, vwName ...
- para stored procedures sp_, spActionEntity
- para functions usamos fn_, fnActionEntity
- para triggers tr_, trEventEntity
- para checks ch_, chFieldCondition
- para jobs job_, jobDescription

Este es un ejemplo de spec para un IA agent que genere el script de una base de datos indicandole el naming convention:

Here’s a structured section you can add to your AI Agent spec about **SQL Server object and constraint naming conventions**:

---
## Naming Conventions
- **Tables:**  
  `<Plural EntityName>`  
  *Example:* `Projects`, `Materials`

- **Views:**  
  `vw<Action><EntityName>`  
  *Example:* `vwGetTopMaterials`, `vwListProjects`

- **Stored Procedures:**  
  `sp<Action><Entity>`  
  *Example:* `spInsertProject`, `spUpdateMaterial`

- **Functions:**  
  `fn<Action><Entity>`  
  *Example:* `fnCalculateBudgetCRC`, `fnGetProjectStatus`

- **Triggers:**  
  `trg<Table><Time><Action>`  
  *Example:* `trgProjectsBeforeInsert`, `trgMaterialsAfterUpdate`

- **Cursors:**  
  `cur<Entity><Purpose>`  
  *Example:* `curProjectsAudit`, `curMaterialsValidation`

- **Indexes:**  
  - Clustered: `IXC<Table><Column>`  
  - Nonclustered: `IX<Table><Column>`  
  *Example:* `IXCProjectsProjectId`, `IXMaterialsName`

- **Checks:**  
  `CK_<Table>_<Column>`  
  *Example:* `CK_Projects_BudgetCRC`

- **Defaults:**  
  `DF_<Table>_<Column>`  
  *Example:* `DF_Projects_CreatedAt`

- **Primary Keys:**  
  `PK_<Table>`  
  *Example:* `PK_Projects`

- **Foreign Keys:**  
  `FK_<TableOrigin>_<TableDestiny>_<Column>`  
  *Example:* `FK_Projects_Clients_ClientId`

- **User-Defined Types:**  
  `udt_<Entity>_<Purpose>`  
  *Example:* `udt_ProjectCode`, `udt_MaterialQuantity`
---


Las vistas nos permiten agrupar instrucciones select juntando joins, subqueries, etc dentro de un solo object para simplificar la complejidad de la escritura. Normalmente usamos vistas para queries que hay que estar haciendo muy seguido que requieren varios joins entre otras operaciones.

- Poner un "mega" query dentro de un nombre o etiqueta. 

- No soportan order by, unicamente dentro de los subqueries, no en el resultado final de la vista

- Las vistas normalmente no fueron diseñadas para escritura, esto porque perfectamente una vista puede tener solo campos parciales de las tablas que la generan, entonces hacer un insert dentro de una vista, abriría la pregunta de: qué información inserto en los campos que no son parte de la vista? 

- Sin embargo algunos motores de bases de datos, crearon ciertas reglas para poder tener vistas que soporten inserts y updates, en cuyo caso deben ser declaradas con ciertos requisitos propios del proveedor para poder insertar en vistas. 

- Existen lo que llamamos vistas indexadas o materializadas, esto es cuando se crea un índice cluster sobre una vista, en cuyo caso lo que se hace es UNA COPIA DE LOS DATOS Y SE INDEXAN EN UN ESPACIO TEMPORAL, por lo cual, podría la información llegar a estar desactualizada, esto se hace principalmente para temas de rendimiento en consultas de alto volúmen. 


View example in RedFoxConstru

**Task #1** Escriba una vista ejemplo que use 3 tablas entre ellas mandatoriamente ExecutionMaterialDetails y las otras dos a su discreción, haga la vista y escriba una descripción del objetivo de esa vista. 

El top 3 de los materiales que mas se gastan por proyecto. 
```sql
ALTER VIEW [dbo].[vw_MaterialPerProjectRank]
AS
SELECT 
    Material,
    ProjectName,
    QuantityUsed
FROM (
    SELECT 
        m.Name AS Material,
        p.Name AS ProjectName,
        SUM(execMat.Quantity) AS QuantityUsed,
        ROW_NUMBER() OVER (
            PARTITION BY p.Name 
            ORDER BY SUM(execMat.Quantity) DESC
        ) AS rn
    FROM dbo.ExecutionLogs el
    INNER JOIN dbo.ExecutionMaterialDetails execMat 
        ON el.ExecutionLogId = execMat.ExecutionLogId
    INNER JOIN dbo.Materials m 
        ON execMat.MaterialId = m.MaterialId
    INNER JOIN dbo.Projects p 
        ON el.ProjectId = p.ProjectId
    GROUP BY execMat.MaterialId, m.Name, p.Name
) AS Ranked
WHERE rn <= 3;
GO

```

# Consultas que requieren groups, funciones agregadas, ranks, particiones, CTE y ordenamientos  
- las operaciones de rank y partitions van de la mano, nos permiten crear rankings y numeraciones
asociados a los criterios de orden y de agrupamiento de los datos

Las funciones de partición se aplican dentro de cada partición.

```sql
select *, row_number() over (partition by Unit Order by Unit ASC) from Materials

select * from Materials order by BaseCostCRC

select *, rank() over (Order by baseCostCRC ASC) from Materials

select *, dense_rank() over (Order by baseCostCRC ASC) from Materials

select *, dense_rank() over (partition by Unit Order by baseCostCRC ASC) from Materials
```

**Task #2** Escriban un query que haga uso de rank() y partition() sobre la tabla de MaterialDetails sobre el criterio que usted seleccione.  


# Pruebas de integridad de datos tanto de llaves foráneas, defaults, checks.

**Task #3** por medio de inserts validar que los FK son validados, agregar un check que lo vamos a probar con insert o update,
y un default que vamos a probar con un insert. 

```sql

-- intentar insertar con un FK que no existe, solo existen clientid 1,2,3
insert into dbo.Projects (ClientId, Name, LotNumber, LocationId, LotSizeM2, ConstructionSizeM2, BudgetCRC)
values (5, 'Residencias del Pacifico', '322', 4, 2300, 320, 200000000)



EXEC sp_rename 'FK__Projects__Client__5070F446', 'FK_Projects_Clients_ClientId', 'OBJECT';

-- De donde salen los nombres de los constraints:
-- Salían de los diagramadores o los scripts que los programadores hacen, cuando uno establece un FK en el diagramador
-- ponerle el nombre con el standard de nombre que tenga definido la compañía en el naming convention. 
-- También podría estarse generando el script por AI, en cuyo caso en el prompt o en agente indicar el naming convention de los objetos:

-- Ejemplo de spec del AI Agent:
## Naming conventions:
- Views: vw<ViewOperationName>
- FK: FK_<tableorigin>_<tabledestiny>_fieldname 
- Stored procedures:  sp<Action><Entity> 
- y asi para los demás nombres de los objetos 


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

```


# Evaluación de estructura y eficiencia de múltiples consultas 
que obtienen la misma información  

- se repasan los algoritmos de S1 a S9 del libro de navatte creando ejemplos en SQL
- 



# Comparación de la optimización de consultas por medio de 
índices primarios, secundarios, tablas temporales y cursores 


# Realizar pruebas de transaccionalidad todo o nada 

Stored procedure transaccional
```sql
-----------------------------------------------------------
-- Autor: Rnunez
-- Fecha: 04/25/2025
-- Descripcion: pruebas de clase de transacciones
-- Otros detalles de los parametros
-----------------------------------------------------------
CREATE PROCEDURE [dbo].[XXXXXXSP_VerboEntidad]
	@Param1 NVARCHAR(35),
	@Param2 BIGINT
AS 
BEGIN
	
	SET NOCOUNT ON
	
	DECLARE @ErrorNumber INT, @ErrorSeverity INT, @ErrorState INT, @CustomError INT
	DECLARE @Message VARCHAR(200)
	DECLARE @InicieTransaccion BIT

	-- declaracion de otras variables

	-- operaciones de select que no tengan que ser bloqueadas
	-- tratar de hacer todo lo posible antes de q inice la transaccion
	
	SET @InicieTransaccion = 0
	IF @@TRANCOUNT=0 BEGIN
		SET @InicieTransaccion = 1
		SET TRANSACTION ISOLATION LEVEL READ COMMITTED
		BEGIN TRANSACTION		
	END
	
	BEGIN TRY
		SET @CustomError = 2001

		-- put your code here
		-- es importante que el código que escriba aquí sea lo más corto y lo más eficiente posible
		-- queremos durar lo menos posible para llegar al commit 
		-- aqui asustan, hay que pasar rápido por aquí
					
		IF @InicieTransaccion=1 BEGIN
			COMMIT
		END
	END TRY
	BEGIN CATCH
		-- en esencia, lo que hay  que hacer es registrar el error real, y enviar para arriba un error custom 
		SET @ErrorNumber = ERROR_NUMBER()
		SET @ErrorSeverity = ERROR_SEVERITY()
		SET @ErrorState = ERROR_STATE()
		SET @Message = ERROR_MESSAGE()
		
		IF @InicieTransaccion=1 BEGIN
			ROLLBACK
		END
		-- el error original lo inserte en la tabla de logs, pero retorno a la capa superior un error en "bonito"
		RAISERROR('%s - Error Number: %i', 
			@ErrorSeverity, @ErrorState, @Message, @CustomError) -- hay que sustituir el @message por un error personalizado bonito, lo ideal es sacarlo de sys.messages 
		-- en la tabla de sys.messages se pueden insertar mensajes personalizados de error, los cuales se les hace match con el numero en @CustomError
	END CATCH	
END
RETURN 0
GO

```