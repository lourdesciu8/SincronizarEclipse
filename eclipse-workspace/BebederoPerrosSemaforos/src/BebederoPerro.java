import java.util.Random;
import java.util.concurrent.Semaphore;

public class BebederoPerro extends Thread {
    private static Semaphore bebedero = new Semaphore(3); // Solo 3 perros pueden beber a la vez(solo 3 hilos paralelamente pueden acceder a la vez)
    private int identificador;
    private double aguaConsumida;
    Random random = new Random();

    public BebederoPerro(int identificador) {
        this.identificador = identificador;
    }

    public void run() {
        try {
            bebedero.acquire(); // El perro adquiere el semáforo (permiso para beber. 
            //Utilizando acquire si no hubiera sitio para entrar hay que esperar, en cambio con tryAcquire si no hay hueco se va.
            
            System.out.println("El perro " + identificador + " ha comenzado a beber.");
            
            int tiempoBebida = 10 + random.nextInt(91); // Tiempo aleatorio entre 10 y 100 milisegundos
            Thread.sleep(tiempoBebida);
            
            aguaConsumida = tiempoBebida * 0.1; // Cantidad de agua que bebió el perro en litros
            
            System.out.println("El perro " + identificador + " ha terminado de beber y ha consumido " + aguaConsumida + " litros de agua.");
            bebedero.release(); // El perro libera el semáforo
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getAguaConsumida() {
        return aguaConsumida;
    }

    public static void main(String[] args) {
        int numeroPerros = 6; // Número de perros total en la perrera
        BebederoPerro perros [] = new BebederoPerro[numeroPerros];
        
        for (int i = 0; i < numeroPerros; i++) {
            perros[i] = new BebederoPerro(i + 1);
            perros[i].start();
        }

        // Esperar a que todos los perros terminen y sumar el consumo total
        double totalAguaConsumida = 0.0;
        for (int i = 0; i < numeroPerros; i++) {
            try {
                perros[i].join(); // Esperamos a que el perro termine de beber
                 
                // Sumamos el agua consumida por cada perro
                double aguaConsumidaPorPerro = perros[i].getAguaConsumida();
                totalAguaConsumida += aguaConsumidaPorPerro;

                //el hilo principal espera a que cada perro termine (con join()) y luego acumula el consumo total de agua
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostrar el resultado total
        System.out.println("Cantidad total de agua consumida por todos los perros: " + totalAguaConsumida + " litros.");
    }
}

