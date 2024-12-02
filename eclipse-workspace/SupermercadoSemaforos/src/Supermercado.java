import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Supermercado {

    private static final int MAX_PERSONAS = 15; // Máximo de personas en el supermercado
    private static Semaphore entrada = new Semaphore(MAX_PERSONAS); // Semáforo para la entrada
    private static Semaphore caja1 = new Semaphore(1); // Semáforo para la caja 1
    private static Semaphore caja2 = new Semaphore(1); // Semáforo para la caja 2
    private static Semaphore caja3 = new Semaphore(1); // Semáforo para la caja 3

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar número de clientes al usuario
        System.out.println("¿Cuántos clientes quieres simular?");
        int numClientes = scanner.nextInt();

        // Crear un array para los hilos de clientes
        Cliente[] clientesArray = new Cliente[numClientes];

        // Crear y lanzar hilos para cada cliente
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = new Cliente(i + 1, entrada, caja1, caja2, caja3); // Crear cliente
            clientesArray[i] = cliente; // Guardar en el array
            cliente.start(); // Iniciar el hilo
        }

        // Esperar a que todos los hilos terminen
        for (Cliente cliente : clientesArray) {
            try {
                cliente.join(); // Esperar a que termine cada cliente
            } catch (InterruptedException e) {
                System.out.println("Error esperando el hilo: " + e.getMessage());
            }
        }

        // Calcular la suma total de las ganancias
        double totalGanancias = Cliente.getGananciasCaja1() + Cliente.getGananciasCaja2() + Cliente.getGananciasCaja3();

        // Mostrar las ganancias totales con buen formato
        System.out.println("\nResumen de ganancias:");
        System.out.printf("Caja 1: %.2f€%n", Cliente.getGananciasCaja1());
        System.out.printf("Caja 2: %.2f€%n", Cliente.getGananciasCaja2());
        System.out.printf("Caja 3: %.2f€%n", Cliente.getGananciasCaja3());
        System.out.printf("Total de ganancias: %.2f€%n", totalGanancias);
    }
}

