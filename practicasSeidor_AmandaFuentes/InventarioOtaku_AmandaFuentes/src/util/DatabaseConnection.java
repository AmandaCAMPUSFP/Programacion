package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/akihabara_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";     
    private static final String PASSWORD = "1234"; 

    private static Connection connection = null;

    // M�todo para obtener la conexi�n 
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    // M�todo para cerrar la conexi�n 
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando la conexi�n: " + e.getMessage());
            }
        }
    }
}

