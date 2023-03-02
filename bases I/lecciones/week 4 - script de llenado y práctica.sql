use coperosystem;

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
('Azucena', 24, 0),
('Croto especial', 45, 0),
('Rosa Negra', 12, 0),
('Limoncillo', 8, 0),
('Crisantemo amarillo', 45, 0),
('Geranio', 13, 0),
('Amapola roja', 11, 0),
('Amapola amarilla', 9, 0),
('Lavanda', 17, 0),
('Zanahoria', 36, 0),
('Loteria criolla', 29, 0);

-- Operation Types
-- 0 = ingreso de cosecha
-- 1 = ingreso de proveedor
-- 2 = dadas de baja
-- 3 = salida por venta
-- 4 = ajuste

DELIMITER $$
DROP PROCEDURE IF EXISTS fillInventoryLogs$$
CREATE PROCEDURE fillInventoryLogs(IN amountofrecords INT, IN operationtype INT, IN employeeid INT, IN providerid INT, IN inventorycheckid INT)
BEGIN
	DECLARE theplantid INT;
    DECLARE quantity INT;
    DECLARE operationFactor INT DEFAULT 1;
    DECLARE recordTime TIMESTAMP;
    
    SELECT DATE_ADD(NOW(), INTERVAL -FLOOR(RAND() * 8) MONTH) + INTERVAL FLOOR(RAND() * 86400) SECOND AS random_timestamp INTO recordTime;
    
	WHILE amountofrecords > 0 DO
		IF (operationtype>1 AND operationtype<4) THEN
			SET operationFactor = -1;
        END IF;

		SELECT plantid FROM plantas ORDER BY RAND() LIMIT 1 INTO theplantid;
        
		INSERT INTO inventorylog (operationType, posttime, plantid, quantity, employeeid, providerid, inventorycheckid) VALUES
		(operationtype, recordTime, theplantid, RAND()*17*operationFactor, employeeid, providerid, inventorycheckid);
        
		SET amountofrecords = amountofrecords - 1;
	END WHILE;
END$$
DELIMITER ;  

CALL fillInventoryLogs (5, 1, 3, 2, NULL);

select * from inventorylog;


