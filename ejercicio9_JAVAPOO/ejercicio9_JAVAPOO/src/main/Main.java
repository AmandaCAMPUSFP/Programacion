package main; 

import conexion.ConexionBD; 
import controlador.ClienteControlador; 
import java.sql.Connection; 
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Establecer la conexi�n a la base de datos
        Connection conn = null;
        try {
            // Usamos la clase ConexionBD para obtener la conexi�n
            conn = ConexionBD.obtenerConexion();
            if (conn != null) {
                System.out.println("Conexi�n exitosa a la base de datos.");
                
                // Crear una instancia del controlador y gestionar clientes
                ClienteControlador controlador = new ClienteControlador(conn);
                controlador.gestionarClientes(); // Llamamos al m�todo del controlador que maneja las operaciones de clientes
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close(); // Cerramos la conexi�n cuando terminamos
                    System.out.println("Saliendo..");
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexi�n: " + e.getMessage());
            }
        }
    }
}

