## T-SQL instrucciones y casos varios

### 1. Cursors 

Los cursores podrían bloquear las filas que van recoriendo si se usa el modificador SCROLL_LOCKS. 

```sql
DECLARE @teamid SMALLINT
DECLARE @teamname VARCHAR(60)
DECLARE @division TINYINT

DECLARE fut_teams_cursor CURSOR SCROLL_LOCKS FOR
SELECT teamid, teamname, division
FROM dbo.fut_teams WITH (ROWLOCK, UPDLOCK) -- otra opcion es que el cursor sea para update

-- DECLARE fut_teams_cursor CURSOR SCROLL_LOCKS FOR
-- SELECT teamid, teamname, division
-- FROM dbo.fut_teams FOR UPDATE

OPEN fut_teams_cursor

FETCH NEXT FROM fut_teams_cursor INTO @teamid, @teamname, @division

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Example operation on the current record
    PRINT 'Processing Team: ' + @teamname + ', Division: ' + CAST(@division AS VARCHAR)

    -- Fetch the next record
    FETCH NEXT FROM fut_teams_cursor INTO @teamid, @teamname, @division
END

CLOSE fut_teams_cursor
DEALLOCATE fut_teams_cursor
```

### 2. Triggers

```sql

-- Create a trigger 
CREATE TRIGGER trg_betresult_update
ON dbo.fut_bets
AFTER UPDATE
AS
BEGIN
    -- The INSERTED table contains the new rows after the update
    -- The DELETED table contains the old rows before the update
    INSERT INTO sometable (betid, old_betresult, new_betresult)
    SELECT 
        D.betid,          -- Retrieve the betid from the DELETED table
        D.betresult,      -- Old value of betresult from the DELETED table
        I.betresult       -- New value of betresult from the INSERTED table
    FROM DELETED D
    INNER JOIN INSERTED I
        ON D.betid = I.betid -- Match the old and new rows by their primary key
END
GO
```

- deleted y inserted son virtual tables que existen solo dentro del contexto y sesion  

- se pueden definir múltiples triggers para una sola tabla, estos se ejecutan de forma secuencial, no en paralelo, para evitar conflictos. 

- pésima mantenibilidad y debugging 

- el abuso de los triggers podría ralentizar el sistema 

- es fuente de dependencias ocultas que no están en el diseño 


### 3. schemabinding and with encryption

**Schema Binding:**
   - La opción `WITH SCHEMABINDING` se utiliza en vistas y funciones para vincularlas al esquema subyacente de las tablas o vistas referenciadas. Esto asegura que no se puedan realizar cambios estructurales (como eliminar o modificar columnas) en las tablas involucradas mientras la vista o función vinculada existe.
   - Beneficio: Ayuda a preservar la integridad referencial y garantiza que la lógica del objeto no se rompa debido a cambios en las tablas subyacentes. 


**With Encryption:**
   - La opción `WITH ENCRYPTION` se usa en procedimientos almacenados, vistas, funciones o triggers para cifrar su definición de texto. Esto impide que otros usuarios puedan ver el código fuente en `sys.sql_modules`.
   - Beneficio: Es útil para proteger la lógica del negocio o el código propietario, ocultando la implementación.

```sql

-- Crear una vista con schema binding
CREATE VIEW dbo.vw_Teams_Division
WITH SCHEMABINDING
AS
    SELECT teamid, teamname, division
    FROM dbo.fut_teams;

-- Ahora, no va a ser posible modificar o eliminar columnas de la tabla `fut_teams` mientras esta vista exista.

CREATE FUNCTION dbo.fn_CalculateChecksum
    (@betid BIGINT)
RETURNS VARBINARY(32) -- El checksum SHA-256 es de 256 bits (32 bytes)
WITH ENCRYPTION
AS
BEGIN
    DECLARE @concatString NVARCHAR(400)
    DECLARE @checksum VARBINARY(32)

    -- Concatenar los campos de la tabla 'fut_bets' para el registro con la clave primaria proporcionada
    SELECT 
        @concatString = CAST(customerid AS NVARCHAR) + 
                        CAST(matchid AS NVARCHAR) + 
                        CAST(visitorgoals AS NVARCHAR) + 
                        CAST(homegoals AS NVARCHAR) + 
                        CAST(pareto AS NVARCHAR) + 
                        CAST(amount AS NVARCHAR) + 
                        CAST(COALESCE(betresult, '') AS NVARCHAR) + 
                        CAST(COALESCE(amountWon, '') AS NVARCHAR) + 
                        CAST(bettime AS NVARCHAR)
    FROM dbo.fut_bets
    WHERE betid = @betid

    SET @checksum = HASHBYTES('SHA2_256', @concatString)

    RETURN @checksum
END
```

