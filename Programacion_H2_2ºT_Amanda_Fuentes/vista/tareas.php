<?php
include '../configuracion/classConexion.php';
include '../modelo/classTarea.php';
session_start();

if (!isset($_SESSION['usuario_id'])) {
    header('Location: ../index.php');
    exit();
}

$tarea = new Tarea();
$tareas = $tarea->obtenerTareas($_SESSION['usuario_id']);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['eliminar'])) {
        $tarea->eliminarTarea($_POST['id_tarea']);
    }
    if (isset($_POST['completar'])) {
        $tarea->completarTarea($_POST['id_tarea']);
    }
    header('Location: tareas.php');
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tareas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Tareas Pendientes</h2>
        <a href="añadirTarea.php" class="btn btn-primary mb-3">Agregar Nueva Tarea</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Descripción</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($tareas as $tarea) { ?>
                    <tr>
                        <td><?php echo htmlspecialchars($tarea['descripcion']); ?></td>
                        <td><?php echo $tarea['completada'] ? 'Completada' : 'Pendiente'; ?></td>
                        <td>
                            <?php if (!$tarea['completada']) { ?>
                                <form method="POST" class="d-inline">
                                    <input type="hidden" name="id_tarea" value="<?php echo $tarea['id']; ?>">
                                    <button type="submit" name="completar" class="btn btn-success btn-sm">Completar</button>
                                </form>
                            <?php } ?>
                            <form method="POST" class="d-inline">
                                <input type="hidden" name="id_tarea" value="<?php echo $tarea['id']; ?>">
                                <button type="submit" name="eliminar" class="btn btn-danger btn-sm">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</body>
</html>
