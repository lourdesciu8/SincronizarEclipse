import java.util.Scanner;

public class VentaTablets {

	public static void main(String[] args) {
		//Desarrollar una aplicación que me permita guardar diferentes tipos de tablets y venderlas a los clientes.
		/*Debes de tener una o varias arrays para guardar las tables que están disponibles para vender y
		realizar las ventas a los clientes. Haz un menú para que el usuario vea las diferentes opciones que puede realizar:

		1.- Dar de alta una tablet.

		2.- Dar de alta un cliente.

		3.- Vender una tablet a un cliente.

		4.- Mostrar tablets disponibles para la venta.

		5.- Mostrar tablets compradas por un cliente en concreto.

		6.- Salir.
		*/
		
		int opcion;
		final int FILAS=100;
		final int COLUMNAS=3;
		boolean tablet=false;
		boolean cliente=false;
		String DNI;
		String referencia;
		Scanner sc = new Scanner(System.in);
		String Ventatablets [][] = new String [FILAS][COLUMNAS];
		String clientes [][] = new String [FILAS][COLUMNAS];
		String clientesCompranTablet[][] = new String [FILAS][COLUMNAS];
		
		do {
			System.out.println("Menu de opciones");
			System.out.println("1.- Dar de alta una tablet");
			System.out.println("2.- Dar de alta un cliente");
			System.out.println("3.- Vender una tablet a un cliente");
			System.out.println("4.- Mostrar tablets disponibles para la venta");
			System.out.println("5.- Mostrar tablets compradas por un cliente en concreto");
			System.out.println("6.- Salir");
			opcion=sc.nextInt();
			
			switch(opcion) {
				case 1: System.out.println("Dime referencia de la tablet");
						referencia=sc.next();
						//Buscamos la tablet en el array
						for (int i=0;i<FILAS;i++) {
							if(Ventatablets[i][0]!=null && Ventatablets[i][0].equals(referencia)) {
								System.out.println("No se puede insertar, ya está guardada la tablet");
								tablet=true;//En caso de encontrarlo
								break;
							}
						}
						//Preguntamos si existe o no dicha tablet
						if(!tablet) {
							for (int i=0;i<FILAS;i++) {
								if(Ventatablets[i][0]==null) {
									Ventatablets[i][0]=referencia;
									System.out.println("Dime la marca");
									Ventatablets[i][1]=sc.next();
									System.out.println("Dime el color");
									Ventatablets[i][2]=sc.next();
									i=FILAS;
								}
							}
						}
						tablet=false;
					break;
				case 2: System.out.println("Dime DNI de cliente");
						DNI=sc.next();
						//Buscamos DNI en el array
						for (int i=0;i<FILAS;i++) {
							if(clientes[i][0]!=null && clientes[i][0].equals(DNI)) {
								System.out.println("No se puede insertar, ya está guardado el DNI");
								cliente=true;//En caso de encontrarlo
								break;
							}
						}
						//Preguntamos si existe o no dicho DNI
						if(!cliente) {
							for (int i=0;i<FILAS;i++) {
								if(clientes[i][0]==null) {
									clientes[i][0]=DNI;
									System.out.println("Dime el nombre");
									clientes[i][1]=sc.next();
									System.out.println("Dime los apellidos");
									clientes[i][2]=sc.next();
									i=FILAS;
								}
							}
						}
						cliente=false;
					break;
						
				//case 3: System.out.println("Dime la matricula");
				/*		matricula=sc.next();
						//Buscamos la matricula en el array
						for (int filas=0;filas<FILAS;filas++) {
							if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
								System.out.println("Dime la matricula nueva");
								vehiculos[filas][0]=sc.next();
								System.out.println("Matricula modificada");
								break;
							}
						}
					break;
					*/
				case 4: 
						for (int i=0;i<FILAS;i++) {
							if(Ventatablets[i][0]!=null) {
								System.out.println("Tablets disponibles para la venta");
								System.out.println("Referencia: "+Ventatablets[i][0]);
								System.out.println("Marca: "+Ventatablets[i][1]);
								System.out.println("Color: "+Ventatablets[i][2]);
							}
						}
				break;
						
			
				case 5: System.out.println("Introduce DNI de cliente");
				DNI=sc.next();
				//Buscamos DNI en el array
				for (int i=0;i<FILAS;i++) {
					if(clientesCompranTablet[i][0]==null) {
						
							clientesCompranTablet[i][0]=DNI;
							System.out.println("Dime la referencia de la tablet comprada por ese cliente");
							referencia=sc.next();
							clientesCompranTablet[i][1]=referencia;
							System.out.println("El cliente con DNI " + clientesCompranTablet[i][0] +" "+ "ha comprado la tablet con referencia " + clientesCompranTablet[i][1]);
							i=FILAS;
						}
					}
				break;	
				
				case 6: System.out.println("SALIR");
					break;
				default: System.out.println("Opcion incorrecta");
			}
		} while(opcion!=6);
		
	}

}
