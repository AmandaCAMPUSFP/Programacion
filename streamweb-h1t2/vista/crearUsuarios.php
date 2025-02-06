<?php
//incluimos el controlador de usuario
require_once '../controlador/usuarioControlador.php';
//creamos una instancia del controlador
$controlador = new UsuarioControlador(); 

//si se envía el formulario, intentamos crear un nuevo usuario
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    //llamamos al método para crear el usuario
    $controlador->crearUsuario($_POST); 
}

//obtenemos los planes disponibles para mostrarlos en el formulario
$planes = $controlador->obtenerPlanes();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Crear Usuario</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="correo">Correo:</label>
            <input type="email" class="form-control" name="correo" required>
        </div>
        <div class="form-group">
            <label for="edad">Edad:</label>
            <input type="number" class="form-control" name="edad" required>
        </div>
        <div class="form-group">
            <label for="plan_id">Plan:</label>
            <select class="form-control" name="plan_id" required>
                <option value="">Seleccione un plan</option>
                <?php foreach ($planes as $plan): ?>
                    <option value="<?php echo $plan['id']; ?>"><?php echo $plan['nombre']; ?></option>
                <?php endforeach; ?>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Crear Usuario</button>
    </form>
</div>
</body>
</html>