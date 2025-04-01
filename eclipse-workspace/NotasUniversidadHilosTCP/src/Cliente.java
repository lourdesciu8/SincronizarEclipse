import java.io.*;
import java.net.*;
import java.util.*;

//El cliente se conecta al servidor y hace las solicitudes.

import java.io.*;
import java.net.*;
import java.util.*;

// El cliente se conecta al servidor y hace las solicitudes.
public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");

            // Intentamos conectarnos al servidor en localhost en el puerto 5000
            System.out.println("Intentando conectarse al servidor...");
            Socket sc = new Socket("127.0.0.1", 5000);
            System.out.println("Conectado al servidor.");

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            // Leemos la bienvenida del servidor
            String mensaje = in.readUTF();
            System.out.println("Mensaje del servidor: " + mensaje);  // Mensaje de depuración

            // Pedimos el nombre al cliente
            System.out.println("Introduce tu nombre:");
            String nombre = sn.nextLine();
            
            System.out.println("Enviando nombre al servidor: " + nombre);
            out.writeUTF(nombre);

            // Creamos y arrancamos el hilo del cliente para gestionar las opciones
            ClienteHilo hilo = new ClienteHilo(in, out);
            hilo.start();
            
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
