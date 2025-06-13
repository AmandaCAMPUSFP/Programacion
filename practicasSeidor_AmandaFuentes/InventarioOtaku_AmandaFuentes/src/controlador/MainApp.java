package controlador; 

import vista.InterfazConsola;
import dao.ProductoDAO;
import modelo.ProductoOtaku;
import servicio.LlmService;
import java.util.List;

// Definimos la clase principal que ejcutará el programa
public class MainApp {
    public static void main(String[] args) {
    	// Instancias para manejar la consola, los datos y la IA
        InterfazConsola consola = new InterfazConsola();
        ProductoDAO dao = new ProductoDAO();
        LlmService ia = new LlmService();

        boolean salir = false;

        while (!salir) {
            consola.mostrarMenu();
            int opcion = consola.leerOpcion();
            
            // Definimos un switch con opciones para elegir en el menú
            switch (opcion) {
                case 1:
                    // 1. Añadir nuevo producto
                    ProductoOtaku nuevo = consola.leerDatosProductoNuevo();
                    dao.agregarProducto(nuevo);
                    consola.mostrarMensaje("Producto añadido con éxito.");
                    break;

                case 2:
                    // 2. Consultar por producto por ID
                    int idConsulta = consola.leerIdProducto();
                    ProductoOtaku encontrado = dao.obtenerProductoPorId(idConsulta);
                    consola.mostrarProducto(encontrado);
                    break;

                case 3:
                    // 3. Mostrar todos los productos
                    List<ProductoOtaku> lista = dao.obtenerTodosLosProductos();
                    consola.mostrarListaProductos(lista);
                    break;

                case 4:
                    // 4. Actualizar un producto
                    int idActualizar = consola.leerIdProducto();
                    if (dao.obtenerProductoPorId(idActualizar) != null) {
                        ProductoOtaku actualizado = consola.leerDatosProductoActualizado(idActualizar);
                        boolean exito = dao.actualizarProducto(actualizado);
                        consola.mostrarMensaje(exito ? "Producto actualizado correctamente." : "No se pudo actualizar.");
                    } else {
                        consola.mostrarMensaje("Producto no encontrado.");
                    }
                    break;

                case 5:
                    // 5. Eliminar un producto
                    int idEliminar = consola.leerIdProducto();
                    boolean eliminado = dao.eliminarProducto(idEliminar);
                    consola.mostrarMensaje(eliminado ? "Producto eliminado correctamente." : "Producto no encontrado.");
                    break;

                case 6:
                    // 6. Asistente IA
                    consola.mostrarSubmenuIA();
                    int opcionIA = consola.leerOpcion();
                    switch (opcionIA) {
                        case 1:
                            int idProd = consola.leerIdProducto();
                            ProductoOtaku prod = dao.obtenerProductoPorId(idProd);
                            if (prod != null) {
                            	String promptDescripcion = "Genera **solo** una descripción de marketing breve y atractiva en español para el producto otaku llamado '" 
                            	        + prod.getNombre() + "', que pertenece a la categoría '" + prod.getCategoria() + "'. No incluyas texto en otro idioma ni traducciones.";
                                String descripcion = ia.obtenerRespuestaIA(promptDescripcion);
                                consola.mostrarMensaje("Descripción generada por IA:");
                                consola.mostrarMensaje(descripcion);
                            } else {
                                consola.mostrarMensaje("Producto no encontrado.");
                            }
                            break;
                        case 2:
                            String nombreNuevo = consola.leerNombreProducto();
                            String promptCategoria = "Para un producto otaku llamado '" + nombreNuevo + 
                                    "', sugiere en español una categoría adecuada de esta lista: Figura, Manga, Póster, Llavero, Ropa, Videojuego, Otro.";
                            String categoriaSugerida = ia.obtenerRespuestaIA(promptCategoria);
                            consola.mostrarMensaje("Categoría sugerida por IA:");
                            consola.mostrarMensaje(categoriaSugerida);
                            break;
                        default:
                            consola.mostrarMensaje("Opción no válida en menú IA.");
                    }
                    break;

                case 7:
                	
                    // 7. Salir
                    consola.mostrarMensaje("¡Gracias por usar el sistema! Saliendo...");
                    salir = true;
                    break;

                default:
                    consola.mostrarMensaje("Opción no válida, intenta de nuevo.");
            }
        }
    }
}
