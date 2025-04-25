
DECLARE @NewRole VARCHAR(30)
DECLARE @NewUser VARCHAR(50)
DECLARE @RoleId INT

/*
SELECT @NewRole = 'Repartidor'
SELECT @NewUser = 'jperez'

SET TRANSACTION ISOLATION LEVEL READ COMMITTED -- dato que READ COMMITTED es el default, esto está sobrando, pero todo bien si se pone
BEGIN TRANSACTION
	INSERT INTO dbo.caipi_roles (rolename) VALUES (@NewRole)

	SELECT @RoleId = SCOPE_IDENTITY()

	INSERT INTO dbo.caipi_users (name, roleid) VALUES (@NewUser, @RoleId)

COMMIT

select * from dbo.caipi_roles
select * from dbo.caipi_users
*/
-----

/*
SELECT @NewRole = 'Driver'
SELECT @NewUser = 'johndoe'

SET TRANSACTION ISOLATION LEVEL READ COMMITTED -- dato que READ COMMITTED es el default, esto está sobrando, pero todo bien si se pone
BEGIN TRANSACTION
	INSERT INTO dbo.caipi_roles (rolename) VALUES (@NewRole)

	SELECT @RoleId = SCOPE_IDENTITY()

	INSERT INTO dbo.caipi_users (name, roleid) VALUES (@NewUser, @RoleId)

ROLLBACK
*/

SELECT @NewRole = 'UberDriver2'
SELECT @NewUser = NULL

SET TRANSACTION ISOLATION LEVEL READ COMMITTED -- dato que READ COMMITTED es el default, esto está sobrando, pero todo bien si se pone
BEGIN TRANSACTION
BEGIN TRY 
	INSERT INTO dbo.caipi_roles (rolename) VALUES (@NewRole)

	SELECT @RoleId = SCOPE_IDENTITY()

	INSERT INTO dbo.caipi_users (name, roleid) VALUES (@NewUser, @RoleId)

	COMMIT 
END TRY
BEGIN CATCH
	ROLLBACK
END CATCH

select * from dbo.caipi_roles
select * from dbo.caipi_users
