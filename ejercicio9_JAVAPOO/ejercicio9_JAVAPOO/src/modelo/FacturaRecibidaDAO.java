package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class FacturaRecibidaDAO {
    // Aquí guardo la lista de facturas recibidas en memoria
    private List<FacturaRecibida> facturas;

    // Constructor que crea la lista vacía para guardar facturas
    public FacturaRecibidaDAO() {
        facturas = new ArrayList<>();
    }

    // Método para añadir una factura nueva a la lista
    public void crear(FacturaRecibida factura) {
        facturas.add(factura);
    }

    // Método para obtener la lista completa de facturas recibidas
    public List<FacturaRecibida> listar() {
        return facturas;
    }

    // Método para modificar una factura buscando por su ID
    public void modificar(FacturaRecibida facturaModificada) {
        for (int i = 0; i < facturas.size(); i++) {
            // Si encuentro la factura con el mismo ID, la sustituyo por la modificada
            if (facturas.get(i).getId() == facturaModificada.getId()) {
                facturas.set(i, facturaModificada);
                return; // Salgo del método porque ya actualicé la factura
            }
        }
    }

    // Método para eliminar una factura según su ID
    public void eliminar(int id) {
        // Elimino todas las facturas que tengan el ID indicado
        facturas.removeIf(factura -> factura.getId() == id);
    }

    // Método para buscar y devolver una factura por su ID
    public FacturaRecibida buscarPorId(int id) {
        for (FacturaRecibida f : facturas) {
            if (f.getId() == id) {
                return f; // Devuelvo la factura si la encuentro
            }
        }
        return null; // Si no la encuentro, devuelvo null
    }
}

