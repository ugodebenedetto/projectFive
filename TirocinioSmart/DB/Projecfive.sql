
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8 ;
USE mydb ;

-- -----------------------------------------------------
-- Table mydb.Tutor Accademico
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.TutorAccademico (
  email VARCHAR(45) not NULL,
  luogoNascita VARCHAR(45) NULL,
  codiceFiscale VARCHAR(45) NULL,
  dataNascita DATE NULL,
  cognome VARCHAR(45) NULL,
  nome VARCHAR(45) NULL,
  password varchar(45)null,
  residenza varchar(45)null,
  via varchar(45)null,
  sesso varchar(20)null,
  dipartimento VARCHAR(45) NULL,
  PRIMARY KEY (`email`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Studente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Studente (
  email VARCHAR(45) NOT NULL,
  luogoNascita VARCHAR(45) NULL,
  codiceFiscale VARCHAR(45) NULL,
  dataNascita DATE NULL,
  cognome VARCHAR(45) NULL,
  nome VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  residenza varchar(45)null,
  via varchar(45)null,
  sesso varchar(20)null,
  matricola VARCHAR(45) NULL,
  tipoLaurea VARCHAR(45) NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Didattica
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Didattica (
  email VARCHAR(45) NOT NULL,
  luogoNascita VARCHAR(45) NULL,
  codiceFiscale VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  residenza varchar(45)null,
  via varchar(45)null,
  sesso varchar(20)null,
  dataNascita DATE NULL,
  cognome VARCHAR(45) NULL,
  nome VARCHAR(45) NULL,
  direttore BOOLEAN NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Tirocinio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Tirocinio (
  id INT NOT NULL,
  stato SMALLINT(5) NULL,
  nome VARCHAR(45) NULL,
  svolgimento VARCHAR(45) NULL,
  descrizione VARCHAR(45) NULL,
  argomento VARCHAR(45) NULL,
  numposti INT NULL,
  responsabile VARCHAR(45) NULL,
  sede VARCHAR(45) NULL,
  tipo VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT email
  FOREIGN KEY (responsabile) REFERENCES mydb.TutorAccademico(email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Feedback
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Feedback (
  tirocinio INT NOT NULL,
  id INT NOT NULL,
  dataInvio DATE NULL,
  commento VARCHAR(225) NULL,
  valutazione INT NULL,
  studente VARCHAR(45) NULL, 
  PRIMARY KEY (`id`),
  CONSTRAINT id
    FOREIGN KEY (tirocinio) REFERENCES mydb.Tirocinio(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT email
    FOREIGN KEY (studente)
    REFERENCES mydb.Studente (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Richiede
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.RichiestaTirocinio (
  stato SMALLINT(5) NULL,
  dataRichiesta DATE NULL,
  dataRisposta DATE NULL,
  richiedente VARCHAR(4) NULL,
  tirocinio INT NOT NULL,
  CONSTRAINT id
    FOREIGN KEY (tirocinio)
    REFERENCES mydb.Tirocinio (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT email
    FOREIGN KEY (richiedente)
    REFERENCES mydb.Studente (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Annuncio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Annuncio (
  titolo VARCHAR(45) NULL,
  didattica VARCHAR(45) NULL,
  id INT NOT NULL,
  descrizione VARCHAR(225) NULL,
  data DATE NULL,
  filePosition VARCHAR(45)NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT email
    FOREIGN KEY (didattica)
    REFERENCES mydb.Didattica (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.Avvia
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.Avvia (
didattica VARCHAR(45)NULL,
tirocinio INT NOT NULL,
  CONSTRAINT email
    FOREIGN KEY (didattica)
    REFERENCES mydb.Didattica (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT ID
    FOREIGN KEY (tirocinio)
    REFERENCES mydb.Tirocinio (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;