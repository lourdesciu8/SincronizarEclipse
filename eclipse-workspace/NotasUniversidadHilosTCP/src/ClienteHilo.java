import java.io.*;
import java.net.*;
import java.util.*;

//Gestiona las opciones del cliente en un hilo.
import java.io.*;
import java.net.*;
import java.util.*;

// Gestiona las opciones del cliente en un hilo.
public class ClienteHilo extends Thread {
    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        
        while (!salir) {
            // Menú de opciones
            System.out.println("1. Insertar nota");
            System.out.println("2. Modificar nota");
            System.out.println("3. Consultar nota");
            System.out.println("4. Eliminar nota");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sn.nextInt();
            
            try {
                // Enviamos la opción al servidor
                out.writeInt(opcion);
                System.out.println("Opción enviada al servidor: " + opcion);  // Mensaje de depuración
                
                // Esperamos y leemos la respuesta del servidor
                String respuestaServidor = in.readUTF(); // Lee la respuesta del servidor
                System.out.println("Respuesta del servidor: " + respuestaServidor); // Muestra la respuesta

                switch (opcion) {
                    case 1:
                        // Caso 1: Insertar nota
                        // El servidor ya envió el mensaje para introducir la nota
                        System.out.println("Introduce la nota a insertar:");
                        int nota = sn.nextInt();  // Leemos la nota
                        out.writeInt(nota);
                        System.out.println("Nota enviada al servidor: " + nota);  // Depuración
                        // Leemos la confirmación del servidor
                        String confirmacion = in.readUTF();
                        System.out.println("Confirmación del servidor: " + confirmacion);
                        break;
                    case 2:
                        // Caso 2: Modificar nota
                        // Se espera que el servidor envíe un mensaje pidiendo la nueva nota
                        System.out.println("Introduce la nueva nota a modificar:");
                        int nuevaNota = sn.nextInt();
                        out.writeInt(nuevaNota);
                        // Leemos la respuesta del servidor
                        String modConfirm = in.readUTF();
                        System.out.println("Confirmación del servidor: " + modConfirm);
                        break;
                    case 3:
                        // Caso 3: Consultar nota
                        // El servidor envía directamente la nota consultada
                        // (Ya se leyó la respuesta inicial antes del switch, por lo que se muestra)
                        break;
                    case 4:
                        // Caso 4: Eliminar nota
                        // Se asume que el servidor elimina y envía confirmación
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
