<?php
require_once '../modelo/classTarea.php';

class TareaControlador {
    private $modelo;

    public function __construct() {
        $this->modelo = new Tarea();
    }

    // Método para agregar una nueva tarea
    public function agregarTarea($usuario_id, $descripcion) {
        return $this->modelo->agregarTarea($usuario_id, $descripcion);
    }

    // Método para obtener todas las tareas de un usuario
    public function obtenerTareas($usuario_id) {
        return $this->modelo->obtenerTareas($usuario_id);
    }

    // Método para obtener una tarea específica por ID
    public function obtenerTarea($id) {
        return $this->modelo->obtenerTarea($id);
    }

    // Método para actualizar una tarea
    public function actualizarTarea($id, $descripcion) {
        return $this->modelo->actualizarTarea($id, $descripcion);
    }

    // Método para eliminar una tarea
    public function eliminarTarea($id) {
        return $this->modelo->eliminarTarea($id);
    }

    // Método para marcar una tarea como completada
    public function completarTarea($id) {
        return $this->modelo->completarTarea($id);
    }
}
?>