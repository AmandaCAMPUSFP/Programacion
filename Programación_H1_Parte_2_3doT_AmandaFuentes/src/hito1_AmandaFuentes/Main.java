package hito1_AmandaFuentes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Listas para almacenar animales y adopciones
    public static ArrayList<Animal> listaAnimales = new ArrayList<>();
    public static ArrayList<Adopcion> listaAdopciones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while(!salir) {
            System.out.println("---Menú principal---");
            System.out.println("1. Dar de alta animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal");
            System.out.println("4. Realizar adopción");
            System.out.println("5. Dar de baja");
            System.out.println("6. Mostrar estadísticas de gatos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarAnimal(scanner);
                    break;
                case 2:
                    listarAnimales();
                    break;
                case 3:
                    buscarAnimal(scanner);
                    break;
                case 4:
                    realizarAdopcion(scanner);
                    break;
                case 5:
                    darDeBaja(scanner);
                    break;
                case 6:
                    mostrarEstadisticasGatos();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Hasta otra!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // Registrar un animal (Perro o gato)
    public static void registrarAnimal(Scanner scanner) {
        System.out.println("Registrar animal:");
        String tipoAnimal = pedirTexto(scanner, "¿Es un perro o un gato?");
        if (tipoAnimal.equalsIgnoreCase("perro")) {
            registrarPerro(scanner);
        } else if (tipoAnimal.equalsIgnoreCase("gato")) {
            registrarGato(scanner);
        } else {
            System.out.println("Tipo de animal no reconocido.");
        }
    }

    // Registrar un perro
    public static void registrarPerro(Scanner scanner) {
        System.out.println("Registrar perro:");
        String chip = pedirTexto(scanner, "Chip:");
        String nombre = pedirTexto(scanner, "Nombre:");
        int edad = pedirEntero(scanner, "Edad:");
        String raza = pedirTexto(scanner, "Raza:");
        boolean adoptado = pedirBooleano(scanner, "¿Es adoptado?");
        String tamaño = pedirTexto(scanner, "Tamaño (pequeño/mediano/grande):");
        Perro perro = new Perro(chip, nombre, edad, raza, adoptado, tamaño);
        listaAnimales.add(perro);
        System.out.println("Perro registrado correctamente.");
    }

    // Registrar un gato
    public static void registrarGato(Scanner scanner) {
        System.out.println("Registrar gato:");
        String chip = pedirTexto(scanner, "Chip:");
        String nombre = pedirTexto(scanner, "Nombre:");
        int edad = pedirEntero(scanner, "Edad:");
        String raza = pedirTexto(scanner, "Raza:");
        boolean adoptado = pedirBooleano(scanner, "¿Es adoptado?");
        boolean testLeucemia = pedirBooleano(scanner, "¿Test de leucemia positivo? (sí/no)");
        Gato gato = new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);
        listaAnimales.add(gato);
        System.out.println("Gato registrado correctamente.");
    }

    // Mostrar todos los animales
    public static void listarAnimales() {
        if (listaAnimales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal animal : listaAnimales) {
                animal.mostrar();
            }
        }
    }

    // Buscar un animal por chip
    public static void buscarAnimal(Scanner scanner) {
        String chipBuscado = pedirTexto(scanner, "Introduce el número de chip:");
        boolean encontrado = false;
        for (Animal animal : listaAnimales) {
            if (animal.chip.equals(chipBuscado)) {
                animal.mostrar();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún animal con ese chip.");
        }
    }

    // Realizar adopción
    public static void realizarAdopcion(Scanner scanner) {
        String chipAdoptado = pedirTexto(scanner, "Introduce el número de chip del animal que va a ser adoptado:");
        boolean animalEncontrado = false;
        Animal animalAdoptado = null;
        for (Animal animal : listaAnimales) {
            if (animal.chip.equals(chipAdoptado)) {
                if (!animal.adoptado) {
                    animalAdoptado = animal;
                    animal.adoptado = true;
                    String nombreAdoptante = pedirTexto(scanner, "Nombre del adoptante:");
                    String dniAdoptante = pedirTexto(scanner, "DNI del adoptante:");
                    Adopcion adopcion = new Adopcion(animalAdoptado, nombreAdoptante, dniAdoptante);
                    listaAdopciones.add(adopcion);
                    System.out.println("Adopción realizada correctamente.");
                } else {
                    System.out.println("Este animal ya ha sido adoptado.");
                }
                animalEncontrado = true;
                break;
            }
        }

        if (!animalEncontrado) {
            System.out.println("No se encontró ningún animal con ese chip.");
        }
    }

    // Dar de baja un animal
    public static void darDeBaja(Scanner scanner) {
        String chipABorrar = pedirTexto(scanner, "Introduce el chip del animal que deseas eliminar:");
        boolean animalEncontrado = false;

        for (int i = 0; i < listaAnimales.size(); i++) {
            if (listaAnimales.get(i).chip.equals(chipABorrar)) {
                listaAnimales.remove(i);
                System.out.println("Animal eliminado correctamente.");
                animalEncontrado = true;
                break;
            }
        }

        if (!animalEncontrado) {
            System.out.println("No se encontró ningún animal con ese chip.");
        }
    }

    // Mostrar estadísticas de gatos
    public static void mostrarEstadisticasGatos() {
        int gatosLeucemiaPositiva = 0;
        int gatosTotales = 0;

        for (Animal animal : listaAnimales) {
            if (animal instanceof Gato) {
                gatosTotales++;
                if (((Gato) animal).tieneLeucemia()) {
                    gatosLeucemiaPositiva++;
                }
            }
        }

        System.out.println("Total de gatos: " + gatosTotales);
        System.out.println("Total de gatos con leucemia positiva: " + gatosLeucemiaPositiva);
    }

    // Métodos auxiliares para pedir datos al usuario
    public static String pedirTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    public static boolean pedirBooleano(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().equalsIgnoreCase("sí");
    }
}
