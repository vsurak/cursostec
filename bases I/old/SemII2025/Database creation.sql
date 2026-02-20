-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema petsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema petsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petsdb` DEFAULT CHARACTER SET utf8 ;
USE `petsdb` ;

-- -----------------------------------------------------
-- Table `petsdb`.`pets_countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_test` (
  `testid` TINYINT(16) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `language` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`testid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_estates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_estates` (
  `stateid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NULL,
  `countryid` TINYINT(16) NOT NULL,
  PRIMARY KEY (`stateid`),
  INDEX `fk_pets_estates_pets_countries_idx` (`countryid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_estates_pets_countries`
    FOREIGN KEY (`countryid`)
    REFERENCES `petsdb`.`pets_countries` (`countryid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_cities` (
  `cityid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `stateid` INT NOT NULL,
  PRIMARY KEY (`cityid`),
  INDEX `fk_pets_cities_pets_estates1_idx` (`stateid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_cities_pets_estates1`
    FOREIGN KEY (`stateid`)
    REFERENCES `petsdb`.`pets_estates` (`stateid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_addresses` (
  `addressesid` INT NOT NULL AUTO_INCREMENT,
  `line1` VARCHAR(200) NOT NULL,
  `line2` VARCHAR(200) NOT NULL,
  `zipcode` VARCHAR(9) NULL,
  `location` POINT NULL,
  `cityid` INT NOT NULL,
  PRIMARY KEY (`addressesid`),
  INDEX `fk_pets_addresses_pets_cities1_idx` (`cityid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_addresses_pets_cities1`
    FOREIGN KEY (`cityid`)
    REFERENCES `petsdb`.`pets_cities` (`cityid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_modules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_modules` (
  `moduleid` TINYINT(8) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NULL,
  PRIMARY KEY (`moduleid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_roles` (
  `roleid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`roleid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_users` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(70) NOT NULL,
  `name` VARCHAR(80) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_permissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_permissions` (
  `permissionid` INT NOT NULL,
  `description` VARCHAR(60) NOT NULL,
  `code` VARCHAR(10) NOT NULL,
  `moduleid` TINYINT(8) NOT NULL,
  `htmlObjectId` VARCHAR(60) NULL,
  `dotnetTag` VARCHAR(45) NULL,
  PRIMARY KEY (`permissionid`),
  INDEX `fk_pet_permissions_pets_modules1_idx` (`moduleid` ASC) VISIBLE,
  CONSTRAINT `fk_pet_permissions_pets_modules1`
    FOREIGN KEY (`moduleid`)
    REFERENCES `petsdb`.`pets_modules` (`moduleid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_rolespermissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_rolespermissions` (
  `rolepermissionid` INT NOT NULL,
  `pets_roles_roleid` INT NOT NULL,
  `permissionid` INT NOT NULL,
  `enabled` BIT(1) NOT NULL DEFAULT 1,
  `deleted` BIT(1) NOT NULL DEFAULT 0,
  `lastupdate` DATETIME NOT NULL DEFAULT NOW(),
  `username` VARCHAR(50) NOT NULL,
  `checksum` VARBINARY(250) NOT NULL,
  INDEX `fk_pets_rolespermissions_pets_roles1_idx` (`pets_roles_roleid` ASC) VISIBLE,
  PRIMARY KEY (`rolepermissionid`),
  INDEX `fk_pets_rolespermissions_pets_permissions1_idx` (`permissionid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_rolespermissions_pets_roles1`
    FOREIGN KEY (`pets_roles_roleid`)
    REFERENCES `petsdb`.`pets_roles` (`roleid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pets_rolespermissions_pets_permissions1`
    FOREIGN KEY (`permissionid`)
    REFERENCES `petsdb`.`pets_permissions` (`permissionid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_userspermissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_userspermissions` (
  `rolepermissionid` INT NOT NULL AUTO_INCREMENT,
  `permissionid` INT NOT NULL,
  `enabled` BIT(1) NOT NULL DEFAULT 1,
  `deleted` BIT(1) NOT NULL DEFAULT 0,
  `lastupdate` DATETIME NOT NULL DEFAULT NOW(),
  `username` VARCHAR(50) NOT NULL,
  `checksum` VARBINARY(250) NOT NULL,
  `pets_users_userid` INT NOT NULL,
  PRIMARY KEY (`rolepermissionid`),
  INDEX `fk_pets_rolespermissions_pets_permissions1_idx` (`permissionid` ASC) VISIBLE,
  INDEX `fk_pets_userspermissions_pets_users1_idx` (`pets_users_userid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_rolespermissions_pets_permissions10`
    FOREIGN KEY (`permissionid`)
    REFERENCES `petsdb`.`pets_permissions` (`permissionid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pets_userspermissions_pets_users1`
    FOREIGN KEY (`pets_users_userid`)
    REFERENCES `petsdb`.`pets_users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_usersroles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_usersroles` (
  `roleid` INT NOT NULL,
  `userid` INT NOT NULL,
  `lastupdate` DATETIME NOT NULL DEFAULT NOW(),
  `username` VARCHAR(50) NOT NULL,
  `checksum` VARBINARY(250) NOT NULL,
  `enabled` BIT(1) NOT NULL DEFAULT 1,
  `deleted` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`roleid`, `userid`),
  INDEX `fk_pets_roles_has_pets_users_pets_users1_idx` (`userid` ASC) VISIBLE,
  INDEX `fk_pets_roles_has_pets_users_pets_roles1_idx` (`roleid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_roles_has_pets_users_pets_roles1`
    FOREIGN KEY (`roleid`)
    REFERENCES `petsdb`.`pets_roles` (`roleid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pets_roles_has_pets_users_pets_users1`
    FOREIGN KEY (`userid`)
    REFERENCES `petsdb`.`pets_users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_owners`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_owners` (
  `ownerid` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(80) NULL,
  `addressesid` INT NOT NULL,
  PRIMARY KEY (`ownerid`),
  INDEX `fk_pets_owners_pets_addresses1_idx` (`addressesid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_owners_pets_addresses1`
    FOREIGN KEY (`addressesid`)
    REFERENCES `petsdb`.`pets_addresses` (`addressesid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_pets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_pets` (
  `petid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `race` VARCHAR(20) NOT NULL,
  `age` INT NULL,
  `status` TINYINT(4) NULL DEFAULT 1,
  PRIMARY KEY (`petid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_visits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_visits` (
  `visitid` INT NOT NULL AUTO_INCREMENT,
  `startime` DATETIME NOT NULL,
  `endtime` DATETIME NULL,
  `description` VARCHAR(500) NOT NULL,
  `vetname` VARCHAR(100) NOT NULL,
  `condition` VARCHAR(50) NULL,
  `ownerid` INT NOT NULL,
  `petid` INT NOT NULL,
  PRIMARY KEY (`visitid`),
  INDEX `fk_pets_visits_pets_owners1_idx` (`ownerid` ASC) VISIBLE,
  INDEX `fk_pets_visits_pets_pets1_idx` (`petid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_visits_pets_owners1`
    FOREIGN KEY (`ownerid`)
    REFERENCES `petsdb`.`pets_owners` (`ownerid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pets_visits_pets_pets1`
    FOREIGN KEY (`petid`)
    REFERENCES `petsdb`.`pets_pets` (`petid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petsdb`.`pets_petowners`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petsdb`.`pets_petowners` (
  `ownerid` INT NOT NULL,
  `petid` INT NOT NULL,
  PRIMARY KEY (`ownerid`, `petid`),
  INDEX `fk_pets_owners_has_pets_pets_pets_pets1_idx` (`petid` ASC) VISIBLE,
  INDEX `fk_pets_owners_has_pets_pets_pets_owners1_idx` (`ownerid` ASC) VISIBLE,
  CONSTRAINT `fk_pets_owners_has_pets_pets_pets_owners1`
    FOREIGN KEY (`ownerid`)
    REFERENCES `petsdb`.`pets_owners` (`ownerid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pets_owners_has_pets_pets_pets_pets1`
    FOREIGN KEY (`petid`)
    REFERENCES `petsdb`.`pets_pets` (`petid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
