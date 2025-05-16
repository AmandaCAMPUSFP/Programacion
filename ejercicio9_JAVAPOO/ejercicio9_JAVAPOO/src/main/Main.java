package main;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Articulo;
import modelo.ArticuloDAO;
import modelo.Venta;
import modelo.VentaDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        VentaDAO ventaDAO = new VentaDAO();

        // Mostrar clientes
        System.out.println("=== Lista de Clientes ===");
        List<Cliente> clientes = clienteDAO.listar();
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre());
        }

        // Mostrar artículos
        System.out.println("\n=== Lista de Artículos ===");
        List<Articulo> articulos = articuloDAO.listar();
        for (Articulo a : articulos) {
            System.out.println("ID: " + a.getId() + ", Nombre: " + a.getNombre() + ", Precio: " + a.getPrecio());
        }

        // Mostrar ventas
        System.out.println("\n=== Lista de Ventas ===");
        List<Venta> ventas = ventaDAO.listar();
        for (Venta v : ventas) {
            System.out.println("ID Venta: " + v.getId() + ", ID Cliente: " + v.getIdCliente() + ", ID Artículo: " + v.getIdArticulo() + ", Cantidad: " + v.getCantidad());
        }
    }
}

