<?php
session_start();
require_once '../controlador/usuarioControlador.php';

$usuarioControlador = new UsuarioControlador();

if (!isset($_SESSION['usuario_id'])) {
    header("Location: isesionUsuario.php");
    exit();
}

// Aquí puedes agregar la lógica para obtener los datos del usuario y mostrarlos en el formulario
// Por simplicidad, se omite la implementación de la obtención de datos.

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nombre_usuario = $_POST['nombre_usuario'];
    $correo = $_POST['correo'];
    // Aquí deberías implementar la lógica para actualizar el usuario en la base de datos
    echo "Usuario actualizado.";
}
?>

<form method="POST">
    Nombre de usuario: <input type="text" name="nombre_usuario" required>
    Correo: <input type="email" name="correo" required>
    <button type="submit">Actualizar Usuario</button>
</form>