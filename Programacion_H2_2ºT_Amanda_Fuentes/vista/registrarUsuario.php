<?php
require_once '../controlador/usuarioControlador.php';

$usuarioControlador = new UsuarioControlador();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nombre_usuario = $_POST['nombre_usuario'];
    $correo = $_POST['correo'];
    $contrasena = $_POST['contrasena'];

    if ($usuarioControlador->registrar($nombre_usuario, $correo, $contrasena)) {
        echo "Registro exitoso.";
    } else {
        echo "Error en el registro.";
    }
}
?>

<form method="POST">
    Nombre de usuario: <input type="text" name="nombre_usuario" required>
    Correo : <input type="email" name="correo" required>
    Contraseña: <input type="password" name="contrasena" required>
    <button type="submit">Registrar</button>
</form>