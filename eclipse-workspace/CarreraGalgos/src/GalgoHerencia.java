import java.util.Scanner;

public class GalgoHerencia extends Thread {
	
	protected String nombre;
	protected int tiempoCarrera;
	

	public GalgoHerencia(String nombre, int tiempoCarrera) {
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
	}
	
	public void run() {
		try{
			System.out.printf("El galgo %s ha comenzado la carrera%n", nombre);
			Thread.sleep(tiempoCarrera * 1000);//pausa la ejecucion del hilo. Milisegundos.
			System.out.printf("El galgo %s ha terminado la carrera%n",nombre);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int NUMEROGALGOS = 3; //Se considera un valor fijo
		
		//Se crea un array de galgos
        GalgoHerencia galgosArray [] = new GalgoHerencia[3];

        // Solicitar el tiempo de carrera para cada galgo
        for (int i = 0; i < NUMEROGALGOS; i++) {
            System.out.printf("Introduce el tiempo de carrera en segundos para el galgo %d: ", i + 1);
            int tiempoCarrera = sc.nextInt();
            GalgoHerencia g = new GalgoHerencia("Galgo " + (i + 1), tiempoCarrera); // Crear el objeto galgo
            galgosArray[i] = g; // Se asigna al array

        }


        // Iniciar todos los hilos
        for (GalgoHerencia Galgo : galgosArray) {
            Galgo.start();
        }
    }
}
