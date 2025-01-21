<?php

class Animal {
    private $especie;

    public function __construct($especie) {
        $this->especie = $especie;
    }


    public function emitirSonido() {
        echo "El " . $this->especie . "hace guau guau.\n";
    }

    public function getEspecie() {
        return $this->especie;
    }

}


class Perro extends Animal {
    private $raza;


    public function __construct($especie, $raza) {
        parent::__construct($especie);
        $this->raza = $raza;
    }

    public function getRaza() {
        return $this->raza;
    }
    public function emitirSonido() {
        echo "El perro de raza " . $this->raza . " dice: ¡Guau Guau!\n";
    }
}

$miPerro = new Perro("Mamifero", "Pastor Aleman");

echo "Especie: " . $miPerro->getEspecie() . "\n";
echo "Raza: " . $miPerro->getRaza() . "\n";
$miPerro->emitirSonido();
