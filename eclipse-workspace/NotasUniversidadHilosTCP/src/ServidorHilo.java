import java.io.*;
import java.net.Socket;
import java.util.*;

//Gestiona la comunicación con un cliente específico en un hilo separado.
import java.io.*;
import java.net.Socket;
import java.util.*;

// Gestiona la comunicación con un cliente específico en un hilo separado.
public class ServidorHilo extends Thread {
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;

    public ServidorHilo(Socket clientSocket, DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.clientSocket = clientSocket;
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {
        try {
            // El fichero donde se almacenarán las notas
            File archivoNotas = new File("notas.txt");

            // Comprobamos si el archivo no existe y lo creamos si es necesario
            if (!archivoNotas.exists()) {
                try {
                    archivoNotas.createNewFile();  // Crea el archivo si no existe
                    System.out.println("Archivo notas.txt creado.");
                } catch (IOException e) {
                    System.out.println("Error al crear el archivo notas.txt.");
                    e.printStackTrace();
                }
            }
            
            // Mostramos el nombre recibido (del constructor)
            System.out.println("Nombre del cliente : " + nombreCliente);

            // Bucle para gestionar las opciones del cliente
            boolean salir = false;
            while (!salir) {
                // Se espera que el cliente envíe una opción (int)
                int opcion = in.readInt();
                System.out.println("Opción recibida del cliente: " + opcion);
                switch (opcion) {
                    case 1:
                        // Insertar nota
                        insertarNota(archivoNotas);
                        break;
                    case 2:
                        // Modificar nota
                        modificarNota(archivoNotas);
                        break;
                    case 3:
                        // Consultar nota
                        consultarNota(archivoNotas);
                        break;
                    case 4:
                        // Eliminar nota
                        eliminarNota(archivoNotas);
                        break;
                    case 5:
                        // Salir: enviamos confirmación y salimos
                        out.writeUTF("Desconectado.");
                        salir = true;
                        break;
                    default:
                        out.writeUTF("Opción no válida.");
                        break;
                }
            }
            clientSocket.close(); // Cerramos la conexión con el cliente
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar una nueva nota
    private void insertarNota(File archivoNotas) throws IOException {
        // Comprobamos si ya existe una nota para el cliente
        BufferedReader reader = new BufferedReader(new FileReader(archivoNotas));
        String linea;
        boolean existe = false;
        
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(":");
            if (partes[0].equals(nombreCliente)) {
                existe = true;
                break;
            }
        }
        reader.close();
        
        if (existe) {
            out.writeUTF("El usuario ya tiene una nota registrada.");
        } else {
            // Paso 1: Enviar mensaje pidiendo la nota al cliente
            out.writeUTF("Introduce la nota a insertar:");
            // Paso 2: Esperar y leer la nota
            int nota = in.readInt();
            // Paso 3: Insertar la nota en el archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas, true));
            writer.write(nombreCliente + ":" + nota + "\n");
            writer.close();
            // Paso 4: Enviar confirmación
            out.writeUTF("Nota insertada correctamente.");
        }
    }

    // Método para modificar una nota
    private void modificarNota(File archivoNotas) throws IOException {
        // Enviar mensaje solicitando nueva nota para modificar
        out.writeUTF("Introduce la nueva nota:");
        int nuevaNota = in.readInt();
        
        // Comprobamos si el cliente tiene una nota
        BufferedReader reader = new BufferedReader(new FileReader(archivoNotas));
        StringBuilder contenido = new StringBuilder();
        String linea;
        boolean existe = false;
        
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(":");
            if (partes[0].equals(nombreCliente)) {
                existe = true;
                // Reemplazamos la nota antigua por la nueva
                contenido.append(partes[0] + ":" + nuevaNota + "\n");
            } else {
                contenido.append(linea + "\n");
            }
        }
        reader.close();
        
        if (!existe) {
            out.writeUTF("El usuario no tiene ninguna nota para modificar.");
        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas));
            writer.write(contenido.toString());
            writer.close();
            out.writeUTF("Nota modificada correctamente.");
        }
    }

    // Método para consultar una nota
    private void consultarNota(File archivoNotas) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivoNotas));
        String linea;
        boolean encontrado = false;
        
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(":");
            if (partes[0].equals(nombreCliente)) {
                out.writeUTF("Nota del estudiante " + nombreCliente + ": " + partes[1]);
                encontrado = true;
                break;
            }
        }
        reader.close();
        
        if (!encontrado) {
            out.writeUTF("El usuario no tiene ninguna nota.");
        }
    }

    // Método para eliminar una nota
    private void eliminarNota(File archivoNotas) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivoNotas));
        StringBuilder contenido = new StringBuilder();
        String linea;
        boolean existe = false;
        
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(":");
            if (partes[0].equals(nombreCliente)) {
                existe = true;
            } else {
                contenido.append(linea + "\n");
            }
        }
        reader.close();
        
        if (!existe) {
            out.writeUTF("El usuario no tiene ninguna nota para eliminar.");
        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNotas));
            writer.write(contenido.toString());
            writer.close();
            out.writeUTF("Nota eliminada correctamente.");
        }
    }
}
