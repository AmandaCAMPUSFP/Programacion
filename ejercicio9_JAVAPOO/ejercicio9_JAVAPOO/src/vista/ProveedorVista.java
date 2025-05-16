package vista;

import modelo.Proveedor;

import java.util.List;
import java.util.Scanner;

public class ProveedorVista {
    private Scanner scanner = new Scanner(System.in);

    // Método para leer datos del proveedor desde consola
    public Proveedor leerDatosProveedor() {
        System.out.println("Introduce el ID del proveedor:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce el nombre del proveedor:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el correo del proveedor:");
        String correo = scanner.nextLine();

        System.out.println("Introduce el teléfono del proveedor:");
        String telefono = scanner.nextLine();

        // Creamos y devolvemos el proveedor
        return new Proveedor(id, nombre, correo, telefono);
    }

    // Método para mostrar lista de proveedores
    public void mostrarProveedores(List<Proveedor> proveedores) {
        System.out.println("Listado de proveedores:");
        for (Proveedor p : proveedores) {
            System.out.println(p);
        }
    }

    // Método para mostrar un mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para leer el ID desde consola
    public int leerId() {
        System.out.println("Introduce el ID:");
        return Integer.parseInt(scanner.nextLine());
    }
}
