package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ProveedorDAO {
    // Lista que almacena los proveedores en memoria
    private List<Proveedor> proveedores;

    // Constructor que inicializa la lista vacía de proveedores
    public ProveedorDAO() {
        proveedores = new ArrayList<>();
    }

    // Método para agregar un nuevo proveedor a la lista
    public void crear(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    // Método para obtener la lista completa de proveedores
    public List<Proveedor> listar() {
        return proveedores;
    }

    // Método para modificar un proveedor existente buscando por ID
    public void modificar(Proveedor proveedorModificado) {
        for (int i = 0; i < proveedores.size(); i++) {
            // Si encontramos el proveedor con el mismo ID, lo reemplazamos
            if (proveedores.get(i).getId() == proveedorModificado.getId()) {
                proveedores.set(i, proveedorModificado);
                return; 
            }
        }
    }

    // Método para eliminar un proveedor de la lista según su ID
    public void eliminar(int id) {
        proveedores.removeIf(proveedor -> proveedor.getId() == id);
    }

    // Método para buscar y devolver un proveedor por su ID
    public Proveedor buscarPorId(int id) {
        for (Proveedor p : proveedores) {
            if (p.getId() == id) {
                return p; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}

