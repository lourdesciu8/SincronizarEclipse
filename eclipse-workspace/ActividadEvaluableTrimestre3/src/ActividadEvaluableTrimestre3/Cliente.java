package ActividadEvaluableTrimestre3;

public class Cliente extends Usuario{

	//Atributos
		protected String nombre;
	    protected String email;
	    protected String password;
	    
	//Constructor
	public Cliente(String nombre, String email, String password) {
		super(nombre, email, password);
		this.nombre = nombre;
        this.email = email;
        this.password = password; 
	}
	
	//Getters y setters 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
