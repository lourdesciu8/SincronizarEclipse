import java.util.Scanner;
import java.util.Random;

public class GalgoHerencia2 extends Thread {
    
    protected String nombre;
    protected int tiempoCarrera;
    

    public GalgoHerencia2(String nombre, int tiempoCarrera) {
        this.nombre = nombre;
        this.tiempoCarrera = tiempoCarrera;
    }
    
    public void run() {
        try {
            System.out.printf("El galgo %s ha comenzado la carrera%n", nombre);
            Thread.sleep(tiempoCarrera * 1000); // pausa la ejecución del hilo en milisegundos
            System.out.printf("El galgo %s ha terminado la carrera%n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Introduce el número de galgos a correr: ");
        int numeroGalgos = sc.nextInt();
        sc.nextLine(); 

        // Crear un array de galgos con el tamaño especificado por el usuario
        GalgoHerencia galgosArray [] = new GalgoHerencia[numeroGalgos];

        // Solicitar el nombre de cada galgo y asignar un tiempo de carrera aleatorio
        for (int i = 0; i < numeroGalgos; i++) {
            System.out.printf("Introduce el nombre del galgo %d: ", i + 1);
            String nombre = sc.nextLine();
            int tiempoCarrera = random.nextInt(1, 6); // Genera un número aleatorio entre 1 (incluido) y 6 (excluido)
            System.out.printf("Tiempo de carrera generado para %s: %d segundos%n", nombre, tiempoCarrera); 
            
            galgosArray[i] = new GalgoHerencia(nombre, tiempoCarrera);
        }

        // Iniciar todos los hilos
        for (GalgoHerencia galgo : galgosArray) {
            galgo.start();
        }
    }
}
