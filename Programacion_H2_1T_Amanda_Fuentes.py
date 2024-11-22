'''Vamos a crear aplicación para un supermercado online. 
Esta app nos permitirá registrar clientes, mostrar un catálogo de productos, realizar compras calculando el total automáticamente y consultar pedidos mediante su número único. 
Es útil como prototipo educativo o para pequeñas tiendas, aunque no almacena datos de forma permanente ni tiene interfaz gráfica.'''

import random

#Hacemos un diccionario para almacenar todos los datos de los clientes
clientes = {}  

#Hacemos un diccionario para almacenar todos los datos de los productos del supermercado
productos = {
    1: {"nombre": "Manzanas (kg)", "precio": 2.5},
    2: {"nombre": "Pan de molde", "precio": 1.2},
    3: {"nombre": "Leche (litro)", "precio": 0.9},
    4: {"nombre": "Huevos (docena)", "precio": 2.8},
    5: {"nombre": "Arroz (kg)", "precio": 1.5},
    6: {"nombre": "Pasta (kg)", "precio": 1.3},
    7: {"nombre": "Pollo (kg)", "precio": 6.0},
}  

#Hacemos una lista para almacenar todos los datos de los pedidos
pedidos = []  

#Definimos una función para registrar un cliente
def registrarCliente():
    print("\nRegistro de Cliente")
    clienteId = input("Ingrese un ID único para el cliente: ")
    if clienteId in clientes:
        print("El ID ya está registrado. Intentalo otra vez")
        return
    nombre = input("Ingrese el nombre del cliente: ")
    email = input("Ingrese el email del cliente: ")
    telefono = input("Ingrese el teléfono del cliente: ")
    clientes[clienteId] = {"nombre": nombre, "email": email, "telefono": telefono}
    print("El cliente ha sido registrado")

#Definimos una función para ver a los clientes
#Esto hace que muestre todos los clientes registrados en el sistema.
#Si no hay clientes, se notifica al usuario.
def verClientes():
    print("\nLista de Clientes")
    if not clientes:
        print("No hay clientes registrados")
        return
    for clienteId, datos in clientes.items():
        print(f"ID: {clienteId}, Nombre: {datos['nombre']}, Email: {datos['email']}, Teléfono: {datos['telefono']}")

#Definimos una función para realizar una compra
#Esto permite a un cliente realizar una compra seleccionando productos disponibles.
#Se calcula el total y se genera un número de pedido único.
def realizarCompra():
    print("\nRealizar Compra")
    clienteId = input("Ingrese el ID del cliente: ")
    if clienteId not in clientes:
        print("Cliente no encontrado. Registra al cliente antes de realizar una compra.")
        return

#Mostramos los productos disponibles con sus precios
    print("\nProductos disponibles:")
    for idProducto, infoProducto in productos.items():
        print(f"{idProducto}, {infoProducto['nombre']} -> {infoProducto['precio']:.2f}€")
    
    #Pedimos al cliente que seleccione los productos por su ID
    seleccion = input("Ingrese los números de los productos que desea comprar: ")
    
    #Convertimos la selección en una lista de números enteros
    seleccion = [int(x.strip()) for x in seleccion.split(",") if x.strip().isdigit()]
    productosComprados = []
    total = 0.0
    
    #Procesamos cada producto seleccionado
    #Sumamos al total
    #Guardamos los detalles del producto comprado
    for idProducto in seleccion:
        if idProducto in productos:
            producto = productos[idProducto]
            cantidad = int(input(f"Ingrese la cantidad de {producto['nombre']} que desea comprar: "))
            total += producto["precio"] * cantidad
            productosComprados.append({"nombre": producto["nombre"], "cantidad": cantidad, "subtotal": producto["precio"] * cantidad})
    
    #Usamos un if not por si no se seleccionaron productos válidos
    if not productosComprados:
        print("No se seleccionaron productos válidos.")
        return

#Generamos un número de pedido único
    pedidoId = f"PEDIDO-{random.randint(1000, 9999)}"
    #Guardamos el pedido en la lista de pedidos
    pedidos.append({"clienteId": clienteId, "productosComprados": productosComprados, "pedidoId": pedidoId, "total": total})
    #Mostramos la confirmación del pedido
    print(f"Compra realizada con éxito. Número de pedido: {pedidoId}")
    print(f"Total de la compra: {total:.2f}€")

#Definimos la función para ver el seguimiento del pedido
#Permite al usuario buscar un pedido mediante su número único.
#Muestra los detalles del cliente y los productos comprados.
def seguimientoPedido():
    print("\nSeguimiento de Pedido")
    pedidoId = input("Ingrese el número de pedido: ")
    #Buscamos el pedido en la lista
    pedido = next((p for p in pedidos if p["pedidoId"] == pedidoId), None)
    #Usamos un if not por si no encuentra el pedido
    if not pedido:
        print("Pedido no encontrado.")
        return

#Obtenemos los datos del cliente asociado al pedido
    cliente = clientes[pedido["pedidoId"]]
    print("\nDetalles del Pedido")
    print(f"Cliente: {cliente['nombre']}")
    print(f"Email: {cliente['email']}")
    print(f"Teléfono: {cliente['telefono']}")
    print("Productos comprados:")
    #Mostramos cada producto del pedido
    for producto in pedido["productos"]:
        print(f"- {producto['nombre']}, (Cantidad: {producto['cantidad']}) -> Subtotal: {producto['subtotal']:.2f}€")
    print(f"Total de la compra: {pedido['total']:.2f}€")

#Usamos uan función para hacer el menú principal
def menu():
    while True:
        print("\nMenú Principal")
        print("1. Registrar Cliente")
        print("2. Ver Clientes")
        print("3. Realizar Compra")
        print("4. Seguimiento de Pedido")
        print("5. Salir")
        opcion = input("Selecciona una opción: ")
        #Llamamos a las funciones según la opción seleccionada
        if opcion == "1":
            registrarCliente()
        elif opcion == "2":
            verClientes()
        elif opcion == "3":
            realizarCompra()
        elif opcion == "4":
            seguimientoPedido()
        elif opcion == "5":
            print("¡Gracias por usar la app de nuestro supermercado!")
            break
        else:
            print("Opción no válida. Intentalo de nuevo.")

#Ejecutamos el programa
menu()
