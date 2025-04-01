package EdadFichero;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP2 {

	public static void main(String[] args) {
		//Puerto para escuchar al cliente
		final int PUERTO = 1230;

		//socket de datagrama
		try(DatagramSocket socket = new DatagramSocket(PUERTO)){
			//notifica que el servidor esta iniciado
			System.out.println("El servidor ha iniciado");
			//creas el byte para recibir el paquete
			byte[] buffer = new byte[1024];
			
			//crea un fichero para recibir respuesta
			try (FileOutputStream fichero_recibido = new FileOutputStream("fichero_servidor.txt")) {
				
				while(true) { 
					//recibe el paquete de datagrama y recibe en bytes
					DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
					socket.receive(recibido);
					
					//obtiene datos que recibidos  y longitud
					byte[] data = recibido.getData();
					int longitud = recibido.getLength();
					
					//pasa los datos de lo que recibidos en el fichero que ha creado 
					fichero_recibido.write(data, 0, longitud);
					//convierte en String
					String pregunta = new String(data, 0, longitud);
					//notifica
					System.out.println("Cliente: "+pregunta);
					
					//quita los espacios en blancos
					pregunta = pregunta.trim();
					
					//convierte a entero.
					int edad = Integer.parseInt(pregunta);
					
					//prepara el mensaje 
					String mensaje = (edad >= 18)? "Eres mayor de edad" : "Eres menor de edad";
					
					//notifica
					System.out.println("Servidor: "+mensaje);
					
					//convierte el mensaje en bytes para enviar por datagrama 
					byte[] mensajeDelServidor = mensaje.getBytes();
					
					//crea el paquete datagrama obteniendo la dirección y el puerto del paquete que ha recibido
					DatagramPacket enviado = new DatagramPacket(mensajeDelServidor, mensajeDelServidor.length, recibido.getAddress(), recibido.getPort());
					socket.send(enviado);
					
					
					
					

					
					
					
					
					
					
				}
			}
			
			
			
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
