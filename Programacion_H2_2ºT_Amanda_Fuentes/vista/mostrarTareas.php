<?php
session_start();
require_once '../controlador/TareaControlador.php';

if (!isset($_SESSION['usuario_id'])) {
    header("Location: isesionUsuario.php");
    exit();
}

$tareaControlador = new TareaControlador();
// Aquí deberías implementar la lógica para obtener las tareas del usuario
$tareas = []; // Suponiendo que obtienes las tareas de la base de datos

?>

<h1>Tus Tareas</h1>
<ul>
    <?php foreach ($tareas as $tarea): ?>
        <li><?php echo $tarea['descripcion']; ?></li>
    <?php endforeach; ?>
</ul>
<a href="añadirTarea.php">Añadir Nueva Tarea</a>