package vista;

import modelo.Cliente;
import java.util.List;

public class ClienteVista {

    // M�todo para mostrar la lista de clientes
    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("----- Lista de Clientes -----");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() 
                + " | Nombre: " + cliente.getNombre() 
                + " | Email: " + cliente.getCorreo() 
                + " | Tel�fono: " + cliente.getTelefono());
        }
        System.out.println("----------------------------");
    }

    // M�todo para mostrar un mensaje simple
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
