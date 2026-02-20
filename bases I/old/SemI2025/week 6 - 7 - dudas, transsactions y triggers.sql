use viveroshop;

select  'pedro' supervisor, rand()*100 valorDeAlgo from plantas;

select 1;

select * from shifts into cuentashifts
-- while counter basado en una tabla
	select into variable
    
    select into variable2
    
    calculan random1, random2
    
    insert tabla variable, variable2, randoom1, random2

-- endwhile

DELIMITER $$
CREATE FUNCTION  getPlantRandom() returns INT DETERMINISTIC
BEGIN
	SELECT plantid FROM plantas ORDER BY RAND() LIMIT 1 INTO @result;
    RETURN @result;
END $$
DELIMITER ;

select *, getPlantRandom() from plantas;

DELIMITER $$
CREATE FUNCTION  addPlantQuantity(pPlantName VARCHAR(45), pQuantity INT) returns INT DETERMINISTIC
BEGIN
	SELECT plantid FROM plantas WHERE name = pPlantName INTO @plantid;
    UPDATE plantas set quantity=quantity+pQuantity WHERE plantid = @plantid;
    RETURN 1;
END $$
DELIMITER ;



-- no me permite operar el function sobre la misma tabla en la que se está iterando
-- Error Code: 1442. Can't update table 'plantas' in stored function/trigger because it is already used by statement which invoked this stored function/trigger.
select *, addPlantQuantity(name, 5) from plantas;



