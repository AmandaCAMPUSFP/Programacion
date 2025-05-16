package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/javapoo"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "1234"; 

    public static Connection obtenerConexion() throws SQLException {
        try {
            // Establecer la conexión con la base de datos
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
