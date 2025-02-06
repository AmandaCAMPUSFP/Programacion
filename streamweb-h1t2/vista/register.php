<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="text-center">Registrarse</h2>
    <form action="../controlador/registerControlador.php" method="POST"> 
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" name="nombre" required>
        </div>
        <div class="form-group">
        <label for="edad">Edad:</label>
        <input type="number" class="form-control" name="edad" required> 
        </div>
        <div class="form-group">
            <label for="correo">Correo Electrónico:</label> 
            <input type="email" class="form-control" name="correo" required> 
        </div>
        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" class="form-control" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Registrarse</button>
        <a href="login.php" class="btn btn-link">Ya tengo una cuenta</a>
    </form>
</div>
</body>
</html>