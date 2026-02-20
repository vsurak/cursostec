# structure query language SQL

## introducción a SQL - create table, insert, delete, update, select parte I

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
```

*Orden de ejecución de las consultas* 

```sql
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


# patrones de diseño en bases de datos - parte I

A continuación se presentan 3 historias diferentes las cuales evocan a algún patron de diseño de base de datos, proceda para cada historia a hacer el diseño en workbench y seguidamente a realizar el ejercicio propuesto el cual es una consulta en SQL. Cada ejercicio debe incluir como respuesta el dibujo del diseño y el select hecho. 

## **Use Case 1: Maria la viajera**

María es una consultora que se muda frecuentemente entre ciudades por trabajo. Tiene un correo personal y otro laboral, y varios números de teléfono según su ubicación. Además, posee varias direcciones: su apartamento en la ciudad donde trabaja, la casa de sus padres donde pasa los fines de semana, y una dirección temporal en otro país mientras hace un proyecto internacional. Cada vez que María crea un perfil en un sistema profesional, quiere poder agregar todas estas formas de contacto para que clientes y colegas puedan comunicarse con ella de manera correcta según la situación.

**Idea clave para diseño:** cada persona debe poder tener **múltiples direcciones y medios de contacto**, y estos pueden cambiar o actualizarse con el tiempo.

**Ejercicio #1** 

Escribe un SELECT que muestre el nombre completo de la persona junto con todas sus direcciones principales. Debe desplegarse el nombre de la persona, la ciudad, el estado y la fecha en que se registró dicha dirección en forma descendente.  


## **Use Case 2: Juan el trader**

Juan es un entusiasta de las criptomonedas. Tiene varias cuentas donde almacena Bitcoin, Ethereum y algunas monedas emergentes. Todos los días realiza depósitos, retiros y pequeñas transacciones de intercambio entre sus criptos. Él necesita ver su **saldo actualizado** en cada moneda, y también poder consultar **el historial de cada movimiento** para saber qué operaciones hizo, cuándo y por qué motivo. Además, Juan quiere que el sistema le notifique si una transacción falla o si recibe un depósito inesperado.

**Idea clave para diseño:** los usuarios manejan **múltiples balances** y un historial detallado de transacciones, donde cada operación debe registrarse y reflejar cambios en el saldo de manera consistente.

**Ejercicio #2** 
Escribe un SELECT que muestre el nombre del usuario, el nombre de la criptomoneda, el balance actual, la suma total de todas sus transacciones exitosas en esa moneda y la fecha de la última transacción exitosa. 


## **Use Case 3: Lo siento! no puedes hacer eso!!** 

Este no se evaluó

Una empresa de logística tiene un sistema interno para gestionar pedidos, clientes y reportes de entregas. En la plataforma, algunos empleados solo pueden **ver información** (como un supervisor que revisa métricas), otros pueden **modificar datos de clientes o pedidos**, y los administradores pueden **crear, actualizar o eliminar cualquier registro**. Cada acción que hacen los usuarios queda registrada para auditoría. Por ejemplo, cuando un gerente cambia el estado de un pedido o asigna un envío a un repartidor, el sistema guarda **quién lo hizo y cuándo**, para mantener control y seguridad sobre la operación.

**Idea clave para diseño:** los usuarios del sistema tienen **roles distintos que determinan qué acciones pueden realizar**, y todas las acciones importantes deben ser auditables.

**Ejercicio-no evaluado** 
Escribe un select que dado una lista de roles, retorne la lista de permisos que todos esos roles comparten.  
