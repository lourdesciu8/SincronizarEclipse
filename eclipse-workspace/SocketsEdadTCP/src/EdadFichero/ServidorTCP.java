package EdadFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTCP {

	public static void main(String[] args) {
		int puerto = 5000;
		String fichero = "ficheroTCP.txt";
		
		//se crea el ServerSocket para esperar la conexión en el puerto.
		try(ServerSocket servidor= new ServerSocket(puerto)){
			System.out.println("El servidor espera conexión");
			
			//Bucle que espera multiples conexiones.
			while(true) {
			// se acepta la conexión.
			Socket socket = servidor.accept();
			System.out.println("El cliente ya esta conectado");
			
			//se crea los flujos de entrada y salida.
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			
			//se recibe y se notifica
			String mensaje = entrada.readLine();
			System.out.println("Cliente: "+mensaje);
			
			//abre el archivo donde se guardó la edad.
			try(BufferedReader lector_fichero = new BufferedReader(new FileReader(fichero))){
			String linea =lector_fichero.readLine();
			//se convierte a entero
			int edad = Integer.parseInt(linea);
			lector_fichero.close();
			
			// verifica si es menor o mayor y se almacena en una variable.
			String respuesta = (edad >= 18)? "Eres mayor de edad" : "Eres menor de edad";
			
			
			//Se envia la respuesta al cliente
			salida.println(respuesta);
			System.out.println("Servidor: " + respuesta);
			//se cierra y libera recursos.
			salida.close();
			socket.close();
			}
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
