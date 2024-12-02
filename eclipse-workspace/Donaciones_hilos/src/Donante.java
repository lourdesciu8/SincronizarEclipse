import java.util.Random;

public class Donante extends Thread { //Se usa herencia, start y join.
    private String nombre;
    private static int totalDonantes = 0;
    private static double totalDonado = 0.0;
    
    Random random = new Random();
    
    public Donante(String nombre) {
        this.nombre = nombre;
    }
    
    public void donar() {
        try {
            System.out.println(nombre + " ha comenzado a donar");
            
            // Genera un valor de donación aleatorio entre 1 y 100 euros
            double cantidadDonada = 1 + random.nextInt(100);
            Thread.sleep(10 + random.nextInt(91) * 10); // Simula el tiempo que tarda en realizar la donación
            
            totalDonantes++;  // Incrementa el número de donantes
            totalDonado += cantidadDonada;  // Suma la cantidad donada
            
            System.out.println(nombre + " ha donado " + cantidadDonada + " euros.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        donar();
    }
    
    public static void main(String[] args) {
        // Crear y comenzar los hilos de donación
        Donante d1 = new Donante("Donante 1");
        Donante d2 = new Donante("Donante 2");
        Donante d3 = new Donante("Donante 3");
        Donante d4 = new Donante("Donante 4");

        d1.start();
        d2.start();
        d3.start();
        d4.start();

        // Esperar a que todos los hilos terminen
        try {
            d1.join();
            d2.join();
            d3.join();
            d4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar resultados
        System.out.println("Total de donantes: " + totalDonantes);
        System.out.println("Cantidad total donada: " + totalDonado + " euros.");
    }
}
