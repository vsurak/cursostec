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
-- 03/31/2023, rnunez, ya ahora no va a ser el 15% se modifico a un 20% 
-- =============================================
ALTER TRIGGER dbo.FETRI_ProductosBeforeUpdate_ValidatePrice 
   ON  dbo.Productos 
   AFTER UPDATE
AS 
BEGIN
	SET NOCOUNT ON -- es para que no retorne counts de registros afectados
	DECLARE @idProducto INT

	SELECT @idProducto = idProducto FROM inserted

	IF EXISTS(SELECT 1 FROM inserted 
			  INNER JOIN deleted 
			  ON inserted.idProducto = deleted.idProducto
			  WHERE inserted.precioVenta<deleted.precioVenta*0.80 AND inserted.idProducto=@idProducto)
	BEGIN
		UPDATE dbo.Productos set precioVenta = deleted.precioVenta
		FROM deleted WHERE deleted.idProducto = @idProducto AND dbo.Productos.idProducto = @idProducto
	END 
END
GO

-- testing the trigger
select * from dbo.Productos
select 3600*0.7
update dbo.Productos set precioVenta=2520 where idProducto=4

-- diseñando en sql server

insert into dbo.re_products (name) values ('Coca Cola')
insert into dbo.re_products (name) values ('Lapicero')

select * from dbo.re_products

alter table dbo.re_products add measure varchar(20) not null

alter table dbo.re_products drop column measure


