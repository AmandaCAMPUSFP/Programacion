<?php
session_start(); // inicia la sesión
require_once '../configuracion/classConexion.php'; // incluye la clase de conexión

//creamos una clase para manejar el registro de usuarios
class registerControlador {
    //almacenamos la conexión a la base de datos
    private $conn; 

    //establecemos un constructor que establezca la conexión a la bbdd
    public function __construct() {
        //creamos una nueva instancia de la conexión
        $database = new Conexion(); 
        //obtenemos la conexión
        $this->conn = $database->getConnection(); 
    }

    //establecemos un método para registrar un nuevo usuario
    public function registrarUsuario($nombre, $correo, $password, $edad) { 
        //hacemos una consulta para insertar un nuevo usuario en la base de datos
        $query = "INSERT INTO usuarios (nombre, correo, password, edad) VALUES (:nombre, :correo, :password, :edad)";
        //preparamos la consulta sql
        $stmt = $this->conn->prepare($query); 

        //hasheamos la contraseña antes de guardarla en la base de datos
        $hashedPassword = password_hash($password, PASSWORD_DEFAULT);

        //vinculamos el nombre al parámetro
        $stmt->bindParam(':nombre', $nombre); 
        //vinculamos el correo 
        $stmt->bindParam(':correo', $correo); 
        //vinculamos la contraseña hasheada
        $stmt->bindParam(':password', $hashedPassword); 
        //vinculamos la edad 
        $stmt->bindParam(':edad', $edad, PDO::PARAM_INT); 

        //ejecutamos la consulta e intentamos registrar al usuario
        if ($stmt->execute()) {
            //guardamos un mensaje de éxito en la sesión
            $_SESSION['mensaje'] = "registro exitoso, puedes iniciar sesión ahora."; 
            //redirigimos a la página de inicio de sesión
            header("Location: ../vista/login.php"); 
            exit(); 
        } else {
            //mostramos un mensaje si el registro falla
            echo "error al registrar el usuario."; 
        }
    }
}

//verificamos si la solicitud es de tipo post
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    //obtenemos el nombre del formulario
    $nombre = $_POST['nombre']; 
    //obtenemos el correo del formulario
    $correo = $_POST['correo']; 
    //obtenemos la contraseña del formulario
    $password = $_POST['password']; 
    //usamos 18 como valor predeterminado si no se ingresa la edad
    $edad = isset($_POST['edad']) ? $_POST['edad'] : 18; 

    //creamos una nueva instancia del controlador de registro
    $registerControlador = new RegisterControlador(); 
    $registerControlador->registrarUsuario($nombre, $correo, $password, $edad); 
}

