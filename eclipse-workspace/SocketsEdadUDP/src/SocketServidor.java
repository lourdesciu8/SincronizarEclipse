import java.net.*;
/*Observaciones:
//El servidor UDP puede gestionar múltiples solicitudes de los clientes en un solo hilo, procesando los paquetes que recibe sin 
//necesidad de crear un hilo por cada cliente.Entonces, en la versión de UDP, no es necesario tener la clase GestionarClientes
//Comunicación sin conexión:No hay necesidad de establecer una conexión persistente entre el cliente y el servidor. 
Simplemente se envían y reciben paquetes de datos.
*/

public class SocketServidor {
    private static final int PUERTO = 6000; // Puerto donde el servidor escucha

    public static void main(String[] args) {
        try (DatagramSocket servidor = new DatagramSocket(PUERTO)) { // Crea el servidor en el puerto 6000
            System.out.println("Servidor esperando conexiones en el puerto " + PUERTO + "...");

            while (true) { // Espera paquetes de los clientes
                byte[] buffer = new byte[1024]; // Buffer para recibir datos

                // Recibir el paquete del cliente
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                servidor.receive(packet);

                String edadTexto = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Edad recibida del cliente: " + edadTexto);

                // Convertir edad a entero y evaluar
                int edad = Integer.parseInt(edadTexto);
                String respuesta;
                if (edad >= 18) {
                    respuesta = "Eres mayor de edad.";
                } else {
                    respuesta = "Eres menor de edad.";
                }

                // Enviar respuesta al cliente
                byte[] respuestaBytes = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                servidor.send(respuestaPacket);

                System.out.println("Respuesta enviada: " + respuesta);
            }
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
