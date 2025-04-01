package EdadFichero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ClienteUDP2 {

	public static void main(String[] args) {
		final String HOST_SERVIDOR = "localhost";
		final int PUERTO = 1234;
		String fichero = "ficheroUDP.txt";
		
		//socket por datagrama 
		try(DatagramSocket socket = new DatagramSocket()){
			
			//pides que introduzca la edad
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce edad");
		int edad = sc.nextInt();
		
		// introduces la edad en el fichero 
		PrintWriter salida = new PrintWriter(new FileWriter(fichero));
		//escribe en el fichero
		salida.println(edad);
		//se asegura que guarde correctamente
		salida.flush();
		//cierra el flujo
		salida.close();
		
		// conviertes el fichero en bytes 
		byte[] buffer = Files.readAllBytes(Paths.get(fichero));
		//obtienes la dirección ip del servidor
		InetAddress direccion_servidor = InetAddress.getByName(HOST_SERVIDOR);
		
		//datagrama de paquete envia el buffer que es fichero convertido en bytes, host por donde va a conectar y el puerto
		DatagramPacket envioAservidor = new DatagramPacket(buffer, buffer.length, direccion_servidor, PUERTO);
		socket.send(envioAservidor);
		
		//recibe la respuesta del servidor y la recibe bytes
		byte[] bufferRespuesta = new byte[1024];
		//paquete que recibe el ciente
		DatagramPacket recibidoDservidor = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
		socket.receive(recibidoDservidor);
		//convierte en String la información enviada en bytes
		String respuesta = new String(recibidoDservidor.getData(), 0, recibidoDservidor.getLength());
		System.out.println("Servidor: "+respuesta);

		sc.close();	
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
