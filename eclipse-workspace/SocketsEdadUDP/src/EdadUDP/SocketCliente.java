package EdadUDP;
import java.net.*;
import java.util.Scanner;

public class SocketCliente {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 6000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (DatagramSocket socket = new DatagramSocket()) { // Crear socket UDP
            System.out.print("Introduce tu edad: ");
            String edad = scanner.nextLine(); // Leer edad desde consola

            // Enviar edad al servidor
            byte[] datos = edad.getBytes();
            InetAddress serverAddress = InetAddress.getByName(SERVIDOR);
            DatagramPacket packet = new DatagramPacket(datos, datos.length, serverAddress, PUERTO);
            socket.send(packet);
            System.out.println("Edad enviada al servidor...");

            // Recibir respuesta del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket respuestaPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(respuestaPacket);
            String respuesta = new String(respuestaPacket.getData(), 0, respuestaPacket.getLength());

            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}
