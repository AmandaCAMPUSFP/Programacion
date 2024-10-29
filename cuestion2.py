#Importamos la biblioteca random para generar números aleatorios
import random  
#Defnimos el menu de opciones
def menu():
    print("Selecciona una opción:")  
    print("1 - Piedra")  
    print("2 - Papel")   
    print("3 - Tijera")  

def eleccionUsuario():
#Solicitamos al usuario que elija una opción válida y la devuelve.
    #Usamos un bucle While que continuará solicitando hasta recibir una entrada válida
    while True:  
        try:
            #Solicitamos al usuario que ingrese su elección
            opcion = int(input("Introduce tu elección (1: Piedra, 2: Papel, 3: Tijera): "))
            #Verificamos si la opción ingresada está entre las válidas (1, 2 o 3)
            if opcion in [1, 2, 3]: 
                #Si es válida, hacer un return para devolversela al usuario
                return opcion  
            else:
                #Si no es válida, informamos al usuario y repetimos la solicitud
                print("Opción no válida. Por favor, selecciona 1, 2 o 3.\n")
        except ValueError:
            #Si la entrada no se puede convertir a entero, informamos al usuario
            print("No válida. Por favor, introduce un número entero.\n")

def eleccionMaquina():
    #Devolvemos la elección de la máquina
    return random.randint(1, 3)  

#Determinamos el resultado del juego comparando las elecciones del usuario y de la máquina.
def determinarResultado(usuario, maquina):
    #Comparamos las elecciones para determinar el resultado
    if usuario == maquina:  
        return "Empatamos"  
    elif (usuario == 1 and maquina == 3) or (usuario == 2 and maquina == 1) or (usuario == 3 and maquina == 2):
        return "Ganaste"  
    else:
        return "Perdiste"  

def main():
    #Función principal que controla el flujo del programa.
    menu() 
    usuario = eleccionUsuario()  
    maquina = eleccionMaquina()  

    #Definimos de opciones para mostrar en el texto
    opciones = {1: "Piedra", 2: "Papel", 3: "Tijera"}
    #Mostramos las elecciones del usuario y de la máquina
    print(f"\nTu elección: {opciones[usuario]}")  
    print(f"Elección de la máquina: {opciones[maquina]}")  

    #Determinamos el resultado del juego llamando a la función correspondiente
    resultado = determinarResultado(usuario, maquina)
    #Mostramos el resultado final del juego
    print(f"Resultado: {resultado}")

#Ejecutamos el programa
main()  
