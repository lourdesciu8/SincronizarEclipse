//OBSERVACIONES:
//Dado que en este ejercicio queremos asegurarnos de que el número de lotería se envía correctamente y recibimos una
//respuesta precisa, TCP es la opción elegida. Con UDP se podrían perder datos y no tener confirmación de recepción.

//CLIENTE: Se conecta al servidor-Envía el número jugado-Recibe la respuesta y la muestra por consola.

import java.io.*;
import java.net.*;

import java.io.*;  
import java.net.*;  

public class SocketCliente {  
    public static String enviarNumero(String numero) {  
        String servidor = "localhost"; // Dirección del servidor (es lo mismo que 127.0.0.1)  
        int puerto = 7000; // Puerto en el que el servidor está escuchando  

        try {  
            //Establecer conexión con el servidor  
            Socket socket = new Socket(servidor, puerto);  
            System.out.println("Conectado al servidor en " + servidor + ":" + puerto);  

            //Crear flujo de entrada para recibir datos del servidor  
            InputStream input = socket.getInputStream();  
            InputStreamReader inputReader = new InputStreamReader(input);  
            BufferedReader entrada = new BufferedReader(inputReader);  

            //Crear flujo de salida para enviar datos al servidor  
            OutputStream output = socket.getOutputStream();  
            PrintWriter salida = new PrintWriter(output, true); // `true` activa el auto-flush  

            //Enviar número al servidor  
            salida.println(numero);  
            System.out.println("Número enviado: " + numero);  

            //Recibir respuesta del servidor  
            String respuesta = entrada.readLine();  
            System.out.println("Respuesta recibida: " + respuesta);  

            //Cerrar conexión  
            socket.close();  
            System.out.println("Conexión cerrada.");  

            return respuesta; // Devolver la respuesta al cliente  

        } catch (IOException e) {  
            System.err.println("Error de conexión: " + e.getMessage());  
            return "Error de conexión";  
        }  
    }  
}
