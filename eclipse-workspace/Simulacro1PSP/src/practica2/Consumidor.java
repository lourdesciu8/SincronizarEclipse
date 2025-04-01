package practica2;

class Consumidor implements Runnable {
    private Monitor monitor;
    
    public Consumidor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        while (!monitor.isCicloTerminado()) {
            monitor.consumir();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumidor finaliza su operación.");
    }
}
