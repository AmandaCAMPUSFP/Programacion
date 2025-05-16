package modelo;

// Clase que representa un Artículo
public class Articulo {
	public int id;
    public String nombre;
    public double precio;

    // Constructor
    public Articulo(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para mostrar datos del artículo
    @Override
    public String toString() {
        return "Artículo [ID=" + id + ", Nombre=" + nombre + ", Precio=" + precio + "]";
    }
}
