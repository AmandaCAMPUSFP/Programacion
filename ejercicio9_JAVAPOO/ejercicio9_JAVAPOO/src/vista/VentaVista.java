package vista;

import modelo.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VentaVista {
    private Scanner scanner = new Scanner(System.in);

    // Método para leer los datos de una venta desde consola
    public Venta leerDatosVenta() {
        System.out.println("Introduce el ID de la venta:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce el ID del cliente:");
        int idCliente = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce el ID del artículo:");
        int idArticulo = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce la cantidad:");
        int cantidad = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce la fecha (YYYY-MM-DD):");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        return new Venta(id, idCliente, idArticulo, cantidad, fecha);
    }

    // Método para mostrar una lista de ventas
    public void mostrarVentas(List<Venta> ventas) {
        System.out.println("Listado de ventas:");
        for (Venta v : ventas) {
            System.out.println(v);
        }
    }

    // Método para mostrar mensajes genéricos
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para leer un ID desde consola
    public int leerId() {
        System.out.println("Introduce el ID:");
        return Integer.parseInt(scanner.nextLine());
    }
}
