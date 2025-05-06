package modelo;

//Representa una película con su género asociado
public class Pelicula {
	 private String codigo;
	 private String titulo;
	 private String director;
	 private int año;
	 private int duracion;
	 private Genero genero;

 public Pelicula(String codigo, String titulo, String director, int año, int duracion, Genero genero) {
     this.codigo = codigo;
     this.titulo = titulo;
     this.director = director;
     this.año = año;
     this.duracion = duracion;
     this.genero = genero;
 }

 // Muestra la información de la película en formato bonito
 public void mostrar() {
     System.out.printf("""
             Código: %s
             Título: %s
             Director: %s
             Año: %d
             Duración: %d min
             Género: %s
             """, codigo, titulo, director, año, duracion, genero.getNombre());
 }
}
