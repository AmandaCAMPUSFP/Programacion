<?php

//Solicitamos entrada del usuario
echo "Ingrese el primer número: ";
$numero1 = (float) readline();

echo "Ingrese el segundo número: ";
$numero2 = (float) readline();

echo "\nSeleccione la operación a realizar:\n";
echo "1. Sumar\n";
echo "2. Restar\n";
echo "3. Multiplicar\n";
echo "4. Dividir\n";
echo "Seleccione una opción (1-4): ";
$opcion = (int) readline();

//Realizamos la operación que decida el usuario
if ($opcion == 1) {
    $resultado = $numero1 + $numero2;
    echo "Resultado de la suma: $resultado\n";
} elseif ($opcion == 2) {
    $resultado = $numero1 - $numero2;
    echo "Resultado de la resta: $resultado\n";
} elseif ($opcion == 3) {
    $resultado = $numero1 * $numero2;
    echo "Resultado de la multiplicación: $resultado\n";
} elseif ($opcion == 4) {
    if ($numero2 != 0) {
        $resultado = $numero1 / $numero2;
        echo "Resultado de la división: $resultado\n";
    } else {
        echo "Error: División por cero no permitida.\n";
    }
} else {
    echo "Opción no válida.\n";
}

