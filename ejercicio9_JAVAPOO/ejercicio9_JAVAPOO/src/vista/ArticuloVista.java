package vista;

import modelo.Articulo;
import java.util.List;
import java.util.Scanner;

// Vista para interactuar con el usuario respecto a artículos
public class ArticuloVista {
    // Scanner para leer entradas del usuario
    private Scanner scanner = new Scanner(System.in);

    // Método para leer los datos de un artículo desde la consola
    public Articulo leerDatosArticulo() {
        System.out.println("Introduce el ID del artículo:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce el nombre del artículo:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el precio del artículo:");
        double precio = Double.parseDouble(scanner.nextLine());

        return new Articulo(id, nombre, precio);
    }

    // Método para mostrar una lista de artículos
    public void mostrarArticulos(List<Articulo> articulos) {
        System.out.println("Listado de artículos:");
        for (Articulo a : articulos) {
            System.out.println(a); // Usa el método toString() de Articulo
        }
    }

    // Método para mostrar un mensaje genérico
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para leer un ID desde la consola
    public int leerId() {
        System.out.println("Introduce el ID:");
        return Integer.parseInt(scanner.nextLine());
    }
}
