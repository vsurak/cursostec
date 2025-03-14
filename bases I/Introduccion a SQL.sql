use petsdb;

select * from pets_countries;

INSERT INTO `petsdb`.`pets_countries`  
VALUES 
(1,'Panama', 'US Dollar', '$', 'ES');


INSERT INTO `petsdb`.`pets_countries` (`currencySymbol`, `language`, `name`, `currency`)  
VALUES 
('$', 'ES', "Canada", "CAN");

INSERT INTO `petsdb`.`pets_countries` (`name`, `currency`, `currencySymbol`, `language`) 
VALUES 
('United States', 'US Dollar', '$', 'EN'),
('France', 'Euro', '€', 'FR'),
('Japan', 'Japanese Yen', '¥', 'JA');


INSERT INTO `petsdb`.`pets_countries`  
VALUES 
(120,'Costa Rica', 'CRC', 'CRC', 'ES');

INSERT INTO `petsdb`.`pets_countries` (`currencySymbol`, `language`, `name`, `currency`)  
VALUES 
('Y', 'JP', "Japan", "Yens");


select name, currency from pets_countries;

select name, currency from pets_countries WHERE name='Japan';

select name, currency from pets_countries WHERE name IN ('Japan', 'United States');

select * from pets_countries;
select * from pets_estates;

INSERT INTO pets_estates (name, countryid) VALUES
('Cartago', 120),
('Heredia', 120);

INSERT INTO pets_estates (name, countryid) VALUES
('Alajuela', 100) ;

INSERT INTO pets_cities (name, stateid) VALUES
('Los Angeles', 1),
('Tejar', 1),
('El Carmen', 1),
('Flores', 2),
('San Joaquin', 2);


INSERT INTO `petsdb`.`pets_addresses` (`line1`, `line2`, `zipcode`, `location`, `cityid`)
VALUES ('123 Main St', 'Apt 4B', '12345', ST_GeomFromText('POINT(40.7128 -74.0060)'), 1);

INSERT INTO `petsdb`.`pets_addresses` (`line1`, `line2`, `zipcode`, `location`, `cityid`)
VALUES ('123 Main St', 'Apt 4B', '12345', ST_GeomFromText('POINT(41.7128 -74.0060)'), 5);

select * from pets_addresses;


-- Insert 1
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('John', 'Doe', 'john.doe@example.com', 1);

-- Insert 2
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('Jane', 'Smith', 'jane.smith@example.com', 2);

-- Insert 3
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('Alice', 'Johnson', 'alice.johnson@example.com', 1);

-- Insert 4
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('Bob', 'Brown', 'bob.brown@example.com', 2);

-- Insert 5
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('Charlie', 'Davis', 'charlie.davis@example.com', 1);

-- Insert 6
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('Eva', 'Wilson', 'eva.wilson@example.com', 2);

-- Insert 7
INSERT INTO `petsdb`.`pets_owners` (`firstname`, `lastname`, `email`, `addressesid`)
VALUES ('Frank', 'Moore', 'frank.moore@example.com', 1);


-- Insert 1
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Buddy', 'Labrador', 3, 1);

-- Insert 2
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Max', 'German Shepherd', 5, 1);

-- Insert 3
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Bella', 'Golden Retriever', 2, 1);

-- Insert 4
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Charlie', 'Bulldog', 4, 1);

-- Insert 5
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Lucy', 'Poodle', 6, 1);

-- Insert 6
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Daisy', 'Beagle', 1, 1);

-- Insert 7
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Molly', 'Rottweiler', 7, 1);

-- Insert 8
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Bailey', 'Boxer', 3, 1);

-- Insert 9
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Lola', 'Dachshund', 2, 1);

-- Insert 10
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Rocky', 'Siberian Husky', 4, 1);

-- Insert 11
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Coco', 'Chihuahua', 1, 1);

-- Insert 12
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Milo', 'Shih Tzu', 5, 1);

-- Insert 13
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Sophie', 'Pug', 3, 1);

