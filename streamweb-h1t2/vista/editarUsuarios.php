<?php
// incluimos el controlador de usuario
require_once '../controlador/usuarioControlador.php';
$controlador = new UsuarioControlador(); // creamos una instancia del controlador

// obtenemos el ID del usuario a editar
$id = $_GET['id'] ?? null;
if (!$id) {
    header("Location: listarUsuarios.php"); // redirigimos si no se proporciona un ID
    exit;
}

// si se envía el formulario, intentamos actualizar el usuario
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    //llamamos al método para actualizar el usuario
    $controlador->actualizarUsuario($id, $_POST); 
}

//obtenemos los datos del usuario
$usuarios = $controlador->listarUsuarios();
$usuario = array_filter($usuarios, fn($u) => $u['id'] == $id);
//obtenemos el primer elemento
$usuario = reset($usuario); 

//obtenemos los planes disponibles
$planes = $controlador->obtenerPlanes();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Editar Usuario</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" name="nombre" value="<?php echo $usuario['nombre']; ?>" required>
        </div>
        <div class="form-group">
            <label for="correo">Correo:</label>
            <input type="email" class="form-control" name="correo" value="<?php echo $usuario['correo']; ?>" required>
        </div>
        <div class="form-group">
            <label for="edad">Edad:</label>
            <input type="number" class="form-control" name="edad" value="<?php echo $usuario['edad']; ?>" required>
        </div>
        <div class="form-group">
            <label for="plan_id">Plan:</label>
            <select class="form-control" name="plan_id" required>
                <option value="">Seleccione un plan</option>
                <?php foreach ($planes as $plan): ?>
                    <option value="<?php echo $plan['id']; ?>" <?php echo $plan['id'] == $usuario['plan_id'] ? 'selected' : ''; ?>>
                        <?php echo $plan['nombre']; ?>
                    </option>
                <?php endforeach; ?>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Actualizar Usuario</button>
    </form>
</div>
</body>
</html>
