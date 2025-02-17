public class Principal {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        
        Thread productor = new Thread(new Productor(monitor));
        Thread consumidor = new Thread(new Consumidor(monitor));
        
        productor.start();
        consumidor.start();
        
        // Esperamos a que terminen ambos hilos
        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Simulación finalizada.");
    }
}
