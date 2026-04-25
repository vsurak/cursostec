## Database for SQL server introduction

1. Cree la base de datos manualmente usando el SQL Management Studio esto para que explore las diferentes opciones de configuración que el profesor explicó. 

2. Ejecute el script de creación de las tablas y vistas. 

```sql
-- =========================================
-- DATABASE
-- =========================================
USE RedFoxConstru;
GO

-- =========================================
-- CLIENTS
-- =========================================
CREATE TABLE Clients (
    ClientId INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(200) NOT NULL,
    Phone NVARCHAR(50),
    Email NVARCHAR(100),
    CreatedAt DATETIME2 DEFAULT GETDATE()
);

-- =========================================
-- LOCATIONS
-- =========================================
CREATE TABLE Locations (
    LocationId INT IDENTITY PRIMARY KEY,
    Country NVARCHAR(100) NOT NULL,
    City NVARCHAR(100),
    Estate NVARCHAR(100),
    Address NVARCHAR(300)
);

-- =========================================
-- PROJECTS
-- =========================================
CREATE TABLE Projects (
    ProjectId INT IDENTITY PRIMARY KEY,
    ClientId INT NOT NULL,
    Name NVARCHAR(200) NOT NULL,
    LotNumber NVARCHAR(50),
    LocationId INT,
    LotSizeM2 DECIMAL(12,2),
    ConstructionSizeM2 DECIMAL(12,2),
    BudgetCRC DECIMAL(18,2) NOT NULL,
    CreatedAt DATETIME2 DEFAULT GETDATE(),

    FOREIGN KEY (ClientId) REFERENCES Clients(ClientId),
    FOREIGN KEY (LocationId) REFERENCES Locations(LocationId)
);

-- =========================================
-- CATEGORIES (Floors, Walls, Electrical, etc.)
-- =========================================
CREATE TABLE Categories (
    CategoryId INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL
);

-- =========================================
-- MATERIALS
-- =========================================
CREATE TABLE Materials (
    MaterialId INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(200) NOT NULL,
    Unit NVARCHAR(50), -- m2, kg, unit, etc.
    BaseCostCRC DECIMAL(18,2)
);

-- =========================================
-- MATERIAL-CATEGORY (N:N)
-- =========================================
CREATE TABLE MaterialCategories (
    MaterialId INT,
    CategoryId INT,
    PRIMARY KEY (MaterialId, CategoryId),
    FOREIGN KEY (MaterialId) REFERENCES Materials(MaterialId),
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
);

-- =========================================
-- PROJECT CATEGORIES (what applies to project)
-- =========================================
CREATE TABLE ProjectCategories (
    ProjectCategoryId INT IDENTITY PRIMARY KEY,
    ProjectId INT NOT NULL,
    CategoryId INT NOT NULL,

    FOREIGN KEY (ProjectId) REFERENCES Projects(ProjectId),
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
);

-- =========================================
-- PROJECT MATERIAL BUDGET
-- =========================================
CREATE TABLE ProjectMaterialBudget (
    ProjectMaterialBudgetId INT IDENTITY PRIMARY KEY,
    ProjectId INT NOT NULL,
    MaterialId INT NOT NULL,
    CategoryId INT NOT NULL,
    Quantity DECIMAL(18,2) NOT NULL,
    UnitCostCRC DECIMAL(18,2) NOT NULL,
    TotalCostCRC AS (Quantity * UnitCostCRC) PERSISTED,

    FOREIGN KEY (ProjectId) REFERENCES Projects(ProjectId),
    FOREIGN KEY (MaterialId) REFERENCES Materials(MaterialId),
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
);

-- =========================================
-- MANPOWER CATALOG
-- =========================================
CREATE TABLE ManpowerRoles (
    RoleId INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL
);

-- =========================================
-- EXECUTION LOG (HEADER)
-- =========================================
CREATE TABLE ExecutionLogs (
    ExecutionLogId INT IDENTITY PRIMARY KEY,
    ProjectId INT NOT NULL,
    Date DATETIME2 NOT NULL DEFAULT GETDATE(),
    Notes NVARCHAR(500),

    FOREIGN KEY (ProjectId) REFERENCES Projects(ProjectId)
);

-- =========================================
-- EXECUTION - MATERIAL PURCHASES
-- =========================================
CREATE TABLE ExecutionMaterialDetails (
    ExecutionMaterialDetailId INT IDENTITY PRIMARY KEY,
    ExecutionLogId INT NOT NULL,
    MaterialId INT NOT NULL,
    Quantity DECIMAL(18,2),
    UnitCostCRC DECIMAL(18,2),
    TotalCostCRC AS (Quantity * UnitCostCRC) PERSISTED,

    FOREIGN KEY (ExecutionLogId) REFERENCES ExecutionLogs(ExecutionLogId),
    FOREIGN KEY (MaterialId) REFERENCES Materials(MaterialId)
);

-- =========================================
-- EXECUTION - MANPOWER COSTS
-- =========================================
CREATE TABLE ExecutionManpowerDetails (
    ExecutionManpowerDetailId INT IDENTITY PRIMARY KEY,
    ExecutionLogId INT NOT NULL,
    RoleId INT NOT NULL,
    HoursWorked DECIMAL(10,2),
    HourlyRateCRC DECIMAL(18,2),
    TotalCostCRC AS (HoursWorked * HourlyRateCRC) PERSISTED,

    FOREIGN KEY (ExecutionLogId) REFERENCES ExecutionLogs(ExecutionLogId),
    FOREIGN KEY (RoleId) REFERENCES ManpowerRoles(RoleId)
);

-- =========================================
-- VIEW: TOTAL SPENT PER PROJECT
-- =========================================
CREATE VIEW vw_ProjectSpent AS
SELECT 
    p.ProjectId,
    ISNULL(SUM(m.TotalCostCRC), 0) 
    + ISNULL(SUM(mp.TotalCostCRC), 0) AS TotalSpentCRC
FROM Projects p
LEFT JOIN ExecutionLogs el ON p.ProjectId = el.ProjectId
LEFT JOIN ExecutionMaterialDetails m ON el.ExecutionLogId = m.ExecutionLogId
LEFT JOIN ExecutionManpowerDetails mp ON el.ExecutionLogId = mp.ExecutionLogId
GROUP BY p.ProjectId;
GO

-- =========================================
-- VIEW: TOTAL BUDGETED MATERIALS
-- =========================================
CREATE VIEW vw_ProjectBudgetMaterials AS
SELECT 
    ProjectId,
    SUM(TotalCostCRC) AS TotalBudgetMaterialsCRC
FROM ProjectMaterialBudget
GROUP BY ProjectId;
GO

-- =========================================
-- VIEW: PROJECT COMPLETION %
-- =========================================
CREATE VIEW vw_ProjectCompletion AS
SELECT 
    p.ProjectId,
    p.Name,
    p.BudgetCRC,
    ISNULL(s.TotalSpentCRC, 0) AS SpentCRC,
    CASE 
        WHEN p.BudgetCRC = 0 THEN 0
        ELSE (ISNULL(s.TotalSpentCRC, 0) / p.BudgetCRC) * 100
    END AS CompletionPercent
FROM Projects p
LEFT JOIN vw_ProjectSpent s ON p.ProjectId = s.ProjectId;
GO

```

