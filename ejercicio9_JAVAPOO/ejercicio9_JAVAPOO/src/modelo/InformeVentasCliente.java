package modelo;

import java.util.List;

// Clase para representar el informe de ventas por cliente
public class InformeVentasCliente {
    private String nombreCliente;
    private List<DetalleVenta> detalles;
    private double totalGastado;

    // Constructor
    public InformeVentasCliente(String nombreCliente, List<DetalleVenta> detalles, double totalGastado) {
        this.nombreCliente = nombreCliente;
        this.detalles = detalles;
        this.totalGastado = totalGastado;
    }

    // Getters y Setters
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

    // Método para mostrar el informe
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

    // Clase interna para representar los detalles de venta
    public static class DetalleVenta {
        private String nombreArticulo;
        private int cantidad;
        private String fecha;

        // Constructor
        public DetalleVenta(String nombreArticulo, int cantidad, String fecha) {
            this.nombreArticulo = nombreArticulo;
            this.cantidad = cantidad;
            this.fecha = fecha;
        }

        // Getters y Setters
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

        @Override
        public String toString() {
            return "Artículo: " + nombreArticulo + ", Cantidad: " + cantidad + ", Fecha: " + fecha;
        }
    }
}
