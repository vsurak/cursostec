# Data Manipulation Language

## La instrucción SELECT

La instrucción `SELECT` es una sentencia del lenguaje SQL utilizada para consultar y recuperar datos almacenados en una o más tablas de una base de datos. Permite especificar exactamente qué columnas y filas se desean obtener, además de soportar operaciones como ordenamiento, agrupamiento y filtrado de datos.

La sintaxis general de la instrucción `SELECT` es la siguiente:

```sql
SELECT [columnas]
FROM [tabla]
[WHERE <condición>]
[GROUP BY <columnas>]
[HAVING <condición de grupo>]
[ORDER BY <columnas> [ASC|DESC]]
[LIMIT <número_filas> [OFFSET <desplazamiento>]]
```
Donde:

- `[columnas]`: Lista de columnas a recuperar. Se puede usar `*` para todas las columnas.
- `[tabla]`: Nombre de la tabla o tablas a consultar.
- `[WHERE <condición>]`: (Opcional) Filtro para seleccionar filas específicas.
- `[GROUP BY <columnas>]`: (Opcional) Agrupa los resultados por una o más columnas.
- `[HAVING <condición de grupo>]`: (Opcional) Filtro sobre grupos resultantes de un GROUP BY.
- `[ORDER BY <columnas> [ASC|DESC]]`: (Opcional) Ordena los resultados por una o más columnas.
- `[LIMIT <número_filas> [OFFSET <desplazamiento>]]`: (Opcional) Limita la cantidad de filas devueltas y puede saltar una cantidad dada de filas iniciales.
```

Ejemplo: 

```sql
SELECT nombre, edad
FROM empleados
WHERE edad > 30
ORDER BY edad DESC
LIMIT 10 OFFSET 5;
```

El orden más común de ejecución de una instrucción `SELECT` por el motor de base de datos es el siguiente:

1. **FROM**  
   Se identifica la(s) tabla(s) de donde se obtendrán los datos. Si hay uniones (JOIN), se resuelven en este paso.

2. **WHERE**  
   Se aplican las condiciones de filtrado a las filas de las tablas especificadas.

3. **GROUP BY**  
   Si existen, las filas resultantes se agrupan según los criterios indicados.

4. **HAVING**  
   Se filtran los grupos resultantes por condiciones adicionales.

5. **SELECT**  
   Se seleccionan y se procesan las columnas requeridas, incluidas las funciones de agregación (SUM, COUNT, etc.).

6. **ORDER BY**  
   Se ordenan los resultados finales según los criterios especificados.

7. **LIMIT/OFFSET**  
   Por último, se limita la cantidad de filas devueltas, si corresponde.

Este orden es importante porque, aunque uno escriba la consulta con `SELECT` al inicio, el motor internamente procesa primero la obtención de datos (`FROM`) y los filtros (`WHERE`), y hasta el final selecciona las columnas y ordena los datos.

## La instrucción INSERT

Se utiliza para agregar una o más filas nuevas a una tabla.

**Sintaxis básica:**
```sql
INSERT INTO <tabla> ([columna1, columna2, ...])
VALUES (valor1, valor2, ...);
```
O bien, para insertar varias filas:
```sql
INSERT INTO <tabla> ([columna1, columna2, ...])
VALUES 
  (valor1a, valor2a, ...),
  (valor1b, valor2b, ...);
```

- `<tabla>`: Nombre de la tabla donde se insertarán los datos.
- `[columna1, columna2, ...]`: (Opcional) Lista de columnas a insertar. Si se omite, se deben proporcionar valores para todas las columnas en el orden definido por la tabla.
- `(valor1, valor2, ...)`: Los valores que se insertarán. Deben coincidir en cantidad y tipo con las columnas indicadas.

**Ejemplo:**
```sql
INSERT INTO empleados (nombre, edad, salario)
VALUES ('Ana', 28, 25000);
```

**Orden de ejecución `INSERT`:**
1. Se resuelve el nombre de la tabla.
2. Se validan las columnas y tipos de datos.
3. Se insertan los valores indicados.


### Instrucción `UPDATE`

Modifica uno o más valores en una o varias filas de una tabla existente.

**Sintaxis básica:**
```sql
UPDATE <tabla>
SET columna1 = valor1, columna2 = valor2, ...
[WHERE <condición>];
```

- `<tabla>`: Nombre de la tabla a modificar.
- `SET columna = valor`: Especifica qué columnas actualizar y sus nuevos valores.
- `[WHERE <condición>]`: (Opcional) Restringe las filas que serán actualizadas. **¡Cuidado!** Si se omite, todas las filas serán modificadas.

**Ejemplo:**
```sql
UPDATE empleados
SET salario = salario * 1.05
WHERE edad > 30;
```

**Orden de ejecución `UPDATE`:**
1. Se identifica la(s) tabla(s) y filas a actualizar.
2. Se aplican los filtros del `WHERE` (si existen).
3. Se realizan los cambios definidos en el `SET`.


## Instruccion `DELETE`

Elimina una o más filas de una tabla.

**Sintaxis básica:**
```sql
DELETE FROM <tabla>
[WHERE <condición>];
```

- `<tabla>`: Tabla donde se eliminarán las filas.
- `[WHERE <condición>]`: (Opcional, pero práctico) Limita las filas a eliminar. **¡Precaución!** Si se omite, serán eliminadas *todas* las filas de la tabla.

**Ejemplo:**
```sql
DELETE FROM empleados
WHERE edad < 25;
```

**Orden de ejecución `DELETE`:**
1. Se identifica la tabla.
2. Se filtran las filas a eliminar con `WHERE` (si existe).
3. Se eliminan las filas seleccionadas.


## Common Table Expressions, CTE

Una **CTE** (Common Table Expression) es una consulta temporal que puedes referenciar dentro de otra consulta más grande. Ayuda a que las consultas sean más legibles y reutilizables, especialmente cuando los subqueries son complejos.

**Sintaxis básica:**
```sql
WITH nombre_cte AS (
    SELECT ...
    FROM ...
    WHERE ...
)
SELECT ...
FROM nombre_cte
WHERE ...;
```

- `nombre_cte`: Nombre que le das a la expresión de tabla (puedes usarlo como si fuera una tabla temporal).
- El bloque dentro del paréntesis es una consulta `SELECT` que define la CTE.

**Ejemplo:**
Supón que queremos listar los empleados que ganan más del salario promedio:

```sql
WITH salarios_mayores AS (
    SELECT *
    FROM empleados
    WHERE salario > (SELECT AVG(salario) FROM empleados)
)
SELECT nombre, salario
FROM salarios_mayores;
```

**Notas Importantes:**
- Las CTEs sólo existen durante la ejecución de la consulta completa.
- Puedes definir varias CTEs separadas por comas:
  ```sql
  WITH cte1 AS (...), cte2 AS (...)
  SELECT ...
  FROM cte2
  JOIN cte1 ON ...;
  ```
- Son muy útiles para consultas recursivas y para dar claridad a partes complejas de una consulta.

---

# Para ejecutar en clase

- Explicar el join y el where, el estudiante va escribir 3 joins en papel
- Explicar declaración de variables, asignacion en codigo, en select, uso de variables y constantes en el select, el estudiante va escribir 2 selects que hagan uso de esa información
- Explicar el update simple y el update con join, el estudiante va escribir uno de cada uno 
- Proceder con el ejercicio de store procedures 

