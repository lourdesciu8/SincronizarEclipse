package practica1;

import java.util.concurrent.Semaphore; 

public class TornoEstadio extends Thread {

    private int persona; 

    public TornoEstadio(int persona) {
        this.persona = persona;
    }

    @Override
    public void run() {
        // Elegimos un torno aleatoriamente entre 1 y 4
        int tornoElegido = Estadio.random.nextInt(4) + 1;

        // Se simula un tiempo de paso aleatorio entre 1 y 200 ms
        int tiempoPaso = Estadio.random.nextInt(200) + 1;

        // Según el torno elegido, llamamos a pasarPorTorno con el semáforo y nombre adecuados
        switch (tornoElegido) {
            case 1:
                pasarPorTorno(Estadio.torno1, "torno1");
                break;
            case 2:
                pasarPorTorno(Estadio.torno2, "torno2");
                break;
            case 3:
                pasarPorTorno(Estadio.torno3, "torno3");
                break;
            case 4:
                pasarPorTorno(Estadio.torno4, "torno4");
                break;
        }

        // Simulamos el tiempo de paso
        try {
            Thread.sleep(tiempoPaso);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Una vez que la persona ha pasado, asignamos un palco VIP aleatorio (1 o 2)
        int palcoElegido = Estadio.random.nextInt(2) + 1;
        Estadio.asignarAPalcoVIP(palcoElegido);
    }

    /*
     * Método para que la persona adquiera y libere el semáforo del torno correspondiente.
     * Además, incrementa el contador de cada torno según el nombreTorno que reciba.
     */
    private void pasarPorTorno(Semaphore semaforo, String nombreTorno) {
        try {
            // Adquirimos el semáforo para asegurarnos de que pasa de uno en uno
            semaforo.acquire();
            System.out.println("La persona " + persona + " está pasando por " + nombreTorno);

            // Actualizamos el contador de ese torno (1 persona más)
            switch (nombreTorno) {
                case "torno1":
                    Estadio.contadorTorno1++;
                    break;
                case "torno2":
                    Estadio.contadorTorno2++;
                    break;
                case "torno3":
                    Estadio.contadorTorno3++;
                    break;
                case "torno4":
                    Estadio.contadorTorno4++;
                    break;
                default:
                    // En teoría, no debería entrar aquí si se usan solo torno1..4
                    System.out.println("Torno desconocido: " + nombreTorno);
                    break;
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Liberamos el semáforo para que la siguiente persona pueda pasar
            semaforo.release();
            System.out.println("La persona " + persona + " ha dejado " + nombreTorno);
        }
    }
}

