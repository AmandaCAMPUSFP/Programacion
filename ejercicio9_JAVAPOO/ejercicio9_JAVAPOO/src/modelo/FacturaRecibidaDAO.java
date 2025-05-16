package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class FacturaRecibidaDAO {
    // Lista que almacena las facturas recibidas en memoria
    private List<FacturaRecibida> facturas;

    // Constructor que inicializa la lista vacía de facturas
    public FacturaRecibidaDAO() {
        facturas = new ArrayList<>();
    }

    // Método para agregar una nueva factura a la lista
    public void crear(FacturaRecibida factura) {
        facturas.add(factura);
    }

    // Método para obtener la lista completa de facturas recibidas
    public List<FacturaRecibida> listar() {
        return facturas;
    }

    // Método para modificar una factura existente buscando por ID
    public void modificar(FacturaRecibida facturaModificada) {
        for (int i = 0; i < facturas.size(); i++) {
            // Si encontramos la factura con el mismo ID, la reemplazamos
            if (facturas.get(i).getId() == facturaModificada.getId()) {
                facturas.set(i, facturaModificada);
                return; 
            }
        }
    }

    // Método para eliminar una factura de la lista según su ID
    public void eliminar(int id) {
        facturas.removeIf(factura -> factura.getId() == id);
    }

    // Método para buscar y devolver una factura por su ID
    public FacturaRecibida buscarPorId(int id) {
        for (FacturaRecibida f : facturas) {
            if (f.getId() == id) {
                return f; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}
