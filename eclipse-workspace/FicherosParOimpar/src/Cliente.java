import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 8000;
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            // Menú 
            System.out.println("Menú de opciones: ");
            System.out.println("1. Introduce un número positivo");
            System.out.println("2. Mostrar los números pares almacenados en pares.txt");
            System.out.println("3. Mostrar los números impares almacenados en impares.txt");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduce un número positivo: ");
                    String numero = sc.nextLine();

                    try (Socket socket = new Socket(host, puerto);
                         PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                        salida.println("1");         // Opción 1 para enviar número
                        salida.println(numero);      // Enviar el número al servidor
                        String respuesta = entrada.readLine();
                        System.out.println("Servidor: " + respuesta);

                    } catch (IOException e) {
                        System.out.println("Error al conectar con el servidor: " + e.getMessage());
                    }
                    break;

                case "2":
                    try (Socket socket = new Socket(host, puerto);
                         PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                        salida.println("2"); // Opción para ver pares
                        String linea;
                        while ((linea = entrada.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        System.out.println("Error al conectar con el servidor: " + e.getMessage());
                    }
                    break;

                case "3":
                    try (Socket socket = new Socket(host, puerto);
                         PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                        salida.println("3"); // Opción para ver impares
                        String linea;
                        while ((linea = entrada.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        System.out.println("Error al conectar con el servidor: " + e.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!opcion.equals("4"));

        sc.close();
    }
}
