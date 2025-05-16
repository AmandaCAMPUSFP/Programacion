package controlador;

import modelo.FacturaRecibida;
import modelo.FacturaRecibidaDAO;
import vista.FacturaRecibidaVista;

import java.util.List;

public class FacturaRecibidaControlador {
    private FacturaRecibidaDAO facturaDAO;
    private FacturaRecibidaVista vistaFactura;

    public FacturaRecibidaControlador(FacturaRecibidaDAO facturaDAO, FacturaRecibidaVista vistaFactura) {
        this.facturaDAO = facturaDAO;
        this.vistaFactura = vistaFactura;
    }

    public void crearFactura(FacturaRecibida factura) {
        facturaDAO.crear(factura);
        vistaFactura.mostrarMensaje("Factura recibida creada correctamente.");
    }

    public void listarFacturas() {
        List<FacturaRecibida> facturas = facturaDAO.listar();
        vistaFactura.mostrarFacturas(facturas);
    }

    public void modificarFactura(FacturaRecibida factura) {
        facturaDAO.modificar(factura);
        vistaFactura.mostrarMensaje("Factura recibida modificada correctamente.");
    }

    public void eliminarFactura(int id) {
        facturaDAO.eliminar(id);
        vistaFactura.mostrarMensaje("Factura recibida eliminada correctamente.");
    }

    public FacturaRecibida buscarFacturaPorId(int id) {
        return facturaDAO.buscarPorId(id);
    }
}

