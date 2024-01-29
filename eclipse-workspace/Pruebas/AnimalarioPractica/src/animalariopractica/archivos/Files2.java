/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica.archivos;

/**
 *
 * @author dayannakatherine
 */
import animalariopractica.*;
import animalariopractica.auxiliar.InputOutput;
import animalariopractica.exceptions.*;
import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author lucia
 */
public class Files2 {

    public String path;

    public Files2(String path) {
        this.path = "";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //cargar la info del que existe
    public static File OpenFile() throws NoSpaceException, ExceptionPoblacion, PesoException, IncorrectCromosome, MalformedFileException {
        System.out.println("Introduce el nombre del fichero: ");
        String path = InputOutput.getString("path: ");
        File fichero = new File(path); 
        if (fichero.exists()) {

            try {
                //flujos de datos
                FileInputStream fich = new FileInputStream(fichero);   //fichero
                InputStreamReader isR = new InputStreamReader(fich);   //texto
                BufferedReader bR = new BufferedReader(isR);   //consola

                String lineaTexto = bR.readLine();

                String[] bloque = lineaTexto.split(",");  //parte la linea de texto y crea un array de String con distintos los elementos
                PoblacionRatones poblacion = new PoblacionRatones(bloque[0], bloque[1], Integer.parseInt(bloque[2]), Integer.parseInt(bloque[3]));
                while (lineaTexto != null) {
                    bloque = lineaTexto.split(",");
                    //LocalDate nacimiento = LocalDate.of(Integer.parseInt(bloque[1]), Integer.parseInt(bloque[2]), Integer.parseInt(bloque[3]));
                    int codigoRaton;
                    try {
                        codigoRaton = Integer.parseInt(bloque[0]);
                    } catch (NumberFormatException nfe) {
                        throw new MalformedFileException("Hay ratones con codigo que no son un entero");
                    }

                    LocalDate fecha = null;
                    try {
                        fecha = LocalDate.of(Integer.parseInt(bloque[1]), Integer.parseInt(bloque[2]), Integer.parseInt(bloque[3]));

                    } catch (DateTimeException ex) {
                        System.out.println("la fecha no es correcta");
                    }

                    int peso;
                    try {
                        peso = Integer.parseInt(bloque[2]);
                    } catch (NumberFormatException nfe) {
                        throw new MalformedFileException("El peso no es un entero");
                    }

                    Sexo sexo = null;
                    try {
                        sexo = Sexo.valueOf(bloque[3]);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("No se encuentra en la enumeracion.");
                    }

                    float temp;
                    try {
                        temp = Float.parseFloat(bloque[4]);
                    } catch (NumberFormatException nfe) {
                        throw new MalformedFileException("La temperatura no es un real");
                    }

                    Raton mouse = new Raton(codigoRaton, fecha, peso, sexo, temp, bloque[5],
                            Cromosoma.valueOf(bloque[6]), Cromosoma.valueOf(bloque[7]));// codigo, peso, sexo,  temperatura, comentario

                    poblacion.addRaton(mouse);
                } 
                return fichero;
            } catch (IOException ex) {
                System.out.println("error, el archivo no existe");
                ex.printStackTrace();
            } 
        }
        return null;  // "else"
    }

    public static void SaveFile(PoblacionRatones poblacion) throws NoSpaceException, ExceptionPoblacion, PesoException, IncorrectCromosome, MalformedFileException {

        File fichero = OpenFile();
        String contenido;
        if (fichero.exists()) {

            try {
                //declaramos los flujos de datos
               /*FileInputStream fich = new FileInputStream(fichero);   //fichero
                InputStreamReader isR = new InputStreamReader(fich);   //texto
                BufferedReader bR = new BufferedReader(isR);   //consola */
                PrintWriter pw = new PrintWriter(fichero);

                contenido = "\n " + poblacion.getNombre() + "," + poblacion.getResponsable() + "," + poblacion.getNumDias() + "\n";
                pw.println(contenido);
                for (int cont = 0; cont < poblacion.getNumRatones(); cont++) {
                    Raton mouse = poblacion.getRatones()[cont];
                    contenido = "\n" + mouse.getCodigo() + "," + mouse.getFecha() + "," + mouse.getPeso() + "," + mouse.getGrados() + "," + mouse.getComentario() + ",";
                    pw.println(contenido);
                }

                pw.close();  //solo guarda el archivo si hay informacion dentro
                System.out.println("el archivo se ha guardado correctamente");

            } catch (IOException ex) {
                System.out.println("error al guardar");
                ex.printStackTrace();
            }

        }
    }

    public static void SaveFileAs(PoblacionRatones poblacion) {
        System.out.println("Introduce el nombre del fichero en el que desea guardar los datos: ");
        String nombrefich = InputOutput.getString("path: ");
        String contenido;
        File fichero = new File(nombrefich);

        if (fichero.exists()) {
            fichero.delete();   //borramos el que existia para poder crear uno nuevo
        }
        try {
       
            PrintWriter pw = new PrintWriter(fichero); 

            contenido = "\n " + poblacion.getNombre() + "," + poblacion.getResponsable() + "," + poblacion.getNumDias() + "," + poblacion.getNumRatones() + "\n";
            pw.println(contenido);

            for (int cont = 0; cont < poblacion.getNumRatones(); cont++) {
                Raton mouse = poblacion.getRatones()[cont];
                contenido = "\n" + mouse.getCodigo() + "," + mouse.getFecha() + "," + mouse.getPeso() + "," + mouse.getGrados() + "," + mouse.getComentario() + ",";
                pw.println(contenido);
            }

            pw.close();  //solo guarda el archivo si hay informacion dentro
            System.out.println("el archivo se ha guardado correctamente");

        } catch (IOException ex) {
            System.out.println("error al guardar");
            ex.printStackTrace();
        }
    }
}
