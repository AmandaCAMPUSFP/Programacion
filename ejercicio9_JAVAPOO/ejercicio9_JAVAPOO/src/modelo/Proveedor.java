package modelo;

// Clase que representa a un Proveedor
public class Proveedor {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    // Constructor
    public Proveedor(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para mostrar datos del proveedor
    @Override
    public String toString() {
        return "Proveedor [ID=" + id + ", Nombre=" + nombre + ", Correo=" + correo + ", Teléfono=" + telefono + "]";
    }
}
