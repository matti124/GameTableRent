DROP DATABASE IF EXISTS GT_RENT;
CREATE DATABASE GAME_TABLE_RENT;
USE GAME_TABLE_RENT;

CREATE Table User (
Nome VARCHAR(60) NOT NULL,
Cognome varchar(30) not null,
ID int NOT NULL AUTO_INCREMENT  ,
Indirizzo varchar(60) NOT NULL,
email varchar(35) not null unique,
psw varchar(100) not null,
PRIMARY KEY(ID));

CREATE TABLE PRODOTTO(
ID_Prod INT NOT NULL AUTO_INCREMENT,
Nome varchar(20) not null unique,
Descrizione text not null,
Prezzo double not null,
PrezzoXDays double not null, 
Quantity smallint not null,
In_Cat bool default 0 not null,
PRIMARY KEY(ID_Prod),
check(Prezzo>0 AND PrezzoXDays>0 AND Quantity>0));

CREATE TABLE CARRELLO(
ID_CARRELLO INT AUTO_INCREMENT NOT NULL, 
ID_U INT NOT NULL, 
FOREIGN KEY(ID_U) REFERENCES User(ID),
PRIMARY KEY(ID_CARRELLO));


CREATE TABLE PRODOTTI_CARRELLO(
ID_CARRELLO INT NOT NULL,
ID_PRODOTTO INT NOT NULL, 
QUANTITY INT NOT NULL,
GIORNI INT DEFAULT 0 NOT NULL,
FOREIGN KEY(ID_CARRELLO) REFERENCES CARRELLO(ID_CARRELLO),
FOREIGN KEY (ID_PRODOTTO) REFERENCES PRODOTTO(ID_Prod),
CHECK(QUANTITY>0 AND GIORNI>=0));

CREATE TABLE ORDINE(
ID_ORDINE INT AUTO_INCREMENT NOT NULL,
ID_CARRELLO INT NOT NULL,
DATA_ORDINE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(ID_ORDINE),
FOREIGN KEY(ID_CARRELLO) REFERENCES CARRELLO(ID_CARRELLO));

CREATE TABLE PRODOTTI_ORDINE(
ID_ORDINE INT NOT NULL,
ID_PRODOTTO INT NOT NULL,
PREZZO DOUBLE NOT NULL,
GIORNI SMALLINT NOT NULL,
PRIMARY KEY(ID_ORDINE, ID_PRODOTTO),
FOREIGN KEY(ID_ORDINE) REFERENCES ORDINE(ID_ORDINE),
FOREIGN KEY(ID_PRODOTTO) REFERENCES PRODOTTO(ID_Prod));




