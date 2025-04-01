package ParImparFichero;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ParImparFichero {
    public static void main(String[] args) {
    	
        final int PUERTO = 5000;

        // inicio el Hilo del servidor
        Thread servidor = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
                System.out.println("Servidor conectandose :) ");

                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String nombre = in.readUTF();
                int numero = in.readInt();

                File archivo = new File("datos.txt");
                //si no existe el archivo lo creamos
                if (!archivo.exists()) {
                    archivo.createNewFile();
                }

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                    if (numero % 2 == 0) {
                        bw.write(nombre + " - " + numero);
                        System.out.println("Dato escrito en el archivo.");
                        System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());
                    } else {
                        //bw.write(String.valueOf(numero));
                    	System.out.println("El número no se guardará en el fichero");
                    }
                    bw.newLine();
                }

                in.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Hilo cliente
        Thread cliente = new Thread(() -> {
            try {
                // Esperar un poco para que el servidor arranque
                Thread.sleep(1000);

                Socket socket = new Socket("localhost", PUERTO);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);

                System.out.print("Ingresa tu nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingresa un número: ");
                int numero = sc.nextInt();

                out.writeUTF(nombre);
                out.writeInt(numero);
                

                out.close();
                socket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Iniciamos ambos hilos
        servidor.start();
        cliente.start();

        try {
            servidor.join();
            cliente.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado.");
       
    }
}
