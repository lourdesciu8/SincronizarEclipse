package temaDosProgramacionMultihilo;

public class bRaton extends Thread{
	protected String nombre;
	protected int tiempoAlimentacion;
	
	public bRaton(String nombre, int tiempo){
		this.nombre=nombre;
		this.tiempoAlimentacion=tiempo;
	}
	
	//Este metodo tiene que ser obligatoriamente el run debido a que cuando arranca un hilo busca este metodo
	public void run(){
		try{
			System.out.printf("El raton %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);//pausa la ejecucion del hilo. Milisegundos.
			System.out.printf("El raton %s ha terminado de alimentarse%n",nombre);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		bRaton fievel = new bRaton("Fievel", 4);
		bRaton jerry = new bRaton("Jerry", 5);
		bRaton pinky = new bRaton("Pinky", 3);
		bRaton mickey = new bRaton("Mickey", 6);
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
		//Cada raton comienza a comer de inmediato(los 4 ratones comen a la vez)
		//EN PARALELO(multihilo->ejecuta diferentes hilos a la vez)
		//Utilizando herencia, se crea un objeto para cada hilo
	}
}
