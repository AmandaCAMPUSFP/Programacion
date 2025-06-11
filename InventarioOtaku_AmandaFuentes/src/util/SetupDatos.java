package util; 

import dao.ProductoDAO;
import modelo.ProductoOtaku;
import java.util.List;

public class SetupDatos {

    public static void cargarDatosIniciales() {
        ProductoDAO productoDAO = new ProductoDAO();

        // (1) Comprobamos si hay productos ya en la base de datos
        List<ProductoOtaku> productosExistentes = productoDAO.obtenerTodosLosProductos();

        if (productosExistentes.isEmpty()) {
            // (2) Insertamos los productos de ejemplo
        	productoDAO.agregarProducto(new ProductoOtaku("Figura de Anya Forger", "Figura", 59.95, 8));
            productoDAO.agregarProducto(new ProductoOtaku("Manga Chainsaw Man Vol.1", "Manga", 9.99, 20));
            productoDAO.agregarProducto(new ProductoOtaku("Póster Studio Ghibli Colección", "Póster", 15.50, 15));
            productoDAO.agregarProducto(new ProductoOtaku("Funko Pop Naruto Uzumaki", "Figura", 12.99, 25));
            productoDAO.agregarProducto(new ProductoOtaku("Camiseta Attack on Titan", "Ropa", 22.00, 30));
            productoDAO.agregarProducto(new ProductoOtaku("Llaveros Demon Slayer (set 5 unidades)", "Merchandising", 10.00, 50));
            productoDAO.agregarProducto(new ProductoOtaku("Taza My Hero Academia", "Accesorios", 8.50, 40));
            productoDAO.agregarProducto(new ProductoOtaku("Box set Dragon Ball Z (DVD)", "DVD", 39.95, 10));
            productoDAO.agregarProducto(new ProductoOtaku("Mochila Sailor Moon", "Ropa", 45.00, 12));
            productoDAO.agregarProducto(new ProductoOtaku("Libro de arte de One Piece", "Libro", 29.90, 7));
            
            System.out.println("Datos iniciales cargados correctamente.");
        } else {
            System.out.println("La base de datos ya contiene productos, no se cargaron los datos iniciales.");
        }
    }

}