### 4. cifrado en SQL Server

```sql 
-- Crear una clave maestra para la base de datos
CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'passwordaproteger'

-- Crear un certificado para proteger la clave simétrica
CREATE CERTIFICATE BetsGeneralCert
WITH SUBJECT = 'Este certificado es emitido por la base de datos y solo funciona en la base de datos'

-- Crear una clave simétrica protegida por el certificado
CREATE SYMMETRIC KEY LaLlaveSimetricaCreada
WITH ALGORITHM = AES_256
ENCRYPTION BY CERTIFICATE BetsGeneralCert
```

Una vez que se tiene el certificado se puede empezar a usar en las funciones: 

```sql 
-- Agregar la columna para almacenar los datos cifrados
ALTER TABLE dbo.fut_teams
ADD teamowner VARBINARY(300) NULL;

-- Abrir la clave simétrica para cifrar
OPEN SYMMETRIC KEY LaLlaveSimetricaCreada
DECRYPTION BY CERTIFICATE BetsGeneralCert;

-- Insertar un ejemplo con el valor cifrado
INSERT INTO dbo.fut_teams (teamname, division, teamowner)
VALUES ('Team A', 1, 
    ENCRYPTBYKEY(KEY_GUID('LaLlaveSimetricaCreada'), 'Dueno del Equipo'));

CLOSE SYMMETRIC KEY TeamOwnerKey;
```

Ahora hacemos un select normal, notamos el cifrado, por lo que hay que hacer la funcion de decrypt

```sql
select * from dbo.fut_teams 

-- Abrir la clave simétrica para descifrar
OPEN SYMMETRIC KEY LaLlaveSimetricaCreada
DECRYPTION BY CERTIFICATE BetsGeneralCert;

-- Seleccionar los datos descifrados
SELECT 
    teamid,
    teamname,
    division,
    CONVERT(VARCHAR, DECRYPTBYKEY(teamowner)) AS teamowner
FROM dbo.fut_teams;

CLOSE SYMMETRIC KEY LaLlaveSimetricaCreada;
```

### 5. Views

Las vistas pueden contener prácticamente cualquier combinación de tablas involucradas en un SELECT, más no pueden tener cláusula de WHERE. En general todas las vistas entran en la categoría de SELECT simples o complejos: 

**Vistas Simples:**
   - Son las más comunes y están basadas en una sola tabla o combinación sencilla de tablas. Se utilizan para simplificar consultas y facilitar el acceso a datos. 
   - Ejemplo: Una vista que muestra solo ciertos campos de una tabla.

**Vistas Complejas:**
   - Involucran múltiples tablas, uniones (`JOIN`) o funciones agregadas (`SUM`, `COUNT`, etc.). Se utilizan para consolidar información de varias fuentes.
   - Ejemplo: Una vista que combina datos de pedidos y clientes para generar un reporte.

El segundo tipo, son las indexadas o materializadas, se les llama así, pues sus datos son copiados a la base de datos de tempdb, y se aplican algoritmos enfocados en ese set de datos para optimizar las lecturas. Tenga presente que se copian los datos. 

**Vistas Indexadas:**
   - Estas vistas almacenan físicamente los datos y tienen índices que mejoran el rendimiento de las consultas. Son ideales para escenarios de alta demanda en los datos.
   - **Nota:** Requieren `WITH SCHEMABINDING` para garantizar que el esquema subyacente permanezca sin cambios.


### 6. Checks and Defaults

