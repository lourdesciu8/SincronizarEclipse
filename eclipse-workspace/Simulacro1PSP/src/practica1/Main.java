package practica1;

/*
 * Clase principal para ejecutar la simulación:
 * - Genera un número aleatorio de personas (entre 1 y 50)
 * - Lanza un hilo por persona (cada hilo es un TornoEstadio)
 * - Espera a que terminen todos los hilos
 * - Muestra los resultados finales de cuántas personas han pasado
 *   por cada torno y cuántas hay en cada palco VIP.
 */
public class Main {
    
    public static void main(String[] args) {
        // Generamos un número aleatorio de personas entre 1 y 50
        int cantidadPersonas = Estadio.random.nextInt(50) + 1;
        
        // Creamos el array de hilos (uno por persona)
        TornoEstadio[] hilos = new TornoEstadio[cantidadPersonas];
        
        // Inicializamos e iniciamos cada hilo
        for (int i = 0; i < cantidadPersonas; i++) {
            hilos[i] = new TornoEstadio(i + 1);
            hilos[i].start();
        }
        
        // Esperamos a que todos los hilos terminen (join)
        for (int i = 0; i < cantidadPersonas; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Mostramos los resultados finales
        System.out.println("RESULTADOS FINALES:");
        System.out.println("Personas que han pasado por torno1: " + Estadio.contadorTorno1);
        System.out.println("Personas que han pasado por torno2: " + Estadio.contadorTorno2);
        System.out.println("Personas que han pasado por torno3: " + Estadio.contadorTorno3);
        System.out.println("Personas que han pasado por torno4: " + Estadio.contadorTorno4);
        
        System.out.println("Total de personas que han entrado al estadio: " + cantidadPersonas);
        
        System.out.println("Palco VIP 1 tiene: " + Estadio.palcoVIP1 + " personas.");
        System.out.println("Palco VIP 2 tiene: " + Estadio.palcoVIP2 + " personas.");
    }
}
