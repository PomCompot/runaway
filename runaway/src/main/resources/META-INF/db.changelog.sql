--liquibase formatted sql

--changeset PomCompot:1

CREATE  TABLE IF NOT EXISTS `Gender` (
  `idGender` CHAR NOT NULL ,
  PRIMARY KEY (`idGender`) 
);
INSERT INTO `Gender` (`idGender`) VALUES ('M');
INSERT INTO `Gender` (`idGender`) VALUES ('F');

CREATE  TABLE IF NOT EXISTS `City` (
  `idCity` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCity`)
);

CREATE  TABLE IF NOT EXISTS `Person` (
  `idPerson` INT NOT NULL ,
  `firstname` VARCHAR(45) NOT NULL ,
  `lastname` VARCHAR(45) NOT NULL ,
  `birthdate` DATE NULL ,
  `Gender_idGender` CHAR  ,
  `City_idCity` INT ,
  PRIMARY KEY (`idPerson`) ,
  CONSTRAINT `fk_Person_Gender`
    FOREIGN KEY (`Gender_idGender` )
    REFERENCES `Gender` (`idGender` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_City`
    FOREIGN KEY (`City_idCity` )
    REFERENCES `City` (`idCity` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
CREATE INDEX `fk_Person_Gender_idx` ON `Person` (`Gender_idGender` ASC);
CREATE INDEX `fk_Person_City_idx` ON `Person` (`City_idCity` ASC);

CREATE  TABLE IF NOT EXISTS `Club` (
  `idClub` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idClub`)
);

CREATE  TABLE IF NOT EXISTS `Competition` (
  `idCompetition` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idCompetition`)
);

CREATE  TABLE IF NOT EXISTS `Status` (
  `idStatus` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`idStatus`)
);
INSERT INTO `Status` (`idStatus`) VALUES ('Created');
INSERT INTO `Status` (`idStatus`) VALUES ('Pending');
INSERT INTO `Status` (`idStatus`) VALUES ('Running');
INSERT INTO `Status` (`idStatus`) VALUES ('Closed');

CREATE  TABLE IF NOT EXISTS `Edition` (
  `idEdition` INT NOT NULL ,
  `year` INT(4) NOT NULL ,
  `nickname` VARCHAR(45) NULL ,
  `Competition_idCompetition` INT NOT NULL ,
  `Status_idStatus` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`idEdition`) ,
  CONSTRAINT `fk_Opus_Competition`
    FOREIGN KEY (`Competition_idCompetition` )
    REFERENCES `Competition` (`idCompetition` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Edition_Status`
    FOREIGN KEY (`Status_idStatus` )
    REFERENCES `Status` (`idStatus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
CREATE INDEX `fk_Opus_Competition_idx` ON `Edition` (`Competition_idCompetition` ASC) ;
CREATE INDEX `fk_Edition_Status_idx` ON `Edition` (`Status_idStatus` ASC) ;

CREATE  TABLE IF NOT EXISTS `Participant` (
  `idParticipant` INT NOT NULL ,
  `Participantcol` VARCHAR(45) NULL ,
  `Club_idClub` INT NOT NULL ,
  `Person_idPerson` INT NOT NULL ,
  PRIMARY KEY (`idParticipant`) ,
  CONSTRAINT `fk_Participant_Club`
    FOREIGN KEY (`Club_idClub` )
    REFERENCES `Club` (`idClub` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participant_Person`
    FOREIGN KEY (`Person_idPerson` )
    REFERENCES `Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
CREATE INDEX `fk_Participant_Club_idx` ON `Participant` (`Club_idClub` ASC) ;
CREATE INDEX `fk_Participant_Person_idx` ON `Participant` (`Person_idPerson` ASC) ;

CREATE  TABLE IF NOT EXISTS `Score` (
  `idScore` INT NOT NULL ,
  `value` INT NULL ,
  `Participant_idParticipant` INT NOT NULL ,
  `Edition_idEdition` INT NOT NULL ,
  PRIMARY KEY (`idScore`) ,
  CONSTRAINT `fk_Score_Participant`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `Participant` (`idParticipant` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Score_Edition`
    FOREIGN KEY (`Edition_idEdition` )
    REFERENCES `Edition` (`idEdition` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
CREATE INDEX `fk_Score_Participant_idx` ON `Score` (`Participant_idParticipant` ASC) ;
CREATE INDEX `fk_Score_Edition_idx` ON `Score` (`Edition_idEdition` ASC) ;

CREATE  TABLE IF NOT EXISTS `PendingScore` (
  `idPendingScore` INT NOT NULL ,
  `PendingScorecol` VARCHAR(45) NULL ,
  `Participant_idParticipant` INT NOT NULL ,
  `Edition_idEdition` INT NOT NULL ,
  PRIMARY KEY (`idPendingScore`) ,
  CONSTRAINT `fk_PendingScore_Participant`
    FOREIGN KEY (`Participant_idParticipant` )
    REFERENCES `Participant` (`idParticipant` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PendingScore_Edition`
    FOREIGN KEY (`Edition_idEdition` )
    REFERENCES `Edition` (`idEdition` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
CREATE INDEX `fk_PendingScore_Participant_idx` ON `PendingScore` (`Participant_idParticipant` ASC) ;
CREATE INDEX `fk_PendingScore_Edition_idx` ON `PendingScore` (`Edition_idEdition` ASC) ;
