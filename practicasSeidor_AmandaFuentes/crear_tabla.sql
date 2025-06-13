-- Crear base de datos akihabara_db
CREATE DATABASE IF NOT EXISTS akihabara_db;
USE akihabara_db;

-- Crear tabla productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(100),
    precio DECIMAL(10, 2),
    stock INT
);

