Week #7 - semana santa, no se trabajó
Week #8 - una lección no se dió y la segunda fué asíncrona con trabajo en clase

Week #9 - SQL Select, Stored procedures, Updates, Inserts, Views, Functions

Proceda a trabajar con la siguiente base de datos que es un minificado de Etheria Global:

```sql
-- =========================================
-- Database: etheriadb
-- =========================================

-- =========================================
-- Countries
-- =========================================
CREATE TABLE Countries (
    countryId SERIAL PRIMARY KEY,
    countryName VARCHAR(60),
    isoCode VARCHAR(3),
    enabled BOOLEAN
);

-- =========================================
-- States
-- =========================================
CREATE TABLE States (
    stateId SERIAL PRIMARY KEY,
    stateName VARCHAR(50),
    countryId INT,
    CONSTRAINT fk_states_country
        FOREIGN KEY (countryId)
        REFERENCES Countries(countryId)
);

-- =========================================
-- Cities
-- =========================================
CREATE TABLE Cities (
    cityId SERIAL PRIMARY KEY,
    cityName VARCHAR(50),
    stateId INT,
    CONSTRAINT fk_cities_state
        FOREIGN KEY (stateId)
        REFERENCES States(stateId)
);

-- =========================================
-- Addresses
-- =========================================
CREATE TABLE Addresses (
    addressId SERIAL PRIMARY KEY,
    address VARCHAR(150),
    zipcode VARCHAR(20),
    cityId INT,
    enabled BOOLEAN,
    postTime TIMESTAMP,
    CONSTRAINT fk_addresses_city
        FOREIGN KEY (cityId)
        REFERENCES Cities(cityId)
);

-- =========================================
-- Suppliers
-- =========================================
CREATE TABLE Suppliers (
    supplierId SERIAL PRIMARY KEY,
    supplierName VARCHAR(120),
    countryId INT,
    addressId INT,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    updatedBy INT,
    enabled BOOLEAN,
    checksum BYTEA,
    CONSTRAINT fk_suppliers_country
        FOREIGN KEY (countryId)
        REFERENCES Countries(countryId),
    CONSTRAINT fk_suppliers_address
        FOREIGN KEY (addressId)
        REFERENCES Addresses(addressId)
);

-- =========================================
-- MeasurementUnits
-- =========================================
CREATE TABLE MeasurementUnits (
    measurementUnitId SERIAL PRIMARY KEY,
    measure VARCHAR(30),
    abbreviation VARCHAR(10)
);

-- =========================================
-- Products
-- =========================================
CREATE TABLE Products (
    productId SERIAL PRIMARY KEY,
    productName VARCHAR(120),
    categoryId INT,
    description TEXT,
    measurementUnitId INT,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    updatedBy INT,
    enabled BOOLEAN,
    checksum BYTEA,
    CONSTRAINT fk_products_measurement_unit
        FOREIGN KEY (measurementUnitId)
        REFERENCES MeasurementUnits(measurementUnitId)
);

-- =========================================
-- ImportPurchase
-- =========================================
CREATE TABLE ImportPurchase (
    purchaseId SERIAL PRIMARY KEY,
    supplierId INT,
    countryId INT,
    purchaseDate TIMESTAMP,
    totalUSD NUMERIC(14,2),
    notes VARCHAR(300),
    CONSTRAINT fk_purchase_supplier
        FOREIGN KEY (supplierId)
        REFERENCES Suppliers(supplierId),
    CONSTRAINT fk_purchase_country
        FOREIGN KEY (countryId)
        REFERENCES Countries(countryId)
);

-- =========================================
-- Currencies
-- =========================================
CREATE TABLE Currencies (
    currencyId SERIAL PRIMARY KEY,
    currencySymbol VARCHAR(10),
    currencyName VARCHAR(50),
    enabled BOOLEAN,
    postTime TIMESTAMP,
    countryId INT,
    updatedAt TIMESTAMP,
    updatedBy INT,
    checksum BYTEA,
    CONSTRAINT fk_currency_country
        FOREIGN KEY (countryId)
        REFERENCES Countries(countryId)
);

-- =========================================
-- ExchangeRates
-- =========================================
CREATE TABLE ExchangeRates (
    exchangeRateId SERIAL PRIMARY KEY,
    currencyId1 INT, -- origen
    currencyId2 INT, -- destino
    exchangeRate DECIMAL(18,6),
    isCurrent BOOLEAN,
    validFrom TIMESTAMP,
    validTo TIMESTAMP,
    postTime TIMESTAMP,
    checksum BYTEA,
    CONSTRAINT fk_exchange_currency1
        FOREIGN KEY (currencyId1)
        REFERENCES Currencies(currencyId),
    CONSTRAINT fk_exchange_currency2
        FOREIGN KEY (currencyId2)
        REFERENCES Currencies(currencyId)
);

-- =========================================
-- PurchaseDetails
-- =========================================
CREATE TABLE PurchaseDetails (
    purchaseDetailId SERIAL PRIMARY KEY,
    purchaseId INT,
    productId INT,
    quantity NUMERIC(12,2),
    unitPrice NUMERIC(10,2),
    subtotal NUMERIC(12,2),
    exchangeRateId INT,
    createdAt TIMESTAMP,
    updatedBy INT,
    checksum BYTEA,
    CONSTRAINT fk_detail_purchase
        FOREIGN KEY (purchaseId)
        REFERENCES ImportPurchase(purchaseId),
    CONSTRAINT fk_detail_product
        FOREIGN KEY (productId)
        REFERENCES Products(productId),
    CONSTRAINT fk_detail_exchange
        FOREIGN KEY (exchangeRateId)
        REFERENCES ExchangeRates(exchangeRateId)
);

-- =========================================
-- Recommended Indexes
-- =========================================
CREATE INDEX idx_states_country ON States(countryId);
CREATE INDEX idx_cities_state ON Cities(stateId);
CREATE INDEX idx_addresses_city ON Addresses(cityId);
CREATE INDEX idx_suppliers_country ON Suppliers(countryId);
CREATE INDEX idx_suppliers_address ON Suppliers(addressId);
CREATE INDEX idx_products_measurement ON Products(measurementUnitId);
CREATE INDEX idx_purchase_supplier ON ImportPurchase(supplierId);
CREATE INDEX idx_purchase_country ON ImportPurchase(countryId);
CREATE INDEX idx_currency_country ON Currencies(countryId);
CREATE INDEX idx_exchange_currency1 ON ExchangeRates(currencyId1);
CREATE INDEX idx_exchange_currency2 ON ExchangeRates(currencyId2);
CREATE INDEX idx_details_purchase ON PurchaseDetails(purchaseId);
CREATE INDEX idx_details_product ON PurchaseDetails(productId);

```

