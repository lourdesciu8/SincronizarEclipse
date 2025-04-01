import sys
from PyQt6.QtWidgets import QApplication, QMainWindow
from VentanaVentas import Ui_MainWindow  # Importa la clase generada

class VentanaPrincipal(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)  # Configura la UI

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())

