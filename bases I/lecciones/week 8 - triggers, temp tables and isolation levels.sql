create table #sample (
	id int,
	name varchar(20)
)

insert into #sample values (1, 'pedro')
insert into #sample values (2, 'ana')

select * from #sample


----- triggers ------

select * from dbo.Productos

-- crear un trigger que cuando se actualice el precio de venta, no permita que
-- que dicho precio se reduzca en más de un 15%
-- voy a crear un trigger before update , para revisar si el nuevo precio
-- no rebaja más de un 15%, si no es así, lo actualizo, y si si es más alta la rebaja
-- entonces no actualizo el precio lo dejo igual

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		rodri el profe
-- Create date: 03-29-2023
-- Description:	Solo se puede rebajar el precio de un producto en max 15%
-- =============================================
CREATE TRIGGER dbo.FETRI_ProductosBeforeUpdate_ValidatePrice 
   ON  dbo.Productos 
   INSTEAD OF UPDATE
AS 
BEGIN
	DECLARE @prevPrecio MONEY
	DECLARE @newPrecio MONEY

	SET NOCOUNT ON -- es para que no retorne counts de registros afectados

	select @prevPrecio = precioVenta from deleted
	select @newPrecio = precioVenta from inserted
	
	IF (@prevPrecio*0.85>@newPrecio) 
	BEGIN
		update inserted set precioVenta = deleted.precioVenta
		FROM inserted 
		INNER JOIN deleted ON deleted.idProducto = inserted.idProducto
		WHERE inserted.idProducto = deleted.idProducto
	END 

END
GO








