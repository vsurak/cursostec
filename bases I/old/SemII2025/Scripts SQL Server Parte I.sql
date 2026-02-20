/****** Object:  Table [dbo].[fut_customers]    Script Date: 4/16/2021 2:18:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[fut_customers](
	[customerid] [int] IDENTITY(1,1) NOT NULL,
	[personid] [int] NOT NULL,
	[firstname] [nvarchar](60) NOT NULL,
	[lastname] [nvarchar](60) NOT NULL,
	[secondname] [nvarchar](60) NOT NULL,
	[birthdate] [datetime] NOT NULL,
	[enabled] [bit] NOT NULL,
	[password] [varbinary](300) NULL,
 CONSTRAINT [PK_fut_customers] PRIMARY KEY CLUSTERED 
(
	[customerid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[fut_matches]    Script Date: 4/16/2021 2:18:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[fut_matches](
	[matchid] [bigint] IDENTITY(1,1) NOT NULL,
	[caption] [varchar](200) NULL,
	[brochureurl] [varchar](200) NULL,
	[matchtime] [datetime] NOT NULL,
	[visitorid] [smallint] NOT NULL,
	[homeid] [smallint] NOT NULL,
	[finishedtime] [datetime] NULL,
	[visitorgoals] [tinyint] NOT NULL,
	[homegoals] [tinyint] NOT NULL,
 CONSTRAINT [PK_fut_matches] PRIMARY KEY CLUSTERED 
(
	[matchid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[fut_teams]    Script Date: 4/16/2021 2:18:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[fut_teams](
	[teamid] [smallint] IDENTITY(1,1) NOT NULL,
	[teamname] [varchar](60) NOT NULL,
	[division] [tinyint] NOT NULL,
 CONSTRAINT [PK_fut_teams] PRIMARY KEY CLUSTERED 
(
	[teamid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[fut_bets] ADD  CONSTRAINT [DF_fut_bets_bettime]  DEFAULT (getdate()) FOR [bettime]
GO
ALTER TABLE [dbo].[fut_bets]  WITH CHECK ADD  CONSTRAINT [FK_bets_customers_customerid] FOREIGN KEY([customerid])
REFERENCES [dbo].[fut_customers] ([customerid])
GO
ALTER TABLE [dbo].[fut_bets] CHECK CONSTRAINT [FK_bets_customers_customerid]
GO
ALTER TABLE [dbo].[fut_bets]  WITH CHECK ADD  CONSTRAINT [FK_bets_matches_matchid] FOREIGN KEY([matchid])
REFERENCES [dbo].[fut_matches] ([matchid])
GO
ALTER TABLE [dbo].[fut_bets] CHECK CONSTRAINT [FK_bets_matches_matchid]
GO
ALTER TABLE [dbo].[fut_matches]  WITH CHECK ADD  CONSTRAINT [FK_matches_teams_teamid_homeid] FOREIGN KEY([homeid])
REFERENCES [dbo].[fut_teams] ([teamid])
GO
ALTER TABLE [dbo].[fut_matches] CHECK CONSTRAINT [FK_matches_teams_teamid_homeid]
GO
ALTER TABLE [dbo].[fut_matches]  WITH CHECK ADD  CONSTRAINT [FK_matches_teams_teamid_visitorid] FOREIGN KEY([visitorid])
REFERENCES [dbo].[fut_teams] ([teamid])
GO
ALTER TABLE [dbo].[fut_matches] CHECK CONSTRAINT [FK_matches_teams_teamid_visitorid]
GO


insert into dbo.fut_teams (teamname, division) values
('Saprisa', 1)

insert into dbo.fut_teams (teamname, division) values
('Liga', 1)

insert into dbo.fut_teams (teamname, division) values
('Cartaguito', 1)

insert into dbo.fut_teams (teamname, division) values
('Heredia', 1)

insert into dbo.fut_teams (teamname, division) values
('Santos de Guápiles', 1)

select * from dbo.fut_teams


DECLARE @cantidadClientes INT
DECLARE @years INT
DECLARE @cedula INT
DECLARE @birthdate DATETIME

SET @cantidadClientes = 300
SET @cedula = 0

WHILE @cantidadClientes>0 BEGIN
	SET @cedula = floor(rand()*7+1)*100000000+floor(rand()*99999999)
	SET @years = (19+floor(rand()*70))*-1
	SET @birthdate = dateadd(year, @years, getdate())

	SET @birthdate = dateadd(day, CASE WHEN rand()<0.5 THEN -1 ELSE 1 END * 200*rand(), @birthdate)

	INSERT INTO dbo.fut_customers 
	(personid, firstname, lastname, secondname, birthdate, enabled)
	VALUES
	(@cedula, 'Mariana '+CONVERT(VARCHAR,floor(999999*rand())), 
	'Lopez '+CONVERT(VARCHAR, floor(999999*rand())), 
	'Obrador '+CONVERT(VARCHAR,floor(999999*rand())), @birthdate, 1)


	SET @cantidadClientes = @cantidadClientes - 1
END
select * from fut_customers


select @algunvalor = 30
SET @algunvalor = 15

select @algunvalor

declare @algunvalor INT

select top 1 @algunvalor=teamid from dbo.fut_teams
where teamname='carmelita'
select @algunvalor = ISNULL(@algunvalor, 0)
select @algunvalor



DECLARE @matches INT
DECLARE @caption VARCHAR(200)
DECLARE @visitorid SMALLINT
DECLARE @homeid SMALLINT
DECLARE @visitor VARCHAR(60)
DECLARE @home VARCHAR(60)

SET @matches = 30


WHILE @matches>0 BEGIN
	
	SELECT TOP 1 @visitorid=teamid, @visitor=teamname 
	from dbo.fut_teams ORDER BY NEWID()

	SELECT TOP 1 @homeid=teamid, @home=teamname from dbo.fut_teams 
	WHERE teamid<>@visitorid
	ORDER BY NEWID()

	INSERT INTO dbo.fut_matches (caption, matchtime, 
	visitorid, homeid, homegoals, visitorgoals)
	VALUES
	('MEJENGA '+@home+' vs '+@visitor, DATEADD(day, floor(rand()*30), getdate()),
	@visitorid, @homeid, 0 ,0)

	SET @matches = @matches - 1
END

select * from dbo.fut_matches



