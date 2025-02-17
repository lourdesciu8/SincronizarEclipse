public class Consumidor implements Runnable {
    private Monitor monitor;
    
    public Consumidor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        while (!monitor.isCicloTerminado()) {
            monitor.consumir();
            // Esperamos 0,1 segundo antes de la siguiente iteración
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Consumidor finaliza su labor.");
    }
}
