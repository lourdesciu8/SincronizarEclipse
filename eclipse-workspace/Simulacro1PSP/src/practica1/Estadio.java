package practica1;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Aquí centralizamos:
 * - Los semáforos de cada torno.
 * - Los contadores de personas por torno.
 * - Los contadores de personas por cada palco VIP.
 * - Un objeto Random compartido para generar valores aleatorios.
 */
public class Estadio {
    
    // Generador de números aleatorios
    public static Random random = new Random();
    
    // Semáforos para controlar el acceso a cada torno (1 persona a la vez)
    public static Semaphore torno1 = new Semaphore(1);
    public static Semaphore torno2 = new Semaphore(1);
    public static Semaphore torno3 = new Semaphore(1);
    public static Semaphore torno4 = new Semaphore(1);
    
    // Contadores de personas que han pasado por cada torno
    public static int contadorTorno1 = 0;
    public static int contadorTorno2 = 0;
    public static int contadorTorno3 = 0;
    public static int contadorTorno4 = 0;
    
    // Cantidad de personas en cada palco VIP
    public static int palcoVIP1 = 0;
    public static int palcoVIP2 = 0;
    
    /*
     * Método sincronizado para asignar la persona que ya ha pasado
     * por el torno a uno de los palcos VIP (evitando problemas de concurrencia).
     */
    public static synchronized void asignarAPalcoVIP(int numPalco) {
        if (numPalco == 1) {
            palcoVIP1++;
        } else {
            palcoVIP2++;
        }
    }
}
