package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionAlumno {
	 			//Obtiene modulos donde se ha matriculado 
			public static List<String> obtenerModulosParaAlumno(int id_alumno) {
				List<String> modulos = new ArrayList<>();
				String query = "SELECT m.nombre FROM modulos m "+
						"JOIN matriculas mt ON m.id = mt.id_modulo "+
						"WHERE mt.id_alumno = ?";
				//conecta y ejecuta
				try(Connection connection = DBConnection.getDbconnection();
						PreparedStatement ps = connection.prepareStatement(query)){
					ps.setInt(1, id_alumno);
					try(ResultSet rs = ps.executeQuery()){
				
					while(rs.next()) {
						modulos.add(rs.getString("nombre"));
					}
					}
				}catch(SQLException e) {
					System.out.println("Error al obtener modulos "+e);
				}
				return modulos;
		}
			
			//obtener el id del alumno. Es llamado desde la evento btnEntrar en la venta principal
			public static int obteneridAlumno(String usuario){
				int id_alumno = -1;
				String query = "SELECT id FROM alumnos WHERE nombre = ?";
				try(Connection connection = DBConnection.getDbconnection();
						PreparedStatement ps = connection.prepareStatement(query)){
					ps.setString(1, usuario);
					
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						id_alumno = rs.getInt("id");

					}
					
				}catch (SQLException e) {
					System.out.println("Error al obtener usuarios "+e.getMessage());
				}
				return id_alumno;
			}
			
			//obtenemos los datos para un único alumno que es quien inicia la sesión
			public static List<String[]> obtenerDatosModulosDeAlumno(String modulo, int id_alumno){
				//consulta
			    List<String[]> datos = new ArrayList<>();
			    String query = "SELECT alumnos.id, alumnos.nombre, alumnos.apellido, notas.nota " +
			                    "FROM notas " +
			                    "JOIN alumnos ON notas.id_alumno = alumnos.id " +
			                    "JOIN modulos ON notas.id_modulo = modulos.id " +
			                    "WHERE modulos.nombre = ? AND alumnos.id = ?";
			    //conecta y ejecuta
			    try(Connection connection = DBConnection.getDbconnection();
			        PreparedStatement ps = connection.prepareStatement(query)){
			        
			        ps.setString(1, modulo);  // Establecemos el nombre del módulo
			        ps.setInt(2, id_alumno);  // Establecemos el id del alumno que inició sesión, id funciona como un filtro, para que no me imprima a todos mis compañero
			        
			        ResultSet rs = ps.executeQuery();
			        
			        while(rs.next()) {
			            String id = rs.getString("id");
			            String nombre = rs.getString("nombre");
			            String apellido = rs.getString("apellido");
			            String nota = rs.getString("nota");
			            datos.add(new String[]{id, nombre, apellido, nota});    
			        }
			        
			    }catch(SQLException e) {
			        System.out.println("Error al obtener alumnos del modulo " + e.getMessage());
			    }
			    return datos;
			}
	}


