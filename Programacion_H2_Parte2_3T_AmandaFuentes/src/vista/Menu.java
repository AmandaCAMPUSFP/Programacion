package vista;

import controlador.ControladorPeli;
import modelo.Genero;
import modelo.Pelicula;

import java.util.Scanner;

public class Menu {
    private ControladorPeli controladorPeli; // Instancia del controlador que maneja las operaciones de la pel�cula
    private Scanner scanner; 

    // Constructor que inicializa el controlador y el esc�ner
    public Menu() {
        controladorPeli = new ControladorPeli(); 
        scanner = new Scanner(System.in); 
    }

    // M�todo para mostrar el men� y manejar las opciones
    public void mostrarMenu() {
        int opcion; 
        do {
            // Imprime las opciones del men�
            System.out.println("===== MEN� PEL�CULAS =====");
            System.out.println("1. Ver pel�culas");
            System.out.println("2. A�adir pel�cula");
            System.out.println("3. Eliminar pel�cula");
            System.out.println("4. Modificar pel�cula");
            System.out.println("5. Salir");
            System.out.print("Elige una opci�n: ");
            opcion = Integer.parseInt(scanner.nextLine()); 

            // Dependiendo de la opci�n elegida, llama al m�todo correspondiente
            switch (opcion) {
                case 1:
                    verPeliculas(); 
                    break;
                case 2:
                    a�adirPelicula(); 
                    break;
                case 3:
                    eliminarPelicula(); 
                    break;
                case 4:
                    modificarPelicula(); 
                    break;
                case 5:
                    System.out.println("�Hasta luego!"); 
                    break;
                default:
                    System.out.println("Opci�n no v�lida. Intenta de nuevo."); 
            }
        } while (opcion != 5); 
    }

    // M�todo para mostrar las pel�culas registradas
    private void verPeliculas() {
        // Obtiene las pel�culas a trav�s del controlador
        var peliculas = controladorPeli.obtenerPeliculas();
        if (peliculas.isEmpty()) { 
            System.out.println("No hay pel�culas registradas.");
        } else {
            // Si hay pel�culas, las muestra
            for (Pelicula pelicula : peliculas) {
                System.out.println("C�digo: " + pelicula.getCodigo() +
                        ", T�tulo: " + pelicula.getTitulo() +
                        ", Director: " + pelicula.getDirector() +
                        ", A�o: " + pelicula.getA�o() +
                        ", Duraci�n: " + pelicula.getDuracion() + " minutos" +
                        ", G�nero: " + pelicula.getGenero().getNombre());
            }
        }
    }

    // M�todo para a�adir una nueva pel�cula
    private void a�adirPelicula() {
        // Solicita al usuario los datos de la nueva pel�cula
        System.out.print("Introduce el c�digo de la pel�cula: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduce el t�tulo de la pel�cula: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el director de la pel�cula: ");
        String director = scanner.nextLine();
        System.out.print("Introduce el a�o de la pel�cula: ");
        int a�o = Integer.parseInt(scanner.nextLine()); 
        System.out.print("Introduce la duraci�n de la pel�cula en minutos: ");
        int duracion = Integer.parseInt(scanner.nextLine()); 
        System.out.print("Introduce el c�digo del g�nero: ");
        String codigoGenero = scanner.nextLine(); 

        // Crea el objeto Genero y luego crea la pel�cula con los datos ingresados
        Genero genero = new Genero(codigoGenero, ""); 
        Pelicula pelicula = new Pelicula(codigo, titulo, director, a�o, duracion, genero);

        // Llama al controlador para a�adir la pel�cula
        boolean exito = controladorPeli.a�adirPelicula(pelicula);
        if (exito) {
            System.out.println("Pel�cula a�adida exitosamente.");
        } else {
            System.out.println("No se pudo a�adir la pel�cula.");
        }
    }

    // M�todo para eliminar una pel�cula
    private void eliminarPelicula() {
        System.out.print("Introduce el c�digo de la pel�cula a eliminar: ");
        String codigo = scanner.nextLine();
        
        // Llama al controlador para eliminar la pel�cula
        boolean exito = controladorPeli.eliminarPelicula(codigo);
        if (exito) {
            System.out.println("Pel�cula eliminada exitosamente.");
        } else {
            System.out.println("No se pudo eliminar la pel�cula.");
        }
    }

    // M�todo para modificar una pel�cula
    private void modificarPelicula() {
        System.out.print("Introduce el c�digo de la pel�cula que deseas modificar: ");
        String codigo = scanner.nextLine();

        // Verifica si la pel�cula existe antes de modificarla
        if (!controladorPeli.existePelicula(codigo)) {
            System.out.println("No existe ninguna pel�cula con ese c�digo.");
            return;
        }

        // Solicita los nuevos datos para la pel�cula
        System.out.print("Introduce el nuevo t�tulo de la pel�cula: ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Introduce el nuevo director de la pel�cula: ");
        String nuevoDirector = scanner.nextLine();
        System.out.print("Introduce el nuevo a�o de la pel�cula: ");
        int nuevoA�o = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduce la nueva duraci�n de la pel�cula en minutos: ");
        int nuevaDuracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduce el nuevo c�digo del g�nero: ");
        String nuevoCodigoGenero = scanner.nextLine();

        // Crea el nuevo objeto Genero
        Genero nuevoGenero = new Genero(nuevoCodigoGenero, "");

        // Llama al controlador para actualizar la pel�cula
        boolean exito = controladorPeli.modificarPelicula(codigo, nuevoTitulo, nuevoDirector, nuevoA�o, nuevaDuracion, nuevoGenero);
        if (exito) {
            System.out.println("Pel�cula modificada exitosamente.");
        } else {
            System.out.println("No se pudo modificar la pel�cula.");
        }
    }
}
