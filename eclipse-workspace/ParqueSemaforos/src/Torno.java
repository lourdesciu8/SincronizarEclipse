import java.util.Random;
import java.util.concurrent.Semaphore;

public class Torno extends Thread {

    private int id; // Identificador del torno
    private int visitantesTorno = 0; // Contador de visitantes de este torno
    private static int totalVisitantes = 0; // Contador total de visitantes
    private Semaphore semaforo; // Semáforo para controlar el acceso por este torno
    private Semaphore totalSemaphore; // Semáforo para actualizar el total de visitantes

    // Constructor
    public Torno(int id, Semaphore semaforo, Semaphore totalSemaphore) {
        this.id = id;
        this.semaforo = semaforo;
        this.totalSemaphore = totalSemaphore;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int numPersonas = random.nextInt(30) + 1; // Entre 1 y 30 personas
            for (int i = 0; i < numPersonas; i++) {
                semaforo.acquire(); // Una persona accede por el torno
                registrarVisitante();
                semaforo.release(); // Liberar el acceso del torno
                Thread.sleep(500); // Simular tiempo entre accesos
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Registrar un visitante en este torno
    private void registrarVisitante() {
        try {
            visitantesTorno++; // Incrementar visitantes de este torno
            totalSemaphore.acquire(); // Acceder al semáforo global para actualizar el total
            totalVisitantes++; // Incrementar el total de visitantes
            totalSemaphore.release(); // Liberar el semáforo global
            System.out.println("Torno " + id + " registró un visitante. Total del torno: " + visitantesTorno);
        } catch (InterruptedException e) {
            System.out.println("Error al actualizar el total de visitantes.");
        }
    }

    // Método para obtener el total de visitantes de este torno
    public int getVisitantesTorno() {
        return visitantesTorno;
    }

    // Método estático para obtener el total de visitantes del parque
    public static int getTotalVisitantes() {
        return totalVisitantes;
    }
}
