package controlador;

// Importo las clases necesarias del modelo y la vista
import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.ProveedorVista;

import java.util.List;

public class ProveedorControlador {
    // Creo los atributos para manejar datos (DAO) y mostrar info (vista)
    private ProveedorDAO proveedorDAO;
    private ProveedorVista vistaProveedor;

    // Constructor para recibir el DAO y la vista y poder usarlos en la clase
    public ProveedorControlador(ProveedorDAO proveedorDAO, ProveedorVista vistaProveedor) {
        this.proveedorDAO = proveedorDAO;
        this.vistaProveedor = vistaProveedor;
    }

    // Método para crear un proveedor y mostrar un mensaje de éxito
    public void crearProveedor(Proveedor proveedor) {
        proveedorDAO.crear(proveedor); // Guardo el proveedor en la base de datos
        vistaProveedor.mostrarMensaje("Proveedor creado correctamente."); // Mensaje para el usuario
    }

    // Método para listar todos los proveedores y mostrarlos en la vista
    public void listarProveedores() {
        List<Proveedor> proveedores = proveedorDAO.listar(); // Pido la lista de proveedores al DAO
        vistaProveedor.mostrarProveedores(proveedores); // Muestro la lista usando la vista
    }

    // Método para modificar un proveedor y avisar que se modificó
    public void modificarProveedor(Proveedor proveedor) {
        proveedorDAO.modificar(proveedor); // Actualizo el proveedor en la base de datos
        vistaProveedor.mostrarMensaje("Proveedor modificado correctamente."); // Mensaje de confirmación
    }

    // Método para eliminar un proveedor usando su ID y mostrar mensaje
    public void eliminarProveedor(int id) {
        proveedorDAO.eliminar(id); // Borro el proveedor de la base de datos
        vistaProveedor.mostrarMensaje("Proveedor eliminado correctamente."); // Mensaje para avisar
    }

    // Método para buscar un proveedor por su ID y devolverlo
    public Proveedor buscarProveedorPorId(int id) {
        return proveedorDAO.buscarPorId(id); // Devuelvo el proveedor que encontró el DAO
    }
}
