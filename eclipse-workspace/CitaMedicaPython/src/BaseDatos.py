#Importar la librería para interactuar con la base de datos.
import mysql.connector

#Definir una clase para gestionar la conexión con la base de datos.
class ConexionBaseDeDatos:
    #Método  inicializador de la clase (constructor)
    def __init__(self):
        #Configura la base de datos
        self.host="localhost"
        self.user="root"
        self.password=""
        self.database="cita_medica"
        #Variable que almacenará la conexión a la base de datos.
        self.conexion= None
        #Variable que almacenará el cursor para ejecutar las consultas.
        self.cursor= None
    
    #Método para conectar a la base de datos.
    def conectar(self):
        try:
            self.conexion = mysql.connector.connect(
                host=self.host,
                user=self.user,
                password=self.password,
                database=self.database
                )
            #Sí la conexión es existosa,
            if self.conexion.is_connected():
                    # se crea el cursor 
                    self.cursor = self.conexion.cursor()
                    print("conexión exitosa")
                    return True
            #Sí la conexión es erronea y muestra el error. 
        except mysql.connector.Error as err:
            print(f"Error de conexión {err}")
            return False
        return False
    
    #Método para desconectar de la base de datos
    def desconectar(self):
        #Sí el cursor está abierto, se cierra
        if self.cursor:
            self.cursor.close()
        #Sí la conexión esta activa, se cierra
        if self.conexion and self.conexion.is_connected():
            self.conexion.close()
            print("Conexión cerrada")

    #Método para insertar datos en la base de datos.
    def insertar_datos(self, nombre, apellido, telefono, fecha):
        #Se llama al método para conectar a la base de datos.
        if self.conectar():
            try:
                #Se define la query para insertar los datos en la tabla. 
                query = "INSERT INTO citas (nombre, apellido, telefono, fecha) VALUES (%s, %s, %s, %s)"
                #Sejecuta la query con los datos que se han proporcionado
                self.cursor.execute(query, (nombre, apellido, telefono, fecha))
                #Se confirma la transacción en la base de datos.
                self.conexion.commit()
                print("Insertado datos correctamente")
            #En caso de error se captura y muestra por consola.
            except mysql.connector.Error as err:
                print(f"Error al insertar datos: {err}")
            #Se llama al método para cerra el cursor y la conexión.
            finally:
                self.desconectar()
        #En caso de que no conecte a la base de datos, se muestre por consola.        
        else:
            print("No se pudo conectar para insertar los datos")
        

    