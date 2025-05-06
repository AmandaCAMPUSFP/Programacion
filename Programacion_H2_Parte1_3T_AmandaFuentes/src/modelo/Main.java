package modelo;

import modelo.Genero;           // Clase que representa el género de la película
import modelo.Pelicula;         // Clase que representa la película
import util.ConexionBD;         // Clase para manejar la conexión a la base de datos

import java.sql.Connection;     
import java.sql.ResultSet;      
import java.sql.Statement;    
import java.util.Scanner;     


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos un scanner para leer la opción del usuario
        int opcion; // Variable para guardar la opción del menú

        // Bucle que muestra el menú hasta que el usuario elija salir
        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Ver películas");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                // Leemos la opción y la convertimos en entero
                opcion = Integer.parseInt(sc.nextLine());

                // Ejecutamos una acción según la opción seleccionada
                switch (opcion) {
                    case 1 -> verPeliculas();                // Si elige 1, mostramos las películas
                    case 2 -> System.out.println("Saliendo..."); // Si elige 2, mostramos mensaje de salida
                    default -> System.out.println("Opción inválida"); // Si pone otra cosa, error
                }

            } catch (NumberFormatException e) {
                // Si el usuario no escribe un número, mostramos un mensaje
                System.out.println("Debes introducir un número.");
                opcion = 0; // Reiniciamos la opción para seguir en el menú
            }

        } while (opcion != 2); // Repetimos hasta que el usuario seleccione salir
    }

    // Método para consultar y mostrar las películas desde la base de datos
    public static void verPeliculas() {
        // Consulta SQL que une la tabla de películas con la de géneros
        String sql = """
            SELECT p.codigoPelicula, p.titulo, p.director, p.año, p.duracion, g.codigoGenero, g.nombre
            FROM pelicula p
            JOIN genero g ON p.generoCodigo = g.codigoGenero;
            """;

        // Bloque try 
        try (Connection conn = ConexionBD.obtenerConexion(); // Obtenemos la conexión
             Statement stmt = conn.createStatement();        // Creamos el objeto para ejecutar SQL
             ResultSet rs = stmt.executeQuery(sql)) {        // Ejecutamos la consulta y obtenemos resultados

            // Recorremos cada fila del resultado
            while (rs.next()) {
                // Creamos un objeto Genero con los datos recuperados
                Genero genero = new Genero(
                        rs.getString("codigoGenero"),
                        rs.getString("nombre")
                );

                // Creamos un objeto Pelicula con los datos y el género
                Pelicula pelicula = new Pelicula(
                        rs.getString("codigoPelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("año"),
                        rs.getInt("duracion"),
                        genero
                );

                // Mostramos la película por consola
                pelicula.mostrar();
            }

        } catch (Exception e) {
            // Si ocurre algún error, lo mostramos
            System.out.println("Error al recuperar las películas: " + e.getMessage());
        }
    }
}

