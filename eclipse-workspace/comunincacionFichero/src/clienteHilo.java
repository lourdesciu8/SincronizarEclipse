//package comunicacionFichero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class clienteHilo extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner sn;
    
    public clienteHilo(DataInputStream in, DataOutputStream out) {
        super();
        this.in = in;
        this.out = out;
        //Uso de Scanner como variable de instancia en la nueva versión en lugar de declararlo dentro de run().
        this.sn = new Scanner(System.in);
    }
    
    public void run() {
        String mensaje;
        int opcion;
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("1. Almacenar numero en el archivo");
                System.out.println("2. Numeros almacenados hasta el momento");
                System.out.println("3. Lista de numeros almacenados");
                System.out.println("4. El numero de numeros almacenados por el cliente");
                System.out.println("5. Archivo con numeros del cliente");
                System.out.println("6. Salir");
                //Mensaje adicional "Elige una opción:" para mejorar la interacción con el usuario.
                System.out.print("Elige una opción: ");
                opcion = sn.nextInt();
                //Consumo del salto de línea con sn.nextLine(); después de leer la opción del usuario.
                sn.nextLine(); 
                out.writeInt(opcion);
                switch(opcion) {
                    case 1:
                        int numeroAleatorio = generarNumeroAleatorio(0, 100);
                        System.out.println("Numero generado: " + numeroAleatorio);
                        out.writeInt(numeroAleatorio);
                        mensaje = in.readUTF();
                        System.out.println(mensaje);
                        //Inclusión del método pausa() en la nueva versión para detener la ejecución y esperar la interacción del usuario.
                        pausa();
                        break;
                    case 2:
                        int numLineas = in.readInt();
                        System.out.println("Hay " + numLineas + " numeros");
                        //Inclusión del método pausa() en la nueva versión para detener la ejecución y esperar la interacción del usuario.
                        pausa();
                        break;
                    case 3:
                        int limite = in.readInt();
                        System.out.println("Lista de numeros almacenados:");
                        for (int i = 0; i < limite; i++) {
                            System.out.println(in.readInt());
                        }
                        //Inclusión del método pausa() en la nueva versión para detener la ejecución y esperar la interacción del usuario.
                        pausa();
                        break;
                    case 4:
                        int numLineasCliente = in.readInt();
                        System.out.println("Hay " + numLineasCliente + " numeros de este cliente");
                        pausa();
                        break;
                    case 5:
                        int limiteFichero = in.readInt();
                        byte[] contenidoFichero = new byte[limiteFichero];
                        for (int i = 0; i < limiteFichero; i++) {
                            contenidoFichero[i] = in.readByte();
                        }
                        String contenido = new String(contenidoFichero);
                        try (FileWriter fw = new FileWriter("numeros_cliente.txt")) {
                            fw.write(contenido);
                        }
                        //Mensaje de confirmación al actualizar el archivo "El archivo 'numeros_cliente.txt' ha sido actualizado."
                        System.out.println("El archivo 'numeros_cliente.txt' ha sido actualizado.");
                        //Inclusión del método pausa() en la nueva versión para detener la ejecución y esperar la interacción del usuario.
                        pausa();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        mensaje = in.readUTF();
                        System.out.println(mensaje);
                        //Inclusión del método pausa() en la nueva versión para detener la ejecución y esperar la interacción del usuario.
                        pausa();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public int generarNumeroAleatorio(int minimo, int maximo) {
        int num = (int)Math.floor(Math.random() * (maximo - minimo) + minimo);
        return num;
    }
    
    /**
     * Método para pausar la ejecución y permitir al usuario leer la respuesta
     */
    private void pausa() {
        System.out.println("Presione ENTER para continuar...");
        sn.nextLine();
    }
}
