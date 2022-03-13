/* 220312 3
 * SQLstmtLog
 */
/**
 * Author:  antw
 * Created: 12 Mar 2022
 */

/* Database: aceBank */

/* ver: bnk01 */
CREATE DATABASE  IF NOT EXISTS aceBank; 

/* ver: bnk02 */
/* Table: bankAc */
USE aceBank;
DROP TABLE IF EXISTS bankAc;
CREATE TABLE bankAc (
  id int NOT NULL AUTO_INCREMENT,
  accNo varchar(45) NOT NULL,
  balance double DEFAULT 1000,
  intRate double DEFAULT 0.05,
  accOpenDate date DEFAULT NULL,
  accClosedDate date DEFAULT NULL,
  minBal double DEFAULT 200,
  PRIMARY KEY (id)
); 

INSERT INTO aceBank.bankAc (accNo, balance, intRate, accOpenDate,
 accClosedDate, minBal) VALUES ('123-456-789-0', 1000, 0.05000000, 
    '2022-03-01', '2022-03-11', 200);

