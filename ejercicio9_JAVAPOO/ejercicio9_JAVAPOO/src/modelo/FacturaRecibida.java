package modelo;

import java.time.LocalDate;

// Esta clase representa una factura que recibimos de un proveedor
public class FacturaRecibida {
    private int id;           // ID único de la factura
    private int idProveedor;  // ID del proveedor que envió la factura
    private LocalDate fecha;  // Fecha en la que se recibió la factura
    private double total;     // Total del importe de la factura

    // Constructor para crear una factura con todos sus datos
    public FacturaRecibida(int id, int idProveedor, LocalDate fecha, double total) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y setters para poder leer y cambiar los datos de la factura
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

    // Método que muestra los datos de la factura en formato texto
    @Override
    public String toString() {
        return "FacturaRecibida [ID=" + id + ", ID Proveedor=" + idProveedor + ", Fecha=" + fecha + ", Total=" + total + "]";
    }
}
