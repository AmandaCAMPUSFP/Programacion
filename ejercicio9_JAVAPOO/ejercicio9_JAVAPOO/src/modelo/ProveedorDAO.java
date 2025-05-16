package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ProveedorDAO {
    // Lista donde almacenamos los proveedores en memoria
    private List<Proveedor> proveedores;

    // Constructor que crea una lista vacía para empezar a guardar proveedores
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

    // Método para modificar un proveedor buscando por su ID y reemplazándolo
    public void modificar(Proveedor proveedorModificado) {
        for (int i = 0; i < proveedores.size(); i++) {
            // Si encontramos un proveedor con el mismo ID, lo actualizamos con los datos nuevos
            if (proveedores.get(i).getId() == proveedorModificado.getId()) {
                proveedores.set(i, proveedorModificado);
                return; // Salimos porque ya modificamos el proveedor
            }
        }
    }

    // Método para eliminar un proveedor de la lista según su ID
    public void eliminar(int id) {
        // Eliminamos todos los proveedores que tengan el ID indicado
        proveedores.removeIf(proveedor -> proveedor.getId() == id);
    }

    // Método para buscar y devolver un proveedor por su ID
    public Proveedor buscarPorId(int id) {
        // Recorremos la lista y si encontramos el proveedor con ese ID, lo devolvemos
        for (Proveedor p : proveedores) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Si no lo encontramos, devolvemos null
    }
}

