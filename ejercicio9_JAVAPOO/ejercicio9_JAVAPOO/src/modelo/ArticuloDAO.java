package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ArticuloDAO {
    // Lista que almacena todos los art�culos en memoria
    private List<Articulo> articulos;

    // Constructor que inicializa la lista vac�a cuando se crea un objeto ArticuloDAO
    public ArticuloDAO() {
        articulos = new ArrayList<>();
    }

    // M�todo para agregar un nuevo art�culo a la lista
    public void crear(Articulo articulo) {
        articulos.add(articulo);
    }

    // M�todo para devolver todos los art�culos guardados
    public List<Articulo> listar() {
        return articulos;
    }

    // M�todo para modificar un art�culo existente, busca por ID
    public void modificar(Articulo articuloModificado) {
        for (int i = 0; i < articulos.size(); i++) {
            // Comparamos IDs para encontrar el art�culo a modificar
            if (articulos.get(i).getId() == articuloModificado.getId()) {
                // Reemplazamos el art�culo viejo por el nuevo modificado
                articulos.set(i, articuloModificado);
                return; 
            }
        }
    }

    // M�todo para eliminar un art�culo de la lista seg�n su ID
    public void eliminar(int id) {
        // Elimina todos los art�culos cuyo ID coincida con el par�metro
        articulos.removeIf(articulo -> articulo.getId() == id);
    }

    // M�todo para buscar un art�culo por su ID y devolverlo
    public Articulo buscarPorId(int id) {
        for (Articulo a : articulos) {
            if (a.getId() == id) {
                return a; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}
