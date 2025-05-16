package controlador;

// Importo las clases necesarias del modelo y la vista
import modelo.Articulo;
import modelo.ArticuloDAO;
import vista.ArticuloVista;

import java.util.List;

public class ArticuloControlador {
    // Creo los atributos que voy a usar: el DAO y la vista
    private ArticuloDAO articuloDAO;
    private ArticuloVista vistaArticulo;

    // Este es el constructor, que recibe el DAO y la vista al crear el controlador
    public ArticuloControlador(ArticuloDAO articuloDAO, ArticuloVista vistaArticulo) {
        this.articuloDAO = articuloDAO;
        this.vistaArticulo = vistaArticulo;
    }

    // Método para crear un artículo
    public void crearArticulo(Articulo articulo) {
        articuloDAO.crear(articulo); // Llamo al DAO para guardarlo en la base de datos
        vistaArticulo.mostrarMensaje("Artículo creado correctamente."); // Muestro un mensaje
    }

    // Método para mostrar todos los artículos
    public void listarArticulos() {
        List<Articulo> articulos = articuloDAO.listar(); // Pido la lista al DAO
        vistaArticulo.mostrarArticulos(articulos); // Se la paso a la vista para que los muestre
    }

    // Método para modificar un artículo
    public void modificarArticulo(Articulo articulo) {
        articuloDAO.modificar(articulo); // Llamo al DAO para hacer los cambios
        vistaArticulo.mostrarMensaje("Artículo modificado correctamente."); // Muestro un mensaje
    }

    // Método para eliminar un artículo por su id
    public void eliminarArticulo(int id) {
        articuloDAO.eliminar(id); // Llamo al DAO para borrarlo
        vistaArticulo.mostrarMensaje("Artículo eliminado correctamente."); // Muestro un mensaje
    }

    // Método para buscar un artículo por su id
    public Articulo buscarArticuloPorId(int id) {
        return articuloDAO.buscarPorId(id); // Devuelvo el artículo encontrado
    }
}

