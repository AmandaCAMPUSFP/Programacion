package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseConnection;
import modelo.ProductoOtaku;

public class ProductoDAO {

    // (1) Método para agregar un producto nuevo a la base de datos
    public void agregarProducto(ProductoOtaku producto) {
    	// Insertamos un producto nuevo en la tabla 
    	// Preparamos una consulta SQL para insertar productos
        String sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
        // Creamos la conexion y el PreparedStatement en un bloque try-with-resources
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
        	// Asignamos los valores a los ?
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error agregando el producto: " + e.getMessage());
        }
    }

    // (2) Método para obtener un producto por su id
    public ProductoOtaku obtenerProductoPorId(int id) {
    	// Preparamos la consulta para obtener un producto por su id
        String sql = "SELECT * FROM productos WHERE id = ?";
        ProductoOtaku producto = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            // Si encuentra un resultado, crea un nuevo objeto ProductoOtaku con los datos
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new ProductoOtaku(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error obteniendo producto por ID: " + e.getMessage());
        }
        return producto;
    }

    // (3) Método para obtener todos los productos
    public List<ProductoOtaku> obtenerTodosLosProductos() {
    	// Crea una lista vacía para guardar los productos
        List<ProductoOtaku> productos = new ArrayList<>();
        // Preparamos una consulta para ver todos los productos
        String sql = "SELECT * FROM productos";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ProductoOtaku producto = new ProductoOtaku(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error obteniendo todos los productos: " + e.getMessage());
        }
        return productos;
    }

    // (4) Método para actualizar un producto
    public boolean actualizarProducto(ProductoOtaku producto) {
    	// Preparamaos una consulta para actualizar el producto deseado
        String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());
            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error actualizando producto: " + e.getMessage());
            return false;
        }
    }

    // (5) Método para eliminar un producto por id
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filasEliminadas = ps.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error eliminando producto: " + e.getMessage());
            return false;
        }
    }

    // (6) Método para buscar productos por nombre 
    public List<ProductoOtaku> buscarProductosPorNombre(String nombre) {
        List<ProductoOtaku> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE nombre LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoOtaku producto = new ProductoOtaku(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                productos.add(producto);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error buscando productos por nombre: " + e.getMessage());
        }
        return productos;
    }
}
