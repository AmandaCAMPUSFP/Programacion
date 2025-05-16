package modelo;

import java.util.List;

// Clase que representa un informe de ventas para un cliente específico
public class InformeVentasCliente {
    private String nombreCliente;
    private List<DetalleVenta> detalles;
    private double totalGastado;

    // Constructor para crear el informe con el nombre del cliente, los detalles y el total gastado
    public InformeVentasCliente(String nombreCliente, List<DetalleVenta> detalles, double totalGastado) {
        this.nombreCliente = nombreCliente;
        this.detalles = detalles;
        this.totalGastado = totalGastado;
    }

    // Getters y setters para acceder y modificar los atributos
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(double totalGastado) {
        this.totalGastado = totalGastado;
    }

    // Método para mostrar el informe completo en formato texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Informe de ventas para el cliente: ").append(nombreCliente).append("\n");
        for (DetalleVenta detalle : detalles) {
            sb.append(detalle.toString()).append("\n");
        }
        sb.append("Total gastado: ").append(totalGastado).append("€\n");
        return sb.toString();
    }

    // Clase interna para representar cada detalle de venta
    public static class DetalleVenta {
        private String nombreArticulo;
        private int cantidad;
        private String fecha;

        // Constructor para crear un detalle de venta con nombre, cantidad y fecha
        public DetalleVenta(String nombreArticulo, int cantidad, String fecha) {
            this.nombreArticulo = nombreArticulo;
            this.cantidad = cantidad;
            this.fecha = fecha;
        }

        // Getters y setters para acceder y modificar los atributos
        public String getNombreArticulo() {
            return nombreArticulo;
        }

        public void setNombreArticulo(String nombreArticulo) {
            this.nombreArticulo = nombreArticulo;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        // Método para mostrar el detalle en formato texto
        @Override
        public String toString() {
            return "Artículo: " + nombreArticulo + ", Cantidad: " + cantidad + ", Fecha: " + fecha;
        }
    }
}
