package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max=0;
        int numero;
        int count = 1;

        do {
            try {
                System.out.print("Introduce el número " + count + ": ");
                numero = sc.nextInt();
                if (count == 1 || numero > max) {
                    max = numero;
                }
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Error, se debe introducir un número entero.");
                sc.next();
            }
        } while (count <7);

        System.out.println("El número máximo es igual a : " + max);
    }
}
