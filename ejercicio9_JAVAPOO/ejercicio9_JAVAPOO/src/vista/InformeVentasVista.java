package vista;

import modelo.InformeVentasCliente;
import java.util.List;

public class InformeVentasVista {

    public void mostrarInforme(List<InformeVentasCliente> informes) {
        for (InformeVentasCliente informe : informes) {
            System.out.println("Cliente: " + informe.getNombreCliente());
            System.out.println("Total gastado: " + informe.getTotalGastado());
            System.out.println("-------------------------");
        }
    }
}
