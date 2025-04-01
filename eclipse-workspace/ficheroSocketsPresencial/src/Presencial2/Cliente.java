package Presencial2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		String direccion = "localhost";
		int puerto = 8000;
	
		//Crear socket 
		try(Socket socket = new Socket(direccion, puerto)){
		 
			//Petición de número
			Scanner sc = new Scanner(System.in);
			System.out.println("Escribe un número");
			int numero = sc.nextInt();
			
			//Abre flujo de salida para enviar el número al Servidor
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				salida.println(numero);
						System.out.println("Cliente: Número introducido "+numero);
				
						//Abre flujo de entrada para recibir respuesta del servidor
				BufferedReader entrada= new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String linea_entrada = entrada.readLine();
					System.out.println("Mensaje recibido del servidor: "+linea_entrada);
				sc.close();
			 
			}catch(IOException e) {
				e.printStackTrace();

		}

	}

}