Insertando sample data:

```sql
-- =========================================
-- SAMPLE DATA FOR etheriadb
-- =========================================

-- Countries
INSERT INTO Countries (countryName, isoCode, enabled) VALUES
('United States', 'USA', true),
('Costa Rica', 'CRI', true),
('Germany', 'DEU', true);

-- States
INSERT INTO States (stateName, countryId) VALUES
('California', 1),
('Texas', 1),
('San Jose', 2),
('Alajuela', 2),
('Bavaria', 3);

-- Cities
INSERT INTO Cities (cityName, stateId) VALUES
('Los Angeles', 1),
('San Francisco', 1),
('Houston', 2),
('San José', 3),
('Alajuela City', 4),
('Munich', 5);

-- Addresses
INSERT INTO Addresses (address, zipcode, cityId, enabled, postTime) VALUES
('123 Main St', '90001', 1, true, now()),
('456 Market St', '94105',  2, true, now()),
('789 Texas Ave', '77001',  3, true, now()),
('101 Central Ave', '10101',  4, true, now()),
('202 Alajuela St', '20101',  5, true, now()),
('303 Munich Str', '80331',  6, true, now());

-- Suppliers
INSERT INTO Suppliers (supplierName, countryId, addressId, createdAt, updatedAt, updatedBy, enabled, checksum) VALUES
('Global Supplies Inc', 1, 1, now(), now(), 1, true, decode('AA','hex')),
('Tico Imports', 2, 4, now(), now(), 1, true, decode('BB','hex')),
('EuroTrade GmbH', 3, 6, now(), now(), 1, true, decode('CC','hex'));

-- Measurement Units
INSERT INTO MeasurementUnits (measure, abbreviation) VALUES
('Kilogram', 'kg'),
('Unit', 'u'),
('Liter', 'l');

-- Products (20)
-- =========================================
-- Macrobiotic Products with Calculated Checksum
-- =========================================

INSERT INTO Products (
    productName, categoryId, description, measurementUnitId,
    createdAt, updatedAt, updatedBy, enabled, checksum
)
SELECT
    p.productName,
    p.categoryId,
    p.description,
    p.measurementUnitId,
    now(),
    now(),
    1,
    true,
    decode(md5(p.productName || p.description || p.measurementUnitId), 'hex')
FROM (
    VALUES
    ('Organic Brown Rice', 1, 'Whole grain brown rice, macrobiotic staple', 1),
    ('Quinoa', 1, 'High-protein ancient grain', 1),
    ('Miso Paste', 1, 'Fermented soybean paste for soups', 2),
    ('Tamari Soy Sauce', 1, 'Gluten-free fermented soy sauce', 3),
    ('Seaweed (Nori)', 1, 'Dried sea vegetable rich in minerals', 2),
    ('Kombu', 1, 'Seaweed used for broths and digestion', 2),
    ('Green Tea Organic', 1, 'Antioxidant-rich natural tea', 1),
    ('Herbal Detox Tea', 1, 'Blend of cleansing herbs', 1),
    ('Cold-Pressed Sesame Oil', 2, 'Natural oil for cooking and skin care', 3),
    ('Coconut Oil Organic', 2, 'Multi-purpose oil for cooking and personal care', 3),

    ('Natural Soap Bar', 3, 'Handmade soap with no chemicals', 2),
    ('Aloe Vera Gel', 3, 'Soothing gel for skin care', 3),
    ('Essential Oil Lavender', 3, 'Relaxing essential oil', 3),
    ('Essential Oil Eucalyptus', 3, 'Respiratory support oil', 3),
    ('Natural Toothpaste', 3, 'Fluoride-free herbal toothpaste', 2),

    ('Plant Protein Powder', 4, 'Vegan protein supplement', 1),
    ('Spirulina Powder', 4, 'Nutrient-dense algae supplement', 1),
    ('Chlorella Tablets', 4, 'Detoxifying green algae supplement', 2),
    ('Herbal Immune Booster', 4, 'Natural supplement for immunity', 2),
    ('Probiotic Capsules', 4, 'Digestive health supplement', 2)
) AS p(productName, categoryId, description, measurementUnitId);

-- Currencies
INSERT INTO Currencies (currencySymbol, currencyName, enabled, postTime, countryId, updatedAt, updatedBy, checksum) VALUES
('$', 'USD', true, now(), 1, now(), 1, decode('AA','hex')),
('₡', 'CRC', true, now(), 2, now(), 1, decode('BB','hex')),
('€', 'EUR', true, now(), 3, now(), 1, decode('CC','hex'));

-- Exchange Rates
INSERT INTO ExchangeRates (currencyId1, currencyId2, exchangeRate, isCurrent, validFrom, validTo, postTime, checksum) VALUES
(2,1,0.0019,true,now(),null,now(),decode('01','hex')),
(3,1,1.1,true,now(),null,now(),decode('02','hex')),
(1,1,1,true,now(),null,now(),decode('03','hex'));

-- =========================================
-- ImportPurchase (40 orders)
-- =========================================
INSERT INTO ImportPurchase (supplierId, countryId, purchaseDate, totalUSD, notes)
SELECT
    (random()*2+1)::int,
    (random()*2+1)::int,
    now() - (random()*100 || ' days')::interval,
    0,
    'Sample order #' || gs
FROM generate_series(1,40) gs;

-- =========================================
-- PurchaseDetails (2–5 items per order)
-- =========================================
DO $$
DECLARE
    p_id INT;
    num_items INT;
    i INT;
    prod INT;
    qty NUMERIC;
    price NUMERIC;
BEGIN
    FOR p_id IN SELECT purchaseId FROM ImportPurchase LOOP
        num_items := (random()*3 + 2)::int; -- 2 to 5 items

        FOR i IN 1..num_items LOOP
            prod := (random()*19 + 1)::int;
            qty := (random()*10 + 1)::numeric(12,2);
            price := (random()*20 + 5)::numeric(10,2);

            INSERT INTO PurchaseDetails (
                purchaseId, productId, quantity, unitPrice, subtotal,
                exchangeRateId, createdAt, updatedBy, checksum
            )
            VALUES (
                p_id, prod, qty, price, qty*price,
                1, now(), 1, decode('AA','hex')
            );
        END LOOP;

        -- Update totalUSD
        UPDATE ImportPurchase
        SET totalUSD = (
            SELECT SUM(subtotal)
            FROM PurchaseDetails
            WHERE purchaseId = p_id
        )
        WHERE purchaseId = p_id;
    END LOOP;
END $$;
```

