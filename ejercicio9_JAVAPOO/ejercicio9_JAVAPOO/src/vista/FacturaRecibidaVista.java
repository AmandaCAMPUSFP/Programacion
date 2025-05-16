package vista;

import modelo.FacturaRecibida;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Clase vista para interactuar con el usuario sobre facturas recibidas
public class FacturaRecibidaVista {
    private Scanner scanner = new Scanner(System.in);

    // Método para leer los datos de una factura recibida desde consola
    public FacturaRecibida leerDatosFactura() {
        System.out.println("Introduce el ID de la factura:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce el ID del proveedor:");
        int idProveedor = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce la fecha (YYYY-MM-DD):");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        System.out.println("Introduce el importe:");
        double importe = Double.parseDouble(scanner.nextLine());

        // Creamos y devolvemos el objeto factura
        return new FacturaRecibida(id, idProveedor, fecha, importe);
    }

    // Método para mostrar una lista de facturas
    public void mostrarFacturas(List<FacturaRecibida> facturas) {
        System.out.println("Listado de facturas recibidas:");
        for (FacturaRecibida f : facturas) {
            System.out.println(f);
        }
    }

    // Método para mostrar un mensaje genérico
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para leer un ID desde consola
    public int leerId() {
        System.out.println("Introduce el ID:");
        return Integer.parseInt(scanner.nextLine());
    }
}
