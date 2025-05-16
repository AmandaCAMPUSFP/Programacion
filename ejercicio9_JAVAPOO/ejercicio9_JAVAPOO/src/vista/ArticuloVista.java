package vista;

import modelo.Articulo;

import java.util.List;
import java.util.Scanner;

public class ArticuloVista {
    private Scanner scanner = new Scanner(System.in);

    public Articulo leerDatosArticulo() {
        System.out.println("Introduce el ID del artículo:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nombre del artículo:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el precio del artículo:");
        double precio = Double.parseDouble(scanner.nextLine());

        return new Articulo(id, nombre, precio);
    }

    public void mostrarArticulos(List<Articulo> articulos) {
        System.out.println("Listado de artículos:");
        for (Articulo a : articulos) {
            System.out.println(a);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int leerId() {
        System.out.println("Introduce el ID:");
        return Integer.parseInt(scanner.nextLine());
    }
}

