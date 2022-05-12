USE mydb4;
CREATE TABLE Board
SELECT * FROM mydb2.Board;

CREATE TABLE Reply
SELECT * FROM mydb2.Reply;

DESC Board;
ALTER TABLE Board MODIFY COLUMN id INT PRIMARY KEY auto_increment;
DESC Reply;
ALTER TABLE Reply MODIFY column id INT primary key auto_increment;

ALTER TABLE Reply ADD foreign key (board_id) references Board(id);

SELECT * FROM Board;