package modelo;

import modelo.Genero;           // Clase que representa el g�nero de la pel�cula
import modelo.Pelicula;         // Clase que representa la pel�cula
import util.ConexionBD;         // Clase para manejar la conexi�n a la base de datos

import java.sql.Connection;     
import java.sql.ResultSet;      
import java.sql.Statement;    
import java.util.Scanner;     


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos un scanner para leer la opci�n del usuario
        int opcion; // Variable para guardar la opci�n del men�

        // Bucle que muestra el men� hasta que el usuario elija salir
        do {
            System.out.println("----- MEN� -----");
            System.out.println("1. Ver pel�culas");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opci�n: ");

            try {
                // Leemos la opci�n y la convertimos en entero
                opcion = Integer.parseInt(sc.nextLine());

                // Ejecutamos una acci�n seg�n la opci�n seleccionada
                switch (opcion) {
                    case 1 -> verPeliculas();                // Si elige 1, mostramos las pel�culas
                    case 2 -> System.out.println("Saliendo..."); // Si elige 2, mostramos mensaje de salida
                    default -> System.out.println("Opci�n inv�lida"); // Si pone otra cosa, error
                }

            } catch (NumberFormatException e) {
                // Si el usuario no escribe un n�mero, mostramos un mensaje
                System.out.println("Debes introducir un n�mero.");
                opcion = 0; // Reiniciamos la opci�n para seguir en el men�
            }

        } while (opcion != 2); // Repetimos hasta que el usuario seleccione salir
    }

    // M�todo para consultar y mostrar las pel�culas desde la base de datos
    public static void verPeliculas() {
        // Consulta SQL que une la tabla de pel�culas con la de g�neros
        String sql = """
            SELECT p.codigoPelicula, p.titulo, p.director, p.a�o, p.duracion, g.codigoGenero, g.nombre
            FROM pelicula p
            JOIN genero g ON p.generoCodigo = g.codigoGenero;
            """;

        // Bloque try 
        try (Connection conn = ConexionBD.obtenerConexion(); // Obtenemos la conexi�n
             Statement stmt = conn.createStatement();        // Creamos el objeto para ejecutar SQL
             ResultSet rs = stmt.executeQuery(sql)) {        // Ejecutamos la consulta y obtenemos resultados

            // Recorremos cada fila del resultado
            while (rs.next()) {
                // Creamos un objeto Genero con los datos recuperados
                Genero genero = new Genero(
                        rs.getString("codigoGenero"),
                        rs.getString("nombre")
                );

                // Creamos un objeto Pelicula con los datos y el g�nero
                Pelicula pelicula = new Pelicula(
                        rs.getString("codigoPelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("a�o"),
                        rs.getInt("duracion"),
                        genero
                );

                // Mostramos la pel�cula por consola
                pelicula.mostrar();
            }

        } catch (Exception e) {
            // Si ocurre alg�n error, lo mostramos
            System.out.println("Error al recuperar las pel�culas: " + e.getMessage());
        }
    }
}

