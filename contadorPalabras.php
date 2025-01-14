<?php

//Pedimos al usuario que ingrese una frase
echo 'Ingrese una frase: ';
$frase = readline();

//Iniciamos el contador 
$contadorPalabras = 0;
$longitud = strlen($frase);

//Recorremos cada caracter de la frase
for ($i = 0; $i < $longitud; $i++) {
    if($frase[$i] == ' ') {
        $contadorPalabras++;
    }
}

//Sumamos 1 al contador de palabras (para contar la última palabra)
if ($longitud > 0) {
    $contadorPalabras++;
}

//Mostramos el numero total de palabras
echo 'El numero total de palabras es: ' . $contadorPalabras . "\n";

