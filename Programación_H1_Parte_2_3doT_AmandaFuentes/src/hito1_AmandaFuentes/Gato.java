package hito1_AmandaFuentes; 

// Declaramos la clase Gato que hereda de la clase abstracta Animal
public class Gato extends Animal {
    // Atributo privado específico de los gatos
	// Indica si el test de leucemia ha dado positivo
    private boolean testLeucemia; 

    // Constructor que inicializa los atributos heredados y el propio
    public Gato(String chip, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
        super(chip, nombre, edad, raza, adoptado); // Llama al constructor de la clase Animal
        this.testLeucemia = testLeucemia; // Inicializa el atributo testLeucemia
    }

    // Método público que devuelve si el test de leucemia es positivo
    public boolean tieneLeucemia() {
        return testLeucemia;
    }

    // Muestra por pantalla los datos del gato
    @Override
    public void mostrar() {
        System.out.println("Gato"); 
        System.out.println("Chip: " + chip); 
        System.out.println("Nombre: " + nombre); 
        System.out.println("Edad: " + edad); 
        System.out.println("Raza: " + raza); 
        System.out.println("Adoptado: " + (adoptado ? "Sí" : "No")); 
        System.out.println("Test leucemia: " + (testLeucemia ? "Positivo" : "Negativo")); 
    }
}
