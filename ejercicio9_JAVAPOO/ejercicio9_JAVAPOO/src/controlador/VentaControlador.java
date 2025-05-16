package controlador;

import modelo.Venta;
import modelo.VentaDAO;
import vista.VentaVista;

import java.util.List;

public class VentaControlador {
    private VentaDAO ventaDAO;
    private VentaVista vistaVenta;

    public VentaControlador(VentaDAO ventaDAO, VentaVista vistaVenta) {
        this.ventaDAO = ventaDAO;
        this.vistaVenta = vistaVenta;
    }

    public void crearVenta(Venta venta) {
        ventaDAO.crear(venta);
        vistaVenta.mostrarMensaje("Venta creada correctamente.");
    }

    public void listarVentas() {
        List<Venta> ventas = ventaDAO.listar();
        vistaVenta.mostrarVentas(ventas);
    }

    public void modificarVenta(Venta venta) {
        ventaDAO.modificar(venta);
        vistaVenta.mostrarMensaje("Venta modificada correctamente.");
    }

    public void eliminarVenta(int id) {
        ventaDAO.eliminar(id);
        vistaVenta.mostrarMensaje("Venta eliminada correctamente.");
    }

    public Venta buscarVentaPorId(int id) {
        return ventaDAO.buscarPorId(id);
    }
}

