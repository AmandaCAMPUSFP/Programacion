package controlador;

import modelo.Genero;
import modelo.Pelicula;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Definimos la clase ControladorPeli
public class ControladorPeli {
	// M�todo que obtiene todas las pel�culas junto con su g�nero
    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = """
            SELECT p.codigoPelicula, p.titulo, p.director, p.a�o, p.duracion, 
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
                        rs.getInt("a�o"),
                        rs.getInt("duracion"),
                        genero
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar pel�culas: " + e.getMessage());
        }
        return lista;
    }
    
    // M�todo para a�adir una nueva pel�cula a la base de datos
    public boolean a�adirPelicula(Pelicula p) {
        if (existePelicula(p.getCodigo())) {
            System.out.println("Ya existe una pel�cula con ese c�digo.");
            return false;
        }

        String sql = """
            INSERT INTO pelicula (codigoPelicula, titulo, director, a�o, duracion, generoCodigo)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getCodigo());
            pstmt.setString(2, p.getTitulo());
            pstmt.setString(3, p.getDirector());
            pstmt.setInt(4, p.getA�o());
            pstmt.setInt(5, p.getDuracion());
            pstmt.setString(6, p.getGenero().getCodigo());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar pel�cula: " + e.getMessage());
            return false;
        }
    }
    
    // M�todo para eliminar una pel�cula existente
    public boolean eliminarPelicula(String codigo) {
        if (!existePelicula(codigo)) {
            System.out.println("No existe ninguna pel�cula con ese c�digo.");
            return false;
        }

        String sql = "DELETE FROM pelicula WHERE codigoPelicula = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar pel�cula: " + e.getMessage());
            return false;
        }
    }
    
    // M�todo para modificar el t�tulo y director de una pel�cula
    public boolean modificarPelicula(String codigo, String nuevoTitulo, String nuevoDirector, int nuevoA�o, int nuevaDuracion, Genero nuevoGenero) {
        if (!existePelicula(codigo)) {
            System.out.println("No existe ninguna pel�cula con ese c�digo.");
            return false;
        }

        String sql = "UPDATE pelicula SET titulo = ?, director = ?, a�o = ?, duracion = ?, generoCodigo = ? WHERE codigoPelicula = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer los valores a modificar
            pstmt.setString(1, nuevoTitulo);
            pstmt.setString(2, nuevoDirector);
            pstmt.setInt(3, nuevoA�o);
            pstmt.setInt(4, nuevaDuracion);
            pstmt.setString(5, nuevoGenero.getCodigo()); 
            pstmt.setString(6, codigo);  

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar pel�cula: " + e.getMessage());
            return false;
        }
    }


	 // M�todo que comprueba si una pel�cula existe por su c�digo.
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
