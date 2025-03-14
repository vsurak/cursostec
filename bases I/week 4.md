# structure query language SQL

## introducción a SQL - create table, insert, delete, update, select

*DDL*: data definition language, todo lo que tenga que ver con creación, diseño, definición de estructuras, reglas, objetos, funciones, jobs, procesos

*DML*: data manipulation language, referente a como hago la manipulación de los datos, read, write, select, delete, insert, update, bulks, etc

*DCL*: data control language, control de permisos, accesos, operaciones del sistema, network, etc

```sql
-- esto es de DDL
CREATE TABLE nombre_tabla (
    columna1 TIPO_DATO CONSTRAINTS,
    columna2 TIPO_DATO CONSTRAINTS,
    ...
    PRIMARY KEY (columna),
    FOREIGN KEY (columna) REFERENCES otra_tabla(columna)
);


-- dml
INSERT INTO tabla (columna1, columna2, ...)
VALUES (valor1, valor2, ...);

DELETE FROM tabla WHERE condición;

UPDATE tabla
SET columna1 = valor1, columna2 = valor2
WHERE condición;

SELECT columnas
FROM tabla
WHERE condición
ORDER BY columna ASC|DESC
LIMIT n;



SELECT columnas | aggregatefunction (5)
FROM table1, table2, table3 (1)
JOIN conditions (3)
WHERE condiciónes (2)
GROUP BY <condiciones> (4)
HAVING <condiciones agregadas> (6)
ORDER BY columna ASC|DESC (7 o a veces 2)
LIMIT n; (8)


```

refiérase a [Introduccion a SQL](Introduccion%20a%20SQL.sql) para ampliar en los ejemplos hechos en clase. 