Ahora proceda a realizar las siguientes actividades en un archivo .sql por separado, "Ejercicio #8 - stored procedures.sql"

1. Agregue el campo precio a productos con precios entre 20 y 140 USD dóllars

2. Agregue el campo quantity para saber cuánto hay de cada producto, ponga aleatoriamente entre 14 y 60. 

3. Escriba un select que haga uso de group by y una función agregada.

4. Ahora haga un experimento con los operadores seleccionados de estos:

```sql
-- case 
SELECT productName,
       CASE 
           WHEN enabled = true THEN 'Active'
           ELSE 'Inactive'
       END AS status
FROM Products;

-- coalesce
SELECT productName,
       COALESCE(description, 'No description') AS description
FROM Products;

-- common table expression
WITH sales AS (
    SELECT purchaseId, SUM(subtotal) total
    FROM PurchaseDetails
    GROUP BY purchaseId
)
SELECT * FROM sales;

-- cast
SELECT totalUSD::INTEGER
FROM ImportPurchase;

-- time intervals
SELECT purchaseDate - INTERVAL '10 days'
FROM ImportPurchase;

-- string operations
SELECT LTRIM('   hello');

SELECT TRIM('   hello   ');

SELECT LOWER(productName)
FROM Products;

-- IF in stored procedures, functions or routines
DO $$
BEGIN
    IF 10 > 5 THEN
        RAISE NOTICE 'Es mayor';
    END IF;
END $$;


-- WHILE in stored procedures, functions or routines
DO $$
DECLARE
    contador INT := 1;
BEGIN
    WHILE contador <= 5 LOOP
        RAISE NOTICE 'Valor: %', contador;
        contador := contador + 1;
    END LOOP;
END $$;

-- unnest
SELECT unnest(ARRAY[10, 20, 30]);

-- stored procedure con parámetros
CREATE OR REPLACE PROCEDURE insert_products_array(
    p_names TEXT[],
    p_descriptions TEXT[],
    p_measurementUnitIds INT[]
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Products (
        productName,
        description,
        measurementUnitId,
        createdAt,
        updatedAt,
        updatedBy,
        enabled,
        checksum
    )
    SELECT 
        name,
        description,
        mu_id,
        now(),
        now(),
        1,
        true,
        decode(md5(name || description || mu_id), 'hex')
    FROM unnest(p_names, p_descriptions, p_measurementUnitIds)
         AS t(name, description, mu_id);
END;
$$;

-- llamando el SP
CALL insert_products_array(
    ARRAY['Prod A', 'Prod B', 'Prod C'],
    ARRAY['Desc A', 'Desc B', 'Desc C'],
    ARRAY[1, 2, 1]
);

-- function con parámetros

CREATE OR REPLACE FUNCTION insert_products(
    p_names TEXT[],
    p_prices NUMERIC[]
)
RETURNS VOID AS $$
BEGIN
    INSERT INTO Products (productName, unitPrice)
    SELECT name, price
    FROM unnest(p_names, p_prices) AS t(name, price);
END;
$$ LANGUAGE plpgsql;

-- llamndo la funcion
SELECT insert_products(
    ARRAY['Prod A', 'Prod B'],
    ARRAY[10.5, 20.0]
);
```

Ahora proceda a describir el flujo para los siguientes stored procedures teniendo en cuenta que:
- indicar al inicio que el stored procedure no va a ser transaccional 
- se recibe data por parámetro, normalmente no se reciben IDs, en su lugar nombres
- lo primero que hace el stored procedure es buscar los IDs
- segundo hace calculos que no sean de escritura
- procede a hacer las escrituras


1. Registrar un nuevo tipo de cambio dado dos currencies. 

2. Registrar un importpurchase , con los details, consiste con los productos, precios, existencia y suppliers. 

Entregar el archivo SQL en el submit. 

