-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema workshopDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema workshopDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workshopDB` DEFAULT CHARACTER SET utf8 ;
USE `workshopDB` ;

-- -----------------------------------------------------
-- Table `workshopDB`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`role` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `role` INT NOT NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshopDB`.`userInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`userInfo` (
  `userID` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `phoneNumber` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshopDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`user` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL,
  `pass` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `id_UNIQUE` (`userID` ASC) VISIBLE,
  CONSTRAINT `FK_user_role`
    FOREIGN KEY (`userID`)
    REFERENCES `workshopDB`.`role` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_userInfo`
    FOREIGN KEY (`userID`)
    REFERENCES `workshopDB`.`userInfo` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshopDB`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`product` (
  `productID` INT NOT NULL AUTO_INCREMENT,
  `typeID` INT NOT NULL,
  `materialID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `weight` INT NOT NULL,
  PRIMARY KEY (`productID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshopDB`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`type` (
  `typeID` INT NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`typeID`),
  CONSTRAINT `FK_type_product`
    FOREIGN KEY (`typeID`)
    REFERENCES `workshopDB`.`product` (`typeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshopDB`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`material` (
  `materialID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`materialID`),
  CONSTRAINT `FK_material_product`
    FOREIGN KEY (`materialID`)
    REFERENCES `workshopDB`.`product` (`materialID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshopDB`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshopDB`.`order` (
  `orderID` INT NOT NULL AUTO_INCREMENT,
  `userID` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `orderDescription` MEDIUMTEXT NOT NULL,
  `isChecked` TINYINT NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `fk_order_user1_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `FK_order_user`
    FOREIGN KEY (`userID`)
    REFERENCES `workshopDB`.`user` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
