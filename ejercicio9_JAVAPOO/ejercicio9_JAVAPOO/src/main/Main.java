package main; 

import conexion.ConexionBD; 
import controlador.ClienteControlador; 
import java.sql.Connection; 
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Establecer la conexión a la base de datos
        Connection conn = null;
        try {
            // Usamos la clase ConexionBD para obtener la conexión
            conn = ConexionBD.obtenerConexion();
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                
                // Crear una instancia del controlador y gestionar clientes
                ClienteControlador controlador = new ClienteControlador(conn);
                controlador.gestionarClientes(); // Llamamos al método del controlador que maneja las operaciones de clientes
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close(); // Cerramos la conexión cuando terminamos
                    System.out.println("Saliendo..");
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

