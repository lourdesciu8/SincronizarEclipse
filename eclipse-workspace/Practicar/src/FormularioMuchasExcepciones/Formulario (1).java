package FormularioMuchasExcepciones;

import java.util.Scanner;

class Formulario{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String dni = "";
        String email = "";
        boolean flagNombre = false;
        boolean flagApellidos = false;
        boolean flagDNI = false;
        boolean flagEmail = false;
        int opcion = 0;

        while (opcion != 5) {
            try {
                System.out.println("Ingrese una opcion:");
                System.out.println("1. Rellenar nombre.");
                System.out.println("2. Rellenar apellidos.");
                System.out.println("3. Rellenar DNI.");
                System.out.println("4. Rellenar e-mail.");
                System.out.println("5. Finalizar");

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce tu nombre: ");
                        nombre = teclado.nextLine();
                        for (int i = 0; i < nombre.length(); i++){
                            if (Character.isDigit(nombre.charAt(i))){
                                throw new TipoDatoIncorrectoException("Excepción: hay algún dígito en el nombre.");
                            }
                        }
                        flagNombre = true;
                        break;
                    case 2:
                        System.out.println("Introduce tus apellidos: ");
                        apellidos = teclado.nextLine();
                        for (int i = 0; i < apellidos.length(); i++){
                            if (Character.isDigit(apellidos.charAt(i))){
                                throw new TipoDatoIncorrectoException("Excepción: hay algún dígito en el apellido.");
                            }
                        }
                        flagApellidos = true;
                        break;
                    case 3:
                        System.out.println("Introduce tu DNI: ");
                        dni = teclado.nextLine();
                        if (dni.length() != 9){
                            throw new LongitudDNINoValidaException("Excepción: Longitud no válida");
                        }
                        if(!Character.isLetter(dni.charAt(8))){
                            throw new UltimoDigitoNoLetraException("Excepción: El último caracter no es una letra");
                        }
                        for (int i = 0; i < 8; i++){
                            if (!Character.isDigit(dni.charAt(i))){
                                throw new NumeracionContieneLetrasException("Excepción: La numeración contiene dígitos no válidos");
                            }
                        }
                        flagDNI = true;
                        break;
                    case 4:
                        System.out.println("Introduce tu mail: ");
                        email = teclado.nextLine();
                        if (!email.contains("@") || !email.contains(".")){
                            throw new EmailIncorrectoException("Excepción: El mail introducido no tiene el formato correcto");
                        }
                        flagEmail = true;
                        break;
                    case 5:
                        if (flagNombre && flagApellidos && flagDNI && flagEmail){
                            System.out.println("Ha introducido todos los datos de forma satisfactoria:");
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Apellidos: " + apellidos);
                            System.out.println("DNI: " + dni);
                            System.out.println("E-mail: " + email);
                        } else {
                            System.out.println("Aún le quedan datos por rellenar.");
                            opcion = 0;
                        }
                        break;
                    default:
                        System.out.println("La opción elegida no está disponible, por favor, elija una opción correccta");
                        break;
                }
            } catch(TipoDatoIncorrectoException e){
                System.out.println(e.getMessage());
            } catch(LongitudDNINoValidaException e){
                System.out.println(e.getMessage());
            } catch(UltimoDigitoNoLetraException e){
                System.out.println(e.getMessage());
            } catch(NumeracionContieneLetrasException e){
                System.out.println(e.getMessage());
            } catch(EmailIncorrectoException e){
                System.out.println(e.getMessage());
            }
        }
        teclado.close();
    }        
}

