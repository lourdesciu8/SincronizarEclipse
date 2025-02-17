import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketCliente {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 6000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        try {
            System.out.print("Introduce tu edad: ");
            String edad = scanner.nextLine(); // Leer edad desde consola

            // CONECTARSE AL SERVIDOR
            System.out.println("Intentando conectar con el servidor...");
            socket = new Socket(SERVIDOR, PUERTO);
            System.out.println("Conexión establecida con el servidor en " + SERVIDOR + ":" + PUERTO);

            // CREAR BUFFER PARA LEER RESPUESTAS DEL SERVIDOR
          
            InputStream flujoEntrada = socket.getInputStream();
            InputStreamReader lectorEntrada = new InputStreamReader(flujoEntrada);
            entrada = new BufferedReader(lectorEntrada);
            System.out.println("Flujo de entrada listo.");

            // CREAR PRINTWRITER PARA ENVIAR DATOS AL SERVIDOR
        
            OutputStream flujoSalida = socket.getOutputStream();
            salida = new PrintWriter(flujoSalida, true);
            System.out.println("Flujo de salida listo.");

            // ENVIAR EDAD AL SERVIDOR
            salida.println(edad);
            System.out.println("Edad enviada al servidor...");

            // RECIBIR RESPUESTA DEL SERVIDOR
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) entrada.close();
                if (salida != null) salida.close();
                if (socket != null) socket.close();
                System.out.println("Conexión cerrada.");
            } catch (IOException e) {
                System.err.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
    }
}
