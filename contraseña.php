<?php

//Pedimos al usuario que ingrese una contraseña
echo "Ingrese una contraseña: ";
$contraseña = readline();

//Verificamos la longitud de la contraseña
if (strlen($contraseña) < 8) {
    echo "La contraseña debe tener al menos 8 caracteres.\n";
    exit;
}

//Inicializamos variables para verificar los criterios
$tieneMayuscula = false;
$tieneMinuscula = false;
$tieneNumero = false;

//Recorremos cada carácter de la contraseña
for ($i = 0; $i < strlen($contraseña); $i++) {
    $caracter = $contraseña[$i];

    //Verificamos si es una letra mayúscula
    if ($caracter >= 'A' && $caracter <= 'Z') {
        $tieneMayuscula = true;
    }

    //Verificamos si es una letra minúscula
    if ($caracter >= 'a' && $caracter <= 'z') {
        $tieneMinuscula = true;
    }

    //Verificamos si es un número
    if ($caracter >= '0' && $caracter <= '9') {
        $tieneNumero = true;
    }
}

//Validamos los criterios
if ($tieneMayuscula && $tieneMinuscula && $tieneNumero) {
    echo "La contraseña es válida.\n";
} else {
    echo "La contraseña debe contener al menos una letra mayúscula, una minúscula y un número.\n";
}