-- Insert 14
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Duke', 'Great Dane', 2, 1);

-- Insert 15
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Luna', 'Border Collie', 4, 1);

-- Insert 16
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Zoe', 'Yorkshire Terrier', 1, 1);

-- Insert 17
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Toby', 'Australian Shepherd', 3, 1);

-- Insert 18
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Oscar', 'French Bulldog', 2, 2);

-- Insert 19
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Ruby', 'Cocker Spaniel', 5, 2);

-- Insert 20
INSERT INTO `petsdb`.`pets_pets` (`name`, `race`, `age`, `status`)
VALUES ('Leo', 'Pomeranian', 1, 2);



select * from pets_owners;
select * from pets_pets;
select * from pets_petowners;


INSERT INTO pets_petowners (ownerid, petid) 
SELECT 1, petid from pets_pets;

select * from pets_petowners;

update pets_petowners SET ownerid = 2 WHERE petid IN (11, 19, 9);
update pets_petowners SET ownerid = 3 WHERE petid IN (1, 4, 3);
update pets_petowners SET ownerid = 4 WHERE petid IN (5, 10);
update pets_petowners SET ownerid = 5 WHERE petid IN (20);
update pets_petowners SET ownerid = 6 WHERE petid IN (17, 13, 8);
update pets_petowners SET ownerid = 7 WHERE petid IN (11, 2);

select * from pets_owners ORDER BY lastname;
select * from pets_owners ORDER BY lastname ASC;
select * from pets_owners ORDER BY lastname DESC;

select * from pets_owners ORDER BY lastname, firstname DESC;

SELECT @countVisits;

select RAND();

select 'hola';
select 1;

select *,RAND() from pets_petowners;

DROP PROCEDURE LlenarDeVisitas;
DELIMITER //

CREATE PROCEDURE LlenarDeVisitas()
BEGIN
	SET @countVisits = 1000;

	WHILE @countVisits > 0 DO
		-- User-defined variable in a session
		SET @ownerid = 1;
		SET @petid = 1;

		SELECT ownerid, petid from pets_petowners ORDER BY RAND() limit 1 INTO @ownerid, @petid;

		-- Declarar la variable para almacenar la fecha y hora aleatoria
		SET @starttime = NULL;
		-- Generar una fecha y hora aleatoria dentro del rango especificado
		SET @starttime = DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 200) DAY); -- Fecha aleatoria en los últimos 200 días
		SET @starttime = DATE_ADD(DATE(@starttime), INTERVAL FLOOR(8 + RAND() * 9) HOUR); -- Hora entre 8 AM y 5 PM
		SET @starttime = DATE_ADD(@starttime, INTERVAL FLOOR(RAND() * 60) MINUTE); -- Minutos aleatorios (0-59)

		-- Declarar la variable para almacenar la nueva fecha
		SET @endtime = NULL;
		-- Agregar un número aleatorio de minutos entre 15 y 130
		SET @endtime = DATE_ADD(@starttime, INTERVAL FLOOR(15 + RAND() * 116) MINUTE);

		SET @vetname = NULL;
		SET @condicion = NULL;
		SELECT ELT(FLOOR(1 + RAND() * 4), 'patitas vet', 'mi mascota', 'uñitas', 'maskotitas') INTO @vetname;
		SELECT ELT(FLOOR(1 + RAND() * 6), 'fiebre', 'infección', 'sano', 'sarro', 'virus estomacal', 'dolor muscular') INTO @condicion;

		INSERT INTO pets_visits (startime, endtime, description, vetname, `condition`, ownerid, petid)
		VALUES (@starttime, @endtime, 'Esto es la descripcion', @vetname, @condicion, @ownerid, @petid);

		SET @countVisits = @countVisits - 1;
	END WHILE ;
END //

DELIMITER ;

call LlenarDeVisitas();

select * from pets_visits;

DELETE FROM pets_visits;
DELETE FROM pets_visits WHERE visitid = 1;

















