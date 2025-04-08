package hito1_AmandaFuentes;

public class Perro extends Animal {
	   String tama�o;
	   public Perro(String chip, String nombre, int edad, String raza, boolean adoptado, String tama�o) {
	       super(chip, nombre, edad, raza, adoptado);
	       this.tama�o = tama�o;
	   }
	   
public void mostrar() {
	System.out.println("Perro: ");
	System.out.println("Chip: " + chip);
	System.out.println("Nombre: " + nombre);
	System.out.println("Edad: " + edad);
	System.out.println("Raza: " + raza);
	System.out.println("Adoptado: " + adoptado);
	System.out.println("Tama�o: " + tama�o);
	}
}
