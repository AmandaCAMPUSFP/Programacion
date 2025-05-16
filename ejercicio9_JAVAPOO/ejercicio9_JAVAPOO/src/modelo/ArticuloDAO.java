package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ArticuloDAO {
    // Lista donde guardo todos los artículos en memoria
    private List<Articulo> articulos;

    // Constructor que crea la lista vacía cuando hago un objeto ArticuloDAO
    public ArticuloDAO() {
        articulos = new ArrayList<>();
    }

    // Método para añadir un artículo nuevo a la lista
    public void crear(Articulo articulo) {
        articulos.add(articulo);
    }

    // Método que devuelve todos los artículos guardados
    public List<Articulo> listar() {
        return articulos;
    }

    // Método para modificar un artículo buscando por su ID
    public void modificar(Articulo articuloModificado) {
        for (int i = 0; i < articulos.size(); i++) {
            // Busco el artículo que tenga el mismo ID que el que quiero modificar
            if (articulos.get(i).getId() == articuloModificado.getId()) {
                // Cambio el artículo viejo por el nuevo que me pasan
                articulos.set(i, articuloModificado);
                return; 
            }
        }
    }

    // Método para eliminar un artículo usando su ID
    public void eliminar(int id) {
        // Borro todos los artículos que tengan el ID que me pasan
        articulos.removeIf(articulo -> articulo.getId() == id);
    }

    // Método para buscar un artículo por su ID y devolverlo
    public Articulo buscarPorId(int id) {
        for (Articulo a : articulos) {
            if (a.getId() == id) {
                return a; // Devuelvo el artículo si lo encuentro
            }
        }
        return null; // Si no lo encuentro, devuelvo null
    }
}
