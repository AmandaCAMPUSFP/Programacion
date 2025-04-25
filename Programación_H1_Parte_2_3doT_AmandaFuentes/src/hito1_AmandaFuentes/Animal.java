package hito1_AmandaFuentes; 

// Declaramos la clase abstracta Animal
public abstract class Animal {
    // Atributos públicos de la clase Animal
    public String chip;       
    public String nombre;     
    public int edad;         
    public String raza;       
    public boolean adoptado;  

    // Constructor que inicializa todos los atributos al crear un objeto Animal
    public Animal(String chip, String nombre, int edad, String raza, boolean adoptado) {
        this.chip = chip;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.adoptado = adoptado;
    }

    // Método abstracto que será implementado por las clases hijas
    public abstract void mostrar();

    // Método que devuelve si el animal está adoptado
    public boolean estaAdoptado() {
        return adoptado;
    }
}
