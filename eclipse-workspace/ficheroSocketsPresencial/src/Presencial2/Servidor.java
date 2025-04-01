package Presencial2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int puerto = 8000;
		
		//Si el fichero no existe se crea.
		File file = new File("ficheroPar.txt");

		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(IOException e) {
				System.out.println("Error en la creación del archivo "+e);
				return;
			}
		}
	
		//Crea serversocket
	try(ServerSocket servidor = new ServerSocket(puerto)){
			System.out.println("A la espera de conexión");
			
			while(true) {
				Socket socket_cliente = servidor.accept();
				System.out.println("Cliente conectado");
				
				//Abre el flujo de entrada información por el cliente
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
				String numStr = entrada.readLine();
				//Convierte en String en un entero para comparar
				int numero = Integer.parseInt(numStr);
				
				// Abre flujo de salida de información
				PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);
				// Si el número es par.
				if(numero % 2 == 0) {
					//Convierte el entero a String para guardar en un fichero
					String mensaje = String.valueOf(numero);
					//Guarda en el fichero
					try(BufferedWriter escritor = new BufferedWriter(new FileWriter(file, true))){
						escritor.write(mensaje +"\n");
					}
					
					// Mensaje para mostrar en la consola del servidor
				    //System.out.println("El número " + numero + " se ha guardado en el fichero");
				    
					// Usa el flujo de salida para avisar que se ha guardado
					salida.println("El número "+numero+" se ha guardado en el fichero");
					
					//Si no, notifica que es impar y que no se guardará.
				}else{
					salida.println("El número "+numero+" no se guardará en el fichero");		
				}
				socket_cliente.close();
				//Cierra el socket del cliente
			}
	}catch(IOException e) {
			e.printStackTrace();

	}
	}

}
