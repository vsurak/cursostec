Database engine: PostgreSQL 18
Database name: lotocr
Context: El programa para un puesto de venta de lotería debe permitir la gestión integral de operaciones diarias, incluyendo apertura y cierre de caja con control de dinero e inventario, registro de ventas de lotería, tiempos y raspaditas, pago de premios, cambios de turno entre empleados, y validación de coincidencia entre sistema y conteo físico; además, debe administrar usuarios con distintos permisos (abrir, cerrar, entregar caja, vender, pagar premios), mantener inventario actualizado de productos y registrar los números y premios ganadores para asegurar transparencia y trazabilidad en todas las transacciones.  

# Table definitions

## usuarios
- usuarioid (PK) GENERATED ALWAYS AS INDENTITY
- nombre varchar 40
- apellido1 varchar 40
- apellido2 varchar 40
- estado boolean

## permisos
- permisoid (PK) GENERATED ALWAYS AS INDENTITY
- permissinoname varchar 80
- permissioncode varchar 10

## cajas
- cajaid (PK) GENERATED ALWAYS AS INDENTITY
- nombre varchar 20
- estado boolean

## transacciones
- transaccionid (PK) GENERATED ALWAYS AS INDENTITY
- cajaid (FK cajas)
- tipoid (FK a tiposdetransacciones)
- monto money (12,2) -- 12 digitos de los cuales 2 son decimales
- detalle varchar(100)
- fechahora timestamp
- usuarioid FK 
- movimientoid FK movimientos 

## movimientos
- movimientoid (PK) GENERATED ALWAYS AS INDENTITY
- tipoproductoid FK a tiposdeproducto 
- numero integer NULL
- serie integer NULL
- cantidad
- sorteoid FK sorteos
- cajaid (FK cajas)

## sorteos
- sorteoid (PK) GENERATED ALWAYS AS INDENTITY
- numerodesorteo integer not null
- numero null 
- serie null
- fechasorteo date
- estadoid FK estadosdesorteo

## controlcajas
- controlcajaid (PK) GENERATED ALWAYS AS INDENTITY
- cajaid (FK cajas)
- tipoproductoid FK a tiposdeproducto 
- emisorid (FK usuarios)
- receptorid FK usuarios
- montocalculado decimal(12, 2)
- montofisico decimal(12,2)
- diferencia decimal(12,2)
- fecha datetime
- tipodeoperacionid FK tiposdeoperacion
- comentarios varchar (200)
- solucionid FK resoluciones


# database script

Aquí tienes un **script en PostgreSQL 18** para crear la base de datos `lotocr` y las tablas definidas en tu esquema:

```sql
-- Tabla de usuarios
CREATE TABLE usuarios (
    usuarioid SERIAL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido1 VARCHAR(40) NOT NULL,
    apellido2 VARCHAR(40),
    estado BOOLEAN DEFAULT TRUE
);

-- Tabla de permisos
CREATE TABLE permisos (
    permisoid SERIAL PRIMARY KEY,
    permissionname VARCHAR(80) NOT NULL,
    permissioncode VARCHAR(10) NOT NULL
);

-- Tabla de cajas
CREATE TABLE cajas (
    cajaid SERIAL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    estado BOOLEAN DEFAULT TRUE
);

-- Tabla de tipos de transacciones
CREATE TABLE tiposdetransacciones (
    tipoid SERIAL PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL
);

-- Tabla de tipos de producto
CREATE TABLE tiposdeproducto (
    tipoproductoid SERIAL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL
);

-- Tabla de estados de sorteo
CREATE TABLE estadosdesorteo (
    estadoid SERIAL PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL
);

-- Tabla de tipos de operación
CREATE TABLE tiposdeoperacion (
    tipodeoperacionid SERIAL PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL
);

-- Tabla de resoluciones
CREATE TABLE resoluciones (
    resolucionid SERIAL PRIMARY KEY,
    descripcion VARCHAR(15)
);

-- Tabla de sorteos
CREATE TABLE sorteos (
    sorteoid SERIAL PRIMARY KEY,
    numerodesorteo INTEGER NOT NULL,
    numero INTEGER,
    serie INTEGER,
    fechasorteo DATE NOT NULL,
    estadoid BIGINT REFERENCES estadosdesorteo(estadoid)
);

-- Tabla de movimientos
CREATE TABLE movimientos (
    movimientoid SERIAL PRIMARY KEY,
    tipoproductoid BIGINT REFERENCES tiposdeproducto(tipoproductoid),
    numero INTEGER,
    serie INTEGER,
    cantidad INTEGER NOT NULL,
    sorteoid BIGINT REFERENCES sorteos(sorteoid),
    cajaid BIGINT REFERENCES cajas(cajaid)
);

-- Tabla de transacciones
CREATE TABLE transacciones (
    transaccionid SERIAL PRIMARY KEY,
    cajaid BIGINT REFERENCES cajas(cajaid),
    tipoid BIGINT REFERENCES tiposdetransacciones(tipoid),
    monto NUMERIC(12,2) NOT NULL,
    detalle VARCHAR(100),
    fechahora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioid BIGINT REFERENCES usuarios(usuarioid),
    movimientoid BIGINT REFERENCES movimientos(movimientoid)
);

-- Tabla de control de cajas
CREATE TABLE controlcajas (
    controlcajaid SERIAL PRIMARY KEY,
    cajaid BIGINT REFERENCES cajas(cajaid),
    tipoproductoid BIGINT REFERENCES tiposdeproducto(tipoproductoid),
    emisorid BIGINT REFERENCES usuarios(usuarioid),
    receptorid BIGINT REFERENCES usuarios(usuarioid),
    montocalculado DECIMAL(12,2) NOT NULL,
    montofisico DECIMAL(12,2) NOT NULL,
    diferencia DECIMAL(12,2),
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tipodeoperacionid BIGINT REFERENCES tiposdeoperacion(tipodeoperacionid),
    comentarios VARCHAR(200),
    solucionid BIGINT REFERENCES resoluciones(resolucionid)
);
