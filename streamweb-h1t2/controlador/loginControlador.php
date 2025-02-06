<?php
session_start(); //iniciamos la sesión
require_once '../configuracion/classConexion.php';

//creamos una clase para manejar el inicio de sesión
class LoginControlador {
    private $conn; // variable para almacenar la conexión

    //establecemos un constructor que establece la conexión a la base de datos
    public function __construct() {
        //creamos una nueva instancia de la clase de conexión
        $database = new Conexion(); 
        //obtenemos la conexión
        $this->conn = $database->getConnection(); 
    }

    //establecemos un método para iniciar sesión
    public function iniciarSesion($correo, $password) {
        //hacemos una consulta para buscar el usuario por correo electrónico
        $query = "SELECT * FROM usuarios WHERE correo = :correo LIMIT 1";  
        //preparamos la consulta
        $stmt = $this->conn->prepare($query); 
        $stmt->bindParam(':correo', $correo); 
        //ejecutamos la consulta
        $stmt->execute(); 

        //verificamos si se encontró un usuario
        if ($stmt->rowCount() > 0) {
            //obtenemos los datos del usuario
            $usuario = $stmt->fetch(PDO::FETCH_ASSOC); 
            //verificamos si la contraseña es correcta
            if (password_verify($password, $usuario['password'])) { // asegúrate de que la contraseña esté hasheada
                //guardamos el ID del usuario en la sesión
                $_SESSION['usuario_id'] = $usuario['id']; 
                //redirigimos a la lista de usuarios
                header("Location: ../vista/listarUsuarios.php"); 
                exit(); 
            } else {
                //estbalecemos un mensaje de error por si la contraseña es incorrecta
                echo "Contraseña incorrecta."; 
            }
        } else {
            //estbalecemos un mensaje de error por si no se encuentra el usuario
            echo "No se encontró un usuario con ese correo electrónico."; 
        }
    }
}

//establecemos el manejo de la solicitud de inicio de sesión
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $correo = $_POST['correo']; 
    $password = $_POST['password']; 

    //creamos una nueva instancia del controlador
    $loginControlador = new LoginControlador(); 
    //llamamos al método para iniciar sesión
    $loginControlador->iniciarSesion($correo, $password); 
}



