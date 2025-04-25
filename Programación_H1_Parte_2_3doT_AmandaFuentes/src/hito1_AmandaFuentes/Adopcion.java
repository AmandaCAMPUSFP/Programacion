package hito1_AmandaFuentes;

// Clase que representa una adopci�n de un animal
public class Adopcion {
    public Animal animal; 
    public String nombreAdoptante;
    public String dniAdoptante;  

    // Constructor que recibe el animal y los datos del adoptante
    public Adopcion(Animal animal, String nombreAdoptante, String dniAdoptante) {
        this.animal = animal;
        this.nombreAdoptante = nombreAdoptante;
        this.dniAdoptante = dniAdoptante;
    }

    // Muestra los datos de la adopci�n
    public void mostrar() {
        System.out.println("Adopci�n realizada:");
        animal.mostrar(); 
        System.out.println("Adoptante: " + nombreAdoptante);
        System.out.println("DNI: " + dniAdoptante);
    }
}
