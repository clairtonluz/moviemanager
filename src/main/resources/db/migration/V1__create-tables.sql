CREATE TABLE users (
  id         SERIAL       NOT NULL PRIMARY KEY,
  name       VARCHAR(150) NOT NULL,
  username   VARCHAR(45)  NOT NULL,
  password   VARCHAR(255) NOT NULL,
  enabled    BOOLEAN      NOT NULL DEFAULT TRUE,
  created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (username)
);

CREATE TABLE user_role (
  id         SERIAL      NOT NULL PRIMARY KEY,
  user_id    INT         NOT NULL REFERENCES users (id),
  role       VARCHAR(45) NOT NULL,
  created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (role, user_id)
);

CREATE TABLE movie (
  id          SERIAL       NOT NULL PRIMARY KEY,
  name        VARCHAR(150) NOT NULL,
  description TEXT,
  type        VARCHAR(100) NOT NULL,
  year        INT          NOT NULL,
  created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (name)
);

CREATE TABLE favorite (
  id         SERIAL    NOT NULL PRIMARY KEY,
  user_id    INT       NOT NULL REFERENCES users (id),
  movie_id   INT       NOT NULL REFERENCES movie (id),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (user_id, movie_id)
);

INSERT INTO users (name, username, password, enabled)
VALUES ('Administrador', 'admin', '$2a$10$IV1.6EyW2KvKOhlLf8mFYuK6JEjWvrfqDXm1c9wPMcfQW2/ywaS4G', TRUE);

INSERT INTO user_role (user_id, role)
VALUES ((SELECT id
         FROM users
         WHERE username = 'admin'), 'ROLE_ADMIN');