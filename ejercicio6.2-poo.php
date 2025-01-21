<?php
class Circulo {
    public $radio;

    public function __construct($radio) {
        $this->radio = $radio;
    }

    public function calcularArea() {
        return pi() * pow($this->radio, 2);
    }
}

$circulo = new Circulo(5);
echo "Área del círculo: " . $circulo->calcularArea();

