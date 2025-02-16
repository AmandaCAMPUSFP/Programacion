<?php
session_start();
if (!isset($_SESSION['usuario_id'])) {
    header('Location: index.php');
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Principal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Bienvenido, <?php echo $_SESSION['nombre_usuario']; ?></h1>
        <div class="mt-4">
            <a href="vista/tareas.php" class="btn btn-primary">Ver Tareas</a>
            <a href="vista/cerrarSesion.php" class="btn btn-danger">Cerrar Sesión</a>
        </div>
    </div>
</body>
</html>
