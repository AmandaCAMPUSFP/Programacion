package hito1_AmandaFuentes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Creamos una lista para almacenar los animales (de tipo Animal, que puede ser Perro o Gato)
    public static ArrayList<Animal> listaAnimales = new ArrayList<>();

    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Bucle principal que se ejecuta mientras la variable "salir" sea falsa
        while(!salir) {
            // Mostrar las opciones del menú
            System.out.println("---Menú principal---");
            System.out.println("1. Registrar perro");
            System.out.println("2. Registrar gato");
            System.out.println("3. Buscar por chip");
            System.out.println("4. Mostrar todos los animales");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            // Leemos la opción seleccionada por el usuario
            int opcion = Integer.parseInt(scanner.nextLine());

            // Según la opción seleccionada, ejecutamos la acción que le corresponda
            switch (opcion) {
                case 1:
                    registrarPerro(scanner);
                    break;
                case 2:
                    registrarGato(scanner);
                    break;
                case 3:
                    buscarPorChip(scanner);
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    // Si el usuario elige salir, cambiamos el valor de "salir" a true y termina el programa
                    salir = true;
                    System.out.println("Hasta otra!");
                    break;
                default:
                    // Si la opción no es válida, mostramos un mensaje
                    System.out.println("Opción no válida");
            }
        }

        // Cerramos el scanner al final 
        scanner.close();
    }

    // Método para registrar un perro
    public static void registrarPerro(Scanner scanner) {
        System.out.println("Introduce los datos del perro:");
        // Pedimos los datos al usuario
        String chip = pedirChip(scanner);
        String nombre = pedirTexto(scanner, "Nombre:");
        int edad = pedirEntero(scanner, "Edad:");
        String raza = pedirTexto(scanner, "Raza:");
        boolean adoptado = pedirBooleano(scanner, "¿Es adoptado? (true si es Si/false si es No):");
        String tamaño = pedirTexto(scanner, "Tamaño (pequeño/mediano/grande):");

        // Creamos un objeto Perro y lo añadimos a la lista de animales
        Perro perro = new Perro(chip, nombre, edad, raza, adoptado, tamaño);
        listaAnimales.add(perro);
        System.out.println("Perro registrado correctamente");
    }

    // Método para registrar un gato
    public static void registrarGato(Scanner scanner) {
        System.out.println("Introduce los datos del gato: ");
        // Pedimos los datos al usuario
        String chip = pedirChip(scanner);
        String nombre = pedirTexto(scanner, "Nombre: ");
        int edad = pedirEntero(scanner, "Edad: ");
        String raza = pedirTexto(scanner, "Raza: ");
        boolean adoptado = pedirBooleano(scanner, "¿Es adoptado? (true si es Si/false si es No): ");
        boolean testLeucemia = pedirBooleano(scanner, "¿Test de leucemia positivo? (true si es Si/false si es No): ");

        // Creamos un objeto Gato y lo añadimos a la lista de animales
        Gato gato = new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);
        listaAnimales.add(gato);
        System.out.println("Gato registrado correctamente");
    }

    // Método para buscar un animal por su número de chip
    public static void buscarPorChip(Scanner scanner) {
        String chipBuscado = pedirTexto(scanner, "Introduce el número de chip: ");
        boolean encontrado = false;

        // Recorremos la lista de animales para buscar uno con el chip especificado
        for (Animal animal : listaAnimales) {
            if (animal.chip.equals(chipBuscado)) {
                // Si encontramos el animal, mostramos sus datos
                animal.mostrar();
                encontrado = true;
                break;
            }
        }

        // Si no se encuentra el animal, mostramos un mensaje de error
        if (!encontrado) {
            System.out.println("No se encontró ningún animal con ese chip");
        }
    }

    // Método para mostrar todos los animales registrados
    public static void mostrarTodos() {
        if (listaAnimales.isEmpty()) {
            System.out.println("No hay animales registrados");
        } else {
            System.out.println("---Lista de animales---");
            // Recorremos la lista de animales y mostramos los datos de cada uno
            for (Animal a : listaAnimales) {
                a.mostrar();
            }
        }
    }

    // Métodos auxiliares para validar la entrada del usuario
    // Método para pedir texto al usuario
    public static String pedirTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextLine();
    }

    // Método para pedir un número entero al usuario
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje + " ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Método para pedir un valor booleano al usuario (true o false)
    public static boolean pedirBooleano(Scanner scanner, String mensaje) {
        System.out.print(mensaje + " ");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    // Método para pedir el número de chip y asegurarse de que no esté repetido
    public static String pedirChip(Scanner scanner) {
        while (true) {
            // Pedimos el chip al usuario
            String chip = pedirTexto(scanner, "Número de chip: ");
            boolean existe = false;
            // Recorremos la lista de animales para verificar que el chip no esté repetido
            for (Animal a : listaAnimales) {
                if (a.chip.equals(chip)) {
                    existe = true;
                    break;
                }
            }
            // Si el chip no existe, lo devolvemos
            if (!existe) return chip;
            // Si ya existe, mostramos un mensaje y pedimos otro chip
            System.out.println("Ya existe un animal con ese chip. Introduce otro.");
        }
    }
}
