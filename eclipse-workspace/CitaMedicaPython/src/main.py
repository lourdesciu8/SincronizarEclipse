import sys
# Para crear la aplicación y la ventana principal
from PyQt6.QtWidgets import QApplication, QMainWindow
# Importa la interfaz gráfica generada con Qt Designer
from CitaMedica import Ui_MainWindow
# Para manejar fechas en los widgets de la UI
from PyQt6.QtCore import QDate
# Para manejar los datos de la tabla
from PyQt6.QtGui import QStandardItemModel, QStandardItem
# Importa la clase que maneja la conexión con la base de datos -> from = nombre del file import = nombre de la clase
from BaseDatos import ConexionBaseDeDatos

# Definición de la clase MainWindow que hereda de QMainWindow
class MainWindow(QMainWindow):
    #inicializador (constructor)
    def __init__(self):
        #Llama al inicializador de la clase padre de QMainWindow
        super().__init__()
        #Crea una instancia de la interfaz gráfica
        self.ui = Ui_MainWindow()
        #Configura la interfaz en la ventana principal
        self.ui.setupUi(self)
        #Muestra la ventana
        self.show()
           
        # Conecta el botón "Agregar"  con el método que agrega las citas
        self.ui.btnAgregar.clicked.connect(self.agregar_cita)
        
        # Configuración del modelo de datos para la tabla
        self.model = QStandardItemModel()
        self.model.setHorizontalHeaderLabels(['Nombre', 'Apellido', 'Telefono','fecha de cita'])
        # Asigna el modelo a la tabla
        self.ui.table_registro.setModel(self.model)
        #Para que se cargue los datos en la tabla cuando abre la app. 
        self.cargar_datos()
        
        
    #Método para agregar una nueva cita a la base de datos   
    def agregar_cita(self):
        #Obtiene los valores ingresados por el usuario en los campos de texto
        nombre = self.ui.lineNombre.text()
        apellido = self.ui.lineApellido.text()
        telefono = self.ui.lineTelefono.text()
        #configura la hora actuar
        self.ui.fecha_cita.setDate(QDate.currentDate())
        # Convierte la fecha al formato YYYY-MM-DD
        fecha = self.ui.fecha_cita.date().toString("yyyy-MM-dd")
        
        #Instancia de la conexión de la base de datos
        db = ConexionBaseDeDatos()
        #Conectar a la base de datos
        if db.conectar():
            #Llama al método de la base de datos para insertar
            db.insertar_datos(nombre, apellido, telefono, fecha)
            #Desconecta
            db.desconectar()
            
            #actualizar la tabla
            self.cargar_datos()
    
    ## Método para cargar los datos almacenados en la base de datos y mostrarlos en la tabla
    def cargar_datos(self):
        print("Intentando conectar con la base de datos")
        # Limpia la tabla antes de agregar nuevos datos
        self.model.removeRows(0, self.model.rowCount())
        #Crea la instancia
        db = ConexionBaseDeDatos()
        #Conecta con la base de datos
        if db.conectar():
            #Se define la query para la consulta
            query = "SELECT nombre, apellido, telefono, fecha FROM citas"
            #Se ejecuta
            db.cursor.execute(query)
            #Recupera todas la filas 
            citas = db.cursor.fetchall()
            
            #Agregar cada dila de la base de datos a la tabla registro
            for cita in citas:
                # Convierte cada dato a un QStandardItem
                fila = [QStandardItem(str(dato)) for dato in cita]
                #Agrega la fila al modelo de la tabla
                self.model.appendRow(fila)
            #Se cierra cursor y conexión
            db.desconectar()
        else:
            print("No se pudo conectar")
      
#Punto de entrada de la aplicación 
if __name__ == "__main__":
    #Crea la aplicación
    app = QApplication(sys.argv)
    #Crea la ventana principal
    window = MainWindow()
    # Muestra la ventana
    window.show()
    # Ejecuta el bucle principal de la aplicación
    sys.exit(app.exec())
    