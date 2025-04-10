import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 8000;

        File ficheroPares = new File("pares.txt");
        File ficheroImpares = new File("impares.txt");

        //Si no existen los ficheros se crean.
        try {
            if (!ficheroPares.exists()) {
            	ficheroPares.createNewFile();
            }
            
            if (!ficheroImpares.exists()) {
            	ficheroImpares.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear los ficheros: " + e.getMessage());
            return;
        }

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println("Cliente conectado");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

                String opcion = entrada.readLine();

                switch (opcion) {
                    case "1":
                        // Recibe el número a enviar
                        int numero = Integer.parseInt(entrada.readLine());
                        if (numero < 0) {
                            salida.println("Por favor, introduce solo números positivos.");
                        } else if (numero % 2 == 0) {
                            // Guardar número par en pares.txt
                            guardarNumero(ficheroPares, numero);
                            salida.println("El número " + numero + " es par y ha sido guardado en pares.txt.");
                        } else {
                            // Guardar número impar en impares.txt
                            guardarNumero(ficheroImpares, numero);
                            salida.println("El número " + numero + " es impar y ha sido guardado en impares.txt.");
                        }
                        break;

                    case "2":
                        // Mostrar contenido del fichero pares.txt
                        salida.println("Números guardados en pares.txt :");
                        enviarContenidoFichero(ficheroPares, salida);
                        break;

                    case "3":
                        // Mostrar contenido del fichero impares.txt
                        salida.println("Números guardados en impares.txt :");
                        enviarContenidoFichero(ficheroImpares, salida);
                        break;

                    default:
                        salida.println("Opción no válida");
                        break;
                }

                socketCliente.close();
                //System.out.println("Cliente desconectado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guarda el número en el fichero indicado
    public static void guardarNumero(File fichero, int numero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {
            bw.write(numero + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el número: " + e.getMessage());
        }
    }

    // Lee el fichero y envía su contenido al cliente
    public static void enviarContenidoFichero(File fichero, PrintWriter salida) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            boolean hayContenido = false;
            while ((linea = br.readLine()) != null) {
                salida.println(linea);
                hayContenido = true;
            }
            if (!hayContenido) {
                salida.println("(fichero vacío)");
            }
        } catch (IOException e) {
            salida.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
