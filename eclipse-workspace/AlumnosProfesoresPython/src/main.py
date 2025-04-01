import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QMessageBox
from VentanaLogeo import Ui_MainWindow  # Ventana de logeo
from VentanaRegistro import Ui_MainWindow as Ui_VentanaRegistro  # Corregir la importación de VentanaRegistro
from VentanaAlumno import Ui_MainWindow as Ui_VentanaAlumno  # Corregir la importación de VentanaAlumno
from VentanaProfesor import Ui_MainWindow as Ui_VentanaProfesor  # Corregir la importación de VentanaProfesor


class VentanaLogeo(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)  # Configura la UI de la ventana Logeo
        
        # Datos de usuario de ejemplo (en un caso real esto debería venir de una base de datos)
        self.usuario_valido = "usuario"
        self.contraseña_valida = "123"
        self.tipo_usuario = "alumno"  # Esto podría ser "alumno" o "profesor"

        # Conectar el botón de "Iniciar sesión" a la función de inicio de sesión
        self.LoginButton.clicked.connect(self.iniciar_sesion)
        
        # Conectar el botón de "Registrar" a la ventana de registro
        self.RegistroButton.clicked.connect(self.ir_a_registro)

    def iniciar_sesion(self):
        # Obtener los datos ingresados por el usuario
        usuario = self.UsuariolineEdit.text()
        contraseña = self.PasslineEdit.text()

        # Verificar si los datos coinciden con los de ejemplo
        if usuario == self.usuario_valido and contraseña == self.contraseña_valida:
            QMessageBox.information(self, "Éxito", "Sesión iniciada correctamente")
            # Redirigir al alumno o profesor según el tipo de usuario
            if self.tipo_usuario == "alumno":
                self.mostrar_ventana_alumno()
            elif self.tipo_usuario == "profesor":
                self.mostrar_ventana_profesor()
        else:
            QMessageBox.warning(self, "Error", "Usuario o contraseña incorrectos")

    def ir_a_registro(self):
        # Crear y mostrar la ventana de registro
        self.registro_window = QMainWindow()
        self.ui_registro = Ui_VentanaRegistro()  # Cargar la interfaz de la ventana de registro
        self.ui_registro.setupUi(self.registro_window)
        self.registro_window.show()

    def mostrar_ventana_alumno(self):
        # Crear y mostrar la ventana de alumno
        self.ventana_alumno = QMainWindow()
        self.ui_alumno = Ui_VentanaAlumno()  # Cargar la interfaz de la ventana de alumno
        self.ui_alumno.setupUi(self.ventana_alumno)
        self.ventana_alumno.show()

    def mostrar_ventana_profesor(self):
        # Crear y mostrar la ventana de profesor
        self.ventana_profesor = QMainWindow()
        self.ui_profesor = Ui_VentanaProfesor()  # Cargar la interfaz de la ventana de profesor
        self.ui_profesor.setupUi(self.ventana_profesor)
        self.ventana_profesor.show()


if __name__ == "__main__":
    # Iniciar la aplicación Qt
    app = QApplication(sys.argv)
    
    # Crear y mostrar la ventana de logeo
    ventana_logeo = VentanaLogeo()
    ventana_logeo.show()
    
    # Ejecutar la aplicación
    sys.exit(app.exec())
