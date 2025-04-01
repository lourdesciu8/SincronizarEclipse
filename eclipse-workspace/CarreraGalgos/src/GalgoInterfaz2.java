import java.util.Scanner;
import java.util.Random;

public class GalgoInterfaz2 implements Runnable {

    protected String nombre;
    protected int tiempoCarrera;

    public GalgoInterfaz2(String nombre, int tiempoCarrera) {
        this.nombre = nombre;
        this.tiempoCarrera = tiempoCarrera;
    }

    // Método para correr, llamado en el método run
    public void correr() {
        try {
            System.out.printf("El galgo %s ha comenzado a correr%n", nombre);
            Thread.sleep(tiempoCarrera * 1000); // Pausa la ejecución del hilo en milisegundos
            System.out.printf("El galgo %s ha terminado la carrera en %d segundos%n", nombre, tiempoCarrera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.correr();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Introduce el número de galgos a correr: ");
        int numeroGalgos = sc.nextInt();
        sc.nextLine(); 

        // Crear un array de galgos con el tamaño especificado por el usuario
        GalgoInterfaz2 galgosArray []  = new GalgoInterfaz2[numeroGalgos];

        // Solicitar el nombre de cada galgo y asignar un tiempo de carrera aleatorio
        for (int i = 0; i < numeroGalgos; i++) {
            System.out.printf("Introduce el nombre del galgo %d: ", i + 1);
            String nombre = sc.nextLine();
            int tiempoCarrera = random.nextInt(1, 6); // Generar tiempo aleatorio entre 1 y 5 segundos
            System.out.printf("Tiempo de carrera generado para %s: %d segundos%n", nombre, tiempoCarrera); // Imprimir el tiempo generado
            galgosArray[i] = new GalgoInterfaz2(nombre, tiempoCarrera);
        }

        // Iniciar todos los hilos
        for (GalgoInterfaz2 galgo : galgosArray) {
            new Thread(galgo).start();
        }
    }
}

