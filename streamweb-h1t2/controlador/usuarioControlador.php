<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
?>
<?php
//incluimos las clases necesarias para la conexión y el modelo de usuario
require_once '../configuracion/classConexion.php';
require_once '../modelo/classUsuario.php';

//definimos la clase UsuarioControlador 
class UsuarioControlador {
    private $usuario; 

    //definimos el constructor que inicializa la conexión y el modelo de usuario
    public function __construct() {
        //creamos una nueva instancia de la clase Conexion
        $conexion = new Conexion(); 
        //creamos una nueva instancia de Usuario
        $this->usuario = new Usuario($conexion->getConnection()); 
    }

    //establecemos un método para crear un nuevo usuario
    public function crearUsuario($data) {
        //validamos los datos del usuario
        if ($this->validarUsuario($data)) { 
            //llamamos al método para crear el usuario
            $this->usuario->crearUsuario($data); 
            //redirigimos a la lista de usuarios
            header("Location: ../vista/listarUsuarios.php"); 
        } else {
            //manejamos los errores de validación
            echo "Error en la validación de datos.";
        }
    }

    //establecemos un método para listar todos los usuarios
    public function listarUsuarios() {
        //llamamos al método para listar usuarios
        return $this->usuario->listarUsuarios();
    }

    //establecemos un método para eliminar un usuario por su ID
    public function eliminarUsuario($id) {
        return $this->usuario->eliminarUsuario($id); // devuelve verdadero si se eliminó correctamente
    }

    //establecemos un método para actualizar un usuario
    public function actualizarUsuario($id, $data) {
        if ($this->validarUsuario($data)) { //validamos los datos del usuario
            $this->usuario->actualizarUsuario($id, $data); //llamamos al método para actualizar el usuario
            header("Location: ../vista/listarUsuarios.php"); //redirigimos a la lista de usuarios
        } else {
            //manejamos los errores de validación
            echo "Error en la validación de datos.";
        }
    }

    //establecemos un método privado para validar los datos del usuario
    private function validarUsuario($data) {
        //hacemos validaciones básicas
        if (empty($data['nombre']) || empty($data['correo']) || empty($data['edad']) || empty($data['plan_id'])) {
            //si falta algún dato, lo devolvemos como falso
            return false; 
        }
        if (!filter_var($data['correo'], FILTER_VALIDATE_EMAIL)) {
            //si el correo no es válido, lo devolvemos como falso
            return false; 
        }
        if ($data['edad'] < 18 && $data['plan_id'] != 3) { 
            //si no cumple la condición, lo devolvemos como falso
            return false; 
        }
        //si todas las validaciones pasan, lo devolvemos como verdadero
        return true; 
    }

    //establecemos un método para obtener todos los planes disponibles
    public function obtenerPlanes() {
        //llamamos al método para obtener los planes
        return $this->usuario->obtenerPlanes(); 
    }
}
