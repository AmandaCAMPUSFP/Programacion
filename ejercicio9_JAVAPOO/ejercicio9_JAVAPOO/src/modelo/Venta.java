package modelo;

import java.time.LocalDate;

// Clase que representa una Venta
public class Venta {
    // Atributos que guardan la información de cada venta
    private int id;             // ID único de la venta
    private int idCliente;      // ID del cliente que hizo la compra
    private int idArticulo;     // ID del artículo que se vendió
    private int cantidad;       // Cantidad de artículos vendidos
    private LocalDate fecha;    // Fecha en la que se realizó la venta

    // Constructor: sirve para crear una venta con todos sus datos
    public Venta(int id, int idCliente, int idArticulo, int cantidad, LocalDate fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Getters y Setters: los usamos para acceder y modificar los datos privados

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

    // Método toString para mostrar los datos de la venta de forma entendible
    @Override
    public String toString() {
        return "Venta [ID=" + id + 
               ", ID Cliente=" + idCliente + 
               ", ID Artículo=" + idArticulo +
               ", Cantidad=" + cantidad + 
               ", Fecha=" + fecha + "]";
    }
}
