/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica.auxiliar;

import animalariopractica.Cromosoma;
import animalariopractica.PoblacionRatones;
import animalariopractica.Raton;
import animalariopractica.Sexo;
import animalariopractica.exceptions.ExceptionPoblacion;
import animalariopractica.exceptions.PesoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author lucia
 */
public class InputOutput {

    public static String getString(String question) {
        BufferedReader consola;
        consola = new BufferedReader(new InputStreamReader(
                System.in));
        while (true) {
            try {
                System.out.println(question);
                String stringLeido;
                stringLeido = consola.readLine();
                return stringLeido;
            } catch (IOException ex) {
                System.out.println("ERROR");
            }
        }
    }

    public static int getInt(String question) {
        BufferedReader consola;
        int x = 0;
        consola = new BufferedReader(new InputStreamReader(
                System.in));
        while (true) {
            try {
                try {
                    System.out.println(question);
                    String stringLeido;
                    stringLeido = consola.readLine();
                    x = Integer.parseInt(stringLeido);
                    return x;

                } catch (NumberFormatException ex) {
                    System.out.println("Introduce un numero entero");
                }
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
    }

    public static int getIntInRange(String question, int begin, int end) {
        BufferedReader consola;
        int x = 0;
        consola = new BufferedReader(new InputStreamReader(
                System.in));
        boolean t = true;
        while (t) {
            try {
                try {
                    System.out.println(question);
                    String stringLeido;
                    stringLeido = consola.readLine();
                    x = Integer.parseInt(stringLeido);
                    if (x >= begin && x <= end) {
                        return x;
                    } else {
                        System.out.println("Debe introducir un número entre " + begin + " y " + end);
                    }

                } catch (NumberFormatException ex) {
                    t = true;
                    System.out.println("Introduce un numero entero");
                }
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
        return x;
    }

    public static float getFloat(String question) {
        BufferedReader consola;
        consola = new BufferedReader(new InputStreamReader(
                System.in));
        while (true) {
            try {
                System.out.println(question);
                String stringLeido;
                stringLeido = consola.readLine();
                float x;
                x = Float.parseFloat(stringLeido);
                return x;
            } catch (IOException ex) {
                System.out.println("ERROR");
            }
        }
    }

    public static PoblacionRatones createPoblacion() {
        String nombre = InputOutput.getString("Nombre poblacion: ");
        String responsable = InputOutput.getString("Nombre persona: ");
        int numDias;
        do {
            numDias = InputOutput.getInt("Dias de estancia: ");
        } while (numDias < 0 || numDias >= 270);
        int numrat = InputOutput.getInt("Numero Ratones: ");
        try {
            PoblacionRatones nuevapoblacion = new PoblacionRatones(nombre, responsable, numDias, numrat);
            return nuevapoblacion;
        } catch (ExceptionPoblacion noPoblacion) {
            System.out.println(noPoblacion.getMessage());
            return null;
        }
    }

    public static LocalDate getDate() {
        int year, month, day;
        LocalDate nacimiento = null;
        do {
            try {
                year = InputOutput.getInt("anho (YYYY): ");
                month = InputOutput.getInt("mes (1-12): ");
                day = InputOutput.getInt("dia: ");
                nacimiento = LocalDate.of(year, month, day);
            } catch (DateTimeException errorFecha) {
                System.out.println("ingrese fecha valida");
                nacimiento = null;
            }
        } while (nacimiento == null);
        return nacimiento;
    }


    public static Raton getMouseFromKeyboard() {

        Sexo genero = null;
        int codigo = InputOutput.getInt("codigo del raton: ");
        System.out.println(codigo);
        System.out.println("fecha de nacimiento: ");
        LocalDate nacimiento = InputOutput.getDate();
        System.out.println("peso del raton: ");
        int peso = 0;
        peso = getIntInRange("Peso: ", 0, 60);

        String sexo = InputOutput.getString("sexo del raton (hembra / macho) ");
        sexo = sexo.toLowerCase();
        if ("hembra".equals(sexo)) {
            genero = Sexo.HEMBRA;

        }
        if ("macho".equals(sexo)) {
            genero = Sexo.MACHO;

        }

        float temp = InputOutput.getFloat("temperatura del raton: ");
        String comentario = InputOutput.getString("comentario:  ");
        float porcentaje = InputOutput.getFloat("porcentaje de mutacion: ");
        Raton nuevoRaton = null;

        nuevoRaton = new Raton(codigo, nacimiento, peso, genero, temp, comentario, porcentaje);

        return nuevoRaton;
    }

}
