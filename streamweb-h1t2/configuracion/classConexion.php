<?php
//definimos la clase Conexion para manejar la conexión a la base de datos
class Conexion {
    private $host = 'localhost'; 
    private $db_name = 'streamweb_hito'; 
    private $username = 'root'; 
    private $password = '1234'; 
    public $conn; 

    //establecemos un método para obtener la conexión a la base de datos
    public function getConnection() {
        $this->conn = null; 
        try {
            //intentamos crear una nueva conexión PDO
            $this->conn = new PDO("mysql:host={$this->host};dbname={$this->db_name}", $this->username, $this->password);
            $this->conn->exec("set names utf8"); 
        } catch(PDOException $exception) {
            //si hay un error, mostramos el mensaje de error
            echo "Connection error: " . $exception->getMessage();
        }
        //devolvemos la conexión
        return $this->conn; 
    }
}
