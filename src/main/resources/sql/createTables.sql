-- MySQL Workbench Synchronization
-- Generated: 2016-02-20 14:00
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Sergey

CREATE SCHEMA IF NOT EXISTS `OnlineAdsBoard` DEFAULT CHARACTER SET utf8 ;


CREATE TABLE IF NOT EXISTS `OnlineAdsBoard`.`Images` (
  `idImage` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idImage`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `OnlineAdsBoard`.`Categories` (
  `idCategory` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idParentCategory` INT(10) UNSIGNED NULL DEFAULT NULL,
  `category` VARCHAR(50) NOT NULL,
  `idImage` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`idCategory`),
  INDEX `idImage_idx` (`idImage` ASC),
  INDEX `idParent_idx` (`idParentCategory` ASC),
    FOREIGN KEY (`idImage`)
    REFERENCES `OnlineAdsBoard`.`Images` (`idImage`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    FOREIGN KEY (`idParentCategory`)
    REFERENCES `OnlineAdsBoard`.`Categories` (`idCategory`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `OnlineAdsBoard`.`Users` (
  `idUser` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `sex` CHAR(1) NULL DEFAULT NULL,
  `idImage` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `idImage_idx` (`idImage` ASC),
    FOREIGN KEY (`idImage`)
    REFERENCES `OnlineAdsBoard`.`Images` (`idImage`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `OnlineAdsBoard`.`Ads` (
  `idAd` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` TEXT NOT NULL,
  `idImage` INT(10) UNSIGNED NULL DEFAULT NULL,
  `idUser` INT(10) UNSIGNED NOT NULL,
  `views` INT(10) UNSIGNED NOT NULL,
  `isActive` TINYINT(1) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `idCategory` INT(10) UNSIGNED NOT NULL,
  `region` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAd`),
  INDEX `idUser_idx` (`idUser` ASC),
  INDEX `idImage_idx` (`idImage` ASC),
  INDEX `idCategory_idx` (`idCategory` ASC),
    FOREIGN KEY (`idUser`)
    REFERENCES `OnlineAdsBoard`.`Users` (`idUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`idImage`)
    REFERENCES `OnlineAdsBoard`.`Images` (`idImage`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    FOREIGN KEY (`idCategory`)
    REFERENCES `OnlineAdsBoard`.`Categories` (`idCategory`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `OnlineAdsBoard`.`AdsAndImages` (
  `idAd` INT(10) UNSIGNED NOT NULL,
  `idImage` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`idAd`, `idImage`),
  INDEX `idImage_idx` (`idImage` ASC),
    FOREIGN KEY (`idAd`)
    REFERENCES `OnlineAdsBoard`.`Ads` (`idAd`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`idImage`)
    REFERENCES `OnlineAdsBoard`.`Images` (`idImage`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `OnlineAdsBoard`.`UsersFavourites` (
  `idUser` INT(10) UNSIGNED NOT NULL,
  `idAd` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`idUser`, `idAd`),
  INDEX `idAd_idx` (`idAd` ASC),
    FOREIGN KEY (`idUser`)
    REFERENCES `OnlineAdsBoard`.`Users` (`idUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`idAd`)
    REFERENCES `OnlineAdsBoard`.`Ads` (`idAd`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

