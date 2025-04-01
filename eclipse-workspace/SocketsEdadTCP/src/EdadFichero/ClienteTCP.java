package EdadFichero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 5000;
		String fichero = "ficheroTCP.txt";
		
		//se crea el socket con el servidor y puerto
		try(Socket socket = new Socket(servidor, puerto)){
			
			//se crea el objeto PrintWriter para enviar el dato a través del socket.
			PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);
			
			//se abre scanner y se pide la edad
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce edad");
			int edad = sc.nextInt();
	
				//se guarda la edad en el fichero
			try (PrintWriter fichero_edad = new PrintWriter(fichero)) {
				fichero_edad.println(edad);
			}
			salida.println("edad guardada en fichero");
			
			// se crea el bufferedReader para leer la respuesta que ha enviado el servidor a través del socket.
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String linea_entrada = entrada.readLine();
				System.out.println("Servidor: "+linea_entrada);
			sc.close();
		
		}catch(IOException e) {
		e.printStackTrace();
		}
		
	}
}
