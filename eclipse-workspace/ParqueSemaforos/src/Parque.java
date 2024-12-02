import java.util.concurrent.Semaphore;

public class Parque {

    private static final int NUM_TORNOS = 5; // Número fijo de tornos

    public static void main(String[] args) {

        Semaphore totalSemaphore = new Semaphore(1); // Semáforo para controlar el acceso al total de visitantes
        Semaphore accesoTorno = new Semaphore(1); // Semáforo para permitir acceso de una persona por vez en cada torno

        // Crear y lanzar hilos para los tornos
        Torno tornosArray [] = new Torno[NUM_TORNOS];
        for (int i = 0; i < NUM_TORNOS; i++) {
            Torno torno = new Torno(i + 1, accesoTorno, totalSemaphore);
            tornosArray[i] = torno; // Guardar el torno en el array
            torno.start(); // Iniciar el hilo del torno
        }

        // Esperar a que todos los hilos terminen
        for (Torno torno : tornosArray) {
            try {
                torno.join(); // Esperar a que termine cada torno
            } catch (InterruptedException e) {
                System.out.println("Error esperando el hilo del torno: " + e.getMessage());
            }
        }

        // Mostrar la información final
        System.out.println("\nResumen de visitantes:");
        for (int i = 0; i < NUM_TORNOS; i++) {
            System.out.println("Torno " + (i + 1) + ": " + tornosArray[i].getVisitantesTorno() + " visitantes.");
        }
        System.out.println("Total de visitantes: " + Torno.getTotalVisitantes());
    }
}
