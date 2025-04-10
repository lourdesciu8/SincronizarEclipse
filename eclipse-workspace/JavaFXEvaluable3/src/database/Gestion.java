package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Gestion {

	//Verificar credenciales para iniciar sessión sea profesor o alumno. Es llamado desde el evento btnEntrar y es usado por usuario también.
	public static boolean verificarCredencial(String nombre, String pass, String cargo) {
		boolean valido = false;
		String query;
		
		//consulta si es alumno o profesor ¿?
	
		if(cargo.equals("Profesor")) {
		    query = "SELECT * FROM profesores WHERE nombre = ? AND pass = ?";
		} else {
		    query = "SELECT * FROM alumnos WHERE nombre = ? AND pass = ?";
		}

		System.out.println("Ejecutando query: " + query);
		//se conecta a la base de datos para generar la consulta
		try(Connection connection = DBConnection.getDbconnection();
				PreparedStatement ps = connection.prepareStatement(query)){
			//establece los parametros en la query
			ps.setString(1, nombre);
			ps.setString(2, pass);
			//ejecución y procesamiento de datos
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				valido = true;
			}
			}catch(SQLException e) {
				System.out.println("Error al verificar credenciales "+e);
			}
		return valido;
	}
	
	//Obtener modulos del profesor. Usuario en VentanaProfesor
	public static List<String> obtenerModulosParaProfesor(int id_profesor) {
		List<String> modulos = new ArrayList<>();
		//Consulta
		String query = "SELECT m.nombre FROM modulos m "+
				"JOIN profesores_modulos pm ON m.id = pm.id_modulo "+
				"WHERE pm.id_profesor = ?";
		//conecta y ejecuta
		try(Connection connection = DBConnection.getDbconnection();
				PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1, id_profesor);
			try(ResultSet rs = ps.executeQuery()){
		
			while(rs.next()) {
				modulos.add(rs.getString("nombre"));
			}
			}
		}catch(SQLException e) {
			System.out.println("Error al obtener modulos "+e.getMessage());
		}
		return modulos;
}


	//obtener el id del profesor y se usa en el evento del btnEntrar
	public static int obteneridProfesor(String usuario){
		int id_profesor = -1;
		String query = "SELECT id FROM profesores WHERE nombre = ?";
		try(Connection connection = DBConnection.getDbconnection();
				PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, usuario);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id_profesor = rs.getInt("id");

			}
			
		}catch (SQLException e) {
			System.out.println("Error al obtener usuarios "+e.getMessage());
		}
		return id_profesor;
	}
	
	//obtenemos los alumnos y sus notas desde los modulos a través del Join
	public static List<String[]> obtenerDatosModulos(String modulo){
		List<String[]> datos = new ArrayList<>();
		String query = "SELECT alumnos.id, alumnos.nombre, alumnos.apellido, notas.nota " +
                "FROM notas " +
                "JOIN alumnos ON notas.id_alumno = alumnos.id " +
                "JOIN modulos ON notas.id_modulo = modulos.id " +
                "WHERE modulos.nombre = ?";
		try(Connection connection = DBConnection.getDbconnection();
				PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, modulo);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
						String id = rs.getString("id");
						String nombre = rs.getString("nombre");
						String apellido = rs.getString("apellido");
						String nota = rs.getString("nota");
	
				datos.add(new String[]{id, nombre, apellido, nota});	
			}
			
		}catch(SQLException e) {
			System.out.println("Error al obtener alumnos del modulo "+e.getMessage());
		}
		return datos;
	}
	
	//Editar notas 
	public static boolean editarNota(int idAlumno, String modulo, double nuevaNota) {
        // La consulta SQL que actualizará la nota del alumno en un módulo específico
		String query = "UPDATE notas n " +
                "JOIN modulos m ON n.id_modulo = m.id " +
                "SET n.nota = ? " +
                "WHERE n.id_alumno = ? AND m.nombre = ?";

        try(Connection connection = DBConnection.getDbconnection();
				PreparedStatement ps = connection.prepareStatement(query)){
            // Establecemos los valores en la consulta
            ps.setDouble(1, nuevaNota); 
            ps.setInt(2, idAlumno);    
            ps.setString(3, modulo);    

            // Ejecutamos la actualización
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
    }
	
}