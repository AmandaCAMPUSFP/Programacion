<?php
class Conexion {
    private $host = 'localhost';
    private $db = 'gestion_tareas';
    private $user = 'root';
    private $pass = '1234';
    public $conexion;

    public function __construct() {
        try {
            $this->conexion = new PDO("mysql:host=$this->host;dbname=$this->db", $this->user, $this->pass);
            $this->conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
    }
}
?>