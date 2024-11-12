import java.util.Scanner;

public class NumImpares extends Thread {

    private String nombreHilo;
    private int tiempo;

    public NumImpares(String nombreHilo, int tiempo) {
        this.nombreHilo = nombreHilo;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        try {
            int suma = 0;
            System.out.printf("El hilo %s ha comenzado%n", nombreHilo);
            for (int i = 1; i <= 10; i += 2) {
                System.out.printf("%s - Número: %d%n", nombreHilo, i);
                suma += i;
                Thread.sleep(tiempo); // Pausa según el tiempo especificado por el usuario en milisegundos
            }
            System.out.printf("Suma de números impares en %s: %d%n", nombreHilo, suma);
            System.out.printf("%s ha terminado.%n", nombreHilo);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tiempo de pausa para los hilos de números impares (en milisegundos): ");
        int tiempo = sc.nextInt();

        System.out.println("Ejecutando hilos de números impares...");
        
        // Crear y lanzar dos hilos de números impares con el tiempo de pausa especificado
        NumImpares hilo1Impar = new NumImpares("Hilo1Impar", tiempo);
        NumImpares hilo2Impar = new NumImpares("Hilo2Impar", tiempo);

        hilo1Impar.start();
        hilo2Impar.start();
    }
}

