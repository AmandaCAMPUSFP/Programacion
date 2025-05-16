package controlador;

import modelo.Venta;
import modelo.Cliente;
import modelo.Articulo;
import modelo.VentaDAO;
import modelo.ClienteDAO;
import modelo.ArticuloDAO;
import vista.VistaVenta;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ControladorInformeVentas {

    private VentaDAO ventaDAO;
    private ClienteDAO clienteDAO;
    private ArticuloDAO articuloDAO;
    private VistaVenta vistaVenta;

    public ControladorInformeVentas(VentaDAO ventaDAO, ClienteDAO clienteDAO, ArticuloDAO articuloDAO, VistaVenta vistaVenta) {
        this.ventaDAO = ventaDAO;
        this.clienteDAO = clienteDAO;
        this.articuloDAO = articuloDAO;
        this.vistaVenta = vistaVenta;
    }

    // Método para mostrar informe ventas por cliente
    public void mostrarInformeVentasPorCliente() {
        List<Cliente> clientes = clienteDAO.listarClientes();
        if(clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre());
            List<Venta> ventasCliente = ventaDAO.listarVentasPorCliente(cliente.getId());
            if (ventasCliente.isEmpty()) {
                System.out.println("  No hay ventas para este cliente.");
                continue;
            }

            Map<Integer, Integer> articuloCantidades = new HashMap<>();
            Map<Integer, String> articuloNombres = new HashMap<>();
            double totalGastado = 0.0;

            for (Venta venta : ventasCliente) {
                int idArticulo = venta.getIdArticulo();
                int cantidad = venta.getCantidad();

                articuloCantidades.put(idArticulo, articuloCantidades.getOrDefault(idArticulo, 0) + cantidad);

                // Guardar nombre artículo
                if (!articuloNombres.containsKey(idArticulo)) {
                    Articulo articulo = articuloDAO.obtenerArticuloPorId(idArticulo);
                    if (articulo != null) {
                        articuloNombres.put(idArticulo, articulo.getNombre());
                    } else {
                        articuloNombres.put(idArticulo, "Artículo desconocido");
                    }
                }
                // Sumar total gastado
                Articulo articulo = articuloDAO.obtenerArticuloPorId(idArticulo);
                if (articulo != null) {
                    totalGastado += articulo.getPrecio() * cantidad;
                }
            }

            System.out.println("  Artículos comprados:");
            for (Integer idArticulo : articuloCantidades.keySet()) {
                System.out.println("    - " + articuloNombres.get(idArticulo) + ": " + articuloCantidades.get(idArticulo) + " unidades");
            }

            System.out.printf("  Total gastado: %.2f\n\n", totalGastado);
        }
    }
}
