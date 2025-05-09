package modelo;

// Definimos la clase Pelicula con sus atributos privados
public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private int año;
    private int duracion;
    private Genero genero;
    
    // Constructor de la clase Pelicula que se utiliza para crear objetos
    public Pelicula(String codigo, String titulo, String director, int año, int duracion, Genero genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.genero = genero;
    }
    
    // Método público que muestra la información de la película en consola
    public void mostrar() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Director: " + director);
        System.out.println("Año: " + año);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Género: " + genero.getNombre());
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public int getAño() { return año; }
    public int getDuracion() { return duracion; }
    public Genero getGenero() { return genero; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDirector(String director) { this.director = director; }
}

