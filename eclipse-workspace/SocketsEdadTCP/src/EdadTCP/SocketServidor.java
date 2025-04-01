package EdadTCP;
import java.io.*;
import java.net.*;

public class SocketServidor {
    private static final int PUERTO = 6000; // Puerto donde el servidor escucha

    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(PUERTO)) { // Crea el servidor en el puerto 6000
            System.out.println("Servidor esperando conexiones en el puerto " + PUERTO + "...");

            while (true) { // Aceptar múltiples clientes
                Socket cliente = servidor.accept(); // Espera a que un cliente se conecte
                System.out.println("Cliente conectado desde: " + cliente.getInetAddress());

                // Manejo de la conexión en un hilo separado
                new Thread(new GestionarClientes(cliente)).start();
            }
        } catch (IOException e) {
            System.err.println("Error iniciando el servidor: " + e.getMessage());
        }
    }
}