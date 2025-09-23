CREATE DATABASE TiemposInternacionales;
GO

USE TiemposInternacionales;
GO

-- Tabla de países
CREATE TABLE Countries (
    CountryId INT IDENTITY(1,1) PRIMARY KEY,
    CountryName NVARCHAR(100) NOT NULL
);

-- Tabla de compradores (usuarios)
CREATE TABLE Buyers (
    BuyerId INT IDENTITY(1,1) PRIMARY KEY,
    Email NVARCHAR(150) NOT NULL UNIQUE,
    NationalId NVARCHAR(50) NOT NULL,
    FirstName NVARCHAR(100) NOT NULL,
    LastName NVARCHAR(100) NOT NULL,
    CountryId INT NOT NULL,
    FOREIGN KEY (CountryId) REFERENCES Countries(CountryId)
);

-- Tabla de sorteos
CREATE TABLE Draws (
    DrawId INT IDENTITY(1,1) PRIMARY KEY,
    DrawName NVARCHAR(100) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL
);

-- Tabla de apuestas (buyins)
CREATE TABLE Buyins (
    BuyinId INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,
    CountryId INT NOT NULL,
    Number INT NOT NULL,
    Amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (UserId) REFERENCES Buyers(BuyerId),
    FOREIGN KEY (CountryId) REFERENCES Countries(CountryId)
);

-----------------------------------------------------
-- Insertar datos de ejemplo
-----------------------------------------------------

-- Países
INSERT INTO Countries (CountryName) VALUES
('Costa Rica'),
('Mexico');

-- Sorteos
INSERT INTO Draws (DrawName, StartDate, EndDate) VALUES
('Sorteo Semanal #1', '2025-09-20', '2025-09-27'),
('Sorteo Extraordinario Septiembre', '2025-09-15', '2025-09-30');

-- Compradores
INSERT INTO Buyers (Email, NationalId, FirstName, LastName, CountryId) VALUES
('ana.cr@example.com', 'CR123456', 'Ana', 'Ramírez', 1),
('luis.mx@example.com', 'MX987654', 'Luis', 'Fernández', 2),
('maria.cr@example.com', 'CR654321', 'María', 'Gómez', 1),
('jose.mx@example.com', 'MX112233', 'José', 'Martínez', 2),
('carlos.cr@example.com', 'CR223344', 'Carlos', 'Alfaro', 1),
('paola.mx@example.com', 'MX334455', 'Paola', 'Hernández', 2),
('sofia.cr@example.com', 'CR445566', 'Sofía', 'Vega', 1),
('ricardo.mx@example.com', 'MX556677', 'Ricardo', 'López', 2),
('andrea.cr@example.com', 'CR778899', 'Andrea', 'Jiménez', 1),
('fernando.mx@example.com', 'MX889900', 'Fernando', 'Sánchez', 2);

-- Apuestas (Buyins)
INSERT INTO Buyins (UserId, CountryId, Number, Amount) VALUES
(1, 1, 23, 50.00),
(2, 2, 45, 100.00),
(3, 1, 11, 25.00),
(4, 2, 99, 75.00),
(5, 1, 7, 200.00);
