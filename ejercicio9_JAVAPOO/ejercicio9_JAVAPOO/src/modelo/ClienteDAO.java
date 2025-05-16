package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ClienteDAO {
    // Lista donde guardo todos los clientes en memoria
    private List<Cliente> clientes;

    // Constructor que crea la lista vacía de clientes
    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    // Método para añadir un cliente nuevo a la lista
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método que devuelve todos los clientes que tengo guardados
    public List<Cliente> listar() {
        return clientes;
    }

    // Método para modificar un cliente buscando por su ID
    public void modificar(Cliente clienteModificado) {
        for (int i = 0; i < clientes.size(); i++) {
            // Busco el cliente con el mismo ID y lo cambio por el nuevo
            if (clientes.get(i).getId() == clienteModificado.getId()) {
                clientes.set(i, clienteModificado);
                return; // Salgo del método cuando ya lo modifiqué
            }
        }
    }

    // Método para borrar un cliente usando su ID
    public void eliminar(int id) {
        // Borro todos los clientes que tengan ese ID
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // Método para buscar un cliente por su ID y devolverlo
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c; // Devuelvo el cliente si lo encuentro
            }
        }
        return null; // Si no lo encuentro, devuelvo null
    }
}
