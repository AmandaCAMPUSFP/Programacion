package hito1_AmandaFuentes;

// Clase Perro que hereda de la clase Animal
public class Perro extends Animal {
    private String tamaño; // Tamaño del perro 

    // Constructor que inicializa todos los atributos, incluyendo los heredados
    public Perro(String chip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
        super(chip, nombre, edad, raza, adoptado); // Llama al constructor de Animal
        this.tamaño = tamaño; 
    }

    // Muestra los datos del perro 
    @Override
    public void mostrar() {
        System.out.println("Perro");
        System.out.println("Chip: " + chip);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
        System.out.println("Adoptado: " + (adoptado ? "Sí" : "No"));
        System.out.println("Tamaño: " + tamaño);
    }
}
