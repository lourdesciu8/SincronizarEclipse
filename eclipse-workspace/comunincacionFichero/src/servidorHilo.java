//package comunicacionFichero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class servidorHilo extends Thread {
    private Socket sc;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    
    public servidorHilo(Socket sc, DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.sc = sc;
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }
    
    public void run() {
        int opcion;
        //Añadir que si no existe el txt, que se cree
        File f = new File("numeros.txt");
        boolean salir = false;
        while (!salir) {
            try {
                opcion = in.readInt();
                switch (opcion) {
                    case 1:
                        int numeroAleatorio = in.readInt();
                        out.writeUTF("Numero guardado");
                        escribirNumeroAleatorio(f, numeroAleatorio);
                        break;
                    case 2:
                        int numLineas = numeroLineasFichero(f);
                        out.writeInt(numLineas);
                        break;
                    case 3:
                        ArrayList<Integer> numeros = listaNumeros(f);
                        out.writeInt(numeros.size());
                        for (int n : numeros) {
                            out.writeInt(n);
                        }
                        break;
                    case 4:
                        // Caso 4: Enviar el número de líneas del archivo correspondientes al cliente
                        int numLineasCliente = numeroLineasFicheroCliente(f);
                        out.writeInt(numLineasCliente);
                        break;
                    case 5:
                        // Caso 5: Enviar el contenido del archivo correspondiente al cliente
                        byte[] contenidoFichero = ficheroNumeroCliente(f);
                        // Primero se envía la longitud del contenido
                        out.writeInt(contenidoFichero.length);
                        // Luego se envía el contenido byte a byte
                        for (int i = 0; i < contenidoFichero.length; i++) {
                            out.writeByte(contenidoFichero[i]);
                        }
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        out.writeUTF("Solo numeros del 1 al 6");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Conexion cerrada con el cliente " + nombreCliente);
    }
    
    /**
     * Escribe el número y el nombre del cliente en el fichero. 
     * Antes de escribir, se verifica si el fichero no termina en salto de línea,
     * para evitar que el nuevo registro se una a la línea anterior.
     */
    public void escribirNumeroAleatorio(File f, int numero) {
        try {
            // Si el fichero existe y no está vacío, se comprueba el último carácter
            if (f.exists() && f.length() > 0) {
                try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
                    raf.seek(f.length() - 1);
                    int lastByte = raf.read();
                    // Si el último carácter no es un salto de línea, se añade uno
                    if (lastByte != '\n') {
                        try (FileWriter fw = new FileWriter(f, true)) {
                            fw.write("\n");
                        }
                    }
                }
            }
            // Se escribe el nuevo registro (número:cliente) y se añade un salto de línea
            try (FileWriter fw = new FileWriter(f, true)) {
                fw.write(numero + ":" + nombreCliente + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Uso de try-with-resources para manejo automático de BufferedReader en numeroLineasFichero:
    //  maneja NumberFormatException e imprime un mensaje de error si una línea no puede convertirse en número.
    public int numeroLineasFichero(File f) throws IOException {
        int numLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while (br.readLine() != null) {
                numLineas++;
            }
        }
        return numLineas;
    }
    //Verificación de la longitud del array partes antes de acceder a los índices en listaNumeros:
    //verifica si partes.length >= 1 o partes.length >= 2 antes de acceder a los índices
    public ArrayList<Integer> listaNumeros(File f) throws IOException {
        ArrayList<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 1) {
                    try {
                        int numero = Integer.parseInt(partes[0].trim());
                        numeros.add(numero);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear el número en la línea: " + linea);
                    }
                }
            }
        }
        return numeros;
    }
    //Verificación de la longitud de partes en numeroLineasFicheroCliente:
    //usa try-with-resources para cerrar automáticamente los archivos.
    public int numeroLineasFicheroCliente(File f) throws IOException {
        int numLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 2 && partes[1].trim().equals(nombreCliente.trim())) {
                    numLineas++;
                }
            }
        }
        return numLineas;
    }
    //Uso de getBytes(StandardCharsets.UTF_8) en ficheroNumeroCliente para asegurar la codificación correcta en lugar de getBytes():


    public byte[] ficheroNumeroCliente(File f) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 2 && partes[1].trim().equals(nombreCliente.trim())) {
                    contenido.append(linea).append("\n");
                }
            }
        }
        return contenido.toString().getBytes(StandardCharsets.UTF_8);
    }
}
