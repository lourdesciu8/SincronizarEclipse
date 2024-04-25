package BibiliotecaSimulacro;

public class Usuario {
	
	protected String nombre;
	
    
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void hacerPrestamo(Articulo articulo) {
        System.out.println(nombre + " ha realizado el préstamo de: " + articulo);
    }

	public void devolverArticulo(Articulo articulo) {
		
	}
}