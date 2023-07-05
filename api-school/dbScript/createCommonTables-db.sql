CREATE DATABASE school_repository;

CREATE TABLE gender
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL
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