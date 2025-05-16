package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ProveedorDAO {
    // Lista que almacena los proveedores en memoria
    private List<Proveedor> proveedores;

    // Constructor que inicializa la lista vac�a de proveedores
    public ProveedorDAO() {
        proveedores = new ArrayList<>();
    }

    // M�todo para agregar un nuevo proveedor a la lista
    public void crear(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    // M�todo para obtener la lista completa de proveedores
    public List<Proveedor> listar() {
        return proveedores;
    }

    // M�todo para modificar un proveedor existente buscando por ID
    public void modificar(Proveedor proveedorModificado) {
        for (int i = 0; i < proveedores.size(); i++) {
            // Si encontramos el proveedor con el mismo ID, lo reemplazamos
            if (proveedores.get(i).getId() == proveedorModificado.getId()) {
                proveedores.set(i, proveedorModificado);
                return; 
            }
        }
    }

    // M�todo para eliminar un proveedor de la lista seg�n su ID
    public void eliminar(int id) {
        proveedores.removeIf(proveedor -> proveedor.getId() == id);
    }

    // M�todo para buscar y devolver un proveedor por su ID
    public Proveedor buscarPorId(int id) {
        for (Proveedor p : proveedores) {
            if (p.getId() == id) {
                return p; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}

