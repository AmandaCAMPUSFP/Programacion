<?php
//inicia la sesión
session_start(); 

error_reporting(E_ALL);
ini_set('display_errors', 1);

//incluimos el controlador de usuario
require_once '../controlador/usuarioControlador.php';

//creamos una instancia del controlador
$controlador = new UsuarioControlador();

//verificamos si se ha proporcionado un ID
$id = $_GET['id'] ?? null;

if ($id) {
    //llamamos al método para eliminar el usuario
    if ($controlador->eliminarUsuario($id)) {
        //almacenamos el mensaje de éxito en la sesión
        $_SESSION['mensaje'] = "Usuario eliminado con éxito.";
    } else {
        $_SESSION['mensaje'] = "Error al eliminar el usuario.";
    }
} else {
    $_SESSION['mensaje'] = "ID de usuario no proporcionado.";
}

//redirigimos a la lista de usuarios después de eliminar
header("Location: ../vista/listarUsuarios.php");
exit();
