<?php
session_start();
require_once '../controlador/TareaControlador.php';

if (!isset($_SESSION['usuario_id'])) {
    header("Location: isesionUsuario.php");
    exit();
}

$tareaControlador = new TareaControlador();

// Verificar si se ha pasado un ID de tarea
if (!isset($_GET['id'])) {
    header("Location: tareas.php");
    exit();
}

$tarea_id = $_GET['id'];

// Obtener la tarea a editar
$tarea = $tareaControlador->obtenerTareas($tarea_id);

if (!$tarea) {
    header("Location: tareas.php");
    exit();
}

// Manejar la actualización de la tarea
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $descripcion = $_POST['descripcion'];
    $tareaControlador->actualizarTarea($tarea_id, $descripcion);
    header("Location: tareas.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Tarea</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <?php include '../menu.php'; ?>

    <div class="container mt-5">
        <h1>Editar Tarea</h1>

        <form method="POST">
            <div class="form-group">
                <label for="descripcion">Descripción de la tarea:</label>
                <input type="text" class="form-control" name="descripcion" value="<?php echo htmlspecialchars($tarea['descripcion']); ?>" required>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar Tarea</button>
        </form>
    </div>
</body>
</html>