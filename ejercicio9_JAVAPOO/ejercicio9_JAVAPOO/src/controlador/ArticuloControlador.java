package controlador;

import modelo.Articulo;
import modelo.ArticuloDAO;
import vista.ArticuloVista;

import java.util.List;

public class ArticuloControlador {
    private ArticuloDAO articuloDAO;
    private ArticuloVista vistaArticulo;

    public ArticuloControlador(ArticuloDAO articuloDAO, ArticuloVista vistaArticulo) {
        this.articuloDAO = articuloDAO;
        this.vistaArticulo = vistaArticulo;
    }

    public void crearArticulo(Articulo articulo) {
        articuloDAO.crear(articulo);
        vistaArticulo.mostrarMensaje("Art�culo creado correctamente.");
    }

    public void listarArticulos() {
        List<Articulo> articulos = articuloDAO.listar();
        vistaArticulo.mostrarArticulos(articulos);
    }

    public void modificarArticulo(Articulo articulo) {
        articuloDAO.modificar(articulo);
        vistaArticulo.mostrarMensaje("Art�culo modificado correctamente.");
    }

    public void eliminarArticulo(int id) {
        articuloDAO.eliminar(id);
        vistaArticulo.mostrarMensaje("Art�culo eliminado correctamente.");
    }

    public Articulo buscarArticuloPorId(int id) {
        return articuloDAO.buscarPorId(id);
    }
}
