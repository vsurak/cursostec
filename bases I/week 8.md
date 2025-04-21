1. inner join, left join, right join, full join, cross join  
- usar la pizarra prepara en onenote

2. stored procedures and functions 
- usar la pizarra prepara en onenote


### structura base para un SP no transaccional
```sql
-- Create a stored procedure
CREATE PROCEDURE AddRecipeWithIngredients
    @RecipeName NVARCHAR(50) INPUT,         -- Input parameter for the recipe name
    @Ingredients TVP_IngredientType INPUT, -- Table-valued parameter for ingredients
    @StatusCode INT OUTPUT,                -- Output parameter for operation status
    @UserName NVARCHAR(50) INOUT           -- InputOutput parameter for the username
AS
BEGIN
    -- Set environment options
    SET NOCOUNT ON -- Prevent metadata messages
    SET ANSI_NULLS ON
    SET ANSI_WARNINGS ON

    -- Declare local variables
    DECLARE @CurrentDate DATETIME = GETDATE() -- Get current date
    DECLARE @NewRecipeId INT                  -- ID for the new recipe
    DECLARE @ExistingRecipeId INT             -- Check for existing recipe ID
    DECLARE @IngredientId INT                 -- Temp variable for ingredient ID
    DECLARE @InsertedCount INT = 0            -- Count of inserted ingredients
    DECLARE @SkippedCount INT = 0             -- Count of skipped ingredients

    -- Assign unique recipe ID
    SELECT @ExistingRecipeId = IdReceta
    FROM Recetas
    WHERE Nombre = @RecipeName;

    --or 
    --IF NOT EXISTS(SELECT IdReceta FROM Recetas WHERE Nombre = @RecipeName) 
    IF @ExistingRecipeId IS NOT NULL
    BEGIN
        -- If recipe already exists, return a status code
        SET @StatusCode = -1 -- Recipe already exists
        RETURN
    END

    -- Insert new recipe
    INSERT INTO Recetas (Nombre)
    VALUES (@RecipeName)

    SELECT @NewRecipeId = SCOPE_IDENTITY()

    -- Insert new ingredients using TVP (Table-Valued Parameter)
    DECLARE @TempIngredients TABLE (
        IdIngrediente INT,
        Nombre NVARCHAR(50)
    );

    INSERT INTO @TempIngredients (IdIngrediente, Nombre)
    SELECT IdIngrediente, Nombre
    FROM @Ingredients;

    -- Insert non-existing ingredients into the Ingredientes table
    INSERT INTO Ingredientes (Nombre)
    SELECT Nombre
    FROM @Ingredients t
    WHERE NOT EXISTS (
        SELECT 1
        FROM Ingredientes i
        WHERE i.Nombre = t.Nombre
    );

    SET @InsertedCount = @@ROWCOUNT; -- Track number of inserted rows

    -- Insert recipe-ingredient relationships
    INSERT INTO IngredientesPorReceta (IdReceta, IdIngrediente)
    SELECT @NewRecipeId, IdIngrediente
    FROM Ingredientes I WHERE Nombre IN (select nombre from @Ingredients)

    SET @SkippedCount = @@ROWCOUNT - @InsertedCount; -- Calculate skipped rows

    -- Output the operation status
    SET @StatusCode = 1; -- Operation successful
END;

```

### structura base para una funcion no transaccional

```sql
-- Create the function
CREATE FUNCTION dbo.CountIngredientsByRecipe
(
    @RecipeName NVARCHAR(50) -- Input parameter for the recipe name
)
RETURNS INT -- Return the count as an integer
AS
BEGIN
    DECLARE @IngredientCount INT;

    -- Count the number of ingredients associated with the given recipe
    SELECT @IngredientCount = COUNT(*)
    FROM Recetas r
    INNER JOIN IngredientesPorReceta ipr ON r.IdReceta = ipr.IdReceta
    WHERE r.Nombre = @RecipeName;

    RETURN ISNULL(@IngredientCount, 0); -- Return 0 if no ingredients are found
END;


-- Ejemplo de su uso en los SELECT
SELECT r.Nombre AS RecipeName,
       dbo.CountIngredientsByRecipe(r.Nombre) AS IngredientCount
FROM Recetas r;

```

3. Mejorando queries , algunas observaciones de queries revisados 

