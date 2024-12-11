<?php

//Predefinimos un número secreto 
$numeroSecreto = 42; 
$intentos = 0; 

echo "Bienvenido al juego de Adivina el Número.\n";
echo "Estoy pensando en un número entre 1 y 100. ¿Puedes adivinar cuál es?\n";

do {
    //Pedimos al usuario que ingrese un número
    $numeroUsuario = (int) readline("Ingresa un número: ");
    $intentos++;

    //Comparamos el número ingresado con el secreto
    if ($numeroUsuario < $numeroSecreto) {
        echo "El número es mayor.\n";
    } elseif ($numeroUsuario > $numeroSecreto) {
        echo "El número es menor.\n";
    } else {
        echo "¡Adivinaste! El número era {$numeroSecreto}. Lo lograste en {$intentos} intentos.\n";
    }
} while ($numeroUsuario != $numeroSecreto); 

