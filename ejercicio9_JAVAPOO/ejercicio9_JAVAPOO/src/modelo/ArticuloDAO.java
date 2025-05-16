package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ArticuloDAO {
    // Lista que almacena todos los artículos en memoria
    private List<Articulo> articulos;

    // Constructor que inicializa la lista vacía cuando se crea un objeto ArticuloDAO
    public ArticuloDAO() {
        articulos = new ArrayList<>();
    }

    // Método para agregar un nuevo artículo a la lista
    public void crear(Articulo articulo) {
        articulos.add(articulo);
    }

    // Método para devolver todos los artículos guardados
    public List<Articulo> listar() {
        return articulos;
    }

    // Método para modificar un artículo existente, busca por ID
    public void modificar(Articulo articuloModificado) {
        for (int i = 0; i < articulos.size(); i++) {
            // Comparamos IDs para encontrar el artículo a modificar
            if (articulos.get(i).getId() == articuloModificado.getId()) {
                // Reemplazamos el artículo viejo por el nuevo modificado
                articulos.set(i, articuloModificado);
                return; 
            }
        }
    }

    // Método para eliminar un artículo de la lista según su ID
    public void eliminar(int id) {
        // Elimina todos los artículos cuyo ID coincida con el parámetro
        articulos.removeIf(articulo -> articulo.getId() == id);
    }

    // Método para buscar un artículo por su ID y devolverlo
    public Articulo buscarPorId(int id) {
        for (Articulo a : articulos) {
            if (a.getId() == id) {
                return a; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}
