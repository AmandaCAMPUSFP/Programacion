package controlador;

// Importo las clases del modelo y la vista necesarias para ventas
import modelo.Venta;
import modelo.VentaDAO;
import vista.VentaVista;

import java.util.List;

public class VentaControlador {
    // Creo los atributos para manejar los datos y la vista
    private VentaDAO ventaDAO;
    private VentaVista vistaVenta;

    // Constructor que recibe el DAO y la vista para usarlos aquí
    public VentaControlador(VentaDAO ventaDAO, VentaVista vistaVenta) {
        this.ventaDAO = ventaDAO;
        this.vistaVenta = vistaVenta;
    }

    // Método para crear una venta y mostrar un mensaje de confirmación
    public void crearVenta(Venta venta) {
        ventaDAO.crear(venta); // Guardo la venta en la base de datos
        vistaVenta.mostrarMensaje("Venta creada correctamente."); // Aviso que se creó
    }

    // Método para listar todas las ventas y mostrarlas en la vista
    public void listarVentas() {
        List<Venta> ventas = ventaDAO.listar(); // Pido la lista de ventas al DAO
        vistaVenta.mostrarVentas(ventas); // Muestro las ventas en la vista
    }

    // Método para modificar una venta y mostrar mensaje de éxito
    public void modificarVenta(Venta venta) {
        ventaDAO.modificar(venta); // Actualizo la venta en la base de datos
        vistaVenta.mostrarMensaje("Venta modificada correctamente."); // Mensaje para avisar
    }

    // Método para eliminar una venta usando su id y mostrar mensaje
    public void eliminarVenta(int id) {
        ventaDAO.eliminar(id); // Borro la venta de la base de datos
        vistaVenta.mostrarMensaje("Venta eliminada correctamente."); // Confirmación
    }

    // Método para buscar una venta por su id y devolverla
    public Venta buscarVentaPorId(int id) {
        return ventaDAO.buscarPorId(id); // Devuelvo la venta que encontró el DAO
    }
}

