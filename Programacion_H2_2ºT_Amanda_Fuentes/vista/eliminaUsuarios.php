<?php
session_start();
require_once '../controlador/usuarioControlador.php';

$usuarioControlador = new UsuarioControlador();

if (!isset($_SESSION['usuario_id'])) {
    header("Location: isesionUsuario.php");
    exit();
}

// Aquí puedes agregar la lógica para eliminar el usuario de la base de datos
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Implementar la lógica para eliminar el usuario
    echo "Usuario eliminado.";
}
?>

<form method="POST">
    <p>¿Estás seguro de que deseas eliminar tu cuenta?</p>
    <button type="submit">Eliminar Cuenta</button>
</form>