Checks and defaults are constraints that help maintain data integrity in SQL Server. A check constraint ensures that the values inserted into a column meet specific conditions. A default constraint assigns a predefined value to a column when no explicit value is provided during insertion.

Checks and defaults is to enforce rules on data values and to simplify data entry by automatically populating columns with standard values when none are specified.

Uses: 

- A check constraint ensures that a salary column cannot contain negative values. 

- A default constraint sets the current date as the default value for a created\_at column. 

```sql
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name NVARCHAR(100),
    Salary DECIMAL(10,2) CHECK (Salary >= 0), -- This ensures only positive values
    CreatedAt DATETIME DEFAULT GETDATE()      -- This automatically inserts current date
);

-- Insert with explicit Salary
INSERT INTO Employees (EmployeeID, Name, Salary)
VALUES (1, 'Alice', 5000);  -- Salary passes the check, CreatedAt is set to current datetime

-- Insert without Salary, CreatedAt is also defaulted
INSERT INTO Employees (EmployeeID, Name)
VALUES (2, 'Bob');  -- Salary must be NULL or provided, CreatedAt is set automatically
```

### 7. Temporary Tables

Temporary tables in SQL Server are special tables stored in tempdb that exist only for the duration of a session or until explicitly dropped. They are useful for storing intermediate results during query execution.

They help developers break down complex queries into manageable parts and allow storing intermediate datasets for further processing.

Uses

- Storing a subset of data for reporting in a single session. 

- Breaking down a multi-step transformation into smaller intermediate steps. 

```sql
CREATE TABLE #TempEmployees (
    EmployeeID INT,
    Name NVARCHAR(100),
    Salary DECIMAL(10,2)
);

INSERT INTO #TempEmployees (EmployeeID, Name, Salary)
VALUES (1, 'Alice', 5000), (2, 'Bob', 4000);

SELECT * FROM #TempEmployees;  -- Returns rows stored temporarily

DROP TABLE #TempEmployees;     -- Removes the temporary table
```

### 8. Tables in Memory 

In SQL Server, memory-optimized table variables defined with @ are small temporary tables held in memory. They are ideal for lightweight data storage within a batch or procedure.

They allow storing small result sets temporarily without creating actual tables in the database, improving performance in scenarios with limited scope.

Uses: 

- Storing intermediate results inside a stored procedure. 

- Returning a small set of calculated values without creating persistent tables. 

```sql
DECLARE @Employees TABLE (
    EmployeeID INT,
    Name NVARCHAR(100),
    Salary DECIMAL(10,2)
);

INSERT INTO @Employees (EmployeeID, Name, Salary)
VALUES (1, 'Alice', 5000), (2, 'Bob', 4000);

SELECT * FROM @Employees;
```

### 9. Dynamic SQL with Execute

Dynamic SQL allows developers to construct SQL statements as strings and execute them at runtime. In SQL Server, this is typically done using the EXECUTE or sp\_executesql command.

It provides flexibility to build queries dynamically when table names, column names, or conditions cannot be predetermined.

Uses cases:  

- Querying a table whose name is determined at runtime. 

- Building a filter condition dynamically based on user input. 

```sql
DECLARE @TableName NVARCHAR(50) = 'Employees';
DECLARE @SQL NVARCHAR(MAX);

SET @SQL = 'SELECT * FROM ' + @TableName;

EXEC(@SQL);  -- Executes the constructed SQL string
```

### 10. Table Value Parameters
A table value parameter (TVP) allows passing a table as a parameter to a stored procedure or function in SQL Server.

They simplify the process of sending multiple rows of data in a single call, avoiding multiple insert statements.

Uses: 

- Passing a list of product IDs to a stored procedure for batch processing. 

- Sending multiple rows of order details in one parameter to a stored procedure.

