package modelo;

//Representa una pel�cula con su g�nero asociado
public class Pelicula {
	 private String codigo;
	 private String titulo;
	 private String director;
	 private int a�o;
	 private int duracion;
	 private Genero genero;

 public Pelicula(String codigo, String titulo, String director, int a�o, int duracion, Genero genero) {
     this.codigo = codigo;
     this.titulo = titulo;
     this.director = director;
     this.a�o = a�o;
     this.duracion = duracion;
     this.genero = genero;
 }

 // Muestra la informaci�n de la pel�cula en formato bonito
 public void mostrar() {
     System.out.printf("""
             C�digo: %s
             T�tulo: %s
             Director: %s
             A�o: %d
             Duraci�n: %d min
             G�nero: %s
             """, codigo, titulo, director, a�o, duracion, genero.getNombre());
 }
}
