package BibiliotecaSimulacro;

public class Administrador {
	protected String nombre;
	protected String password;

    

    public Administrador(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

    

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void darAltaUsuario(Usuario usuario) {
        System.out.println("Usuario dado de alta: " + usuario.getNombre());
    }
}

