package vista;

import controlador.ControladorPeli;
import modelo.Genero;
import modelo.Pelicula;

import java.util.Scanner;

public class Menu {
    private ControladorPeli controladorPeli; // Instancia del controlador que maneja las operaciones de la película
    private Scanner scanner; 

    // Constructor que inicializa el controlador y el escáner
    public Menu() {
        controladorPeli = new ControladorPeli(); 
        scanner = new Scanner(System.in); 
    }

    // Método para mostrar el menú y manejar las opciones
    public void mostrarMenu() {
        int opcion; 
        do {
            // Imprime las opciones del menú
            System.out.println("===== MENÚ PELÍCULAS =====");
            System.out.println("1. Ver películas");
            System.out.println("2. Añadir película");
            System.out.println("3. Eliminar película");
            System.out.println("4. Modificar película");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine()); 

            // Dependiendo de la opción elegida, llama al método correspondiente
            switch (opcion) {
                case 1:
                    verPeliculas(); 
                    break;
                case 2:
                    añadirPelicula(); 
                    break;
                case 3:
                    eliminarPelicula(); 
                    break;
                case 4:
                    modificarPelicula(); 
                    break;
                case 5:
                    System.out.println("¡Hasta luego!"); 
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo."); 
            }
        } while (opcion != 5); 
    }

    // Método para mostrar las películas registradas
    private void verPeliculas() {
        // Obtiene las películas a través del controlador
        var peliculas = controladorPeli.obtenerPeliculas();
        if (peliculas.isEmpty()) { 
            System.out.println("No hay películas registradas.");
        } else {
            // Si hay películas, las muestra
            for (Pelicula pelicula : peliculas) {
                System.out.println("Código: " + pelicula.getCodigo() +
                        ", Título: " + pelicula.getTitulo() +
                        ", Director: " + pelicula.getDirector() +
                        ", Año: " + pelicula.getAño() +
                        ", Duración: " + pelicula.getDuracion() + " minutos" +
                        ", Género: " + pelicula.getGenero().getNombre());
            }
        }
    }

    // Método para añadir una nueva película
    private void añadirPelicula() {
        // Solicita al usuario los datos de la nueva película
        System.out.print("Introduce el código de la película: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduce el título de la película: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el director de la película: ");
        String director = scanner.nextLine();
        System.out.print("Introduce el año de la película: ");
        int año = Integer.parseInt(scanner.nextLine()); 
        System.out.print("Introduce la duración de la película en minutos: ");
        int duracion = Integer.parseInt(scanner.nextLine()); 
        System.out.print("Introduce el código del género: ");
        String codigoGenero = scanner.nextLine(); 

        // Crea el objeto Genero y luego crea la película con los datos ingresados
        Genero genero = new Genero(codigoGenero, ""); 
        Pelicula pelicula = new Pelicula(codigo, titulo, director, año, duracion, genero);

        // Llama al controlador para añadir la película
        boolean exito = controladorPeli.añadirPelicula(pelicula);
        if (exito) {
            System.out.println("Película añadida exitosamente.");
        } else {
            System.out.println("No se pudo añadir la película.");
        }
    }

    // Método para eliminar una película
    private void eliminarPelicula() {
        System.out.print("Introduce el código de la película a eliminar: ");
        String codigo = scanner.nextLine();
        
        // Llama al controlador para eliminar la película
        boolean exito = controladorPeli.eliminarPelicula(codigo);
        if (exito) {
            System.out.println("Película eliminada exitosamente.");
        } else {
            System.out.println("No se pudo eliminar la película.");
        }
    }

    // Método para modificar una película
    private void modificarPelicula() {
        System.out.print("Introduce el código de la película que deseas modificar: ");
        String codigo = scanner.nextLine();

        // Verifica si la película existe antes de modificarla
        if (!controladorPeli.existePelicula(codigo)) {
            System.out.println("No existe ninguna película con ese código.");
            return;
        }

        // Solicita los nuevos datos para la película
        System.out.print("Introduce el nuevo título de la película: ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Introduce el nuevo director de la película: ");
        String nuevoDirector = scanner.nextLine();
        System.out.print("Introduce el nuevo año de la película: ");
        int nuevoAño = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduce la nueva duración de la película en minutos: ");
        int nuevaDuracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduce el nuevo código del género: ");
        String nuevoCodigoGenero = scanner.nextLine();

        // Crea el nuevo objeto Genero
        Genero nuevoGenero = new Genero(nuevoCodigoGenero, "");

        // Llama al controlador para actualizar la película
        boolean exito = controladorPeli.modificarPelicula(codigo, nuevoTitulo, nuevoDirector, nuevoAño, nuevaDuracion, nuevoGenero);
        if (exito) {
            System.out.println("Película modificada exitosamente.");
        } else {
            System.out.println("No se pudo modificar la película.");
        }
    }
}
