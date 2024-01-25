import java.util.Scanner;

public class ActividadEvaluableTrimestre1 {

	public static void main(String[] args) {

		//Calcular el área y el perímetro de un círculo, cuadrado, rectángulo y triángulo. 
		/*El usuario puede elegir qué figura quiere e introducir los valores necesarios
		/*para que se muestren los resultados. La aplicación  termina cuando el usuario lo indique.
		*/
        int opcion, radio, ladoCuadrado, baseRectangulo, alturaRectangulo, baseTriangulo, alturaTriangulo, lado1, lado2;
        Scanner sc=new Scanner (System.in);
        
        while (true) {
        	System.out.println("Elija una figura (1-4): ");
            System.out.println("\n1: Círculo \n2: Cuadrado \n3: Rectángulo \n4: Triángulo");
            opcion=sc.nextInt();
            if (opcion>=5) {
                System.out.println("¡Hasta luego!");
               break;
        }
        
        switch (opcion) {
        case 1:
            System.out.print("Ingrese el radio del círculo: ");
            radio=sc.nextInt();
            System.out.println("El area del círculo es " + Math.PI*(Math.pow(radio, 2)));
            System.out.println("El perímetro del círculo es " + Math.PI*(radio*2));
            break;
        
        case 2:
            System.out.print("Ingrese el lado del cuadrado: ");
            ladoCuadrado=sc.nextInt();
            System.out.println("El area del cuadrado es " +Math.pow(ladoCuadrado, 2));
            System.out.println("El perímetro del círculo es " + (4*ladoCuadrado));
            break;
        
        case 3:
            System.out.print("Ingrese la base del rectángulo: ");
            baseRectangulo=sc.nextInt();
            System.out.print("Ingresa la altura del rectángulo: ");
            alturaRectangulo=sc.nextInt();
            System.out.println("El area del rectángulo es " +baseRectangulo*alturaRectangulo);
            System.out.println("El perímetro del rectángulo es " + (2*baseRectangulo+2*alturaRectangulo));
            break;
		
        case 4:
        	System.out.print("Ingrese la base del triángulo: ");
            baseTriangulo=sc.nextInt();
            System.out.print("Ingresa la altura del triángulo: ");
            alturaTriangulo=sc.nextInt();
            System.out.print("Ingresa el primer lado del triángulo: ");
            lado1=sc.nextInt();
            System.out.print("Ingresa el segundo lado del triángulo: ");
            lado2=sc.nextInt();
            System.out.println("El area del triángulo es " +(baseTriangulo*alturaTriangulo)/2);
            System.out.println("El perímetro del triángulo es " + (baseTriangulo+lado1+lado2));
            break;
        
        	}
        }

	}
}
