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
  url_image   VARCHAR(255),
  description TEXT,
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

CREATE TABLE type (
  id         SERIAL       NOT NULL PRIMARY KEY,
  name       VARCHAR(100) NOT NULL,
  created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (name)
);

CREATE TABLE movie_type (
  id         SERIAL    NOT NULL PRIMARY KEY,
  type_id    INT       NOT NULL REFERENCES type (id),
  movie_id   INT       NOT NULL REFERENCES movie (id),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (type_id, movie_id)
);