package hito1_AmandaFuentes;

//Declaramos la clase abstracta Animal
public abstract class Animal {
	String chip;
	String nombre;
	int edad;
	String raza;
	boolean adoptado;
	
	// Constructor que inicializa los atributos del animal
	public Animal(String chip, String nombre, int edad, String raza, boolean adoptado) {
		this.chip = chip;
		 this.nombre = nombre;
	     this.edad = edad;
	     this.raza = raza;
	     this.adoptado = adoptado;
	}
	// Método abstracto que deberá ser implementado por las subclases
	public abstract void mostrar();
}
