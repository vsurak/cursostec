-- en bases de datos y en general en todos los sistemas, 
-- el 80% de las operaciones son de lectura
-- SQL -> SELECT
-- el otro 20% de escritura
-- SQL -> INSERT, DELETE, UPDATE

-- SINTAXIS BASICA
INSERT INTO <nombre de tabla> [(COLUMNAS,...)] VALUES (value,...);
de tal forma que la primer columna se le asigna el primer valor
la segunda columna el segundo valor y asi sucesivamente

INSERT INTO copo_productos (descripcion)
VALUES
('Copo simple sin leche');

INSERT INTO copo_productos (descripcion)
VALUES
('Copo de una leche');

INSERT INTO copo_productos (descripcion)
VALUES
('Copo de dos leches');

INSERT INTO copo_productos (productoid, descripcion)
VALUES
(2, 'Piña Colada'); -- debería dar un error de PK

INSERT INTO copo_productos (productoid, descripcion)
VALUES
(10, 'Piña Colada'); 

INSERT INTO copo_productos (descripcion)
VALUES
('Fresa frozen'); 

INSERT INTO copo_productos (descripcion)
VALUES
('Pina frozen'); 

INSERT INTO copo_productos (descripcion)
VALUES
('Pina Colada'),
('Mojito'),
('Aperol Spritz'),
('Ron con jugo de naranja'); 

INSERT INTO copo_productos (productoid)
VALUES
(17);  -- error porque description no puede ser null


-- SINTAX UPDATE
UPDATE <tabla> SET nombreCampo=newValue 
[WHERE <condicion>]

<condition> --> determina los algoritmos de búsqueda

UPDATE copo_productos SET descripcion='Fresa Colada'
WHERE productoid=10;

--> PK pueden estar implementados con BTree, con Hash o con clustered index
--> cuando pongo un PK en una condicion, la búsqueda es rápida y directa

UPDATE copo_productos SET descripcion='Fresa Colada'
WHERE descripcion='Pia Colada';

--> si va a funcionar pero hace una busqueda secuencial


SINTAX del SELECT

SELECT *|[lista de campos,...] FROM <tabla>

SELECT * FROM copo_productos;

