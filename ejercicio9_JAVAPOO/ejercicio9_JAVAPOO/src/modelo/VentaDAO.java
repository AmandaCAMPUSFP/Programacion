package modelo;

import java.util.ArrayList;  
import java.util.List;       

public class VentaDAO {
    // Lista que almacena las ventas en memoria (simulando una base de datos)
    private List<Venta> ventas;

    // Constructor que inicializa la lista vacía
    public VentaDAO() {
        ventas = new ArrayList<>();
    }

    // Método para agregar una nueva venta
    public void crear(Venta venta) {
        ventas.add(venta);  // Añadimos la venta a la lista
    }

    // Método para listar todas las ventas registradas
    public List<Venta> listar() {
        return ventas;  // Devolvemos la lista completa
    }

    // Método para modificar una venta ya existente (buscando por ID)
    public void modificar(Venta ventaModificada) {
        for (int i = 0; i < ventas.size(); i++) {
            // Si encontramos la venta con el mismo ID, la reemplazamos
            if (ventas.get(i).getId() == ventaModificada.getId()) {
                ventas.set(i, ventaModificada); // Actualizamos los datos
                return;
            }
        }
    }

    // Método para eliminar una venta usando su ID
    public void eliminar(int id) {
        // Eliminamos usando expresión lambda: borra si el ID coincide
        ventas.removeIf(venta -> venta.getId() == id);
    }

    // Método para buscar una venta concreta por su ID
    public Venta buscarPorId(int id) {
        for (Venta v : ventas) {
            if (v.getId() == id) {
                return v; // Si la encontramos, la devolvemos
            }
        }
        return null; // Si no está, devolvemos null
    }
}
