package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class VentaDAO {
    // Lista que almacena las ventas en memoria
    private List<Venta> ventas;

    // Constructor que inicializa la lista vac�a de ventas
    public VentaDAO() {
        ventas = new ArrayList<>();
    }

    // M�todo para agregar una nueva venta a la lista
    public void crear(Venta venta) {
        ventas.add(venta);
    }

    // M�todo para obtener la lista completa de ventas
    public List<Venta> listar() {
        return ventas;
    }

    // M�todo para modificar una venta existente buscando por ID
    public void modificar(Venta ventaModificada) {
        for (int i = 0; i < ventas.size(); i++) {
            // Si encontramos la venta con el mismo ID, la reemplazamos
            if (ventas.get(i).getId() == ventaModificada.getId()) {
                ventas.set(i, ventaModificada);
                return;
            }
        }
    }

    // M�todo para eliminar una venta de la lista seg�n su ID
    public void eliminar(int id) {
        ventas.removeIf(venta -> venta.getId() == id);
    }

    // M�todo para buscar y devolver una venta por su ID
    public Venta buscarPorId(int id) {
        for (Venta v : ventas) {
            if (v.getId() == id) {
                return v; 
            }
        }
        return null; // Si no se encuentra, devolvemos null
    }
}
