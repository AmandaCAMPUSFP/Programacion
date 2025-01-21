<?php
class Empleado {
    public $nombre;
    public $sueldo;

    public function __construct($nombre, $sueldo) {
        $this->nombre = $nombre;
        $this->sueldo = $sueldo;
    }

    public function mostrarDetalles() {
        echo "Nombre: " . $this->nombre . "\n";
        echo "Sueldo: " . $this->sueldo . "\n";
    }
}

class Gerente extends Empleado {
    public $departamento;

    public function __construct($nombre, $sueldo, $departamento) {
        parent::__construct($nombre, $sueldo);
        $this->departamento = $departamento;
    }

    public function mostrarDetalles() {
        parent::mostrarDetalles();
        echo "Departamento: " . $this->departamento . "\n";
    }
}

$empleado = new Empleado("Juan", 3000);
$empleado->mostrarDetalles();

$gerente = new Gerente("Ana", 5000, "Ventas");
$gerente->mostrarDetalles();

