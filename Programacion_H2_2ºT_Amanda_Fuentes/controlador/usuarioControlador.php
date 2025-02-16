<?php
require_once '../modelo/classUsuario.php';

class UsuarioControlador {
    private $modelo;

    public function __construct() {
        $this->modelo = new Usuario();
    }

    public function registrar($nombre_usuario, $correo, $contrasena) {
        return $this->modelo->registrar($nombre_usuario, $correo, $contrasena);
    }

    public function iniciarSesion($correo, $contrasena) {
        $usuario = $this->modelo->iniciarSesion($correo, $contrasena);
        if ($usuario) {
            session_start();
            $_SESSION['usuario_id'] = $usuario['id'];
            $_SESSION['nombre_usuario'] = $usuario['nombre_usuario'];
            return true;
        }
        return false;
    }

    public function cerrarSesion() {
        session_start();
        session_unset();
        session_destroy();
        header("Location: ../index.php");
        exit();
    }
}
?>