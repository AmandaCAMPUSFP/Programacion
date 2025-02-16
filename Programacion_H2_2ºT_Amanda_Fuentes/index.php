<?php
session_start();
if (isset($_SESSION['usuario_id'])) {
    header('Location: menu.php');
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Tareas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Bienvenido a la Gestión de Tareas</h1>
        <div class="mt-4">
            <a href="vista/registrarUsuario.php" class="btn btn-primary">Registrarse</a>
            <a href="vista/iniciarSesion.php" class="btn btn-secondary">Iniciar Sesión</a>
        </div>
    </div>
</body>
</html>
