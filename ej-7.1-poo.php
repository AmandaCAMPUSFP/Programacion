<?php

class Persona {
    private $nombre;
    private $edad;
    private $genero;


    public function __construct($nombre, $edad, $genero) {
    $this->nombre = $nombre;
    $this->edad = $edad;
    $this->genero = $genero;
    }

    public function presentar() {
    echo "Nombre: " . $this->nombre . "\n";
    echo "Edad: " . $this->edad . "\n";
    echo "Genero: " . $this->genero . "\n";
    }
}

$persona1 = new Persona("Luis", 27, "Masculino");
$persona1->presentar();

$persona2 = new Persona("Adrian", 30, "Masculino");
$persona2->presentar();

$persona3 = new Persona("Claudia", 22, "Femenino");
$persona3->presentar();
