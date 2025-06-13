package modelo;

public class ProductoOtaku {
	private int id;
	private String nombre;
	private String categoria;
	private double precio;
	private int stock;


 // Constructor con todos los campos excepto el ID (para nuevos productos)
 public ProductoOtaku(String nombre, String categoria, double precio, int stock) {
     this.nombre = nombre;
     this.categoria = categoria;
     this.precio = precio;
     this.stock = stock;
 }

 // Constructor con todos los campos (para productos ya existentes en la BD)
 public ProductoOtaku(int id, String nombre, String categoria, double precio, int stock) {
     this.id = id;
     this.nombre = nombre;
     this.categoria = categoria;
     this.precio = precio;
     this.stock = stock;
 }
 
 // Getters y setters
 // ID
 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 // NOMBRE
 public String getNombre() {
     return nombre;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 // CATEGORÍA
 public String getCategoria() {
     return categoria;
 }

 public void setCategoria(String categoria) {
     this.categoria = categoria;
 }

 // PRECIO
 public double getPrecio() {
     return precio;
 }

 public void setPrecio(double precio) {
     this.precio = precio;
 }

 // STOCK
 public int getStock() {
     return stock;
 }

 public void setStock(int stock) {
     this.stock = stock;
 }

 // Método toString para imprimir fácilmente
 @Override
 public String toString() {
     return "ProductoOtaku{" +
             "id=" + id +
             ", nombre='" + nombre + '\'' +
             ", categoria='" + categoria + '\'' +
             ", precio=" + precio +
             ", stock=" + stock +
             '}';
 }
}
