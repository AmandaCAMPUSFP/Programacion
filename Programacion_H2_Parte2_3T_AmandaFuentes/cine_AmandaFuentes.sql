-- Creamos la base de datos
CREATE DATABASE IF NOT EXISTS cine_AmandaFuentes;
USE cine_AmandaFuentes;

-- Tabla de géneros
CREATE TABLE genero (
    codigoGenero CHAR(3) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla de películas 
CREATE TABLE pelicula (
    codigoPelicula CHAR(5) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    director VARCHAR(100),
    año INT,
    duracion INT,
    generoCodigo CHAR(3),
    FOREIGN KEY (generoCodigo) REFERENCES genero(codigoGenero)
);

-- Insertamos géneros
INSERT INTO genero (codigoGenero, nombre) VALUES
('ACT', 'Acción'),
('COM', 'Comedia'),
('DRA', 'Drama'),
('TER', 'Terror'),
('SCI', 'Ciencia ficción');

-- Insertamos películas
INSERT INTO pelicula (codigoPelicula, titulo, director, año, duracion, generoCodigo) VALUES
('P001', 'Matrix', 'Lana Wachowski', 1999, 136, 'SCI'),
('P002', 'Titanic', 'James Cameron', 1997, 195, 'DRA'),
('P003', 'Joker', 'Todd Phillips', 2019, 122, 'DRA'),
('P004', 'Avengers: Endgame', 'Anthony Russo', 2019, 181, 'ACT'),
('P005', 'Scary Movie', 'Keenen Ivory Wayans', 2000, 88, 'COM');
