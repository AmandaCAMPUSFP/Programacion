<?php
class Libro {
    public $titulo;
    public $autor;
    public $numPaginas;

    public function __construct($titulo, $autor, $numPaginas) {
        $this->titulo = $titulo;
        $this->autor = $autor;
        $this->numPaginas = $numPaginas;
    }

    public function mostrarInfo() {
        echo "Título: " . $this->titulo . "\n";
        echo "Autor: " . $this->autor . "\n";
        echo "Número de páginas: " . $this->numPaginas . "\n";
    }
}

$libro = new Libro("El Gran Gatsby", "F. Scott Fitzgerald", 218);
$libro->mostrarInfo();


