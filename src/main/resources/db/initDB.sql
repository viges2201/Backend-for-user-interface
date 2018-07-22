DROP TABLE IF EXISTS logins;
DROP TABLE IF EXISTS users;
-- DROP SEQUENCE IF EXISTS global_seq;

-- CREATE SEQUENCE global_seq START 1;


CREATE TABLE users
(
  id                 SERIAL PRIMARY KEY NOT NULL,
  name               VARCHAR NOT NULL,
  lastName           VARCHAR NOT NULL,
  patronymic         VARCHAR NOT NULL,
  amountOfInvestment INTEGER NOT NULL,
  amountOfRisk       INTEGER NOT NULL,
  term               INTEGER NOT NULL,
  comments           VARCHAR NOT NULL
);

CREATE TABLE logins
(
  user_id SERIAL NOT NULL PRIMARY KEY UNIQUE REFERENCES users(id),
  login    VARCHAR ,
  password    VARCHAR,
  name VARCHAR,
  lastName VARCHAR,
  patronymic VARCHAR
);