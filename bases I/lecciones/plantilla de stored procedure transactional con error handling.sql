
DROP PROCEDURE IF EXISTS prefix_actionEntity;
DELIMITER $$

CREATE PROCEDURE prefix_actionEntity
(
	pParamName VARCHAR(10), -- recomendacion de seguridad, nunca recibir IDs como parámetros
    pParamDecimal DECIMAL(10,2),
    pFundName VARCHAR(60), 
    IN pInputParam INT, 
    OUT pOutputParam BIGINT
)
BEGIN
	-- crear un sistema de código errores , las identificamos con mayúsculas para que parezca una constante
	DECLARE ERROR_CONSTANT_NAME INT DEFAULT(53000);

	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		-- dado una excepción se crean variables locales para salvar la info de la excepción
        -- si es un exception de sql, ambos campos vienen en el diagnostics
        -- pero si es una excepction forzada por el programador solo viene el ERRNO, el texto no
		GET DIAGNOSTICS CONDITION 1 @err_no = MYSQL_ERRNO, @message = MESSAGE_TEXT;
        
        IF (ISNULL(@message)) THEN -- quiere decir q es una excepcion forzada del programador
			SET @message = 'aqui saco el mensaje de un catalogo de mensajes que fue creado por equipo de desarrollo'; 
        ELSE
			-- es un exception de SQL que no queremos que salga hacia la capa de aplicacion
            -- tengo que guardar el error en una bitácora de errores... patron de bitacora
            -- sustituyo el texto del mensaje, porque no quiero que ese texto llegue al app
            SET @message = CONCAT('Internal error: ', @message);
        END IF;
        
        ROLLBACK;
        
        RESIGNAL SET MESSAGE_TEXT = @message;
	END;

	SET autocommit = 0;
    -- sacar todos los valores de lectura antes de iniciar una transacción
	-- into me permite sacar los valores del select a variables
    -- es muy cómo combinar el into con las variables locales @
    -- cuando se usa into hay que tener cuidado con 3 cosas:
    -- a) el select podría retornar más de una fila, generando error
    -- b) retorne null en los rows, usar IFNULL
    -- c) retorne vacio, entonces no se asigna nada a la variable
    
    -- no queremos arrancar una transacción si existen datos inválidos
	IF (validacion de error) THEN
		SIGNAL SQLSTATE '45000' SET MYSQL_ERRNO = ERROR_CONSTANT_NAME;
    END IF;

	START TRANSACTION;
    
		-- ahora si vienen las instrucciones de escritura, las lecturas debieron ser afuera en la medida de lo posible
        -- la distancia y complejidad entre el start tran y el commit debe ser lo más corto posible
    COMMIT;
    
	-- podría aquí hacer asignación de valores de output
END$$
DELIMITER ;


-- usando la plantilla anterior hacemos un ejemplo y lo probamos. Vamos a crear un stored procedure que pueda recibir
-- K registros para inventoryLog y que al recibirlos actualice el conteo en plantas

use viveroshop;

DROP PROCEDURE IF EXISTS vivero_registerInventoryLog;
DELIMITER $$

CREATE PROCEDURE vivero_registerInventoryLog
(
	IN pInventoryGroup VARCHAR(36),
    IN pEmployeeEmail VARCHAR(30),
    IN pEmployeeId INT
)
BEGIN
	DECLARE INVALID_EMPLOYEE INT DEFAULT(53000);
    DECLARE INVALID_OPERATION_TYPE INT DEFAULT(53001);
	DECLARE InventoryPostTIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP();
    DECLARE EmployeeID INT;

	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		GET DIAGNOSTICS CONDITION 1 @err_no = MYSQL_ERRNO, @message = MESSAGE_TEXT;
        
        IF (ISNULL(@message)) THEN 
			SET @message = ''; 
        ELSE
            SET @message = CONCAT('Internal error: ', @message);
        END IF;
        
        ROLLBACK;
        
        RESIGNAL SET MESSAGE_TEXT = @message;
	END;
    
    -- SELECT employeeid FROM employees WHERE email = pEmployeeEmail INTO pEmployeeId;
    SET EmployeeID = pEmployeeId;

    IF (EmployeeID=-1) THEN
		SIGNAL SQLSTATE '45000' SET MYSQL_ERRNO = INVALID_EMPLOYEE;
    END IF;
    
	IF EXISTS(SELECT operationType FROM tmpInventoryData WHERE operationType>4 ) THEN
		SIGNAL SQLSTATE '45000' SET MYSQL_ERRNO = INVALID_OPERATION_TYPE;
    END IF;

	SET autocommit = 0;
	START TRANSACTION;
    
		INSERT INTO inventorylog (operationType, posttime, plantid, quantity, employeeid, providerid, inventorycheckid) 
		SELECT operationType, InventoryPostTIME, plantid, quantity, employeeid, NULL, NULL FROM tmpInventoryData
        WHERE inventorygroup = pInventoryGroup;

		UPDATE Plantas 
        INNER JOIN tmpInventoryData inv ON inv.plantid = Plantas.plantid
        SET Plantas.Quantity = Plantas.Quantity+CASE WHEN (inv.operationType=2 OR inv.operationType=3) THEN -1 ELSE 1 END * inv.Quantity;
    COMMIT;
    
END$$
DELIMITER ;



DROP TABLE IF EXISTS tmpInventoryData;
create table tmpInventoryData (
	inventorygroup VARCHAR(36),
    plantid INT,
    quantity SMALLINT,
    operationType TINYINT
);

SET @migrupo = UUID();
SELECT @migrupo;

select * from plantas;

-- operationtypes
-- 0 = ingreso de cosecha
-- 1 = ingreso de proveedor
-- 2 = dadas de baja
-- 3 = salida por venta
-- 4 = ajuste

select * from plantas;
INSERT INTO tmpInventoryData (inventorygroup, plantid, quantity, operationType) VALUES
(@migrupo,7,8,0),  
(@migrupo,4,6, 2),
(@migrupo,11,6,9),
(@migrupo,6, 4,3);


call vivero_registerInventoryLog('6503a2c9-c466-11ed-b0a3-0242ac110002','delbarrio@tamarindo.com', 3);
