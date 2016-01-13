SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `FutbolDB_V3` ;
CREATE SCHEMA IF NOT EXISTS `FutbolDB_V3` DEFAULT CHARACTER SET utf8 ;
USE `FutbolDB_V3` ;

-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Confederation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Confederation` (
  `idConfederation` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `totalCountries` INT NULL DEFAULT 0,
  PRIMARY KEY (`idConfederation`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Country` (
  `idCountry` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `positionRankingFifa` INT NOT NULL,
  `idConfederation` INT NOT NULL,
  UNIQUE INDEX `positionRankingFifa_UNIQUE` (`positionRankingFifa` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  PRIMARY KEY (`idCountry`),
  INDEX `fk_idConfederation_idx` (`idConfederation` ASC),
  CONSTRAINT `fk_idConfederation`
    FOREIGN KEY (`idConfederation`)
    REFERENCES `FutbolDB_V3`.`Confederation` (`idConfederation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Team` (
  `idTeam` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `championships` INT NOT NULL,
  `idCountry` INT NOT NULL,
  PRIMARY KEY (`idTeam`),
  INDEX `fk_idCountry_idx` (`idCountry` ASC),
  CONSTRAINT `fk_idCountry`
    FOREIGN KEY (`idCountry`)
    REFERENCES `FutbolDB_V3`.`Country` (`idCountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Sponsor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Sponsor` (
  `idSponsor` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSponsor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Player` (
  `idPlayer` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `SecondLastName` VARCHAR(45) NOT NULL,
  `salary` DOUBLE NOT NULL,
  `yearsOfRemainingContract` INT NOT NULL,
  `birthDate` DATE NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `age` INT NULL DEFAULT NULL,
  `idCountry` INT NOT NULL,
  `idSponsor` INT NULL DEFAULT NULL,
  `idTeam` INT NULL DEFAULT NULL,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  PRIMARY KEY (`idPlayer`),
  INDEX `birthDate_idx` (`idCountry` ASC),
  INDEX `fk_id_idx` (`idSponsor` ASC),
  INDEX `fk_idTeam_idx` (`idTeam` ASC),
  CONSTRAINT `fk_idCountry2`
    FOREIGN KEY (`idCountry`)
    REFERENCES `FutbolDB_V3`.`Country` (`idCountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idSponsor`
    FOREIGN KEY (`idSponsor`)
    REFERENCES `FutbolDB_V3`.`Sponsor` (`idSponsor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idTeam`
    FOREIGN KEY (`idTeam`)
    REFERENCES `FutbolDB_V3`.`Team` (`idTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Stadium` (
  `idStadium` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `capacity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idStadium`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Team_Stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Team_Stadium` (
  `idTeam` INT NOT NULL,
  `idStadium` INT NOT NULL,
  PRIMARY KEY (`idTeam`, `idStadium`),
  INDEX `k_idStadium` (`idTeam` ASC),
  INDEX `index_idStadium` (`idStadium` ASC),
  CONSTRAINT `index_idStadium`
    FOREIGN KEY (`idStadium`)
    REFERENCES `FutbolDB_V3`.`Stadium` (`idStadium`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `index_idTeam`
    FOREIGN KEY (`idTeam`)
    REFERENCES `FutbolDB_V3`.`Team` (`idTeam`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutbolDB_V3`.`Team_Sponsor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FutbolDB_V3`.`Team_Sponsor` (
  `idTeam` INT NOT NULL,
  `idSponsor` INT NOT NULL,
  PRIMARY KEY (`idTeam`, `idSponsor`),
  INDEX `index_idSponsor` (`idSponsor` ASC),
  CONSTRAINT `fk_EquPat_idTeam`
    FOREIGN KEY (`idTeam`)
    REFERENCES `FutbolDB_V3`.`Team` (`idTeam`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_EquPat_idSponsor`
    FOREIGN KEY (`idSponsor`)
    REFERENCES `FutbolDB_V3`.`Sponsor` (`idSponsor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `FutbolDB_V3` ;

-- -----------------------------------------------------
-- function getTotalCountries
-- -----------------------------------------------------

DELIMITER $$
USE `FutbolDB_V3`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `getTotalCountries`(p_idConfederation INT) RETURNS int(11)
BEGIN
	declare v_totalCountries int;
	set v_totalCountries = (select count(Country.idCountry)
	from Country
	where Country.idConfederation = p_idConfederation);

RETURN v_totalCountries;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function updateTotalCountries
-- -----------------------------------------------------

DELIMITER $$
USE `FutbolDB_V3`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `updateTotalCountries`(p_totalCountries INT, p_idConfederation INT) RETURNS int(11)
BEGIN
	update Confederation 
	set totalCountries = p_totalCountries
	where Confederation.totalCountries = p_idConfederation;

RETURN 1;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `FutbolDB_V3`;

DELIMITER $$
USE `FutbolDB_V3`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `Country_AftIns` AFTER INSERT ON `Country` FOR EACH ROW
begin
	update Confederation
	set Confederation.totalCountries = getTotalCountries(NEW.idConfederation)
	where Confederation.idConfederation = NEW.idConfederation;
end$$

USE `FutbolDB_V3`$$
CREATE TRIGGER `Player_BefIns` BEFORE INSERT ON `Player` FOR EACH ROW
begin
	SET NEW.age = TIMESTAMPDIFF(YEAR,NEW.birthDate,CURDATE());
end$$


DELIMITER ;
