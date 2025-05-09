package modelo;

// Definimos la clase Genero con los atributos privados codigo y nombre
public class Genero {
    private String codigo;
    private String nombre;
    // Constructor de la clase Genero que se utiliza para crear objetos  
    public Genero(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    //Setters 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
