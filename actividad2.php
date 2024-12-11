<?php

//Solicitamos entrada del usuario
echo "Ingrese un número para crear su tabla de multiplicar: ";
$numero = (int) readline();

//Generamos la tabla de multiplicar
echo "Tabla de multiplicar del $numero:\n";
for ($i = 1; $i <= 10; $i++) {
    $resultado = $numero * $i;
    echo "$numero x $i = $resultado\n";
}


