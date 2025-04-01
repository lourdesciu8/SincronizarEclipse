
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class EstacionTrenes extends Thread{
	static Random random = new Random();
	
	//Controla el acceso de los trenes
	
	//Yo elijo que los trenes se diferencien entre tren de carga o tren de pasajero dependiendo de la via a la que acceda.
	
	// estas estación solo permitirá el acceso de 4 trenes a la vez para evitar una colisión
	private static Semaphore Estacion = new Semaphore(4);
	
	//Existen 2 vias para trenes de carga y 2 vias para trenes de pasajero
	private static Semaphore ViaCarga_A = new Semaphore(1);
	private static Semaphore ViaCarga_B = new Semaphore(1);
	private static Semaphore ViaPasajero_C = new Semaphore(1);
	private static Semaphore ViaPasajero_D = new Semaphore(1);
	
	//Arreglo donde se almacerán los trenes
	protected static EstacionTrenes trenes[];
	
	static private int total_carga = 0; // para que almacenes el número cargas de los trenes
	static private int total_pasajero = 0; // para que almacene el numero de pasajeros
	private int cantidadPasajeros; //Esto se va ir incrementado en la via de trenes de pasajeros
	private int cantidadCarga; // esto tambien se irá incrementando en la via de trenes de carga
	private int nombreTren;
	

	protected EstacionTrenes(int cantidadPasajeros, int cantidadCarga, int nombreTren) {
		this.cantidadPasajeros = cantidadPasajeros;
		this.cantidadCarga = cantidadCarga;
		this.nombreTren = nombreTren;
	}
	
	
	public void run() {
		int tiempo = random.nextInt(2000) + 1;
		int via = random.nextInt(4) + 1;
		try {
			//Lo que tarda el tren en llegar a la estación
			Thread.sleep(tiempo);
			
			//accede a la estación
			Estacion.acquire();
			
			switch(via) {
				case 1:
					//El tren de carga accede a la via de carga
					ViaCarga_A.acquire();
					System.out.println("El tren de carga "+this.nombreTren+" accede a las via A");
					try {
						Thread.sleep(tiempo); // tiempo que permance en la via
					}catch (InterruptedException e) {
						
						e.printStackTrace();
					}finally {
						ViaCarga_A.release(); // el tren sale y libera via para el próximo tren
						System.out.println("El tren "+this.nombreTren+" ha salido de la via A y lleva carga de "+this.cantidadCarga+" toneladas");
					}
					break;
				case 2:
					ViaCarga_B.acquire();
					System.out.println("El tren de carga "+this.nombreTren+" accede a las via B");
					try {
						Thread.sleep(tiempo); 
					}catch (InterruptedException e) {
						
						e.printStackTrace();
					}finally {
						ViaCarga_B.release();
						System.out.println("El tren "+this.nombreTren+" ha salido de la via B y lleva carga de "+this.cantidadCarga+" toneladas");
					}
					break;
				case 3:
					//El tren de pasajero accede a la via de pasajero
					ViaPasajero_C.acquire();
					System.out.println("El tren de pasajeros "+this.nombreTren+" accede a las via C");
					try {
						Thread.sleep(tiempo); //tiempo que permanece en la via
					}catch (InterruptedException e) {
						
						e.printStackTrace();
					}finally {
						ViaPasajero_C.release(); // el tren sale y libera via para el próximo tren
						System.out.println("El tren "+this.nombreTren+" ha salido de la via C y lleva "+this.cantidadPasajeros+" pasajeros");
					}
					break;
				case 4:
					ViaPasajero_D.acquire();
					System.out.println("El tren de pasajeros "+this.nombreTren+" accede a las via D");
					try {
						Thread.sleep(tiempo); 
					}catch (InterruptedException e) {
						
						e.printStackTrace();
					}finally {
						ViaPasajero_D.release();
						System.out.println("El tren "+this.nombreTren+" ha salido de la via D y lleva "+this.cantidadPasajeros+" pasajeros");
					}
					break;
					default: 
						System.out.println("Via de tren no valida");
						break;
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Estacion.release(); // Los trenes salen de la estación y libera 
			System.out.println("El tren :"+this.nombreTren+" ha salido de la estación");
			
			//calculo de las cargas y los pasajeros
			total_carga = total_carga += this.cantidadCarga;
			total_pasajero = total_pasajero += this.cantidadPasajeros;
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		//petición por teclado
		
		System.out.println("Inserte cantidad de trenes de carga");
		int cantidad_trenes_cargas = sc.nextInt();
		
		System.out.println("Inserte cantida de trenes de pasajeros");
		int cantidad_trenes_pasajeros = sc.nextInt();
		
		//Se llama al arreglo
		trenes = new EstacionTrenes[cantidad_trenes_cargas + cantidad_trenes_pasajeros];
		int index = 0; //controla la posición en el arreglo ya que sino sobreescribe la suma de pasajero en la carga, y entonces saldría cifras de carga y pasajero en 0
		
		//For para cargas
		for(int i = 0; i < cantidad_trenes_cargas; i++) {
			int cantidad_carga = random.nextInt(500) + 100;
			trenes[index] = new EstacionTrenes(0, cantidad_carga, index + 1);
			trenes[index].start();
			index++;
		}
		
		//For para pasajeros
		for(int i = 0; i < cantidad_trenes_pasajeros; i++) {
			int cantidad_pasajeros = random.nextInt(200) + 100;
			trenes[index] = new EstacionTrenes(cantidad_pasajeros, 0, index + 1);
			trenes[index].start();
			index++;
		}
		
		//Es util para esperar que todos los trenes hayan hecho el recorrido por la estación
		for (EstacionTrenes tren: trenes) {
			tren.join();
		}
	
		System.out.println("Total de trenes de cargas "+total_carga+" toneladas");
		System.out.println("Total de trenes de pasajeros "+total_pasajero+" pasajeros");
	}

}

