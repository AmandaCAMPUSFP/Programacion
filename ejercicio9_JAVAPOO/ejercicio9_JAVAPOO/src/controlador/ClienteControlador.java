package controlador;

// Importo lo que necesito del modelo y la vista
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteVista;

import java.util.List;

public class ClienteControlador {
    // Declaro los atributos: el DAO para manejar los datos y la vista para mostrar cosas
    private ClienteDAO clienteDAO;
    private ClienteVista vistaCliente;

    // Constructor que recibe el DAO y la vista cuando se crea el controlador
    public ClienteControlador(ClienteDAO clienteDAO, ClienteVista vistaCliente) {
        this.clienteDAO = clienteDAO;
        this.vistaCliente = vistaCliente;
    }

    // Método para crear un cliente nuevo
    public void crearCliente(Cliente cliente) {
        clienteDAO.crear(cliente); // Le digo al DAO que lo guarde
        vistaCliente.mostrarMensaje("Cliente creado correctamente."); // Muestro un mensajito
    }

    // Método para mostrar todos los clientes
    public void listarClientes() {
        List<Cliente> clientes = clienteDAO.listar(); // Pido la lista al DAO
        vistaCliente.mostrarClientes(clientes); // La muestro por pantalla con la vista
    }

    // Método para modificar los datos de un cliente
    public void modificarCliente(Cliente cliente) {
        clienteDAO.modificar(cliente); // Llamo al DAO para cambiar los datos
        vistaCliente.mostrarMensaje("Cliente modificado correctamente."); // Mensaje de confirmación
    }

    // Método para eliminar un cliente por su ID
    public void eliminarCliente(int id) {
        clienteDAO.eliminar(id); // Llamo al DAO para borrarlo
        vistaCliente.mostrarMensaje("Cliente eliminado correctamente."); // Mensaje de confirmación
    }

    // Método para buscar un cliente por su ID
    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id); // Devuelvo el cliente que haya encontrado
    }
}
