import sys
#import resources
from PyQt6.QtWidgets import QApplication, QMainWindow, QMessageBox
from Practica3 import Ui_MainWindow 

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.ui = Ui_MainWindow()  
        self.ui.setupUi(self) 
        
        # Vincular los botones a sus métodos correspondientes
        self.ui.pushLimpiar.clicked.connect(self.limpiar)
        self.ui.pushEntrar.clicked.connect(self.entrar)
        self.ui.pushSalir.clicked.connect(self.salir)
        
    def limpiar(self):
        # Limpia ambos campos de texto
        self.ui.textUsuario.clear()
        self.ui.textPass.clear()

    def entrar(self):
        # Obtiene el contenido de los QTextEdit
        usuario = self.ui.textUsuario.toPlainText().strip()
        clave = self.ui.textPass.toPlainText().strip()
        #Si en lugar de un QTextEdit hubiera sido lineEdit se haría así: self.lineEdit.text()

        # Valida que no estén vacíos
        if usuario and clave: 
            self.bienvenida("Bienvenid@ Usuario", f"Bienvenid@, {usuario}")
        else:
            self.bienvenida("Error", "No has introducido usuario o contraseña")

    def salir(self):
        # Cierra la ventana principal (y, con ello, la aplicación)
        self.close()
        
    def bienvenida(self, titulo, mensaje):
        # Muestra un QMessageBox con el título y mensaje que le pases
        msj = QMessageBox()
        msj.setWindowTitle(titulo)
        msj.setText(mensaje)
        msj.exec()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = MainWindow()
    window.show()
    sys.exit(app.exec())
