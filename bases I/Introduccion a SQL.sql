use petsdb;

select * from pets_countries;

INSERT INTO `petsdb`.`pets_countries`  
VALUES 
(1,'Panama', 'US Dollar', '$', 'ES');

INSERT INTO `petsdb`.`pets_countries`  
VALUES 
(2, 'United States', 'US Dollar', '$', 'EN');

INSERT INTO `petsdb`.`pets_countries` (`currencySymbol`, `language`, `name`, `currency`, )  
VALUES 
('$', 'ES', "Canada", "CAN");

pets_countriesINSERT INTO `petsdb`.`pets_countries` (`name`, `currency`, `currencySymbol`, `language`) 
VALUES 
('United States', 'US Dollar', '$', 'EN'),
('France', 'Euro', '€', 'FR'),
('Japan', 'Japanese Yen', '¥', 'JA');

