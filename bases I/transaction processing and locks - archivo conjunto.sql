
--- esta es T11 que se corre con T10
-- default es read committed
BEGIN TRANSACTION 
	declare @newRole varchar(30)
	declare @newRoleId INT
	select @newRole = 'Operator' --2

	select @newRoleId = roleid from dbo.caipi_roles WHERE rolename = @newRole

	update dbo.caipi_users set roleid = @newRoleId where userid = 1 -- aqui bloquea la columna roleid del userid 1
	
	WAITFOR DELAY '00:00:05'
	
	update dbo.caipi_users set roleid = @newRoleId where userid = 3 -- aqui bloquea la columna roleid del userid 1
COMMIT


-- esta es T21 que se corre con T20
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
DECLARE @visitorgoals INT
DECLARE @homegoals INT

BEGIN TRANSACTION 
	-- mas operaciones
	update dbo.fut_matches SET homegoals = 7 WHERE matchid=27
	-- 
	-- otras instrucciones pero sucede un fallo
	WAITFOR DELAY '00:00:06'

	ROLLBACK

-- esto es T51 para correr con T50

SET TRANSACTION ISOLATION LEVEL READ COMMITTED
BEGIN TRANSACTION 
	update dbo.fut_matches SET visitorgoals = 10 WHERE matchid = 9
COMMIT


SET TRANSACTION ISOLATION LEVEL READ COMMITTED
BEGIN TRANSACTION 
	insert dbo.fut_matches values ('Liga vs Sapri', 'http:something', getdate(), 3, 1, getdate(), 5, 7)
COMMIT
