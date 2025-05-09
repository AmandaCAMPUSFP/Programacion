package controlador;

import modelo.Genero;
import modelo.Pelicula;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Definimos la clase ControladorPeli
public class ControladorPeli {
	// Método que obtiene todas las películas junto con su género
    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = """
            SELECT p.codigoPelicula, p.titulo, p.director, p.año, p.duracion, 
                   g.codigoGenero, g.nombre 
            FROM pelicula p JOIN genero g ON p.generoCodigo = g.codigoGenero
        """;

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Genero genero = new Genero(rs.getString("codigoGenero"), rs.getString("nombre"));
                Pelicula p = new Pelicula(
                        rs.getString("codigoPelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("año"),
                        rs.getInt("duracion"),
                        genero
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar películas: " + e.getMessage());
        }
        return lista;
    }
    
    // Método para añadir una nueva película a la base de datos
    public boolean añadirPelicula(Pelicula p) {
        if (existePelicula(p.getCodigo())) {
            System.out.println("Ya existe una película con ese código.");
            return false;
        }

        String sql = """
            INSERT INTO pelicula (codigoPelicula, titulo, director, año, duracion, generoCodigo)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getCodigo());
            pstmt.setString(2, p.getTitulo());
            pstmt.setString(3, p.getDirector());
            pstmt.setInt(4, p.getAño());
            pstmt.setInt(5, p.getDuracion());
            pstmt.setString(6, p.getGenero().getCodigo());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar película: " + e.getMessage());
            return false;
        }
    }
    
    // Método para eliminar una película existente
    public boolean eliminarPelicula(String codigo) {
        if (!existePelicula(codigo)) {
            System.out.println("No existe ninguna película con ese código.");
            return false;
        }

        String sql = "DELETE FROM pelicula WHERE codigoPelicula = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
            return false;
        }
    }
    
    // Método para modificar el título y director de una película
    public boolean modificarPelicula(String codigo, String nuevoTitulo, String nuevoDirector, int nuevoAño, int nuevaDuracion, Genero nuevoGenero) {
        if (!existePelicula(codigo)) {
            System.out.println("No existe ninguna película con ese código.");
            return false;
        }

        String sql = "UPDATE pelicula SET titulo = ?, director = ?, año = ?, duracion = ?, generoCodigo = ? WHERE codigoPelicula = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer los valores a modificar
            pstmt.setString(1, nuevoTitulo);
            pstmt.setString(2, nuevoDirector);
            pstmt.setInt(3, nuevoAño);
            pstmt.setInt(4, nuevaDuracion);
            pstmt.setString(5, nuevoGenero.getCodigo()); 
            pstmt.setString(6, codigo);  

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar película: " + e.getMessage());
            return false;
        }
    }


	 // Método que comprueba si una película existe por su código.
    public boolean existePelicula(String codigo) {
        String sql = "SELECT COUNT(*) FROM pelicula WHERE codigoPelicula = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.out.println("Error al comprobar existencia: " + e.getMessage());
            return false;
        }
    }
}
