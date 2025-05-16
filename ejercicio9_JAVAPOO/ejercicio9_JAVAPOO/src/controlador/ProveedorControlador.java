package controlador;

import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.ProveedorVista;

import java.util.List;

public class ProveedorControlador {
    private ProveedorDAO proveedorDAO;
    private ProveedorVista vistaProveedor;

    public ProveedorControlador(ProveedorDAO proveedorDAO, ProveedorVista vistaProveedor) {
        this.proveedorDAO = proveedorDAO;
        this.vistaProveedor = vistaProveedor;
    }

    public void crearProveedor(Proveedor proveedor) {
        proveedorDAO.crear(proveedor);
        vistaProveedor.mostrarMensaje("Proveedor creado correctamente.");
    }

    public void listarProveedores() {
        List<Proveedor> proveedores = proveedorDAO.listar();
        vistaProveedor.mostrarProveedores(proveedores);
    }

    public void modificarProveedor(Proveedor proveedor) {
        proveedorDAO.modificar(proveedor);
        vistaProveedor.mostrarMensaje("Proveedor modificado correctamente.");
    }

    public void eliminarProveedor(int id) {
        proveedorDAO.eliminar(id);
        vistaProveedor.mostrarMensaje("Proveedor eliminado correctamente.");
    }

    public Proveedor buscarProveedorPorId(int id) {
        return proveedorDAO.buscarPorId(id);
    }
}
