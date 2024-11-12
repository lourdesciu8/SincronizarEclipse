import java.util.Scanner;
import java.util.Scanner;

public class NumPares extends Thread {

    private String nombreHilo;
    private int tiempo;

    public NumPares(String nombreHilo, int tiempo) {
        this.nombreHilo = nombreHilo;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        try {
            int suma = 0;
            System.out.printf("El hilo %s ha comenzado%n", nombreHilo);
            for (int i = 2; i <= 10; i += 2) {
                System.out.printf("%s - Número: %d%n", nombreHilo, i);
                suma += i;
                Thread.sleep(tiempo); // Pausa según el tiempo especificado por el usuario en milisegundos
            }
            System.out.printf("Suma de números pares en %s: %d%n", nombreHilo, suma);
            System.out.printf("%s ha terminado.%n", nombreHilo);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tiempo de pausa para los hilos de números pares (en milisegundos): ");
        int tiempo = sc.nextInt();

        System.out.println("Ejecutando hilos de números pares...");
        
        // Crear y lanzar dos hilos de números pares con el tiempo de pausa especificado
        NumPares hilo1Par = new NumPares("Hilo1Par", tiempo);
        NumPares hilo2Par = new NumPares("Hilo2Par", tiempo);

        hilo1Par.start();
        hilo2Par.start();
    }
}

