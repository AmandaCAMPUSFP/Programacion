README - Proyecto Gestión Productos Otaku

1. Configuración de la base de datos MySQL

1.1. Asegúrate de tener MySQL Server instalado y funcionando en tu equipo (por ejemplo, con XAMPP) y de tener MySQL Workbench para conectarte gráficamente a la base de datos.

1.2. Abre MySQL Workbench y ejecuta el siguiente script SQL para crear la base de datos akihabara_db y su tabla productos:

	-- Crear base de datos akihabara_db
	CREATE DATABASE IF NOT EXISTS akihabara_db;
	USE akihabara_db;

	-- Crear tabla productos
	CREATE TABLE IF NOT EXISTS productos (
    		id INT AUTO_INCREMENT PRIMARY KEY,
    		nombre VARCHAR(255) NOT NULL,
    		categoria VARCHAR(100),
    		precio DECIMAL(10, 2),
    		stock INT
	);

1.3. La conexión a la base de datos se configura en el archivo util/DatabaseConnection.java. Debes modificar manualmente los siguientes campos:

	private static final String URL = "jdbc:mysql://localhost:3306/akihabara_db";
	private static final String USER = "TU_USUARIO";
	private static final String PASSWORD = "TU_CONTRASEÑA";

1.4. Configura la conexión a la base de datos en el archivo util/DatabaseConnection.java, asegurándote de poner:
    - URL de conexión (host, puerto, base de datos)
    - Usuario y contraseña

2. Configuración de la API Key de OpenRouter

2.1. Obtén tu API Key registrándote en: https://openrouter.ai.

2.2. La API Key se guarda como una variable de entorno en tu sistema operativo. No se guarda directamente en el código por seguridad.

2.3. En el archivo servicio/LlmService.java, se accede a esta variable de entorno así:

	private static final String API_KEY = System.getenv("OPENROUTER_API_KEY");

2.4. Antes de ejecutar la aplicación, asegúrate de tener la variable de entorno OPENROUTER_API_KEY definida con tu clave. En Windows, puedes definirla temporalmente así en CMD:

	set OPENROUTER_API_KEY=tu_clave_aqui

3. Cómo compilar y ejecutar la aplicación

3.1. Abre Eclipse (versión 2024-12 o superior).

3.2. Importa el proyecto desde la opción Archivo > Importar > Proyecto existente en el espacio de trabajo.

3.3. Asegúrate de que todas las librerías necesarias estén añadidas al classpath.
Por ejemplo, debes añadir gson.jar si usas funciones de JSON.

3.4. Compila el proyecto desde Eclipse (el IDE lo hace automáticamente al guardar los archivos).

3.5. Ejecuta la clase principal controlador.MainApp.
Puedes hacer clic derecho sobre ella y seleccionar "Run As > Java Application".

4. Resumen de funcionalidades
Este programa es una aplicación de consola que permite gestionar productos otaku almacenados en una base de datos MySQL. Las funcionalidades principales incluyen:

- CRUD de productos: Permite añadir, consultar, actualizar y eliminar productos de la base de datos akihabara_db.
- Asistente IA:
  - Generar una descripción atractiva para un producto existente.
  - Sugerir categoría adecuada para un producto nuevo basado en su nombre.
- Interfaz de consola sencilla: Permite interacción directa con el usuario mediante menús.

5. Estructura de clases y paquetes

- controlador.MainApp: Clase principal del proyecto. Lanza el menú principal y gestiona el flujo del programa.

- modelo.ProductoOtaku: Representa un producto otaku con sus atributos: id, nombre, categoría, precio, stock.

- dao.ProductoDAO: Clase encargada de acceder a la base de datos para realizar operaciones CRUD sobre productos.

- servicio.LlmService: Clase que se conecta con el modelo de lenguaje de OpenRouter. Utiliza una variable de entorno para leer la API Key.

- util.DatabaseConnection: Gestiona la conexión con MySQL. Configura aquí la URL, usuario y contraseña.

- util.SetupDatos: Permite precargar datos de prueba en la base de datos si decides usarlo.

- vista.InterfazConsola: Se encarga de mostrar menús, leer opciones y mostrar resultados en la consola.