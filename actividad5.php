<?php

//Pedimos al usuario que ingrese la altura de la pirámide
$altura = (int) readline("Ingresa la altura de la pirámide: ");

//Hacemos un bucle para el numero de lineas de la pirámide
for ($i = 1; $i <= $altura; $i++) {
    //Imprimimos los espacios en blanco antes de los números para alinear la pirámide
    for ($j = 1; $j <= $altura - $i; $j++) {
        echo " "; 
    }

    //Imprimimos los numeros en la fila
    for ($k = 1; $k <= $i; $k++) {
        echo $k . " "; 
    }

    //Añadimos un salto de línea al final de cada fila para formar la pirámide
    echo "\n";
}

