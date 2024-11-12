package temaDosProgramacionMultihilo;

public class cRaton implements Runnable{
	private String nombre;
	private int tiempoAlimentacion;
	
	public cRaton(String nombre, int tiempo){
		this.nombre=nombre;
		this.tiempoAlimentacion=tiempo;
	}
	
	//Aqui se podria poner directamente el metodo run en lugar de comer y despues tener que llamarle mas abajo
	public void comer(){
		try{
			System.out.printf("El raton %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);//pausa la ejecucion del hilo. Milisegundos.
			System.out.printf("El raton %s ha terminado de alimentarse%n",nombre);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){//Metodo de ejecucion
		this.comer();
	}
	
	public static void main(String[] args) {
		cRaton fievel = new cRaton("Fievel", 4);
		cRaton jerry = new cRaton("Jerry", 5);
		cRaton pinky = new cRaton("Pinky", 3);
		cRaton mickey = new cRaton("Mickey", 6);
		new Thread(fievel).start();
		new Thread(jerry).start();
		new Thread(pinky).start();
		new Thread(mickey).start();
		//Cada raton comienza a comer de inmediato.
		
		/*También se podría crear un unico objeto para crear multitud de hilos(solo se puede hacer con la interfaz)
		 * cRaton fievel = new cRaton("Fievel", 4);
		 * new Thread (fievel).start();
		 * new Thread (fievel).start();*/
		
		/*También podríamos usar un bucle for para crear tantos objetos necesitemos
		 * for(int i=0;i<100;i++){
		 * new Thread(fievel).start();
		 * }*/
	}
}
