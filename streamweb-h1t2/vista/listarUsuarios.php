<?php
//incluimos el controlador de usuario
require_once '../controlador/usuarioControlador.php';
//creamos una instancia del controlador
$controlador = new UsuarioControlador(); 
//obtenemos la lista de usuarios
$usuarios = $controlador->listarUsuarios(); 
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listar Usuarios</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Lista de Usuarios</h2>
    <a href="crearUsuarios.php" class="btn btn-success">Agregar Usuario</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Edad</th>
                <th>Plan</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <?php if (empty($usuarios)): ?>
                <tr>
                    <td colspan="6" class="text-center">No hay usuarios registrados.</td>
                </tr>
            <?php else: ?>
                <?php foreach ($usuarios as $usuario): ?>
                    <tr>
                        <td><?php echo $usuario['id']; ?></td>
                        <td><?php echo $usuario['nombre']; ?></td>
                        <td><?php echo $usuario['correo']; ?></td>
                        <td><?php echo $usuario['edad']; ?></td>
                        <td><?php echo $usuario['plan']; ?></td>
                        <td>
                            <a href="editarUsuarios.php?id=<?php echo $usuario['id']; ?>" class="btn btn-warning">Editar</a>
                            <a href="eliminaUsuarios.php?id=<?php echo $usuario['id']; ?>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">Eliminar</a>
                    </tr>
                <?php endforeach; ?>
            <?php endif; ?>
        </tbody>
    </table>
</div>
</body>
</html>