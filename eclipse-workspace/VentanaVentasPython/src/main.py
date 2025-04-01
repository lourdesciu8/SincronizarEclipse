import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QMessageBox
from VentanaVentas import Ui_MainWindow  # Importa la clase generada

class VentanaPrincipal(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)  # Configura la UI

        # Variable que simula un cliente registrado
        self.cliente_registrado = "Lourdes"  # Solo un cliente en este caso

        # Conecta el botón "Buscar" a la función que realiza la búsqueda
        self.pushButton.clicked.connect(self.buscar_cliente)

    def buscar_cliente(self):
        # Obtener el texto introducido en el campo de cliente
        cliente = self.lineEdit.text()

        # Verificar si el cliente ingresado es el cliente registrado
        if cliente == self.cliente_registrado:
            # Mostrar mensaje de éxito
            QMessageBox.information(self, "Resultado", "¡Cliente encontrado!")
        else:
            # Mostrar mensaje de error
            QMessageBox.warning(self, "Error", "El cliente no está dado de alta")
            
         # Limpiar el campo de texto para que el usuario pueda introducir otro nombre
        self.lineEdit.clear()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())
