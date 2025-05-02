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


### 6. Transactions 

- explicar el esquema de locking desde la perspectiva del libro de navatte

### 7. Problemas de concurrencia de la base de datos y los niveles de isolación 


**Ejercicio #7:**
Utilizando la plantilla de SP transaccional proporcionada por el profesor "XXXXXSP_VerboEntidad.sql" y el diseño de su base de datos para el caso #2, proceda a implementar un SP que dado el nombre de un proveedor de Soltura, calcule el monto que se le debe pagar del mes anterior al actual e inserte la transacción de pago a ese proveedor por el monto calculado, adicionalmente inserte un log indicando el id de la transacción hecha y la cantidad de subscripciones que fueron tomadas en cuenta en dicho monto. 

El ejercicio es individual, envié el archivo SQL al asistente para antes de las 11:40am del día de hoy. 





