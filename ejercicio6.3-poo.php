<?php
class Vehiculo {
    public $marca;

    public function __construct($marca) {
        $this->marca = $marca;
    }

    public function encender() {
        echo "El vehículo está encendido.\n";
    }
}

class Coche extends Vehiculo {
    public $modelo;

    public function __construct($marca, $modelo) {
        parent::__construct($marca);
        $this->modelo = $modelo;
    }
}

$coche = new Coche("Toyota", "Corolla");
echo "Marca: " . $coche->marca . "\n";
echo "Modelo: " . $coche->modelo . "\n";
$coche->encender();
