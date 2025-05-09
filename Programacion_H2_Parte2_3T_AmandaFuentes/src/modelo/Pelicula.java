package modelo;

// Definimos la clase Pelicula con sus atributos privados
public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private int a�o;
    private int duracion;
    private Genero genero;
    
    // Constructor de la clase Pelicula que se utiliza para crear objetos
    public Pelicula(String codigo, String titulo, String director, int a�o, int duracion, Genero genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.a�o = a�o;
        this.duracion = duracion;
        this.genero = genero;
    }
    
    // M�todo p�blico que muestra la informaci�n de la pel�cula en consola
    public void mostrar() {
        System.out.println("C�digo: " + codigo);
        System.out.println("T�tulo: " + titulo);
        System.out.println("Director: " + director);
        System.out.println("A�o: " + a�o);
        System.out.println("Duraci�n: " + duracion + " minutos");
        System.out.println("G�nero: " + genero.getNombre());
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public int getA�o() { return a�o; }
    public int getDuracion() { return duracion; }
    public Genero getGenero() { return genero; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDirector(String director) { this.director = director; }
}

