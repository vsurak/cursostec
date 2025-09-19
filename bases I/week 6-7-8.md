# SQL básico parte 3 y otros patrones de diseño

En estas semanas se quiere que el estudiante logre un dominio completo de SQL y sus herramientas para ello se le explicará y realizará practicas de diseño y consultas SQL que incluya los siguientes temas:


## SQL básico parte 3

### 🔧 Functions

**Purpose**  
Functions in MySQL are built-in operations that return a value based on input parameters. They help manipulate data, perform calculations, format output, and extract information from strings, numbers, or dates.

**Use Cases**  
1. Calculating interest payments based on loan amounts and rates.  
2. Formatting client names or emails for display in reports or dashboards.

**Basic Syntax**  
```sql
DELIMITER //

CREATE FUNCTION calcMonthlyPayment(
    principal DECIMAL(15,2),
    annual_rate DECIMAL(5,2),
    num_payments INT
)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
    DECLARE monthly_rate DECIMAL(10,6);
    DECLARE payment DECIMAL(15,2);

    SET monthly_rate = annual_rate / 12 / 100;

    SET payment = principal * monthly_rate / (1 - POW(1 + monthly_rate, -num_payments));

    RETURN ROUND(payment, 2);
END //

DELIMITER ;
```

```sql
SELECT FUNCTION_NAME(arguments);
```

**Example (using your schema)**  
```sql
SELECT 
    p.prestamoid,
    c.nombre,
    c.apellido,
    p.monto,
    p.tasa,
    p.cuotas,
    calc_monthly_payment(p.monto, p.tasa, p.cuotas) AS cuota_mensual
FROM prestamos p
JOIN clientes c ON p.clientid = c.clientid;
```

**Official Help**: [MySQL Functions Reference](https://dev.mysql.com/doc/refman/8.4/en/create-procedure.html)

---

### 🔁 Triggers

**Purpose**  
Triggers are database operations that automatically execute in response to specific events (INSERT, UPDATE, DELETE) on a table. They’re used to enforce business rules, maintain audit logs, or synchronize data.

**Use Cases**  
1. Automatically log every loan payment into a transaction history.  
2. Update loan status to 'EN_MORA' if a payment is missed beyond a threshold.

**Basic Syntax**  
```sql
CREATE TRIGGER trigger_name
AFTER INSERT ON table_name
FOR EACH ROW
BEGIN
  -- trigger logic
END;
```

**Example (log new loan disbursement)**  
```sql
CREATE TRIGGER log_disbursement
AFTER INSERT ON prestamos
FOR EACH ROW
INSERT INTO transactions (
  prestamoid, clientid, type, posttime, description, amount,
  saldoBefore, saldoDespues
)
VALUES (
  NEW.prestamoid, NEW.clientid, 'DESEMBOLSO', CURDATE(),
  'Initial disbursement', NEW.monto, 0.00, NEW.monto
);
```

**Official Help**: [MySQL Trigger Syntax](https://dev.mysql.com/doc/refman/8.4/en/triggers.html)

---

### 🧩 Indexes (Primary & Secondary)

**Purpose**  
Indexes improve query performance by allowing MySQL to locate rows faster. A primary index enforces uniqueness and is usually tied to the primary key. Secondary indexes (non-primary) help optimize searches on other columns.

**Use Cases**  
1. Speeding up searches by `cedula` in the `clientes` table.  
2. Filtering transactions by `posttime` or `type`.

**Basic Syntax**  
```sql
CREATE INDEX index_name ON table_name(column_name);
```

**Example (secondary index on transactions type)**  
```sql
CREATE INDEX idx_type ON transactions(type);
```

**Official Help**: [Indexing Best Practices](https://dev.mysql.com/doc/refman/8.4/en/create-index.html)

---

### 📅 Date Functions

**Purpose**  
Date functions allow manipulation and extraction of date/time values. They’re essential for filtering, formatting, and calculating durations.

**Use Cases**  
1. Calculating loan duration between `inicio` and `cierre`.  
2. Filtering transactions from the last 30 days.

**Basic Syntax**  
```sql
SELECT DATE_FUNCTION(date_column);
```

**Example (days between loan start and close)**  
```sql
SELECT DATEDIFF(cierre, inicio) AS loan_duration FROM prestamos;
```

**Official Help**: [MySQL Date Functions](https://dev.mysql.com/doc/refman/8.4/en/date-and-time-functions.html)

---

### 🔤 String Functions

**Purpose**  
String functions manipulate text data—concatenation, trimming, searching, replacing, and formatting.

**Use Cases**  
1. Creating full names from `nombre` and `apellido`.  
2. Validating or formatting email addresses.

**Basic Syntax**  
```sql
SELECT STRING_FUNCTION(string_column);
```

**Example (uppercase client names)**  
```sql
SELECT UPPER(nombre) AS name_upper FROM clientes;
```

**Official Help**: [MySQL String Functions](https://dev.mysql.com/doc/refman/8.4/en/string-functions.html)


## Ejercicio #6

Escriba un script que logre obtener una consulta que retorna un **informe de riesgo de mora personalizado por cliente**, mostrando únicamente el **último pago registrado** para cada uno. El objetivo es identificar clientes con mayor probabilidad de incumplimiento, combinando información financiera, comportamiento de pago y estado del préstamo. 

Campos esperados en el resultado: 

- `clientid`: Identificador único del cliente.
- `cliente`: Nombre completo del cliente en mayúsculas.
- `estado`: Estado actual del préstamo (`AL_DIA` o `EN_MORA`).
- `fecha_ultimo_pago`: Fecha del último pago realizado.
- `dias_sin_pago`: Número de días desde el último pago hasta hoy.
- `nivel_riesgo`: Valor calculado por la función `riesgo_mora`, que puede ser `'BAJO'`, `'MEDIO'` o `'ALTO'`.
- `resumen`: Cadena descriptiva que incluye la cédula del cliente y el saldo pendiente, formateado para presentación.

Para realizar la consulta deberá hacer uso de: 

- Una función
- Dos funciones de fecha
- Dos funciones de string
- Agregar un índice que mejore el tiempo de respuesta de la consulta

Una vez terminado el script con la consulta, haga un dibujo usando datos que ejemplifique paso a paso como es que hace el motor de base de datos para obtener el resultado de la consulta. Cosas que se espera ver en el dibujo:  

- los datos de las tablas involucradas
- el momento en que se llama a la función en alguno de los registros 
- el momento en que se llama ya sea a una función de fecha o de string en algun registro 
- cuando decide usar el índice versus lo que hubiese pasado si no estuviera el índice creado 
- como realiza los matches de algun join  
- números de paso para saber el orden en que se ejecuta 
- que sea a mano alzada y solo lleva indicadores, no redacciones o explicaciones en prosa 
- aparecen N registros en los dibujos pero el dibujo de las operaciones anteriores se hacen sobre una sola iteración de los registros involucrados

La entrega es el archivo SQL con la consulta y el dibujo explicativo como imagen, se entrega en el classroom. 

- Entrega tardía -20
- Sospecha de copia -100
- Incongruencias o errores de AI -40

