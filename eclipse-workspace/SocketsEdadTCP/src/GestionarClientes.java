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
        	
        	InputStream flujoEntrada = cliente.getInputStream(); // Obtiene el flujo de entrada del socket

        	InputStreamReader lectorEntrada = new InputStreamReader(flujoEntrada); // Convierte bytes en caracteres
   
        	entrada = new BufferedReader(lectorEntrada); // Permite leer líneas completas de texto
        
        	//OBTENER FLUJO DE SALIDA (para enviar datos al cliente)
        	OutputStream flujoSalida = cliente.getOutputStream(); // Obtiene el flujo de salida del socket

        	salida = new PrintWriter(flujoSalida, true); // Permite enviar texto con auto-flush activado

            // RECIBIR EDAD DEL CLIENTE
            String edadTexto = entrada.readLine();
            System.out.println("Edad recibida del cliente: " + edadTexto);

            // CONVERTIR EDAD A ENTERO Y EVALUAR
            int edad = Integer.parseInt(edadTexto);
            String respuesta;
            if (edad >= 18) {
                respuesta = "Eres mayor de edad.";
            } else {
                respuesta = "Eres menor de edad.";
            }

            // ENVIAR RESPUESTA AL CLIENTE
            salida.println(respuesta);
            salida.flush(); //Asegura que los datos se envían inmediatamente
            System.out.println("Respuesta enviada: " + respuesta);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error procesando la solicitud del cliente: " + e.getMessage());
        } finally {
            try {
                entrada.close();
                salida.close();
                cliente.close();
                System.out.println("Conexión con el cliente cerrada.");
            } catch (IOException e) {
                System.err.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
    }
}