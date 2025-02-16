<?php
require_once '../configuracion/classConexion.php';

class Tarea {
    private $db;

    public function __construct() {
        $conexion = new Conexion();
        $this->db = $conexion->conexion;
    }

    public function agregarTarea($usuario_id, $descripcion) {
        $query = "INSERT INTO tareas (usuario_id, descripcion) VALUES (:usuario_id, :descripcion)";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':usuario_id', $usuario_id);
        $stmt->bindParam(':descripcion', $descripcion);
        return $stmt->execute();
    }

    public function obtenerTareas($usuario_id) {
        $query = "SELECT * FROM tareas WHERE usuario_id = :usuario_id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':usuario_id', $usuario_id);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function obtenerTarea($id) {
        $query = "SELECT * FROM tareas WHERE id = :id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    public function actualizarTarea($id, $descripcion) {
        $query = "UPDATE tareas SET descripcion = :descripcion WHERE id = :id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':descripcion', $descripcion);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }

    public function eliminarTarea($id) {
        $query = "DELETE FROM tareas WHERE id = :id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }

    public function completarTarea($id) {
        $query = "UPDATE tareas SET completada = 1 WHERE id = :id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }
}
?>