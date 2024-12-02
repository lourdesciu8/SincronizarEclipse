import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cliente extends Thread {

    private int id; // Identificador único del cliente
    private Semaphore entrada; // Semáforo para controlar la entrada al supermercado
    private Semaphore caja1, caja2, caja3; // Semáforos para controlar el acceso a cada caja
    private static double gananciasCaja1 = 0; // Ganancias acumuladas en la caja 1
    private static double gananciasCaja2 = 0; // Ganancias acumuladas en la caja 2
    private static double gananciasCaja3 = 0; // Ganancias acumuladas en la caja 3

    // Constructor
    public Cliente(int id, Semaphore entrada, Semaphore caja1, Semaphore caja2, Semaphore caja3) {
        this.id = id;
        this.entrada = entrada;
        this.caja1 = caja1;
        this.caja2 = caja2;
        this.caja3 = caja3;
    }

    @Override
    public void run() {
        try {
            entrada.acquire(); // Cliente intenta entrar al supermercado
            System.out.println("Cliente " + id + " ha entrado al supermercado.");

            // Determinar la caja a usar
            int cajaElegida = (id % 3); // Elegir caja: case 0 -> caja1, case 1 -> caja2, case 2 -> caja3

            switch (cajaElegida) {
                case 0:
                    caja1.acquire(); // Esperar a que la caja 1 esté disponible
                    double gasto1 = procesarCompra(id, 1); 
                    gananciasCaja1 += gasto1; 
                    caja1.release(); // Liberar la caja 1
                    break;

                case 1:
                    caja2.acquire(); // Esperar a que la caja 2 esté disponible
                    double gasto2 = procesarCompra(id, 2); 
                    gananciasCaja2 += gasto2;
                    caja2.release(); // Liberar la caja 2
                    break;

                case 2:
                    caja3.acquire(); // Esperar a que la caja 3 esté disponible
                    double gasto3 = procesarCompra(id, 3); 
                    gananciasCaja3 += gasto3; 
                    caja3.release(); // Liberar la caja 3
                    break;
            }

            // Salir del supermercado
            System.out.println("Cliente " + id + " ha salido del supermercado.");
            entrada.release(); // Liberar un lugar en el supermercado

        } catch (InterruptedException e) {
            System.out.println("Error: El hilo fue interrumpido.");
        }
    }

    // Método para procesar la compra de un cliente
    private double procesarCompra(int id, int caja) {
        Random random = new Random();
        double gasto = 1 + (100 - 1) * random.nextDouble(); // Generar un gasto aleatorio entre 1 y 100 euros
        System.out.println("Cliente " + id + " está pagando en la caja " + caja + " con un gasto de " + String.format("%.2f", gasto) + "€");

        try {
            Thread.sleep(random.nextInt(1000) + 1000); // Simular tiempo de 1000 a 2000 ms
        } catch (InterruptedException e) {
            System.out.println("Interrupción detectada: " + e.getMessage());
        
        }
        return gasto;
    }

    // Métodos para obtener las ganancias de cada caja
    public static double getGananciasCaja1() {
        return gananciasCaja1;
    }

    public static double getGananciasCaja2() {
        return gananciasCaja2;
    }

    public static double getGananciasCaja3() {
        return gananciasCaja3;
    }
}

