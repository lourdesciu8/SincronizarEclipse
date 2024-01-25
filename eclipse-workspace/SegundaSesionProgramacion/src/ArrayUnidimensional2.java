import java.util.Scanner;

public class ArrayUnidimensional2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double alturaMedia;
		int N;

        // Pedir al usuario el número de personas (N)
        System.out.print("Ingrese el número de personas (N): ");
        N = sc.nextInt();

        // Validar que N sea un entero positivo
        while (N <= 0) {
            System.out.print("Ingrese un número válido y positivo para N: ");
            N = sc.nextInt();
        }

        // Crear un array para almacenar las alturas
        double array [] = new double[N];
        
        //Leer las alturas de las personas desde el teclado
        System.out.println("Ingrese las alturas de las personas:");

        for (int i = 0; i < array.length; i++) {
            System.out.print("Altura de la persona " + (i + 1) + " (en metros): ");
            array[i] = sc.nextDouble();
        }
        
        //Calcular altura media
        
        double sumaAlturas = 0;
        for(int i=0;i<array.length;i++) {
        	sumaAlturas=sumaAlturas+array[i]; 
        }
        
        alturaMedia=sumaAlturas / N;
        System.out.println("Altura media: " + alturaMedia + " metros");
        
        //Contar cuántas personas tienen altura superior e inferior a la media    
      
        int personasSuperiorMedia = 0;
        int personasInferiorMedia = 0;
           
            for(int i=0;i<array.length;i++) {
            	if(array[i]>alturaMedia) {
                    personasSuperiorMedia++;
                    
                } else if (array[i] < alturaMedia) {
                    personasInferiorMedia++;
                }
          }
            
            System.out.println("Personas con altura superior a la media: " + personasSuperiorMedia);
            System.out.println("Personas con altura inferior a la media: " + personasInferiorMedia);
	}      
}