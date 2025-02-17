public class Productor implements Runnable {
    private Monitor monitor;
    
    public Productor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        while (!monitor.isCicloTerminado()) {
            monitor.producir();
            // Esperamos 0,1 segundo antes de la siguiente iteración
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Productor finaliza su labor.");
    }
}
