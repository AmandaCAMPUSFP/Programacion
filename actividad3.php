<?php

//Solicitamos entrada del usuario
echo "Ingrese un número para verificar si es primo: ";
$numero = (int) readline();

//Determinamos si el número es primo
if ($numero <= 1) {
    echo "$numero no es un número primo.\n";
} else {
    $esPrimo = true;
    for ($i = 2; $i <= $numero / 2; $i++) {
        if ($numero % $i == 0) {
            $esPrimo = false;
            break;
        }
    }
    if ($esPrimo) {
        echo "$numero es un número primo.\n";
    } else {
        echo "$numero no es un número primo.\n";
    }
}

