<?php

//Definimos el array de numeros
$numeros = [1, 10, 4, 3, 8, 5, 2, 6, 9, 7];

//Mostramos el primer array 
echo 'Primer array: ' . implode(", ", $numeros) . "\n";

//Aplicamos el algoritmo de burbuja para ordenar el array
$tamaño = count($numeros);

for ($i = 0; $i < $tamaño - 1; $i++) {
    for ($j = 0; $j < $tamaño - $i - 1; $j++) {
        if ($numeros[$j] > $numeros[$j + 1]) {
            //Intercambiamos los elementos
            $temp = $numeros[$j];
            $numeros[$j] = $numeros[$j + 1];
            $numeros[$j + 1] = $temp;
        }
    }
}

//Mostramos el array ordenado
echo "Array ordenado: " . implode(", ", $numeros) . "\n";