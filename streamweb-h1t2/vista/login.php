<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="text-center">Iniciar Sesión</h2>
    <form method="POST" action="../controlador/loginControlador.php">
        <div class="form-group">
            <label for="correo">Correo electrónico:</label>
            <input type="email" class="form-control" name="correo" id="correo" required> 
        </div>

        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Iniciar sesión</button>
    </form>
    
    <br>
    <a href="index.php" class="btn btn-link">Volver a la Página de Inicio</a>
</div>
</body>
</html>
