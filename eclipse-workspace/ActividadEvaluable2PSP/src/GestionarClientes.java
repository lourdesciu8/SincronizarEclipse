//Clase para manejar cada cliente en un hilo

import java.io.*;
import java.net.*;

public class GestionarClientes implements Runnable {
    private Socket cliente;
    public GestionarClientes(Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
    	BufferedReader entrada = null;
        PrintWriter salida = null;
        
        try {
        		// OBTENER FLUJO DE ENTRADA (para recibir datos del cliente)
        		InputStream flujoEntrada = cliente.getInputStream(); // Obtiene el flujo de entrada desde el socket
        		InputStreamReader lectorEntrada = new InputStreamReader(flujoEntrada); // Convierte bytes en caracteres
        		entrada = new BufferedReader(lectorEntrada); // Permite leer líneas completas 

        		// OBTENER FLUJO DE SALIDA (para enviar datos al cliente)
        		OutputStream flujoSalida = cliente.getOutputStream(); // Obtiene el flujo de salida hacia el cliente
        		salida = new PrintWriter(flujoSalida, true); // Permite enviar texto al cliente 

        
            String numeroCliente = entrada.readLine(); // Recibe número del cliente
            String numeroPremiado = SocketServidor.leerNumeroPremiado(); // Lee el número premiado del archivo
            
            // Comprobar si el número del cliente es el premiado
            String respuesta;
            if (numeroCliente.equals(numeroPremiado)) {
                respuesta = "¡Felicidades! Tu número ha sido premiado.";
            } else {
                respuesta = "Lo sentimos, no has sido premiado.";
            }

            
            salida.println(respuesta); // Envía respuesta al cliente
            salida.flush(); //Asegura que los datos se envían inmediatamente
            System.out.println("Respuesta enviada: " + respuesta);
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            try {
            	 entrada.close();
                 salida.close();
                 cliente.close();
                 System.out.println("Conexión con el cliente cerrada.");
            } catch (IOException e) {
                System.err.println("Error cerrando conexión: " + e.getMessage());
            }
        }
    }
}

