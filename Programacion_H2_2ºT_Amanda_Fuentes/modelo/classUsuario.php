<?php
require_once '../configuracion/classConexion.php';

class Usuario {
    private $db;

    public function __construct() {
        $conexion = new Conexion();
        $this->db = $conexion->conexion;

        // Verificar si la conexión es nula
        if ($this->db === null) {
            die("Error: No se pudo conectar a la base de datos.");
        }
    }

    public function registrar($nombre_usuario, $correo, $contrasena) {
        $hash = password_hash($contrasena, PASSWORD_DEFAULT);
        $query = "INSERT INTO usuarios (nombre_usuario, correo, contrasena) VALUES (:nombre_usuario, :correo, :contrasena)";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':nombre_usuario', $nombre_usuario);
        $stmt->bindParam(': correo', $correo);
        $stmt->bindParam(':contrasena', $hash);
        return $stmt->execute();
    }

    public function iniciarSesion($correo, $contrasena) {
        $query = "SELECT * FROM usuarios WHERE correo = :correo";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':correo', $correo);
        $stmt->execute();
        $usuario = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($usuario && password_verify($contrasena, $usuario['contrasena'])) {
            return $usuario;
        }
        return false;
    }
}
?>