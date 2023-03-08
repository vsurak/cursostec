

INSERT INTO checkstatuses (statusname) VALUES
('Clear'),
('Canceled'),
('Differences');

INSERT INTO checktypes (checktypename) VALUES
('Open'),
('Close'),
('Refill'),
('Shift');


INSERT INTO employees (firstname, lastname, email, deleted) VALUES
('Juan', 'Perez', 'jperez@tamarindo.com', 0),
('Alejandro', 'Fernandez', 'afernandez@tamarindo.com', 0),
('Paquita', 'La del Barrio', 'delbarrio@tamarindo.com', 0),
('Ana', 'Belle', 'anabelle@tamarindo.com', 0),
('Colie', 'Buzz', 'buzz@tamarindo.com', 0);


insert into provedores (providername, phonenumber) VALUES
('Planta Feliz', '26388388'),
('Evergreen', '37222444'),('Flores del este', '27293723'),
('Tango Planta', '73927292');

insert into plantas (name, quantity, deleted) VALUES
('Azucena', 0, 0),
('Croto especial', 0, 0),
('Rosa Negra', 0, 0),
('Limoncillo', 0, 0),
('Crisantemo amarillo', 0, 0),
('Geranio', 0, 0),
('Amapola roja', 0, 0),
('Amapola amarilla', 0, 0),
('Lavanda', 0, 0),
('Zanahoria', 0, 0),
('Loteria criolla', 0, 0);

-- Operation Types
-- 0 = ingreso de cosecha
-- 1 = ingreso de proveedor
-- 2 = dadas de baja
-- 3 = salida por venta
-- 4 = ajuste


DROP PROCEDURE IF EXISTS fillInventoryLogs;

DELIMITER $$
CREATE PROCEDURE fillInventoryLogs(IN amountofrecords INT, IN operationtype INT, IN employeeid INT, IN providerid INT, IN inventorycheckid INT)
BEGIN
	DECLARE theplantid INT;
    DECLARE quantityTotal INT;
    DECLARE operationFactor INT DEFAULT 1;
    DECLARE recordTime TIMESTAMP;
    
    SELECT DATE_ADD(NOW(), INTERVAL -FLOOR(RAND() * 8) MONTH) + INTERVAL FLOOR(RAND() * 86400) SECOND AS random_timestamp INTO recordTime;
    
	WHILE amountofrecords > 0 DO
		IF (operationtype>1 AND operationtype<4) THEN
			SET operationFactor = -1;
        END IF;

		SELECT plantid FROM plantas ORDER BY RAND() LIMIT 1 INTO theplantid;

		SET quantityTotal = 1+RAND()*17*operationFactor;
        
		INSERT INTO inventorylog (operationType, posttime, plantid, quantity, employeeid, providerid, inventorycheckid) VALUES
		(operationtype, recordTime, theplantid, quantityTotal, employeeid, providerid, inventorycheckid);
    
		UPDATE plantas SET quantity = quantity + quantityTotal WHERE plantid = theplantid;
        
		SET amountofrecords = amountofrecords - 1;
	END WHILE;
    
    
END$$
DELIMITER ;

CALL fillInventoryLogs (3, 3, 4, 1, NULL);

select * from inventorylog where plantid = 5;
select * from plantas;

select * from plantas where plantid IN (4,6,9);
select * from plantas where plantid BETWEEN 4 and 6;

select plantid numeroplanta, name, posttime from plantas;

select quantity*employeeid algo ,posttime, plantid from inventorylog;

ALTER TABLE inventoryLog ADD COLUMN checksum varbinary(150) ;

select * from inventorylog;

SELECT SHA2(CONCAT(operationtype,posttime, quantity, plantid), 256) FROM inventorylog;

UPDATE inventorylog SET checksum=SHA2(CONCAT(operationtype,'papas y platanos',posttime,'chatgpt737373' ,quantity, plantid), 256)
WHERE inventoryLogid>0

update inventorylog SET quantity=20 WHERE inventorylogid=16;

SELECT * 
FROM inventorylog
WHERE SHA2(CONCAT(operationtype,posttime, quantity, plantid), 256) <>checksum;


- quiero las plantas y las cantidades que se han vendido
-- una alternativa para cruzar tablas es haciendo producto cruz, esto todos con todos

select * from plantas;
select plantid, quantity from inventorylog 
WHERE operationType = 3;

select inventorylog.plantid, inventorylog.quantity, plantas.plantid from inventorylog, plantas 
WHERE operationType = 3 AND inventoryLog.plantid = plantas.plantid;

select inventorylog.plantid, inventorylog.quantity, plantas.plantid, plantas.name 
from inventorylog, plantas 
WHERE operationType = 3 AND inventoryLog.plantid = plantas.plantid;

-- la manera correcta es usas los modificadores de joins
-- el normal es el inner join que me permite cruzar campos por cualquier condicion

select inventorylog.plantid, inventorylog.quantity, plantas.plantid, plantas.name 
from inventorylog
INNER JOIN plantas ON inventoryLog.plantid = plantas.plantid
WHERE operationType = 3; 


select inventorylog.plantid, inventoryLog.employeeid, inventorylog.quantity, 
plantas.plantid, plantas.name, 
concat(employees.firstname, ' ', employees.lastname) employeename 
from inventorylog
INNER JOIN plantas ON inventoryLog.plantid = plantas.plantid
INNER JOIN employees ON Employees.employeeid = inventoryLog.employeeid
WHERE operationType = 3 

select plantas.name, inventorylog.quantity, 
concat(employees.firstname, ' ', employees.lastname) employeename 
from inventorylog
INNER JOIN plantas ON inventoryLog.plantid = plantas.plantid
INNER JOIN employees ON Employees.employeeid = inventoryLog.employeeid
WHERE operationType = 3 

select plantas.name, log.quantity, 
concat(emp.firstname, ' ', emp.lastname) employeename 
from inventorylog log
INNER JOIN plantas ON log.plantid = plantas.plantid
INNER JOIN employees emp ON emp.employeeid = log.employeeid
WHERE operationType = 3 ;

-- quiero ver para todas las plantas existentes cuantas unidades hay disponibles para la venta

insert into plantas (name, quantity, deleted) VALUES
('Crisantemo', 0, 0),
('Apio', 0, 0);

select plantas.name, SUM(log.quantity) existencia 
from plantas
INNER JOIN inventorylog log ON plantas.plantid=log.plantid
GROUP BY plantas.name;

select plantas.name, SUM(log.quantity) existencia 
from plantas
LEFT JOIN inventorylog log ON plantas.plantid=log.plantid
GROUP BY plantas.name;


select plantas.name, IFNULL(SUM(log.quantity),0) existencia 
from plantas
LEFT JOIN inventorylog log ON plantas.plantid=log.plantid
GROUP BY plantas.name;



