package modelo;

//Representa un g�nero cinematogr�fico
public class Genero {
	private String codigo;
	private String nombre;

 public Genero(String codigo, String nombre) {
     this.codigo = codigo;
     this.nombre = nombre;
 }

 public String getCodigo() { return codigo; }
 public String getNombre() { return nombre; }
}
