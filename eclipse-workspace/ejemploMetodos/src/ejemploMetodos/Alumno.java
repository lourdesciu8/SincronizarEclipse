package ejemploMetodos;

public class Alumno {
	//Atributos o propiedades
	
		String nombre, apellido, DNI;

			
		//Constructor o constructores	
		public Alumno() {

		}


		public Alumno(String nombre, String apellido, String dNI) {
			this.nombre = nombre;
			this.apellido = apellido;
			DNI = dNI;
		}

		
		//Métodos para trabajar con los atributos del objeto
		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}


		public String getDNI() {
			return DNI;
		}


		public void setDNI(String dNI) {
			DNI = dNI;
		}
		
		public void comprobarDNI(String dNI) {
			String dni = "12345678Z"; // Cambia esto con el DNI que quieras verificar
	        if (comprobarDNI(dni)) {
	            System.out.println("El DNI es válido.");
	        } else {
	            System.out.println("El DNI no es válido.");
	        }
	    }
		
}
