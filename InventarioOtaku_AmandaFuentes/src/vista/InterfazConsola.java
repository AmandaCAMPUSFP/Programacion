package vista;

import java.util.List;
import java.util.Scanner;
import modelo.ProductoOtaku;

public class InterfazConsola {
    private Scanner scanner;

    // Definimos el constructor e inicializamos el Scanner
    public InterfazConsola() {
        scanner = new Scanner(System.in);
    }

    // (1) Mostramos el menú principal
    public void mostrarMenu() {
        System.out.println("\n --- MENÚ PRINCIPAL ---");
        System.out.println("1. Añadir nuevo producto");
        System.out.println("2. Consultar producto por ID");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Actualizar un producto");
        System.out.println("5. Eliminar un producto");
        System.out.println("6. Usar asistente IA");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }

    // (2) Leemos la opción elegida
    public int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // (3) Pedimos los datos de un producto nuevo
    public ProductoOtaku leerDatosProductoNuevo() {
        scanner.nextLine(); 
        System.out.println("Introduce los datos del nuevo producto:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = leerDoubleSeguro();
        System.out.print("Stock: ");
        int stock = leerIntSeguro();

        return new ProductoOtaku(nombre, categoria, precio, stock);
    }

    // (4) Leemos el ID del producto a consultar, actualizar o eliminar
    public int leerIdProducto() {
        System.out.print("Introduce el ID del producto: ");
        return leerIntSeguro();
    }

    // (5) Mostrar un solo producto
    public void mostrarProducto(ProductoOtaku producto) {
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // (6) Mostrar lista de productos
    public void mostrarListaProductos(List<ProductoOtaku> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("Productos disponibles:");
            for (ProductoOtaku p : productos) {
                System.out.println(p);
            }
        }
    }

    // (7) Leer nuevos datos para actualizar un producto existente
    public ProductoOtaku leerDatosProductoActualizado(int idOriginal) {
        scanner.nextLine(); // Limpieza del buffer
        System.out.println("Introduce los nuevos datos del producto:");
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva categoría: ");
        String categoria = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = leerDoubleSeguro();
        System.out.print("Nuevo stock: ");
        int stock = leerIntSeguro();

        return new ProductoOtaku(idOriginal, nombre, categoria, precio, stock);
    }

    // (8) Mostrar mensajes
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // (9) Mostrar el submenú del asistente IA
    public void mostrarSubmenuIA() {
        System.out.println("\n --- Asistente IA ---");
        System.out.println("1. Generar una descripción del producto");
        System.out.println("2. Sugerir una categoría para el nuevo producto");
        System.out.print("Elige una opción: ");
    }

    // (10) Leer nombre del producto para IA
    public String leerNombreProducto() {
        scanner.nextLine(); 
        System.out.print("Introduce el nombre del producto: ");
        return scanner.nextLine();
    }

    // Métodos privados para validar los datos numéricos
    private int leerIntSeguro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Introduce un número entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double leerDoubleSeguro() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Introduce un número decimal válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
