CREATE DATABASE mydb5;
USE mydb5;

CREATE TABLE Board
SELECT * FROM mydb4.Board;
CREATE TABLE Reply
SELECT * FROM mydb4.Reply;

ALTER TABLE Board 
MODIFY COLUMN id INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE Reply
MODIFY COLUMN id INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE Reply
ADD FOREIGN KEY (board_id) REFERENCES Board(id);

DESC Board;
SELECT * FROM Board;
DESC Reply;


CREATE TABLE Member(
Member_No INT(11) PRIMARY KEY AUTO_INCREMENT,
Member_ID VARCHAR(50),
Member_PW INT(11),
Member_Name VARCHAR(50),
Member_Date DATETIME,
Member_Sex VARCHAR(50),
Member_Email VARCHAR(50),
Member_Role VARCHAR(50),
Member_KaKao INT(11)
);
DESC Member;

SELECT * FROM Member;

DELETE FROM Member WHERE Member_No=8;

ALTER TABLE Member
MODIFY COLUMN Member_PW VARCHAR(11);

SELECT Member_Name memberName FROM Member
WHERE Member_ID=11 AND Member_PW=1;

ALTER TABLE Member
ADD ZondCode VARCHAR(11);

ALTER TABLE Member
MODIFY ZondCode INT(11);

ALTER TABLE Member
ADD Member_Address VARCHAR(100);

ALTER TABLE Member
DROP COLUMN Member_Address;

ALTER TABLE Member
ADD MainAddress VARCHAR(30);

ALTER TABLE Member
ADD DetailAddress VARCHAR(30);

ALTER TABLE Naver_INFO
DROP COLUMN sns_profile;

ALTER TABLE Naver_INFO
ADD sns_type VARCHAR(20);

DESC Naver_INFO;

DROP TABLE Naver_INFO;
SELECT * FROM Member;

UPDATE Member
SET Member_ID = '07cBiVJkkbXYeYHFlOQx3Q6vpQiSWrsY_1528fUNr3U'
WHERE Member_No = 1 ;

UPDATE Member
SET Member_ID = '111'
WHERE Member_No = 1 ;

UPDATE Member
SET Member_Role = '111'
WHERE Member_No = 16; 

DELETE FROM Member WHERE Member_No=16;

SELECT NOW();
DESC Board;

SELECT * FROM mydb6.Member;