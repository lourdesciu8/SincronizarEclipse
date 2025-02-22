# main.py
import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QMessageBox
from ventanaLogeo import Ui_ventanaRegistro  # Importa la UI del login
from VentanaPrincipal import Ui_MainWindow  # Importa la clase VentanaPrincipal

class VentanaLogin(QMainWindow, Ui_ventanaRegistro):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        # Conectar botón de login
        self.botonEntrar.clicked.connect(self.verificar_credenciales)

    def verificar_credenciales(self):
        usuario_correcto = "admin"
        contrasena_correcta = "1234"
    
        usuario_ingresado = self.campoUsuario.toPlainText()  # Si es QTextEdit
        contrasena_ingresada = self.lineEdit.text()  # Si es QLineEdit
        
        if usuario_ingresado == usuario_correcto and contrasena_ingresada == contrasena_correcta:
            self.abrir_ventana_principal()
        else:
            self.mostrar_error()

    def abrir_ventana_principal(self):
        # Crear una instancia de QMainWindow
        self.ventana_principal = QMainWindow()

        # Crear una instancia de Ui_MainWindow y aplicar la UI a la ventana
        self.ui = Ui_MainWindow()  # Crear la instancia aquí
        self.ui.setupUi(self.ventana_principal)  # Usar setupUi para aplicar la UI a la ventana

        # Mostrar la ventana principal
        self.ventana_principal.show()
        self.close()  # Cerrar la ventana de login

    def mostrar_error(self):
        msg = QMessageBox(self)
        msg.setWindowTitle("Error")
        msg.setText("Usuario o contraseña incorrectos")
        msg.setIcon(QMessageBox.Icon.Critical)
        msg.exec()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaLogin()
    ventana.show()
    sys.exit(app.exec())
