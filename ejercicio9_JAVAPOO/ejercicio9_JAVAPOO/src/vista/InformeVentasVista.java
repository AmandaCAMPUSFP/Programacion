package vista;

import modelo.InformeVentasCliente;
import java.util.List;

// Clase vista para mostrar los informes de ventas por cliente
public class InformeVentasVista {

    // Método para mostrar una lista de informes
    public void mostrarInforme(List<InformeVentasCliente> informes) {
        System.out.println("----- Informe de Ventas por Cliente -----");
        for (InformeVentasCliente informe : informes) {
            System.out.println("Cliente: " + informe.getNombreCliente());
            System.out.println("Total gastado: " + informe.getTotalGastado() + " €");
            System.out.println("-----------------------------------------");
        }
    }
}
