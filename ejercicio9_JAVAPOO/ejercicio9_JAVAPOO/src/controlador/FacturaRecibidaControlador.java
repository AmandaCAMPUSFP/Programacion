package controlador;

// Importo las clases que necesito del modelo y la vista
import modelo.FacturaRecibida;
import modelo.FacturaRecibidaDAO;
import vista.FacturaRecibidaVista;

import java.util.List;

public class FacturaRecibidaControlador {
    // Creo dos atributos, uno para manejar datos (DAO) y otro para mostrar info (vista)
    private FacturaRecibidaDAO facturaDAO;
    private FacturaRecibidaVista vistaFactura;

    // Constructor que me permite usar el DAO y la vista para trabajar con facturas
    public FacturaRecibidaControlador(FacturaRecibidaDAO facturaDAO, FacturaRecibidaVista vistaFactura) {
        this.facturaDAO = facturaDAO;
        this.vistaFactura = vistaFactura;
    }

    // Método para crear una factura nueva y avisar que se creó bien
    public void crearFactura(FacturaRecibida factura) {
        facturaDAO.crear(factura);  // Lo guardo en la base de datos
        vistaFactura.mostrarMensaje("Factura recibida creada correctamente."); // Mensaje de confirmación
    }

    // Método para listar todas las facturas y mostrarlas en la vista
    public void listarFacturas() {
        List<FacturaRecibida> facturas = facturaDAO.listar(); // Pido la lista al DAO
        vistaFactura.mostrarFacturas(facturas); // Muestro la lista con la vista
    }

    // Método para modificar una factura y avisar que se hizo bien
    public void modificarFactura(FacturaRecibida factura) {
        facturaDAO.modificar(factura); // Actualizo en la base de datos
        vistaFactura.mostrarMensaje("Factura recibida modificada correctamente."); // Mensaje de confirmación
    }

    // Método para eliminar una factura por su ID y avisar que se borró
    public void eliminarFactura(int id) {
        facturaDAO.eliminar(id); // Borro la factura de la base de datos
        vistaFactura.mostrarMensaje("Factura recibida eliminada correctamente."); // Mensaje de confirmación
    }

    // Método para buscar una factura por su ID y devolverla
    public FacturaRecibida buscarFacturaPorId(int id) {
        return facturaDAO.buscarPorId(id); // Devuelvo la factura encontrada
    }
}

