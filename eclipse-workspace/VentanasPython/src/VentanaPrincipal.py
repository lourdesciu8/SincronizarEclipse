from PyQt6 import QtCore, QtGui, QtWidgets

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(994, 371)
        self.centralwidget = QtWidgets.QWidget(parent=MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.tableView = QtWidgets.QTableView(parent=self.centralwidget)
        self.tableView.setGeometry(QtCore.QRect(360, 10, 631, 281))
        self.tableView.setObjectName("tableView")
        self.botonSalir = QtWidgets.QPushButton(parent=self.centralwidget)
        self.botonSalir.setGeometry(QtCore.QRect(890, 300, 97, 33))
        self.botonSalir.setObjectName("botonSalir")
        self.botonEliminar = QtWidgets.QPushButton(parent=self.centralwidget)
        self.botonEliminar.setGeometry(QtCore.QRect(770, 300, 97, 33))
        self.botonEliminar.setObjectName("botonEliminar")
        self.labelUsuario = QtWidgets.QLabel(parent=self.centralwidget)
        self.labelUsuario.setGeometry(QtCore.QRect(30, 70, 91, 21))
        self.labelUsuario.setObjectName("labelUsuario")
        self.labelPass = QtWidgets.QLabel(parent=self.centralwidget)
        self.labelPass.setGeometry(QtCore.QRect(30, 120, 111, 16))
        self.labelPass.setObjectName("labelPass")
        self.lineUsuario = QtWidgets.QLineEdit(parent=self.centralwidget)
        self.lineUsuario.setGeometry(QtCore.QRect(160, 70, 171, 31))
        self.lineUsuario.setObjectName("lineUsuario")
        self.linePass = QtWidgets.QLineEdit(parent=self.centralwidget)
        self.linePass.setGeometry(QtCore.QRect(160, 110, 171, 31))
        self.linePass.setEchoMode(QtWidgets.QLineEdit.EchoMode.Password)
        self.linePass.setObjectName("linePass")
        self.comboBox = QtWidgets.QComboBox(parent=self.centralwidget)
        self.comboBox.setGeometry(QtCore.QRect(160, 160, 171, 31))
        self.comboBox.setEditable(True)
        self.comboBox.setObjectName("comboBox")
        self.comboBox.addItem("")
        self.comboBox.addItem("")
        self.comboBox.addItem("")
        self.comboBox.addItem("")
        self.label_2 = QtWidgets.QLabel(parent=self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(36, 170, 71, 20))
        self.label_2.setObjectName("label_2")
        self.checkBox = QtWidgets.QCheckBox(parent=self.centralwidget)
        self.checkBox.setGeometry(QtCore.QRect(40, 230, 95, 21))
        self.checkBox.setObjectName("checkBox")
        self.checkBox_2 = QtWidgets.QCheckBox(parent=self.centralwidget)
        self.checkBox_2.setGeometry(QtCore.QRect(40, 270, 95, 21))
        self.checkBox_2.setObjectName("checkBox_2")
        self.botonLimpiar = QtWidgets.QPushButton(parent=self.centralwidget)
        self.botonLimpiar.setGeometry(QtCore.QRect(230, 240, 97, 33))
        self.botonLimpiar.setObjectName("botonLimpiar")
        self.botonInsertar = QtWidgets.QPushButton(parent=self.centralwidget)
        self.botonInsertar.setGeometry(QtCore.QRect(650, 300, 97, 33))
        self.botonInsertar.setObjectName("botonInsertar")
        MainWindow.setCentralWidget(self.centralwidget)
        self.statusbar = QtWidgets.QStatusBar(parent=MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        self.botonSalir.clicked.connect(MainWindow.close) # type: ignore
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

        # Conectar la lógica de los checkboxes
        self.checkBox.toggled.connect(lambda checked: self.limitarCheckbox(checked, self.checkBox_2))
        self.checkBox_2.toggled.connect(lambda checked: self.limitarCheckbox(checked, self.checkBox))

        # Conectar el botón de limpiar
        self.botonLimpiar.clicked.connect(self.limpiar_campos)

        # Conectar el botón de insertar
        self.botonInsertar.clicked.connect(self.insertar_datos)
        
        # Conectar el botón de eliminar
        self.botonEliminar.clicked.connect(self.eliminar_fila)

        # Configurar tabla
        self.configurar_tabla()

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "VentanaPrincipal"))
        self.botonSalir.setText(_translate("MainWindow", "SALIR"))
        self.botonEliminar.setText(_translate("MainWindow", "ELIMINAR"))
        self.labelUsuario.setText(_translate("MainWindow", "USUARIO"))
        self.labelPass.setText(_translate("MainWindow", "CONTRASEÑA"))
        self.comboBox.setItemText(0, _translate("MainWindow", "Inserte una opción"))
        self.comboBox.setItemText(1, _translate("MainWindow", "Alumno"))
        self.comboBox.setItemText(2, _translate("MainWindow", "Profesor"))
        self.comboBox.setItemText(3, _translate("MainWindow", "Administrador"))
        self.label_2.setText(_translate("MainWindow", "TIPO"))
        self.checkBox.setText(_translate("MainWindow", "PRIMERO"))
        self.checkBox_2.setText(_translate("MainWindow", "SEGUNDO"))
        self.botonLimpiar.setText(_translate("MainWindow", "LIMPIAR"))
        self.botonInsertar.setText(_translate("MainWindow", "INSERTAR"))

    def limitarCheckbox(self, checked, otro_checkbox):
        """Si un checkbox se activa, desactiva el otro."""
        if checked:
            otro_checkbox.setChecked(False)

    def limpiar_campos(self):
        """Limpia los campos de texto y los checkboxes."""
        self.lineUsuario.clear()
        self.linePass.clear()
        self.comboBox.setCurrentIndex(0)
        self.checkBox.setChecked(False)
        self.checkBox_2.setChecked(False)

    def insertar_datos(self):
        """Ejemplo de cómo insertar datos en la tabla (o hacer alguna acción)."""
        usuario = self.lineUsuario.text()
        contrasena = self.linePass.text()
        tipo = self.comboBox.currentText()

        row_position = self.modelo.rowCount()
        self.modelo.insertRow(row_position)
        self.modelo.setItem(row_position, 0, QtGui.QStandardItem(usuario))
        self.modelo.setItem(row_position, 1, QtGui.QStandardItem(contrasena))
        self.modelo.setItem(row_position, 2, QtGui.QStandardItem(tipo))

    def configurar_tabla(self):
        """Configura la tabla para usar un modelo adecuado."""
        # Crear el modelo
        self.modelo = QtGui.QStandardItemModel()

        # Configurar las columnas
        self.modelo.setHorizontalHeaderLabels(["Usuario", "Contraseña", "Tipo"])

        # Establecer el modelo en la vista de la tabla
        self.tableView.setModel(self.modelo)
        
        # Establecer el modo de ajuste de las columnas para que se estiren proporcionalmente
        self.tableView.horizontalHeader().setSectionResizeMode(0, QtWidgets.QHeaderView.ResizeMode.Stretch)
        self.tableView.horizontalHeader().setSectionResizeMode(1, QtWidgets.QHeaderView.ResizeMode.Stretch)
        self.tableView.horizontalHeader().setSectionResizeMode(2, QtWidgets.QHeaderView.ResizeMode.Stretch)

    def eliminar_fila(self):
        """Elimina la fila seleccionada en la tabla."""
        # Obtener el índice de la fila seleccionada
        seleccionado = self.tableView.selectionModel().selectedRows()
    
        # Verificar si hay alguna fila seleccionada
        if seleccionado:
            # Obtener el índice de la primera fila seleccionada
            fila = seleccionado[0].row()
    
            # Eliminar la fila del modelo
            self.modelo.removeRow(fila)    
