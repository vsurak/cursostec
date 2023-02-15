# entregable #1

insert into dbo.fe_products (name, quantity)
values ('Tomate', 40)

insert into dbo.fe_products (name, quantity)
values ('Arroz', 300)

insert into dbo.fe_products (name, quantity)
values ('Carne de res', 10)

... hasta 15

insert into dbo.fe_users ()....
.. hasta 20


DECLARE @quantityOfPersons INT
DECLARE @UserId INT 
DECLARE @Orders INT

DECLARE Users CURSOR FOR
SELECT UserId from dbo.fe_users;

OPEN Users

FETCH NEXT FROM Users INTO @UserId  
WHILE @@FETCH_STATUS = 0  
BEGIN  
	SELECT @Orders = 1+RAND()*3
	
	SELECT TOP 1 @productid = productid from dbo.fe_products ORDER BY NEWID()

	INSERT into dbo.fe_orders (posttime, quantity, productid, userid, statusid)
	VALUES
	(DATEADD(dd, RAND()*27*-1, GETDATE()),, rand()*30, @productid, @UserId, 0)

FETCH NEXT FROM Users INTO @UserId  
END  


CLOSE Users
DEALLOCATE Users


select top 5 from orders where
group by 