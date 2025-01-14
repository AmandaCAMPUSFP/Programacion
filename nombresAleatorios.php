<?php

//Array de nombres
$nombres = ["Juan", "Ana", "Carlos", "María", "Luis", "Sofía", "Pedro", "Elena"];

//Array de apellidos
$apellidos = ["García", "López", "Martínez", "Pérez", "Sánchez", "Rodríguez", "Gómez", "Fernández"];

//Generamos un índice aleatorio para el nombre
$indiceNombre = rand(0, count($nombres) - 1);

//Generamos un índice aleatorio para el apellido
$indiceApellido = rand(0, count($apellidos) - 1);

//Formamos el nombre completo concatenando un nombre y un apellido
$nombreCompleto = $nombres[$indiceNombre] . " " . $apellidos[$indiceApellido];

//Mostramos el nombre completo
echo "Nombre aleatorio generado: " . $nombreCompleto . "\n";


