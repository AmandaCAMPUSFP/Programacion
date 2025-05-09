package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Definimos la clase ConexionBD que maneja la conexion a la base de datos
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/cine_AmandaFuentes";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    // Método estático que obtiene la conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
