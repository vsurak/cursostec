# weeks from february 6th to 17th

## actividades fuera de clase

1. conocer el CLI de su sistema operativo y el de linux principalmente 
https://ubuntu.com/tutorials/command-line-for-beginners#1-overview 


2. estudiar github

Teoría
https://docs.github.com/en/get-started/quickstart/hello-world 

https://docs.github.com/en/get-started/using-git/about-git 

Video tutorials
https://www.youtube.com/watch?v=VdGzPZ31ts8 

3. estudiar docker

teoría
https://docs.docker.com/get-started/ 

https://docker-curriculum.com/ 

La documentación y ejemplos es amplia, por el momento se requiere que el estudiante sea capaz de: 
- instalar docker en su computadora
- bajar una imagen del docker hub
- cargar la imagen en un contenedor activo y que este se ejecute en background
- hacer uso del contenedor activo desde la computadora host
- acceder al contenedor y recorrer la estructura de archivos

video tutorials
https://www.youtube.com/watch?v=4Dko5W96WHg 

https://www.youtube.com/watch?v=CV_Uf3Dq-EU 

https://www.youtube.com/watch?v=pTFZFxd4hOI 


4. Instalar sql server developer edition, edition free
https://www.microsoft.com/en-us/sql-server/sql-server-downloads 


## actividades dentro de clase

1. Se hace un repaso del curso de bases de datos I, diseño, patrones y operaciones

2. se crean 4 grupos de trabajo, cada grupo corresponde a uno de los 4 requisitos del diseño del caso #1. internamente el grupo se divide en dos equipos

_equipo de control de calidad:_ este equipo va definir un checklist de la información, validaciones y reglas de negocio que debe cumplir el modelo asignado 

_equipo de diseño:_ implementa un diseño en sql server de las tablas asignadas segun el requisito asignado del caso #1

posteriormente el equipo de control de calidad valida el diseño de sus compañeros basado en las reglas que definió. Todo el grupo procede hacer las mejoras al diseño. Posteriormente se presentan a toda la clase los diseños y se comparten vía script. 

3. Quiz práctico de git/github

4. Quiz práctico de docker


_plantilla para stored procedures transaccionales en sql server_

```sql
-----------------------------------------------------------
-- Autor: Rnunez
-- Fecha: 12/12/2011
-- Descripcion: esta description en comentarios queda almacenada
-- Otros detalles de los parametros
-----------------------------------------------------------
-- Author: pedro perez
-- Fecha: 04-21-2021
-- Desc: actualiza la tabla de xyz bla bla bla
-----------------------------------------------------------
CREATE PROCEDURE [dbo].[XXXXXXSP_VerboEntidad]
	@Param1 NVARCHAR(35),
	@Param2 BIGINT
AS 
BEGIN
	
	SET NOCOUNT ON -- no retorne metadatos
	
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
		
		IF @InicieTransaccion=1 BEGIN
			COMMIT
		END
	END TRY
	BEGIN CATCH
		SET @ErrorNumber = ERROR_NUMBER()
		SET @ErrorSeverity = ERROR_SEVERITY()
		SET @ErrorState = ERROR_STATE()
		SET @Message = ERROR_MESSAGE()
		
		IF @InicieTransaccion=1 BEGIN
			ROLLBACK
		END
		RAISERROR('%s - Error Number: %i', 
			@ErrorSeverity, @ErrorState, @Message, @CustomError)
	END CATCH	
END
RETURN 0
GO
```

