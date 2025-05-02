
DECLARE @NewRole VARCHAR(30)
DECLARE @NewUser VARCHAR(50)
DECLARE @RoleId INT

/*
SELECT @NewRole = 'Repartidor'
SELECT @NewUser = 'jperez'

SET TRANSACTION ISOLATION LEVEL READ COMMITTED -- dato que READ COMMITTED es el default, esto est� sobrando, pero todo bien si se pone
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

SET TRANSACTION ISOLATION LEVEL READ COMMITTED -- dato que READ COMMITTED es el default, esto est� sobrando, pero todo bien si se pone
BEGIN TRANSACTION
	INSERT INTO dbo.caipi_roles (rolename) VALUES (@NewRole)

	SELECT @RoleId = SCOPE_IDENTITY()

	INSERT INTO dbo.caipi_users (name, roleid) VALUES (@NewUser, @RoleId)

ROLLBACK
*/

SELECT @NewRole = 'UberDriver2'
SELECT @NewUser = NULL

SET TRANSACTION ISOLATION LEVEL READ COMMITTED -- dato que READ COMMITTED es el default, esto est� sobrando, pero todo bien si se pone
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



-- ejemplo básico de deadlock
-- esta es T10 que se corre con T11
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
BEGIN TRANSACTION 
	declare @newRole varchar(30)
	declare @newRoleId INT
	select @newRole = 'Repartidor' --1004

	select @newRoleId = roleid from dbo.caipi_roles WHERE rolename = @newRole

	update dbo.caipi_users set roleid = @newRoleId where userid = 3 -- aqui bloquea la columna roleid del userid 3

	WAITFOR DELAY '00:00:05'

	update dbo.caipi_users set roleid = @newRoleId where userid = 1 -- aqui bloquea la columna roleid del userid 1
COMMIT


-- esta es T20 que se corre con T21
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
DECLARE @visitorgoals INT
DECLARE @homegoals INT

BEGIN TRANSACTION 
	SELECT @homegoals=homegoals from dbo.fut_matches WHERE matchid=27 -- haciendo lectura sucia
	SET @homegoals = @homegoals + 1

	update dbo.fut_matches SET homegoals = @homegoals WHERE matchid=27
COMMIT


DECLARE @matchcount INT
DECLARE @visitorgoals INT
DECLARE @homegoals INT

SET @matchcount = 30

WHILE @matchcount > 0 BEGIN
	SET @visitorgoals = RAND()*7
	SET @homegoals = RAND()*7
	--SELECT @visitorgoals, @homegoals

	UPDATE dbo.fut_matches SET visitorgoals = @visitorgoals, homegoals=@homegoals WHERE matchid=@matchcount

	set @matchcount = @matchcount - 1
END


-- hacer una transaccion que actualice el promedio de goles por equipo en stats
-- esto es T50 para correr con T51
SET TRANSACTION ISOLATION LEVEL READ COMMITTED
BEGIN TRANSACTION 
	declare @teamid INT
	declare @matches INT
	declare @matchesDespues INT
	declare @totalGoals INT

	SELECT @teamid = teamid from dbo.fut_teams where teamname='el sapri'

	SELECT @matches = COUNT(1)
	from dbo.fut_matches 
	WHERE visitorid = @teamid or homeid = @teamid

	select @matches

	WAITFOR DELAY '00:00:07'

	SELECT @totalGoals = SUM( CASE WHEN visitorid=@teamid THEN visitorgoals ELSE homegoals END ), 
	@matchesDespues=count(1)
	from dbo.fut_matches 
	WHERE visitorid = @teamid or homeid = @teamid

	IF NOT EXISTS (SELECT teamid FROM dbo.fut_teamstats WHERE teamid = @teamid AND statname ='Average goals') BEGIN
		INSERT INTO dbo.fut_teamstats VALUES (@teamid, 'Average goals', 0 )
	END 

	UPDATE dbo.fut_teamstats SET value = @totalGoals / @matches WHERE teamid = @teamid AND statname ='Average goals'

	select @totalGoals, @matches matchesAntes, @matchesDespues matchesDespues
COMMIT


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
BEGIN TRANSACTION 
	declare @teamid INT
	declare @matches INT
	declare @matchesDespues INT
	declare @totalGoals INT

	SELECT @teamid = teamid from dbo.fut_teams where teamname='el sapri'

	SELECT @matches = COUNT(1)
	from dbo.fut_matches 
	WHERE visitorid = @teamid or homeid = @teamid

	select @matches

	WAITFOR DELAY '00:00:07'

	SELECT @totalGoals = SUM( CASE WHEN visitorid=@teamid THEN visitorgoals ELSE homegoals END ), 
	@matchesDespues=count(1)
	from dbo.fut_matches 
	WHERE visitorid = @teamid or homeid = @teamid

	IF NOT EXISTS (SELECT teamid FROM dbo.fut_teamstats WHERE teamid = @teamid AND statname ='Average goals') BEGIN
		INSERT INTO dbo.fut_teamstats VALUES (@teamid, 'Average goals', 0 )
	END 

	UPDATE dbo.fut_teamstats SET value = @totalGoals / @matches WHERE teamid = @teamid AND statname ='Average goals'

	select @totalGoals, @matches matchesAntes, @matchesDespues matchesDespues
COMMIT



select * from dbo.fut_teamstats
select * from dbo.fut_matches
select * from dbo.fut_teams

BEGIN TRAN
DECLARE @teamid SMALLINT
DECLARE @teamname VARCHAR(60)
DECLARE @division TINYINT

--DECLARE fut_teams_cursor CURSOR FOR
--SELECT teamid, teamname, division
--FROM dbo.fut_teams WITH (ROWLOCK, UPDLOCK) -- otra opcion es que el cursor sea para update

DECLARE fut_teams_cursor CURSOR SCROLL_LOCKS FOR
SELECT teamid, teamname, division
FROM dbo.fut_teams FOR UPDATE

OPEN fut_teams_cursor

FETCH NEXT FROM fut_teams_cursor INTO @teamid, @teamname, @division

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Example operation on the current record
    PRINT 'Processing Team: ' + @teamname + ', Division: ' + CAST(@division AS VARCHAR)

	WAITFOR DELAY '00:00:02'
    FETCH NEXT FROM fut_teams_cursor INTO @teamid, @teamname, @division
END

CLOSE fut_teams_cursor
DEALLOCATE fut_teams_cursor

COMMIT


-- esto lo corrí en paralelo con el cursor
Declare @teamid INT
SET @teamid = 1
BEGIN TRAN
	WHILE @teamid < 6 BEGIN
		
		UPDATE dbo.fut_teams SET teamname = teamname + 'Y' WHERE teamid = @teamid 
		WAITFOR DELAY '00:00:01'

		set @teamid = @teamid + 1
	END 
COMMIT

select * from dbo.fut_teams