```sql

-- no hardcodear IDs cuando son user editable
SELECT 
    CONCAT(u.firstname, ' ', u.lastname) AS full_name,
    email.value AS email,
    country.value AS country,
    SUM(p.monto) AS total_paid_colones
FROM Usuarios u
JOIN ContactInfo email ON email.ownerID = u.userid AND email.contactInfoTypeId = 1
JOIN ContactInfo country ON country.ownerID = u.userid AND country.contactInfoTypeId = 2


-- filtrar en el where, el case ya está pasando por todos los registros que retorna el where
SELECT CONCAT(PS.firstname, ' ', PS.lastname) AS 'Nombre Completo', CT.name 'Pais de Origen',CIP.value Correo, PPE.adquisitionDate 'Fecha de inscripcion', PTS.description Subscripcion, PP.amount Precio,
CASE
    WHEN PP.recurrencyType = 1 THEN 'Mensual'
    WHEN PP.recurrencyType = 2 THEN 'Anual'
    WHEN PP.recurrencyType = 3 THEN 'Permanente' END 'Frecuencia de Cobro',
CASE
    WHEN PP.recurrencyType = 1 THEN TIMESTAMPDIFF(MONTH, PPE.adquisitionDate, NOW())*PP.amount
    WHEN PP.recurrencyType = 2 THEN TIMESTAMPDIFF(YEAR, PPE.adquisitionDate, NOW())*PP.amount
    WHEN PP.recurrencyType = 3 THEN PP.amount END 'Total Pagado'
FROM Payment_Users PU
INNER JOIN Payment_Personas PS ON PU.personID= PS.personID
INNER JOIN Payment_ContactInfoPerson CIP ON (PS.personID = CIP.personID AND CIP.contacInfoTypeID = 1)
INNER JOIN Payment_UserAdresses UA ON PU.userid = UA.userid
INNER JOIN Payment_Adresses AD ON UA.adressid = AD.adressid
INNER JOIN Payment_Cities CY ON CY.cityid = AD.cityid
INNER JOIN Payment_States ST ON ST.stateid = CY.cityid
INNER JOIN Payment_Countries CT ON CT.countryid = ST.countryid
INNER JOIN Payment_PlanPerEntity PPE ON PPE.userid = PU.userid
INNER JOIN Payment_PlanPrices PP ON PPE.planPriceid = PP.planPriceid
INNER JOIN Payment_Subscriptions PTS ON PP.subscriptionid = PTS.subscriptionid
WHERE PU.enabled = 1;


-- no violentamos un diseño para hacer un ejercicio o terminar un tiquete en el trabajo
-- el hoursspent podría ser un campo válido si la naturaleza del negocio lo requiere , de lo contrario no habría de donde sacar dicho valor para insertarlo en la base de datos 
SELECT 
    user_id,
    name,
    last_name,
    email,
    hours_spent
FROM 
    pay_user
ORDER BY 
    hours_spent DESC
LIMIT 15;


-- es más rápido filtrar y cruzar, que resolver subqueries para luego filtrar y cruzar, podría incluso estarse barriendo el mismo set de datos más de una vez 
SELECT userTable.userId, 
		userTable.NombreCompleto,
        countryTable.Pais,
        contactTable.Email,
        coalesce(transactionTable.PagosSuscripciones, 0) AS PagosSuscripciones,
        coalesce(transactionTable.MonedaOriginal, 'Ninguna') AS MonedaOriginal,
        ROUND(coalesce(transactionTable.PagosSuscripcionesEnDolares, 0),2) AS SuscripcionesEnDolares,
        -- Esta linea convierte el Pago de la moneda en dolares a Colones con dos decimales de precision
        ROUND((coalesce(transactionTable.PagosSuscripcionesEnDolares, 0) * (SELECT exchangeRate FROM payment_exchangeRates WHERE exchangeRateId = 6)),2) AS PagosSuscripcionesEnColones
FROM 
(
	SELECT userId, CONCAT(firstName, ' ', lastName) AS NombreCompleto, FK_countryId
	FROM payment_users
    WHERE enabled = 1                                     -- Se asegura que los usuarios listados esten activos
) AS userTable
INNER JOIN (
	SELECT countryId, name AS Pais
	FROM payment_countries
) AS countryTable ON userTable.FK_countryId = countryTable.countryId
INNER JOIN (
	SELECT contactUserInfoId, value AS Email, FK_contactInfoTypesId, FK_userId
	FROM payment_contactsUserInfo
	WHERE FK_contactInfoTypesId = 1                                       -- 1 es tipo Email
) AS contactTable ON userTable.userId = contactTable.FK_userId
LEFT JOIN (                                                               -- Se realiza un LEFT JOIN para ver todos los usuarios
	SELECT SUM(amount) AS PagosSuscripciones, FK_userId, GROUP_CONCAT(DISTINCT name SEPARATOR ', ') AS MonedaOriginal,
    SUM(CASE 
	WHEN FK_currencyIdsource > 1 THEN amount * exchangeRate
    ELSE amount
	END) AS PagosSuscripcionesEnDolares                            -- Se convierte todo en dolares
    
	FROM payment_transactions
    INNER JOIN payment_exchangeRates ON payment_transactions.FK_exchangeRateId = payment_exchangeRates.exchangeRateId
		INNER JOIN payment_currencies ON payment_exchangeRates.FK_currencyIdsource = payment_currencies.currencyId
	WHERE YEAR(transDateTime) >= 2024 and FK_transSubTypeId = 1            -- Se asegura que los pagos sean de 2024 en adelante y
    GROUP BY FK_userId                                                     -- que sean pagos para suscripciones (transSubType = 1 es suscripcion)
) AS transactionTable ON userTable.userId = transactionTable.FK_userId;

```


4. Dinámica de discusión ejercicio #5 y #6

Se uniran los grupos del caso y analizaran los diseños de otros grupos en búsqueda de errores y mejoras. Se entrevistaran a todos los integrantes del grupo para escuchar el análisis de los hallazgos . 

