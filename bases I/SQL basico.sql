select * from clientes;
select * from prestamos;
select * from transactions;


-- Ejercicio #3 - rodrigo nunez

-- order by

select prestamoid, clientid, posttime, amount, saldoDespues from transactions
order by posttime desc, amount; -- el order by permite ordenar por varios cambios y lo hace en la presedencia que se le de en los campos/
-- ordena primero por fecha y dentro de eso ordena por monto y de forma desc, es decir, que estaría obteniendo
-- los pagos mas recientes de mayor a menor monto

-- los ordenamientos no solo hacen el sort , si no que también ayudan a resolver joins, esto porque si para resolver 
-- un join es más efectivo ordenar los datos primero, entonces se hace el sort antes que el join
-- el sort se considera un asistente para el join

-- el detecta que hay join by clientid y order by clientid, o bien que exista un indice de ordenamiento sobre
-- clientid en la tabla donde es foreign key
clientid, name
1, pedro
2, ana
3, juan

transid, clientid, amount
1, 2, 200
2, 2, 100
3, 1, 500
4, 2, 100
5, 3, 500

-- si se dan las condiciones de arriba entonces ordena de segundo

transid, clientid, amount
3, 1, 500
1, 2, 200
2, 2, 100
4, 2, 100
5, 3, 500

order by clientid



-- limit or top, se trae una cantidad determinada de registros
-- traiga las ultimas top 3 transaciones de mayor monto
select transid, prestamoid, clientid, amount from transactions
order by amount desc limit 3; -- sacando los 3 primeros, en otros lenguajes se usa top en lugar de limit
-- select top 3 transid, prestamoid, clientid, amount from transactions
-- order by amount desc

-- case, funciona exactamente como los lenguajes de programacion, se escriben a nivel de fields en la instrucción
-- select 
select * from prestamos;

-- clasificar los prestamos como tasa Alta o Baja, de tal forma que los préstamos con una tasa inferior al 10% se 
-- se consideran Low y los mayor a eso High

-- el case es un ejemplo también de campo calculado
SELECT prestamoid, clientid, monto, tasa, 
CASE 
	WHEN tasa<10.0 THEN 'Low'
    WHEN tasa>=10.0 AND tasa<=20.0 THEN 'High'
    ELSE 'Super High Ladron'
END AS Nivel
from prestamos;


-- quiero sacar la cantidad de prestamos low y high
SELECT
SUM(  
	CASE 
		WHEN tasa<10.0 THEN 1 ELSE 0
	END
) AS CantidadLow,
SUM(  
	CASE 
		WHEN tasa>=10.0 THEN 1 ELSE 0
	END
) AS CantidadHigh
FROM prestamos;

-- views con nested queries
-- views, las vistas son estructuras que nos permiten consolidar consultas a la base de datos
-- de forma que se puedan tratar como si fueran tablas , las cuales son una consulta compleja sobre varias tablas
-- las vistas son código almacenado que calcula el query que debe correrse para obtener los datos de la vista
-- puede ser que esa vista sea dinámica, es decir que la información se va a traer de la base de datos en tiempo de ejecución
-- o bien, puede ser estática, donde los datos se copian en el momento de la creación de la vista y se opera sobre esa copia

-- quiero tener una vista que tenga a todas las personas, el saldo actual que deben, el estado y cuando fué su última 
-- fecha de pago y la cantidad de cuotas pagadas

-- aqui tengo los datos de saldos y estado de prestamos por cliente
select cli.clientid, CONCAT(cli.nombre, ' ', cli.apellido) cliente, p.saldo, p.estado
from clientes cli inner join prestamos p 
ON p.clientid = cli.clientid; 

-- el dato de fecha y cantidad de pagos por clientes
select clientid, count(1) cuotas, max(posttime) lastPaymentDate from transactions
group by clientid;
	
select calc_prestamos.*, cuotas.cuotas, cuotas.lastPaymentDate from (
	(
		select cli.clientid, CONCAT(cli.nombre, ' ', cli.apellido) cliente, p.saldo, p.estado
		from clientes cli inner join prestamos p 
		ON p.clientid = cli.clientid 
	) as calc_prestamos
	inner join (
		select clientid, count(1) cuotas, max(posttime) lastPaymentDate from transactions
		group by clientid    
    ) as cuotas
    on calc_prestamos.clientid = cuotas.clientid
); 

CREATE VIEW vw_estadoprestamos AS
select calc_prestamos.*, cuotas.cuotas, cuotas.lastPaymentDate from (
	(
		select cli.clientid, CONCAT(cli.nombre, ' ', cli.apellido) cliente, p.saldo, p.estado
		from clientes cli inner join prestamos p 
		ON p.clientid = cli.clientid 
	) as calc_prestamos
	inner join (
		select clientid, count(1) cuotas, max(posttime) lastPaymentDate from transactions
		group by clientid    
    ) as cuotas
    on calc_prestamos.clientid = cuotas.clientid
);

select * from vw_estadoprestamos;
-- hasta aqui ejercicio #3


-- Ejercicio #4 

