/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica;

import animalariopractica.archivos.Files2;
import animalariopractica.auxiliar.InputOutput;
import static animalariopractica.auxiliar.InputOutput.getIntInRange;
import animalariopractica.exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucia
 */
public class MenuRatones {

    public static void main(String[] args)  {
         int opcion = 0;
        PoblacionRatones poblacion = null;
        do{

        System.out.println("1. Abrir un archivo de texto plano con extension cvs que contenga una poblacion de ratones. \n"
                + "2. Crear una nueva poblacion de ratones.\n"
                + "3. Anhadir un nuevo raton a una poblacion ya existente.\n"
                + "4. Listar los codigos de referencia de todos los ratones de una poblacion.\n"
                + "5. Eliminar un raton de una poblacion indicando su codigo de referencia.\n"
                + "6. Modificar los datos de un raton, indicando previamente su codigo de referencia.\n"
                + "7. Ver informacion detallada de un raton, habiendo especificado previamente su codigo de referencia.\n"
                + "8. Guardar \n"      //solo si hay un archivo abierto
                + "9. Guardar como.\n" //crear un archivo y guardarlo
                + "0. salir.");
       

        String path = null;
        Files2 fich = new Files2(path);
           opcion = InputOutput.getInt("ESCOGE UNA OPCION:  ");
        switch (opcion) {

            case 1:  //ABRIR UN FICHERO

                try {
                   fich.OpenFile();  //el fichero existia y se ha podido abrir

                } catch (NoSpaceException | ExceptionPoblacion | PesoException | IncorrectCromosome | MalformedFileException ex) {   
                    System.out.println("ERROR");
                    ex.printStackTrace();
                
            
        }
                break;

            case 2: //CREAR UNA NUEVA POBLACION DE RATONES

                poblacion = InputOutput.createPoblacion();
                System.out.println(poblacion.toString());
                break;

            case 3: //AÑADIR UN RATON
                if (poblacion == null) {
                    System.out.println("crea una poblacion");
                } else {
                    try {
                        System.out.println("introduce un raton");
                        Raton r = InputOutput.getMouseFromKeyboard();
                        poblacion.addRaton(r);
                    } catch (NoSpaceException noSpace) {
                        System.out.println(noSpace.getMessage());
                    }
                }

                break;

            case 4:   //LISTA LOS CODIGOS DE LOS RATONES

                if (poblacion == null) {
                    System.out.println("introduce una población");
                } else {
                    
                    for (int i=0; i<poblacion.getNumRatones(); i++) {
                        System.out.println(poblacion.ratones[i].getCodigo());
                    }
                }
                break;

            case 5:   //BORRAR RATONES
                if (poblacion == null) {
                    System.out.println("crea una poblacion");
                } else {
                    try {
                        System.out.println("que raton desea borrar: ");
                        int codigo = InputOutput.getInt("codigo del raton");
                        poblacion.deleteRaton(codigo);
                    } catch (NotFoundException notFound) {
                        System.out.println(notFound.getMessage());
                    }
                }

                break;

            case 6:  //MODIFICAR RATONES

                if (poblacion == null) {
                    System.out.println("crea una poblacion");
                } else {
                    try {
                        System.out.println("que raton desea modificar: ");
                        int nombre = InputOutput.getInt("codigo del raton a modificar");
                        Raton modificado = poblacion.searchRaton(nombre);
                        int codigoR = InputOutput.getInt("nuevo codigo del raton: ");
                        modificado.setCodigo(codigoR);                       
                        int peso = getIntInRange("Peso: ", 0, 60);  
                        modificado.setPeso(peso);
                        float temp = InputOutput.getFloat("nueva temperatura del raton: ");
                        modificado.setGrados(temp);
                        String comentario = InputOutput.getString("nuevo comentario:  ");
                        modificado.setComentario(comentario);
                    } catch (NotFoundException notFound) {
                        System.out.println(notFound.getMessage());
                    }
                }
                break;

            case 7:  //MOSTRAR RATON
                if (poblacion == null) {
                    System.out.println("crea una poblacion");
                } else {
                    try {
                        System.out.println("que raton desea mostrar: ");
                        int identificador = InputOutput.getInt("codigo del raton a mostrar");
                        Raton mostrado = poblacion.searchRaton(identificador);
                        System.out.println(mostrado.toString());
                    } catch (NotFoundException notFound) {
                        System.out.println(notFound.getMessage());
                    }
                }
                break;

            case 8:  //GUARDAR FICHERO
                if (poblacion == null) {
                    System.out.println("la poblacion esta vacia");
                } else {
                   try {
                        fich.SaveFile(poblacion);
                    } catch (NoSpaceException | ExceptionPoblacion| PesoException | IncorrectCromosome| MalformedFileException ex ) {
                        System.out.println("no se ha podido guardar");
                       ex.printStackTrace();
                    }
                }
                break;

            case 9:  //GUARDAR FICHERO COMO
                if (poblacion == null) {
                    System.out.println("la poblacion está vacia");
                } else {

                  fich.SaveFileAs(poblacion);

                }

                break;

        }

    
        }while(opcion!=0); 
    }
}
