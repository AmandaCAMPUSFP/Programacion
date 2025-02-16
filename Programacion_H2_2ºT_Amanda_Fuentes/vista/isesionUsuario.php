<?php
session_start();
require_once '../controlador/usuarioControlador.php';

$usuarioControlador = new UsuarioControlador();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $correo = $_POST['correo'];
    $contrasena = $_POST['contrasena'];

    // Intentar iniciar sesión
    if ($usuarioControlador->iniciarSesion($correo, $contrasena)) {
        // Redirigir a la página de tareas si el inicio de sesión es exitoso
        header("Location: añadirTarea.php");
        exit();
    } else {
        // Mostrar un mensaje de error si las credenciales son incorrectas
        $error = "Credenciales incorrectas.";
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Iniciar Sesión</h1>
        <?php if (isset($error)): ?>
            <div class="alert alert-danger"><?php echo $error; ?></div>
        <?php endif; ?>
        <form method="POST">
            <div class="form-group">
                <label for="correo">Correo:</label>
                <input type="email" class="form-control" name="correo" required>
            </div>
            <div class="form-group">
                <label for="contrasena">Contraseña:</label>
                <input type="password" class="form-control" name="contrasena" required>
            </div>
            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
        </form>
    </div>
</body>
</html>