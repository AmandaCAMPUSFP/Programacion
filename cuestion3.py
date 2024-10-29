#Solicitamos al usuario un saldo inicial y lo valida.
def saldoInicial():
    #Iniciamos un bucle While que solicitará hasta recibir un saldo válido
    while True: 
        try:
            #Pedimos al usuario que introduzca el saldo inicial
            saldo = float(input("Introduzca el saldo inicial de su cuenta (un número negativo no será valido): "))
            #Comprobamos si el saldo es mayor o igual a cero
            if saldo >= 0:  
                return saldo  
            else:
                #Si el saldo es negativo, informamos al usuario y repetimos la solicitud
                print("El saldo no puede ser negativo. Por favor, intenta de nuevo.\n")
        except ValueError:
            #Si la entrada no es válida, informamos al usuario
            print("No válida. Por favor, introduce un número entero.\n")

#Definimos el menú de opciones
def menu():
    print("Selecciona una opción:")  
    print("1 - Ingresar dinero")  
    print("2 - Retirar dinero")   
    print("3 - Mostrar saldo")     
    print("4 - Estadísticas")      
    print("5 - Salir")             

#Solicitamos al usuario una cantidad a ingresar y actualizamos el saldo.
def ingresarDinero(saldo):
    #Iniciamos un bucle While que continuará solicitando hasta recibir una cantidad válido
    while True:  
        try:
            #Pedimos al usuario que introduzca la cantidad a ingresar
            cantidad = float(input("Introduce la cantidad a ingresar: "))
            if cantidad < 0:  
                print("No se puede ingresar una cantidad negativa. Inténtalo de nuevo.\n")  # Informamos al usuario
            else:
                saldo += cantidad  
                print(f"Has ingresado {cantidad:.2f}. Nuevo saldo: {saldo:.2f}\n")  # Mostramos el nuevo saldo
                return saldo  # Retornamos el nuevo saldo
        except ValueError:
            #Si la entrada no se puede convertir a float, informamos al usuario
            print("Entrada no válida. Por favor, introduce un número válido.\n")

#Solicitamos al usuario una cantidad para retirar y actualizar el saldo.
def retirarDinero(saldo):
    #Iniciamos un bucle While que continuará solicitando hasta recibir una cantidad válida
    while True:  
        try:
            #Pedimos al usuario que introduzca la cantidad a retirar
            cantidad = float(input("Introduce la cantidad a retirar: "))
            if cantidad < 0:  
                print("No se puede retirar una cantidad negativa. Inténtalo de nuevo.\n") 
            elif cantidad > saldo:  
                print("No puedes retirar más de lo que tienes en la cuenta. Inténtalo de nuevo.\n")  
            else:
                saldo -= cantidad  
                print(f"Has retirado {cantidad:.2f}. Nuevo saldo: {saldo:.2f}\n") 
                return saldo  
        except ValueError:
            #Si la entrada no se puede convertir a float, informamos al usuario
            print("Entrada no válida. Por favor, introduce un número válido.\n")

#Mostramos el saldo actual de la cuenta.
def mostrarSaldo(saldo):
    #Mostramos el saldo actual, limitando a dos decimales
    print(f"Saldo actual: {saldo:.2f}\n")  

#Definimos las variables
def main():
    saldo = saldoInicial()  
    ingresos = 0  
    retiradas = 0  

#Iniciamos un bucle While que mantiene el programa en funcionamiento hasta que se elige salir
    while True:  
        menu()  
        try:
            #Pedimos al usuario que seleccione una opción
            opcion = int(input("Selecciona una opción (Del 1 al 5): "))  
            if opcion == 1:  
                saldo = ingresarDinero(saldo) 
                ingresos += 1  
            elif opcion == 2:  
                saldo = retirarDinero(saldo)  
                retiradas += 1  
            elif opcion == 3:  
                mostrarSaldo(saldo)  
            elif opcion == 4: 
                #Mostramos la cantidad de ingresos y retiros realizados
                print(f"Ingresos realizados: {ingresos}")  
                print(f"Retiradas realizados: {retiradas}")  
                print(f"Saldo actual: {saldo:.2f}\n")  
            #Si el usuario selecciona la opción 5, es para salir
            elif opcion == 5:  
                print("¡Gracias por usar nuestros servicios!. ¡Hasta pronto!")  
                break  
            else:
                #Si la opción no es válida, informamos al usuario
                print("No válida. Por favor, selecciona una opción entre el 1 y el 5.\n")
        except ValueError:
            #Si la entrada no se puede convertir a entero, informamos al usuario
            print("No válida. Por favor, introduce un número entre el 1 y el 5.\n")

#Ejecutamos del programa
main()  
