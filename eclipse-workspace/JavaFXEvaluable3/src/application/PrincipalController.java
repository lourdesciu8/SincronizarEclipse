package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import database.Gestion;
import database.GestionAlumno;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.PasswordField;

public class PrincipalController {
	@FXML
	private Label lblusuario;
	@FXML
	private TextField textUsuario;
	@FXML
	private Label lblpass;
	@FXML
	private PasswordField textPass;
	@FXML
	private Button btnEntrar;
	@FXML
	private Button btnLimpiar;
	@FXML
	private Button btnSalir;
	@FXML
	private Label lblcargo;
	@FXML
	private ComboBox <String> comboCargo;

	@FXML
	private void initialize() {
	    comboCargo.getItems().addAll("Alumno", "Profesor");
	    
	    // El combo arranca sin valor seleccionado
	    comboCargo.setValue(null);
	    
	    // Texto que se muestra cuando no hay valor seleccionado
	    comboCargo.setPromptText("Seleccionar opción");

	}
	
	// Event Listener on Button[#btnEntrar].onAction
	@FXML
	public void AccionEntrar(ActionEvent event) {
	    String usuario = textUsuario.getText();
	    String pass = textPass.getText();
	    String cargo = comboCargo.getValue(); // Se obtiene el valor seleccionado

	    // Validar que se haya seleccionado un cargo
	    if (cargo == null) {
	        mostrarAlerta(Alert.AlertType.WARNING, "Cargo no seleccionado", 
	                "Debe seleccionar un cargo antes de iniciar sesión.");
	        return;
	    }
	    
	    // Validar campos vacíos
	    if (usuario.isEmpty() || pass.isEmpty()) {
	        mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", 
	                "Por favor, complete todos los campos.");
	        return;
	    }
	    
	    // Verificar credenciales
	    boolean credencialCorrecta = Gestion.verificarCredencial(usuario, pass, cargo);
	    if (!credencialCorrecta) {
	        mostrarAlerta(Alert.AlertType.ERROR, "Credenciales incorrectas", 
	                "Usuario o contraseña incorrectos.");
	        return;
	    }
	    
	    // Si las credenciales son correctas, cargar la ventana correspondiente
	    try {
	        Stage currentStage = (Stage) btnEntrar.getScene().getWindow();
	        if (cargo.equals("Alumno")) {
	            int idAlumno = GestionAlumno.obteneridAlumno(usuario);
	            if (idAlumno == -1) {
	                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se encontró el ID del alumno.");
	                return;
	            }
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VentanaAlumno.fxml"));
	            Parent root = loader.load();
	            VentanaAlumnoController alumnoController = loader.getController();
	            alumnoController.setIdAlumno(idAlumno);
	            
	            Stage stage = new Stage();
	            stage.setTitle("Ventana Alumno");
	            stage.setScene(new Scene(root));
	            stage.show();
	            currentStage.close();
	        } else {  // Para "Profesor"
	            int idProfesor = Gestion.obteneridProfesor(usuario);
	            if (idProfesor == -1) {
	                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se encontró el ID del profesor.");
	                return;
	            }
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VentanaProfesor.fxml"));
	            Parent root = loader.load();
	            VentanaProfesorController profesorController = loader.getController();
	            profesorController.setIdProfesor(idProfesor);
	            
	            Stage stage = new Stage();
	            stage.setTitle("Ventana Profesor");
	            stage.setScene(new Scene(root));
	            stage.show();
	            currentStage.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        mostrarAlerta(Alert.AlertType.ERROR, "Excepción al cargar la ventana", e.getMessage());
	    }
	}

	// Event Listener on Button[#btnLimpiar].onAction
	@FXML
	public void AccionLimpiar(ActionEvent event) {
		textUsuario.clear();
        textPass.clear();
        comboCargo.getSelectionModel().selectFirst();
	}
	
	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void AccionSalir(ActionEvent event) {
		mostrarAlerta(Alert.AlertType.INFORMATION, "Salir", "¡Hasta pronto!");
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
	}
	
	// Método auxiliar para mostrar alertas
    private void mostrarAlerta(Alert.AlertType tipo, String cabecera, String contenido) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Aviso");
        alert.setHeaderText(cabecera);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
