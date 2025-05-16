package controlador;

import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteVista;

import java.util.List;

public class ClienteControlador {
    private ClienteDAO clienteDAO;
    private ClienteVista vistaCliente;

    public ClienteControlador(ClienteDAO clienteDAO, ClienteVista vistaCliente) {
        this.clienteDAO = clienteDAO;
        this.vistaCliente = vistaCliente;
    }

    public void crearCliente(Cliente cliente) {
        clienteDAO.crear(cliente);
        vistaCliente.mostrarMensaje("Cliente creado correctamente.");
    }

    public void listarClientes() {
        List<Cliente> clientes = clienteDAO.listar();
        vistaCliente.mostrarClientes(clientes);
    }

    public void modificarCliente(Cliente cliente) {
        clienteDAO.modificar(cliente);
        vistaCliente.mostrarMensaje("Cliente modificado correctamente.");
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminar(id);
        vistaCliente.mostrarMensaje("Cliente eliminado correctamente.");
    }

    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id);
    }
}
