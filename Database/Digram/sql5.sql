-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema salesdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema salesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `salesdb` DEFAULT CHARACTER SET utf8 ;
USE `salesdb` ;

-- -----------------------------------------------------
-- Table `salesdb`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`Employee` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`Employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `role` VARCHAR(50) NOT NULL CHECK (`role` IN ('Accountant', 'Driver', 'SalesRepresentative')),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`Person` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`Person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `location` VARCHAR(50) NULL,
  `type` VARCHAR(50) NOT NULL CHECK (`type` IN ('Customer', 'Supplier')),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`Phone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`Phone` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`Phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phoneNumber` VARCHAR(15) NOT NULL,
  `Employee_id` INT NULL,
  `Person_id` INT NULL,
  UNIQUE INDEX `number_UNIQUE` (`phoneNumber` ASC) ,
  INDEX `fk_Phone_Person1_idx` (`Person_id` ASC) ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) INVISIBLE,
  UNIQUE INDEX `unique_employee_phone` (`Employee_id` ASC, `phoneNumber` ASC) INVISIBLE,
  UNIQUE INDEX `unique_person_phone` (`Person_id` ASC, `phoneNumber` ASC) ,
  CONSTRAINT `fk_Phone_Employee`
    FOREIGN KEY (`Employee_id`)
    REFERENCES `salesdb`.`Employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Phone_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `salesdb`.`Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`item` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  `itemBalance` DOUBLE NOT NULL,
  `sellingPrice` DECIMAL(10,2) NULL,
  `PurchasingPrice` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`Transaction` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`Transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transactionDate` DATETIME NOT NULL,
  `totalAmount` DECIMAL(10,2) NOT NULL,
  `salesRepId` INT NOT NULL,
  `Person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Transaction_Employee1_idx` (`salesRepId` ASC) ,
  INDEX `fk_Transaction_Person1_idx` (`Person_id` ASC) ,
  CONSTRAINT `fk_Transaction_Employee1`
    FOREIGN KEY (`salesRepId`)
    REFERENCES `salesdb`.`Employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Transaction_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `salesdb`.`Person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`PurchaseTransaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`PurchaseTransaction` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`PurchaseTransaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchaseDate` DATETIME NOT NULL,
  `totalAmount` DECIMAL(10,2) NOT NULL,
  `Person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_PurchaseTransaction_Person1_idx` (`Person_id` ASC) ,
  CONSTRAINT `fk_PurchaseTransaction_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `salesdb`.`Person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`Payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`Payment` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`Payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL(10,2) NOT NULL,
  `paymentDate` DATETIME NOT NULL,
  `paymentType` ENUM('Payment', 'Receipt') NOT NULL,
  `paymentWay` VARCHAR(45) NOT NULL,
  `Transaction_id` INT NULL,
  `Person_id` INT NOT NULL,
  `PurchaseTransaction_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Payment_Person1_idx` (`Person_id` ASC) ,
  INDEX `fk_Payment_Transaction1_idx` (`Transaction_id` ASC) ,
  INDEX `fk_Payment_PurchaseTransaction1_idx` (`PurchaseTransaction_id` ASC) ,
  CONSTRAINT `fk_Payment_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `salesdb`.`Person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Payment_Transaction1`
    FOREIGN KEY (`Transaction_id`)
    REFERENCES `salesdb`.`Transaction` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Payment_PurchaseTransaction1`
    FOREIGN KEY (`PurchaseTransaction_id`)
    REFERENCES `salesdb`.`PurchaseTransaction` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`PurchaseDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`PurchaseDetail` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`PurchaseDetail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` DOUBLE NOT NULL,
  `purchasingPrice` DECIMAL(10,2) NOT NULL,
  `comulativePrice` DECIMAL(10,2) NULL,
  `PurchaseTransaction_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`, `PurchaseTransaction_id`),
  INDEX `fk_PurchaseDetail_PurchaseTransaction1_idx` (`PurchaseTransaction_id` ASC) ,
  INDEX `fk_PurchaseDetail_item1_idx` (`item_id` ASC) ,
  CONSTRAINT `fk_PurchaseDetail_PurchaseTransaction1`
    FOREIGN KEY (`PurchaseTransaction_id`)
    REFERENCES `salesdb`.`PurchaseTransaction` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PurchaseDetail_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `salesdb`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salesdb`.`TransactionDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salesdb`.`TransactionDetail` ;

CREATE TABLE IF NOT EXISTS `salesdb`.`TransactionDetail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` DOUBLE NOT NULL,
  `sellingPrice` DECIMAL(10,2) NOT NULL,
  `comulativePrice` DECIMAL(10,2) NOT NULL,
  `Transaction_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`, `Transaction_id`),
  INDEX `fk_TransactionDetail_Transaction1_idx` (`Transaction_id` ASC) ,
  INDEX `fk_TransactionDetail_item1_idx` (`item_id` ASC) ,
  CONSTRAINT `fk_TransactionDetail_Transaction1`
    FOREIGN KEY (`Transaction_id`)
    REFERENCES `salesdb`.`Transaction` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TransactionDetail_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `salesdb`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
