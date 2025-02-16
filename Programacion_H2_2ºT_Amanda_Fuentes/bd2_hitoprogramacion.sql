-- Creamos la base de datos
create database gestion_tareas;

-- Usamos la base de datos creada
use gestion_tareas;

-- Tabla de usuarios
create table usuarios (
    id int auto_increment primary key,  
    nombre_usuario varchar(50) not null unique,  
    correo varchar(100) not null unique,  
    contrasena varchar(255) not null,  
    fecha_registro timestamp default current_timestamp 
);

-- Tabla de tareas
create table tareas (
    id int auto_increment primary key,  
    usuario_id int not null, 
    descripcion text not null,  
    completada tinyint(1) default 0,  
    fecha_creacion timestamp default current_timestamp,  
    foreign key (usuario_id) references usuarios(id) on delete cascade  
);
