import java.io.*;
import java.net.*;

//El servidor acepta las conexiones y crea hilos que se encarguen de procesar las solicitudes de cada cliente.

import java.io.*;
import java.net.*;

// El servidor acepta las conexiones y crea hilos que se encarguen de procesar las solicitudes de cada cliente.
public class Servidor {
    public static void main(String[] args) {
        try {
            // Creamos un servidor en el puerto 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor iniciado, esperando conexiones...");
            
            // El servidor acepta conexiones de clientes
            while (true) {
                Socket clientSocket = serverSocket.accept();
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                
                // Enviamos un mensaje de bienvenida solicitando el nombre
                out.writeUTF("Bienvenido. Por favor, introduce tu nombre:");
                
                // Leemos el nombre del cliente
                String nombreCliente = in.readUTF();
                
                // Creamos un hilo para gestionar este cliente, pasando el nombre ya recibido
                ServidorHilo hilo = new ServidorHilo(clientSocket, in, out, nombreCliente);
                hilo.start();  // Iniciamos el hilo
                
                System.out.println("Cliente " + nombreCliente + " conectado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
