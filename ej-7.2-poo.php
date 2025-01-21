<?php

class Rectangulo {
    private $base;
    private $altura;

    public function __construct($base, $altura) {
        $this->base = $base;
        $this->altura = $altura;
    }

    public function calcularArea() {
        return $this->base * $this->altura;
    }
}

$rectangulo = new Rectangulo(10, 5);
echo "El area del rectangulo es: " . $rectangulo->calcularArea();
