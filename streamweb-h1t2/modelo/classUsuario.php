<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
?>
<?php
//definimos la clase Usuario para manejar las operaciones relacionadas con los usuarios
class Usuario {
    private $conn; 
    private $table_name = "usuarios"; 

    // constructor que recibe la conexión a la base de datos
    public function __construct($db) {
        $this->conn = $db; // asignamos la conexión a la propiedad
    }

    //establecemos un método para crear un nuevo usuario
    public function crearUsuario($data) {
        // consulta SQL para insertar un nuevo usuario
        $query = "INSERT INTO " . $this->table_name . " (nombre, correo, edad, plan_id) VALUES (?, ?, ?, ?)";
        $stmt = $this->conn->prepare($query); // preparamos la consulta
        return $stmt->execute([$data['nombre'], $data['correo'], $data['edad'], $data['plan_id']]); // ejecutamos la consulta
    }

    //establecemos un método para listar todos los usuarios
    public function listarUsuarios() {
        //hacemos una consulta SQL para obtener todos los usuarios y sus planes
        $query = "SELECT u.*, p.nombre AS plan FROM " . $this->table_name . " u LEFT JOIN planes p ON u.plan_id = p.id";
        //ejecutamos la consulta
        $stmt = $this->conn->query($query); 
        //devolvemos todos los resultados
        return $stmt->fetchAll(PDO::FETCH_ASSOC); 
    }

    //establecemos un método para eliminar un usuario por su ID
    public function eliminarUsuario($id) {
        $query = "DELETE FROM " . $this->table_name . " WHERE id = ?";
        $stmt = $this->conn->prepare($query);
        //devolvemos como verdadero si se eliminó correctamente
        return $stmt->execute([$id]); 
    }

    //establecemos un método para actualizar un usuario
    public function actualizarUsuario($id, $data) {
        //hacemos una consulta SQL para actualizar un usuario
        $query = "UPDATE " . $this->table_name . " SET nombre = ?, correo = ?, edad = ?, plan_id = ? WHERE id = ?";
        //preparamos la consulta
        $stmt = $this->conn->prepare($query); 
        //ejecutamos la consulta
        return $stmt->execute([$data['nombre'], $data['correo'], $data['edad'], $data['plan_id'], $id]); 
    }

    //establecemos un método para obtener todos los planes disponibles
    public function obtenerPlanes() {
        //hacemos una consulta SQL para obtener los planes
        $query = "SELECT * FROM planes"; 
        //ejecutamos la consulta
        $stmt = $this->conn->query($query); 
        //devolvemos todos los resultados
        return $stmt->fetchAll(PDO::FETCH_ASSOC); 
    }
}
