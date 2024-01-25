package ejemploMetodos;

public class Cuenta {
//Esta clase (que es el molde para crear los diferentes objetos) es la que no tiene el método main
	
	//Atributos o propiedades
	
	String titular;
	double cantidad;
	
		
	//Constructor o constructores	
	public Cuenta(String titular) {
		
		this.titular = titular;
	}


	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}


	
	
	//Métodos para trabajar con los atributos del objeto
	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public void ingresarDinero(double saldo) {
		cantidad=cantidad+ saldo;
	}
	
	public void retirarCantidad(double saldo) {
		cantidad=cantidad- saldo;
	}
}
