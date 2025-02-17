//OBSERVACIONES:
//Dado que en este ejercicio queremos asegurarnos de que el número de lotería se envía correctamente y recibimos una
//respuesta precisa, TCP es la opción elegida. Con UDP se podrían perder datos y no tener confirmación de recepción.

//SERVIDOR: Espera conexiones de clientes-Recibe el número enviado por el cliente-
//Compara con el numero premiado(almacenado en un archivo)-Devuelve la respuesta al cliente.


import java.io.*;
import java.net.*;

public class SocketServidor {
    private static final int PUERTO = 7000; // Puerto donde escucha el servidor
    private static final String ARCHIVO_NUMERO = "NumeroPremiado.txt"; // Archivo con el número premiado

    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(PUERTO)) { // Usamos ServerSocket
            System.out.println("Servidor de lotería esperando conexiones...");
            
            while (true) {
                Socket cliente = servidor.accept(); // Acepta conexión de un cliente
                System.out.println("Cliente conectado desde: " + cliente.getInetAddress());
                
                // Creamos una instancia de GestionarClientes, pasándole el cliente conectado
                GestionarClientes clienteHandler = new GestionarClientes(cliente);

                // Creamos un nuevo hilo y le pasamos el objeto clienteHandler
                Thread hiloCliente = new Thread(clienteHandler);

                // Iniciamos el hilo para que maneje la conexión del cliente de forma independiente
                hiloCliente.start();

            }
        } catch (IOException e) {
            System.err.println("Error iniciando el servidor: " + e.getMessage());
        }
    }

    // Método sincronizado para leer el número premiado del archivo
    // Cuando un cliente llama a leerNumeroPremiado(), el método se bloquea para los demás hilos.
    // Si otro cliente intenta leer el archivo al mismo tiempo, tiene que esperar a que el primero termine.
    // Cuando el primer hilo termina la lectura, el siguiente hilo entra y lee.
    public static synchronized String leerNumeroPremiado() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_NUMERO))) {
            return reader.readLine(); // Devuelve el número premiado leído del archivo
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
            return "Error"; 
        }
    }
}

