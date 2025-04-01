package naufrago;

//Clase que representa la balsa encargada del rescate
class Balsa extends Thread {
	//Identificador de balsa
	private int id;
	//Capacidad de la balsa
	private int capacidad = 0;
	//Referencia la isla
	private Isla isla;
	
	//Contructor
	public Balsa(int id, int capacidad, Isla isla) {
		this.id = id;
		this.capacidad = capacidad;
		this.isla = isla;
	}


	
	@Override
	public void run() {
		//Llama al método
		try {
			isla.rescatar(id, capacidad);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
