# Reducción de redundancia y verbosidad de consultas por medio de VIEWS 
- Las vistas las llamamos vw_, vwName ...
- para stored procedures sp_, spActionEntity
- para functions usamos fn_, fnActionEntity
- para triggers tr_, trEventEntity
- para checks ch_, chFieldCondition
- para jobs job_, jobDescription

Las vistas nos permiten agrupar instrucciones select juntando joins, subqueries, etc dentro de un solo object para simplificar la complejidad de la escritura. Normalmente usamos vistas para queries que hay que estar haciendo muy seguido que requieren varios joins entre otras operaciones.

- Poner un "mega" query dentro de un nombre o etiqueta. 
- No soportan order by

View example in RedFoxConstru
Escriba una vista ejemplo que use 3 tablas entre ellas mandatoriamente ExecutionMaterialDetails y las otras dos a su discreción, haga la vista y escriba una descripción del objetivo de esa vista. 

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
```sql
select *, row_number() over (partition by Unit Order by Unit ASC) from Materials

select * from Materials order by BaseCostCRC

select *, rank() over (Order by baseCostCRC ASC) from Materials

select *, dense_rank() over (Order by baseCostCRC ASC) from Materials

select *, dense_rank() over (partition by Unit Order by baseCostCRC ASC) from Materials
```

# Pruebas de integridad de datos tanto de llaves foráneas, defaults, checks.


# Evaluación de estructura y eficiencia de múltiples consultas 
que obtienen la misma información  

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