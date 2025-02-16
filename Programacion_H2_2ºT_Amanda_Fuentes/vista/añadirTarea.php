<?php
session_start();
require_once '../controlador/TareaControlador.php';

if (!isset($_SESSION['usuario_id'])) {
    header("Location: isesionUsuario.php");
    exit();
}

$tareaControlador = new TareaControlador();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $descripcion = $_POST['descripcion'];
    $tareaControlador->agregarTarea($_SESSION['usuario_id'], $descripcion);
    header("Location: añadirTarea.php");
}
?>

<h1>Añadir Tarea</h1>
<form method="POST">
    Descripción: <input type="text" name="descripcion" required>
    <button type="submit">Agregar Tarea</button>
</form>