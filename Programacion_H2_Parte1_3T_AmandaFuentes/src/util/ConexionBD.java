package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase para conectar a la base de datos
public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/cine_AmandaFuentes";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "1234"; 

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
