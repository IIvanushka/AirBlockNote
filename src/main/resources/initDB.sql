-- DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS noteentities;
DROP TABLE IF EXISTS notes;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR                              NOT NULL,
  email      VARCHAR                              NOT NULL,
  password   VARCHAR DEFAULT '0000'               NOT NULL,
  registered TIMESTAMP DEFAULT now()              NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

INSERT INTO users (name, email) VALUES ('Valera','valer@mail.ru');
INSERT INTO users (name, email) VALUES ('Vasya','vas@mail.ru');

-- CREATE TABLE user_roles
-- (
--   user_id INTEGER NOT NULL,
--   role    VARCHAR,
--   CONSTRAINT user_roles_idx UNIQUE (user_id, role),
--   FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
-- );

CREATE TABLE notes (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER                 NOT NULL,
  active      BOOL DEFAULT TRUE       NOT NULL,
  description TEXT,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE noteentities (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  note_id     INTEGER                 NOT NULL,
  active      BOOL DEFAULT TRUE       NOT NULL,
  description TEXT,
  FOREIGN KEY (note_id) REFERENCES notes (id) ON DELETE CASCADE
);