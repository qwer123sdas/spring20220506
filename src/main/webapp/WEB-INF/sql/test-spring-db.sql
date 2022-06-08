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

USE mydb5;
DESC Member;
CREATE TABLE `SNS_INFO` (
  `Member_NO` int(11) NOT NULL,
  `sns_id` varchar(255) NOT NULL,
  `sns_type` varchar(10)  NULL,
  `sns_name` varchar(255)  NULL,
  `sns_profile` varchar(255)  NULL,
  `sns_connect_date` datetime  NULL,
  CONSTRAINT `id` FOREIGN KEY (Member_NO) REFERENCES Member (Member_NO)
);
USE mydb5;
SELECT * FROM Member;
SELECT * FROM Auth;
SELECT * FROM SNS_INFO;
DESC Member;

ALTER TABLE Member
ADD enable INTEGER(2) DEFAULT 1;

ALTER TABLE Auth
DROP enable;
USE mydb5;
SELECT * FROM Member;

DELIMITER $$ 
CREATE PROCEDURE `deletUser`(
	memberNO INTEGER
)

BEGIN 
	DELETE FROM Auth
    WHERE Member_NO = memberNO;
    
    INSERT INTO Member_Delet
	(SELECT *, NOW()  FROM Member WHERE Member_NO = memberNO);
    
    DELETE FROM Member
    WHERE Member_NO = memberNO;
    
	
END $$
DELIMITER ;

SHOW CREATE PROCEDURE deletUser;

-- DROP PROCEDURE deletUser;

SELECT * FROM Member;

CALL deletUser(8);

CREATE TABLE Member_Delet LIKE Member;

DESC Member_Delet;
DROP TABLE Member_Delete;


AlTER  TABLE Member_Delet
ADD Member_Delet_Day DATE;

SELECT * FROM Member_Delet;

-- 이벤트 스케쥴러
SHOW VARIABLES LIKE 'event%';
SET GLOBAL event_scheduler = ON;
SET @@global.event_scheduler = ON; 

DELIMITER $$
CREATE PROCEDURE `deletUserTable`(
	Today DATE
)
BEGIN
	DELETE FROM Member_Delet
    WHERE Member_Delet_Day < DATE_SUB(Today, INTERVAL 1 DAY);

END $$
DELIMITER ;
-- DROP PROCEDURE deletUserTable;


UPDATE Member_Delet
SET Member_Delet_Day = '2022-05-31'
WHERE Member_NO = 8;

CREATE EVENT IF NOT EXISTS `deletUserTable`
ON SCHEDULE
EVERY 1 DAY
STARTS '2022-06-01 12:45:00'
DO
CALL deletUserTable(NOW());





SELECT * FROM Member_Delet;

SELECT * FROM information_schema.EVENTS;
SHOW EVENTS;

DROP event `deletUserTable` ;

USE mydb5;

UPDATE Member
SET Member_Email = 'khs1107y@naver.com'
WHERE Member_ID = 'gwA3Tu3s0VYlS3NGU6c5FdzEnba0H1RoWB5yn33wja8';

SELECT * FROM Member;

CREATE TABLE File(
	id INT PRIMARY KEY AUTO_INCREMENT,
	board_id INT NOT NULL REFERENCES Board(id),
    fileName VARCHAR(255) NOT NULL
);

DROP TABLE File;

USE mydb5;
SELECT * FROM Member;
DESC mydb6.Board;
DESC Member;
DESC Board;
SELECT * FROM Board;
SELECT * FROM Auth;

ALTER TABLE Board
ADD member_id VARCHAR(20) NOT NULL DEFAULT '1111' REFERENCES Member(Member_ID);
ALTER TABLE Board
MODIFY COLUMN member_id VARCHAR(50) NOT NULL;

DESC Reply;
ALTER TABLE Reply
ADD member_id VARCHAR(50) NOT NULL DEFAULT '1111' REFERENCES Member(Member_ID);

ALTER TABLE Reply
MODIFY COLUMN member_id VARCHAR(50) NOT NULL;

SELECT * FROM Reply;
DESC Board;