3. Ejecute el script de llenado de la base de datos que serán los datos que vamos a usar para continuar los nuevos temas del curso.

```sql

-- =========================================
-- CLIENTS
-- =========================================
INSERT INTO Clients (Name, Phone, Email)
VALUES
('Constructora Tica S.A.', '2222-1111', 'info@tica.com'),
('Desarrollos del Valle', '2222-2222', 'contacto@valle.com'),
('Inversiones CR Norte', '2222-3333', 'norte@invcr.com');

-- =========================================
-- LOCATIONS (Costa Rica)
-- =========================================
INSERT INTO Locations (Country, City, Estate, Address)
VALUES
('Costa Rica', 'San José', 'Escazú', 'San Rafael, Calle 1'),
('Costa Rica', 'San José', 'Santa Ana', 'Pozos, Avenida 3'),
('Costa Rica', 'Heredia', 'Belén', 'La Ribera'),
('Costa Rica', 'Alajuela', 'La Guácima', 'Condominio Los Reyes'),
('Costa Rica', 'Cartago', 'Tres Ríos', 'Concepción'),
('Costa Rica', 'Guanacaste', 'Tamarindo', 'Playa Tamarindo'),
('Costa Rica', 'Puntarenas', 'Jacó', 'Centro Jacó');

-- =========================================
-- PROJECTS
-- =========================================
INSERT INTO Projects (ClientId, Name, LotNumber, LocationId, LotSizeM2, ConstructionSizeM2, BudgetCRC)
VALUES
(1, 'Casa Escazú Luxury', 'L-101', 1, 850, 420, 95000000),
(2, 'Residencial Santa Ana Norte', 'L-22', 2, 600, 300, 65000000),
(1, 'Oficinas Corporativas Belén', 'L-9', 3, 1200, 800, 180000000),
(3, 'Casa Club Los Reyes', 'L-55', 4, 900, 500, 110000000),
(2, 'Residencia Familiar Tres Ríos', 'L-77', 5, 700, 350, 70000000),
(3, 'Villa Playa Tamarindo', 'L-3', 6, 1000, 450, 120000000),
(1, 'Edificio Comercial Jacó', 'L-88', 7, 1500, 900, 200000000);

-- =========================================
-- CATEGORIES
-- =========================================
INSERT INTO Categories (Name)
VALUES
('Floors'),
('Walls'),
('Ceilings'),
('Electrical'),
('Plumbing'),
('Finishes');

-- =========================================
-- MATERIALS (25)
-- =========================================
INSERT INTO Materials (Name, Unit, BaseCostCRC)
VALUES
('Concrete', 'm3', 75000),
('Steel Rebar', 'kg', 1200),
('Ceramic Tile', 'm2', 8500),
('Porcelain Tile', 'm2', 12000),
('Wood Flooring', 'm2', 18000),
('Drywall', 'm2', 6000),
('Paint', 'gal', 9500),
('Electrical Cable', 'm', 1200),
('PVC Pipe', 'm', 1800),
('Copper Pipe', 'm', 4500),
('Lighting Fixtures', 'unit', 25000),
('Switches', 'unit', 3500),
('Outlets', 'unit', 3000),
('Roof Tiles', 'm2', 9000),
('Insulation', 'm2', 5000),
('Glass Panels', 'm2', 22000),
('Doors', 'unit', 45000),
('Windows', 'unit', 55000),
('Cement Bags', 'unit', 8500),
('Sand', 'm3', 15000),
('Gravel', 'm3', 14000),
('Adhesive', 'unit', 6000),
('Waterproofing', 'm2', 7000),
('Plumbing Fixtures', 'unit', 30000),
('Ceiling Panels', 'm2', 8000);

-- =========================================
-- MATERIAL-CATEGORY (random mapping)
-- =========================================
INSERT INTO MaterialCategories (MaterialId, CategoryId)
VALUES
(1,2),(1,1),
(2,2),
(3,1),(4,1),(5,1),
(6,3),
(7,6),
(8,4),
(9,5),(10,5),
(11,4),
(12,4),(13,4),
(14,3),
(15,3),
(16,6),
(17,6),(18,6),
(19,2),
(20,2),(21,2),
(22,1),
(23,5),
(24,5),
(25,3);

-- =========================================
-- PROJECT CATEGORIES
-- =========================================
INSERT INTO ProjectCategories (ProjectId, CategoryId)
SELECT p.ProjectId, c.CategoryId
FROM Projects p
CROSS JOIN Categories c;

-- =========================================
-- PROJECT MATERIAL BUDGET
-- =========================================
INSERT INTO ProjectMaterialBudget (ProjectId, MaterialId, CategoryId, Quantity, UnitCostCRC)
SELECT 
    p.ProjectId,
    m.MaterialId,
    mc.CategoryId,
    (10 + (p.ProjectId * m.MaterialId) % 50), -- pseudo-random qty
    m.BaseCostCRC
FROM Projects p
JOIN MaterialCategories mc ON mc.MaterialId <= 25
JOIN Materials m ON m.MaterialId = mc.MaterialId
WHERE (p.ProjectId + m.MaterialId) % 2 = 0;

-- =========================================
-- MANPOWER ROLES
-- =========================================
INSERT INTO ManpowerRoles (Name)
VALUES
('Foreman'),
('Electrician'),
('Plumber'),
('Mason'),
('Laborer');

-- =========================================
-- EXECUTION LOGS (1–3.5 months per project)
-- =========================================
DECLARE @ProjectId INT = 1;

WHILE @ProjectId <= 7
BEGIN
    DECLARE @StartDate DATE = DATEADD(DAY, - (30 + (@ProjectId * 10)), GETDATE());
    DECLARE @Days INT = 30 + (@ProjectId * 5); -- 30 to ~75 days

    DECLARE @i INT = 0;

    WHILE @i < @Days
    BEGIN
        INSERT INTO ExecutionLogs (ProjectId, Date, Notes)
        VALUES (@ProjectId, DATEADD(DAY, @i, @StartDate), 'Daily progress');

        SET @i = @i + (1 + (@ProjectId % 3)); -- skip days randomly
    END

    SET @ProjectId = @ProjectId + 1;
END

-- =========================================
-- EXECUTION MATERIAL DETAILS
-- =========================================
INSERT INTO ExecutionMaterialDetails (ExecutionLogId, MaterialId, Quantity, UnitCostCRC)
SELECT 
    el.ExecutionLogId,
    (el.ExecutionLogId % 25) + 1,
    (1 + (el.ExecutionLogId % 10)),
    m.BaseCostCRC
FROM ExecutionLogs el
JOIN Materials m ON m.MaterialId = (el.ExecutionLogId % 25) + 1;

-- =========================================
-- EXECUTION MANPOWER DETAILS
-- =========================================
INSERT INTO ExecutionManpowerDetails (ExecutionLogId, RoleId, HoursWorked, HourlyRateCRC)
SELECT 
    el.ExecutionLogId,
    (el.ExecutionLogId % 5) + 1,
    (4 + (el.ExecutionLogId % 8)),
    (2500 + ((el.ExecutionLogId % 5) * 500))
FROM ExecutionLogs el;

```

4. Genere el diagrama de la base de datos en el sql management studio

5. Cambie la vista del diagrama para tener detalles que le permita mejorar le diseño mejor y re acomode el diseño. 


