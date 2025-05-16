package vista;

import modelo.Cliente;
import java.util.List;

// Vista para mostrar datos de clientes
public class ClienteVista {

    // Método para mostrar la lista de clientes
    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("----- Lista de Clientes -----");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() 
                + " | Nombre: " + cliente.getNombre() 
                + " | Email: " + cliente.getCorreo() 
                + " | Teléfono: " + cliente.getTelefono());
        }
        System.out.println("----------------------------");
    }

    // Método para mostrar un mensaje simple
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
