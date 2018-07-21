DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 1;


CREATE TABLE users
(
  id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name               VARCHAR NOT NULL,
  lastName           VARCHAR NOT NULL,
  patronymic         VARCHAR NOT NULL,
  amountOfInvestment INTEGER NOT NULL,
  amountOfRisk       INTEGER NOT NULL,
  term               INTEGER NOT NULL,
  comments           VARCHAR NOT NULL
);
