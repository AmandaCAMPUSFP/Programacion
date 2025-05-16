package modelo;

import java.time.LocalDate;

// Clase que representa una Factura Recibida
public class FacturaRecibida {
    private int id;
    private int idProveedor;
    private LocalDate fecha;
    private double total;

    // Constructor
    public FacturaRecibida(int id, int idProveedor, LocalDate fecha, double total) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Método para mostrar datos de la factura recibida
    @Override
    public String toString() {
        return "FacturaRecibida [ID=" + id + ", ID Proveedor=" + idProveedor + ", Fecha=" + fecha + ", Total=" + total + "]";
    }
}
