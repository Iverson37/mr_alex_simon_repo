CREATE SEQUENCE seq_empl
START WITH 1: INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS
"employees"(
"id"        INT DEFAULT nextval 'seq_empl'::REGCLASS) NOT NULL PRIMARY KEY,
"name" VARCHAR(30),
"sername" VARCHAR(30),
"patronymic" VARCHAR(30),
"cabinet_id" INT);