-- stored procedures, cursor, IN, while, IF
/*
Los stored procedures son rutinas de scripting SQL que se almacenan en el motor de base de datos. Dichas rutinas
se almacenan ya compiladas,  para posteriormente solo ejecutarlas y no tener que estar escribiendo o enviando
todas las consultas al mismo tiempo. Adicionalmente, un stored procedure nos permite ejecutar multiples instrucciones
SQL dentro de si, haciendolo muy práctico para crear "métodos" dentro de la base de datos, es decir, bloques de código
que se pueden ejecutar.

Todos los stored procedures, functions, y triggers, cuando se ejecutan se corren por conexión de base de datos, 
y se ejecutan dentro de un scope. El scope es el área de visibilidad de la rutina. 

public void hagaAlgo(int x) 
{
   // entre los braces es el scope, lo mismo sucede en mysql, solo que ahi se usa un BEGIN y END para
   enmarcar el scope
}

Otras habilidades que nos da el scope es la capacidad de sostener variables temporables en memoria, cursores,
punteros, sesiones, tracelogs, errores.
*/

CREATE PROCEDURE <nombre> ([parameters])
BEGIN

END ;

CREATE PROCEDURE sumarHasta(limite INT)
BEGIN
	DECLARE suma INT;
    
    SET suma = 0;
    WHILE (limite>0) DO
		SET suma = suma + limite;
        SET limite = limite - 1;
    END WHILE;
    
    SELECT suma; -- un stored procedure siempre retorna como data el último select que se haya hecho, lo retorna como un dataset, no como un scalar.
END ;

-- lo de arriba da error porque recordemos que mysql usa el ; como terminador de instrucción. Tan pronto
-- se topa un ; cree que ya la instrucción está lista y debe ser enviada a ejecutar. 
-- cuando se tiene una instrucción como el create procedure que una sola instrucción, la cual
-- contiene N instrucciones adentro, se debe manipular el terminador.

DELIMITER //
DROP PROCEDURE IF EXISTS sumarHasta //
CREATE PROCEDURE sumarHasta(limite INT)
BEGIN
	DECLARE suma INT;
    
    SET suma = 0;
    WHILE (limite>0) DO
		SET suma = suma + limite;
        SET limite = limite - 1;
    END WHILE;
    
    SELECT suma as resultado; -- un stored procedure siempre retorna como data el último select que se haya hecho, lo retorna como un dataset, no como un scalar.
END //
DELIMITER ;

-- para modificar un stored procedure existente debe usar ALTER PROCEDURE
-- o bien borrarlo y volverlo a crear 

-- ahora puedo llamar a mi stored procedure
call sumarHasta(67);

-- crear un stored procedure que revise la consistencia entre el saldo de los prestamos
-- y el saldo registrado en las transacciones, esto lo vamos hacer con un cursor 

/*
Los cursores son punteros a datasets, es decir, que apuntan algun registro de una consulta, y 
se pueden utilizar para recorrer registro por registro
*/
select * from transactions where clientid=5;

DELIMITER //
DROP PROCEDURE IF EXISTS checkBalances //
CREATE PROCEDURE checkBalances()
BEGIN
	DECLARE finDeRegistros INT DEFAULT FALSE;
    DECLARE vPrestamoId INT;
    DECLARE vSaldo DECIMAL(15,2);
    DECLARE vSaldoEnTransacciones DECIMAL(15,2);
	DECLARE balPrestamos CURSOR FOR SELECT prestamoid, saldo FROM prestamos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finDeRegistros = TRUE;
    
    OPEN balPrestamos; -- ubicarse en el primer registro del select asociado
    
    cicloLectura: LOOP
		FETCH balPrestamos INTO vPrestamoId, vSaldo;
        
        IF finDeRegistros THEN
			LEAVE cicloLectura;
        END IF;
        
        SELECT saldoDespues FROM transactions 
        WHERE prestamoid = vPrestamoId AND transid IN (
			SELECT MAX(transid) FRoM transactions WHERE prestamoid = vPrestamoId
        ) INTO vSaldoEnTransacciones;
        
        IF (vSaldo <> vSaldoEnTransacciones) THEN
			SELECT 'Prestamo con inconsistencia: ', vPrestamoid, vSaldo SaldoEnPrestamos, vSaldoEnTransacciones SaldoTransacciones;
        END IF;
        
    END LOOP;
END //
DELIMITER ;

select * from prestamos;

-- modifico a fuerza un saldo para que me salga en el chequeo
update prestamos set saldo = 39600.00 WHERE prestamoid=4;

call checkBalances();


/* Ejercicio #4 
Crear un stored procedure que se llame executeLoanTransaction, debe recibir por parámetro:
la cedula del cliente, prestamoid, el type como varchar, el description, el amount del pago. 
Con esta información proceder a insertar la transacción de pago del prestamo, calculando los respectivos
campos y finalmente actualizando el campo saldo y cuotas de la tabla prestamos. 

Utilice solo las instrucciones que se han visto en clase. 
*/
-- functions

-- triggers



