CREATE DATABASE school_repository;

CREATE TABLE city
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE school
(
    id      SERIAL PRIMARY KEY,
    city_id INT REFERENCES city (id) ON DELETE CASCADE,
    name    VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE lesson_class
(
    id             SERIAL PRIMARY KEY,
    city_id        INT REFERENCES city (id) ON DELETE CASCADE,
    school_id      INT REFERENCES school (id) ON DELETE CASCADE,
    clazz          INT NOT NULL,
    postfix        CHAR(1),
    awg_class_mark NUMERIC

);

CREATE TABLE lesson_object
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(64) UNIQUE NOT NULL,
    rus_name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE role_staff
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(64) UNIQUE NOT NULL,
    rus_name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE gender
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE teacher
(
    id              SERIAL PRIMARY KEY,
    city_id         INT REFERENCES city (id) ON DELETE CASCADE,
    school_id       INT REFERENCES school (id) ON DELETE CASCADE,
    main_object_id  INT REFERENCES lesson_object (id),
    role_staff_id   INT REFERENCES role_staff (id),
    lesson_class_id INT REFERENCES lesson_class (id),
    first_name      VARCHAR(128) NOT NULL,
    last_name       VARCHAR(128) NOT NULL,
    birthdate       DATE         NOT NULL
);

ALTER TABLE IF EXISTS lesson_class
    ADD COLUMN teacher_id INT REFERENCES teacher (id);

CREATE TABLE school_staff
(
    id            SERIAL PRIMARY KEY,
    city_id       INT REFERENCES city (id) ON DELETE CASCADE,
    school_id     INT REFERENCES school (id) ON DELETE CASCADE,
    role_staff_id INT REFERENCES role_staff (id),
    first_name    VARCHAR(128) NOT NULL,
    last_name     VARCHAR(128) NOT NULL,
    birthdate     DATE         NOT NULL
);

CREATE TABLE pupil
(
    id              SERIAL PRIMARY KEY,
    city_id         INT REFERENCES city (id) ON DELETE CASCADE,
    school_id       INT REFERENCES school (id) ON DELETE CASCADE,
    role_staff_id   INT REFERENCES role_staff (id),
    gender_id       INT REFERENCES gender (id),
    lesson_class_id INT REFERENCES lesson_class (id),
    first_name      VARCHAR(128) NOT NULL,
    last_name       VARCHAR(128) NOT NULL,
    birthdate       DATE         NOT NULL,
    awg_mark        NUMERIC
);

