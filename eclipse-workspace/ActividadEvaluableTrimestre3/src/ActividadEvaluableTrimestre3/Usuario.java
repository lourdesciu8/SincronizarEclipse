package ActividadEvaluableTrimestre3;

public abstract class Usuario {
	//Atributos
	protected String nombre;
    protected String email;
    protected String password;
    
    
   //Constructor
    protected Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;   
}

    //Getters y setters
	protected String getNombre() {
		return nombre;
	}


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}


	protected String getEmail() {
		return email;
	}


	protected void setEmail(String email) {
		this.email = email;
	}


	protected String getPassword() {
		return password;
	}


	protected void setPassword(String password) {
		this.password = password;
	}
}
