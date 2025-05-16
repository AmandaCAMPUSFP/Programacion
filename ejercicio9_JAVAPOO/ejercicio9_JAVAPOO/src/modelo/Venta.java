package modelo;

import java.time.LocalDate;

// Clase que representa una Venta
public class Venta {
    private int id;
    private int idCliente;
    private int idArticulo;
    private int cantidad;
    private LocalDate fecha;

    // Constructor
    public Venta(int id, int idCliente, int idArticulo, int cantidad, LocalDate fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Método para mostrar los datos de la venta
    @Override
    public String toString() {
        return "Venta [ID=" + id + ", ID Cliente=" + idCliente + ", ID Artículo=" + idArticulo +
               ", Cantidad=" + cantidad + ", Fecha=" + fecha + "]";
    }
}
