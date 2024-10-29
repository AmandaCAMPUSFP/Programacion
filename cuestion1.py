#Creamos un menú de opciones
def menu():
    print("Selecciona el tipo de figura que quieres mostrar:")
    print("1: Cuadrado")
    print("2: Rectángulo")

#Dibujamos el cuadrado usando los caracteres *
def mostrarCuadrado(lado):
    print("\nFigura: Cuadrado")
    for i in range(lado):
        print(" * " * lado)
    #Calculamos el área y perímetro
    area = lado ** 2
    perimetro = 4 * lado
    #Mostramos los resultados de los cálculos
    print(f"\nÁrea: {area}")
    print(f"Perímetro: {perimetro}\n")

#Dibujamos el rectángulo usando los caracteres *
def mostrarRectangulo(base, altura):
    print("\nFigura: Rectángulo")
    for i in range(altura):
        print(" * " * base)
    #Calculamos el área y perímetro
    area = base * altura
    perimetro = 2 * (base + altura)
    #Mostramos los resultados de los cálculos
    print(f"\nÁrea: {area}")
    print(f"Perímetro: {perimetro}\n")

def main():
    #Usamos un bucle While True que se interrumpe con una opción válida
    while True:  
        menu()  
        try:
            #Solicitamos al usuario que introduzca una opción
            opcion = int(input("Introduce una opción (1 o 2): "))
            if opcion == 1:  
                #Solicitamos la longitud del lado del cuadrado
                lado = int(input("Introduce el lado del cuadrado: "))
                mostrarCuadrado(lado)  
                break 
            elif opcion == 2: 
                #Solicitamos la base y altura del rectángulo
                base = int(input("Introduce la base del rectángulo: "))
                altura = int(input("Introduce la altura del rectángulo: "))
                mostrarRectangulo(base, altura) 
                break  
            else:
                #Si la opción no es válida, mostramos un mensaje de error
                print("Opción no válida. Por favor, seleccione 1 o 2.\n")
        except ValueError:
            #Manejamos el caso en que la entrada no es un número entero
            print("No válido. Por favor, introduce un número.\n")

#Ejecutamos el programa
main() 