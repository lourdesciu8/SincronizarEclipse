import java.util.Scanner;

public class GalgoInterfaz implements Runnable {

	protected String nombre;
	protected int tiempoCarrera;
	

	public GalgoInterfaz(String nombre, int tiempoCarrera) {
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
	}
	
	//Aqui se podria poner directamente el metodo run en lugar de correr y despues tener que llamarle mas abajo
		public void correr(){
			try{
				System.out.printf("El galgo %s ha comenzado a correr%n", nombre);
				Thread.sleep(tiempoCarrera * 1000);//pausa la ejecucion del hilo. Milisegundos.
				System.out.printf("El galgo %s ha terminado de correr%n",nombre);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	@Override
		public void run() {
			this.correr();
			
		}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int NUMEROGALGOS = 3; //Se considera un valor fijo
		
		//Se crea un array de galgos
        GalgoInterfaz galgosArray [] = new GalgoInterfaz[3];

        // Solicitar el tiempo de carrera para cada galgo
        for (int i = 0; i < NUMEROGALGOS; i++) {
            System.out.printf("Introduce el tiempo de carrera en segundos para el galgo %d: ", i + 1);
            int tiempoCarrera = sc.nextInt();
            GalgoInterfaz g = new GalgoInterfaz("Galgo " + (i + 1), tiempoCarrera); // Crear el objeto galgo
            galgosArray[i] = g; // Se asigna al array

        }


        // Iniciar todos los hilos
        for (GalgoInterfaz Galgo : galgosArray) {
        	new Thread(Galgo).start();
        }
		
	}


}
