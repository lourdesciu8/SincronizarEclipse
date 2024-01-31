package concesionario;

public class vehiculos {
	   	//Atributos o propiedades
		protected String marca, modelo, matrícula;
		protected int potencia,precio;
		
		
		//Constructores
		public vehiculos(String marca, String modelo, String matrícula, int potencia, int precio) {
			this.marca = marca;
			this.modelo = modelo;
			this.matrícula = matrícula;
			this.potencia = potencia;
			this.precio = precio;
		}


		public vehiculos(String matrícula, String marca) {
			this.matrícula = matrícula;
			this.marca = marca;
		}


		public vehiculos(int potencia, int precio) {
			this.potencia = potencia;
			this.precio = precio;
		}
		
		
		public vehiculos() {
		}


		//Métodos
		public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getModelo() {
			return modelo;
		}


		public void setModelo(String modelo) {
			this.modelo = modelo;
		}


		public String getMatrícula() {
			return matrícula;
		}


		public void setMatrícula(String matrícula) {
			this.matrícula = matrícula;
		}


		public int getPotencia() {
			return potencia;
		}


		public void setPotencia(int potencia) {
			this.potencia = potencia;
		}


		public int getPrecio() {
			return precio;
		}


		public void setPrecio(int precio) {
			this.precio = precio;
		}
		
}