```sql
-- Step 1: Create a table type
CREATE TYPE EmployeeType AS TABLE (
    EmployeeID INT,
    Name NVARCHAR(100),
    Salary DECIMAL(10,2)
);

-- Step 2: Create a procedure accepting TVP
CREATE PROCEDURE InsertEmployees
    @Employees EmployeeType READONLY
AS
BEGIN
    INSERT INTO Employees (EmployeeID, Name, Salary)
    SELECT EmployeeID, Name, Salary FROM @Employees;
END;

-- Step 3: Declare and use TVP
DECLARE @Emp EmployeeType;
INSERT INTO @Emp VALUES (1, 'Alice', 5000), (2, 'Bob', 4000);

EXEC InsertEmployees @Emp;
```

### 11. Common Table Expressions

A common table expression (CTE) is a temporary result set that can be referenced within a single SELECT, INSERT, UPDATE, or DELETE statement.

CTEs improve readability of complex queries and allow recursion.

- Breaking down a complex join into simpler components.
- Querying hierarchical data using recursion.

```sql
WITH EmployeeCTE AS (
    SELECT EmployeeID, Name, Salary
    FROM Employees
    WHERE Salary > 4000
)
SELECT * FROM EmployeeCTE;

-- another usage is to create recursive queries

WITH RecursiveCTE AS (
    SELECT EmployeeID, ManagerID, Name
    FROM Employees
    WHERE ManagerID IS NULL
    UNION ALL
    SELECT e.EmployeeID, e.ManagerID, e.Name
    FROM Employees e
    INNER JOIN RecursiveCTE r ON e.ManagerID = r.EmployeeID
)
SELECT * FROM RecursiveCTE;
```

### 12. Partition
Partition in SQL Server is a keyword used with window functions to divide the result set into groups. Each group is processed independently.

It helps apply calculations like ranking or aggregates within subsets of data.

Uses: 

- Calculating total sales per region without grouping the entire query. 

- Assigning rankings per department separately.

```sql
SELECT 
    DepartmentID,
    Name,
    Salary,
    SUM(Salary) OVER (PARTITION BY DepartmentID) AS TotalSalaryByDept
FROM Employees;
```

### 13. Rank

RANK is a window function that assigns a rank to each row within a partition of a result set, with ties receiving the same rank and gaps left in numbering.

It is used to order data within groups and assign rankings.

- Ranking employees by salary within each department. 

- Identifying the top three products by sales.

```sql
SELECT 
    DepartmentID,
    Name,
    Salary,
    RANK() OVER (PARTITION BY DepartmentID ORDER BY Salary DESC) AS RankBySalary
FROM Employees;
```
### 14. Intersect
INTERSECT is a set operator in SQL Server that returns the rows common to two queries.

It helps find overlapping data between two result sets.

Uses
- Finding employees who are both in the training list and promotion list. 

- Identifying products present in two different suppliers’ catalogs. 

```sql
SELECT EmployeeID FROM Training
INTERSECT
SELECT EmployeeID FROM Promotion;
```

### 15. Merge
MERGE allows performing insert, update, and delete operations in a single statement based on the comparison of a target table and a source dataset.

It simplifies synchronization between two tables.

Uses
- Updating employee records from a staging table. 

- Synchronizing a product catalog with external supplier data. 

```sql
MERGE Employees AS target
USING StagingEmployees AS source
ON target.EmployeeID = source.EmployeeID
WHEN MATCHED THEN
    UPDATE SET target.Salary = source.Salary
WHEN NOT MATCHED BY TARGET THEN
    INSERT (EmployeeID, Name, Salary)
    VALUES (source.EmployeeID, source.Name, source.Salary)
WHEN NOT MATCHED BY SOURCE THEN
    DELETE;
```

### 16. IN/NOT IN
The IN operator allows checking if a value exists within a specified set of values or the result of a subquery.

It simplifies filtering by multiple values.

Uses 
- Finding employees located in specific departments.

- Selecting orders from certain countries.

```sql
SELECT * FROM Employees
WHERE DepartmentID IN (1, 2, 3);

---
SELECT * FROM Employees
WHERE DepartmentID NOT IN (1, 2, 3);
```


## Transactions 

- explicar el esquema de locking desde la perspectiva del libro de navatte

## Problemas de concurrencia de la base de datos y los niveles de isolación 

- explicar el esquema de locking desde la perspectiva del libro de navatte
