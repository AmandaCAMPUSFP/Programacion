package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class ClienteDAO {
    // Lista que almacena los clientes en memoria
    private List<Cliente> clientes;

    // Constructor que inicializa la lista vac�a de clientes
    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    // M�todo para agregar un nuevo cliente a la lista
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    // M�todo para obtener la lista completa de clientes
    public List<Cliente> listar() {
        return clientes;
    }

    // M�todo para modificar un cliente existente buscando por ID
    public void modificar(Cliente clienteModificado) {
        for (int i = 0; i < clientes.size(); i++) {
            // Si encontramos el cliente con el mismo ID, lo reemplazamos
            if (clientes.get(i).getId() == clienteModificado.getId()) {
                clientes.set(i, clienteModificado);
                return; // Salimos del m�todo
            }
        }
    }

    // M�todo para eliminar un cliente de la lista seg�n su ID
    public void eliminar(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // M�todo para buscar y devolver un cliente por su ID
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}
