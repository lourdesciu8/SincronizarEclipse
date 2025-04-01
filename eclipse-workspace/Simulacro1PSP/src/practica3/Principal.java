package practica3;

//clase que inicia la simulación, creando y ejecutando los hilos.

import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) {
        int numHilos = 5; // Número de hilos(simula el nº de alumnos)

        // Crear array de semáforos para los tenedores
        Semaphore[] tenedores = new Semaphore[numHilos];
        for (int i = 0; i < numHilos; i++) {
            tenedores[i] = new Semaphore(1); // Inicializa cada tenedor como disponible
        }

        // Crear e iniciar los hilos
        Thread[] hilos = new Thread[numHilos];
        for (int i = 0; i < numHilos; i++) {
            Semaphore tenedorIzquierdo = tenedores[i];
            Semaphore tenedorDerecho = tenedores[(i + 1) % numHilos];
            
            Hilo filosofo = new Hilo(i, tenedorIzquierdo, tenedorDerecho);
            hilos[i] = new Thread(filosofo);
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < numHilos; i++) {
            try {
                hilos[i].join(); // Esperamos a que cada hilo termine su ciclo antes de finalizar el programa
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Todos los hilos han comido. Simulación finalizada.");
    }
}