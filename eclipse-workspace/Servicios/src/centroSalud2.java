import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class centroSalud2 extends Thread{

	private static Semaphore centSal = new Semaphore(5);//Numero de hilos que adquieren dicho recurso y se ejecutan concurrentemente.
	private static Semaphore consulta = new Semaphore(1);
	//private static Semaphore consulta1 = new Semaphore(1);
	protected int identificador=0;
	private static Scanner sc = new Scanner(System.in);
	
	public centroSalud2 (int identificador) {
		this.identificador=identificador;
	}
	
	public void run(){
			
				try {
					try {
						Thread.sleep((long)(Math.random()*2000) + 100);//hilo dormido
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				//Bloqueo de la sala de espera
				centSal.acquire();//Hilo adquiere el semáforo o testigo
				System.out.println("El paciente "+ this.identificador + " entra a la sala de espera");
					
					//Bloque de la consulta
					consulta.acquire();//Paciente entra en la consulta
					System.out.println("El paciente "+ this.identificador + " entra en consulta");
					
					Thread.sleep((long)(Math.random()*1000) + 100);//tiempo atención en la consulta
				
					consulta.release();//Paciente sale de la consulta
					System.out.println("El paciente "+ this.identificador + " sale de la consulta");
				
				centSal.release();//Paciente sale del centro de salud
				System.out.println("El paciente "+ this.identificador + " sale del centro de salud");
				
				} catch (InterruptedException ex) {System.out.println(ex.getMessage());}
			
		}//fin del método run
	
	public static void main(String[] args) {
		int pacientes=0;
		System.out.println("Cuantos pacientes tienen cita en el día de hoy: ");
		pacientes=sc.nextInt();
		for(int i=1; i<=pacientes;i++) {
			new centroSalud2(i).start();
		}
	}

}
