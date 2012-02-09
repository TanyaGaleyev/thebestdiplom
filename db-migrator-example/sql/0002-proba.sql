ALTER TABLE table1 ADD COLUMN surname text;
UPDATE table1 SET surname = 'Galeyeva' WHERE id = 1;
UPDATE table1 SET surname = 'Pavlukhin' WHERE id = 2;
INSERT INTO table1 VALUES
(3,'Tanya','Kartashova'),
(4,'Dima','Semenistik');