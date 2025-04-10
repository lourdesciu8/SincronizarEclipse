package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

import database.GestionAlumno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class VentanaAlumnoController {
	@FXML
	private Label lblVentanaAlumno;
	@FXML
	private Label lblModulos;
	@FXML
	private ComboBox <String> comboModulos;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private TableView<NotaRow> table;
	@FXML
	private TableColumn<NotaRow, Double> column;

	@FXML
	private Button btnSalir;
	
	 // ID del alumno (asignado desde PrincipalController)
    private int idAlumno;

    public void setIdAlumno(int id) {
        this.idAlumno = id;
        cargarModulos();
    }
    
    @FXML
    private void initialize() {
        // Asigna el ScrollPane para que contenga la tabla (si no lo hiciste en FXML)
        scrollPane.setContent(table);

        // Configurar la única columna para mostrar la propiedad "info"
        column.setCellValueFactory(new PropertyValueFactory<>("nota"));
    }


	// Event Listener on ComboBox[#comboModulos].onAction
	@FXML
	public void actionComboBox(ActionEvent event) {
		String moduloSeleccionado = comboModulos.getSelectionModel().getSelectedItem();
        if (moduloSeleccionado != null) {
            cargarDatosAlumno(moduloSeleccionado);
        }
    }
	
	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void ActionSalir(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cerrar Sesión");
        alert.setHeaderText(null);
        alert.setContentText("¡Hasta pronto!");
        alert.showAndWait();

        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
	}
	
	// Cargar los módulos que cursa el alumno
    private void cargarModulos() {
        List<String> modulos = GestionAlumno.obtenerModulosParaAlumno(idAlumno);
        comboModulos.setItems(FXCollections.observableArrayList(modulos));
    }

    // Cargar nota en la columna
    private void cargarDatosAlumno(String modulo) {
        table.getItems().clear();
        List<String[]> datos = GestionAlumno.obtenerDatosModulosDeAlumno(modulo, idAlumno);
        ObservableList<NotaRow> rows = FXCollections.observableArrayList();
        for (String[] fila : datos) {
            try {
                double nota = Double.parseDouble(fila[3]);
                rows.add(new NotaRow(nota));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        table.setItems(rows);
    }

    
 // Clase para mostrar la nota en la tabla
    public static class NotaRow {
        private Double nota;

        public NotaRow(Double nota) {
            this.nota = nota;
        }

        public Double getNota() {
            return nota;
        }

        public void setNota(Double nota) {
            this.nota = nota;
        }
    }

	
}
