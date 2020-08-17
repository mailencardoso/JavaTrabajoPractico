-- MySQL Script generated by MySQL Workbench
-- Sat Aug 15 20:05:59 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_minimercado
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_minimercado` ;

-- -----------------------------------------------------
-- Schema db_minimercado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_minimercado` DEFAULT CHARACTER SET utf8 ;
USE `db_minimercado` ;

-- -----------------------------------------------------
-- Table `db_minimercado`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_minimercado`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `db_minimercado`.`Usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `tipo_usuario` VARCHAR(45) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_minimercado`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_minimercado`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `db_minimercado`.`Pedido` (
  `id_usuario` INT NOT NULL,
  `fecha_pedido` DATE NULL,
  `orden_completa` VARCHAR(45) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_minimercado`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_minimercado`.`Producto` ;

CREATE TABLE IF NOT EXISTS `db_minimercado`.`Producto` (
  `id_producto` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio` DECIMAL(3) NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_minimercado`.`Linea_pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_minimercado`.`Linea_pedido` ;

CREATE TABLE IF NOT EXISTS `db_minimercado`.`Linea_pedido` (
  `id_producto` INT NOT NULL,
  `id_pedido` INT NOT NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`id_producto`, `id_pedido`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `db_minimercado`.`usuario`
(`usuario`,
`nombre`,
`apellido`,
`email`,
`pass`,
`telefono`,
`direccion`,
`tipo_usuario`)
VALUES
("mcardoso",
"Mailen",
"Cardoso",
"mailalacardoso@gmail.com",
"holanda123",
"3412103600",
"Parana 400",
"administrador");

INSERT INTO `db_minimercado`.`usuario`
(`usuario`,
`nombre`,
`apellido`,
`email`,
`pass`,
`telefono`,
`direccion`,
`tipo_usuario`)
VALUES
("gastonalbizuri",
"Gaston",
"Albizuri",
"gastonalbizuri@gmail.com",
"holanda123",
"3468500043",
"Cordoba 269",
"administrador");

