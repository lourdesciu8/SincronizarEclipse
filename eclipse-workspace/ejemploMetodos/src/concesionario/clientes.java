package concesionario;

public class clientes {
	
		//Atributos o propiedades
		protected String dni, nombre, apellidos, sexo, email;
		
		//Constructores
		public clientes(String dni, String nombre, String apellidos) {
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
		}

		public clientes(String dni, String nombre, String apellidos, String sexo, String email) {
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.sexo = sexo;
			this.email = email;
		}
		
		public clientes() {
		}

		//Métodos
		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	
}
