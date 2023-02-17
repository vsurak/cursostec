-- Quiz #1
-- Rodrigo Nunez

--select * from productos  --> checked ya hay productos

CREATE TYPE dbo.TVP_OrderProducts AS TABLE(
    [Name] varchar(128),
    cantidad float
)
GO


-----------------------------------------------------------
-- Autor: Rnunez
-- Fecha: 02/17/2023
-- Descripcion: procedimiento para registrar un pedido de un consumidor
-----------------------------------------------------------
ALTER PROCEDURE [dbo].[FeriaSP_PlaceOrder]
	@clientId INT,
	@products TVP_OrderProducts READONLY
AS 
BEGIN
	
	SET NOCOUNT ON -- no retorne metadatos
	
	DECLARE @ErrorNumber INT, @ErrorSeverity INT, @ErrorState INT, @CustomError INT
	DECLARE @Message VARCHAR(200)
	DECLARE @InicieTransaccion BIT

	DECLARE @direccionId INT
	DECLARE @productCount INT
	DECLARE @orderStatusId INT
	DECLARE @orderId INT
	DECLARE @Total MONEY

	SELECT @direccionId=ISNULL(idDireccion,0) FROM dbo.DireccionXCliente WHERE idCliente = @clientId

	SELECT @orderStatusId = idEstadoOrden FROM dbo.EstadoOrdenId WHERE Descripcion = 'Por entregar'
	
	SELECT @productCount = COUNT(*) FROM @products

	IF (@direccionId>0 AND @productCount>0) BEGIN

		SET @InicieTransaccion = 0
		IF @@TRANCOUNT=0 BEGIN
			SET @InicieTransaccion = 1
			SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
			BEGIN TRANSACTION		
		END
	
		BEGIN TRY
			SET @CustomError = 2001

			INSERT INTO dbo.Ordenes (postime, totalprice, pesoTotal, clienteid, estadoOrdenId, direccionId)
			VALUES
			(GETDATE(), 0.0, 0.0, @clientId, @orderStatusId, @direccionId)

			SELECT @orderId = SCOPE_IDENTITY()

			INSERT INTO dbo.ProductoXOrden (idProducto, idOrden, cantidad, precio)
			SELECT idProducto, @orderId, prodOrders.cantidad, precioVenta  FROM dbo.Productos prods 
			INNER JOIN @products prodOrders ON prodOrders.Name = prods.Nombre

			SELECT @Total = SUM(cantidad*precio) FROM dbo.ProductoXOrden WHERE idOrden = @orderId

			UPDATE dbo.Ordenes SET totalPrice = @Total WHERE ordenId = @orderId
			
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
END
RETURN 0	
GO

-- prueba del stored procedure que pasa bien, llega al commit
--select * from dbo.Productos
DECLARE @myProducts TVP_OrderProducts
INSERT @myProducts VALUES 
('Aguacate', 5)

exec dbo.[FeriaSP_PlaceOrder] 3, @myProducts
GO

select * from Ordenes where clienteId = 3
select * from ProductoXOrden where idOrden = 53

-- prueba del stored procedure que hace rollback

DECLARE @myProducts TVP_OrderProducts
INSERT @myProducts VALUES 
('AguacateX', 5)


exec dbo.[FeriaSP_PlaceOrder] 3, @myProducts
GO




----- DIRTY READ -----
-- hacer feriaSP_PlaceOrder read uncommited
-- usar una transaccion que afecte un dato que va a leer el SP

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
BEGIN TRANSACTION		

update dbo.Productos SET precioVenta=10000 WHERE idProducto=4

WAITFOR DELAY '00:00:05'

ROLLBACK