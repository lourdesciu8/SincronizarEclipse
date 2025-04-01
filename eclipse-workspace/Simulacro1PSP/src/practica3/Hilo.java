package practica3;

import java.util.concurrent.Semaphore;

//Representa a cada uno de los hilos que participan en la simulación. Cada hilo sigue el ciclo de pensar, tomar los tenedores,
//comer y luego soltar los tenedores.

class Hilo implements Runnable {
    private int id; // Identificador del hilo
    private Semaphore tenedorIzquierdo; // Semáforo para el tenedor izquierdo
    private Semaphore tenedorDerecho; // Semáforo para el tenedor derecho
    
    public Hilo(int id, Semaphore tenedorIzquierdo, Semaphore tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }
    
    @Override
    public void run() {
        try {
            pensar(); // Fase de pensamiento antes de comer
            cogerTenedores(); // Intentar coger los tenedores
            comer(); // Comer una vez
            soltarTenedores(); // Soltar los tenedores después de comer
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Hilo " + id + " ha terminado su comida.");
    }
    
    private void pensar() throws InterruptedException {
        System.out.println("Hilo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 1000)); // Simula el tiempo de pensamiento
    }
    
    private void cogerTenedores() throws InterruptedException {
        tenedorIzquierdo.acquire(); // Intenta coger el tenedor izquierdo
        System.out.println("Hilo " + id + " tomó el tenedor izquierdo.");
        
        tenedorDerecho.acquire(); // Intenta coger el tenedor derecho
        System.out.println("Hilo " + id + " tomó el tenedor derecho.");
    }
    
    private void comer() throws InterruptedException {
        System.out.println("Hilo " + id + " está comiendo.");
        Thread.sleep((long) (Math.random() * 1000)); // Simula el tiempo que tarda en comer
    }
    
    private void soltarTenedores() {
        tenedorIzquierdo.release(); // Suelta el tenedor izquierdo
        tenedorDerecho.release(); // Suelta el tenedor derecho
        System.out.println("Hilo " + id + " soltó ambos tenedores.");
    }
}