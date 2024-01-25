import javax.swing.JOptionPane;

public class CompruebaMailBucleFor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Contempla que si tiene más de una arroba el mail es incorrecto y que al menos tenga un punto.
		
		String mail;
		int arroba=0;
		boolean punto=false;
		
		mail=JOptionPane.showInputDialog("Introduce mail");
		
		for(int i=0; i<mail.length(); i++){
		
			if(mail.charAt(i)=='@') {
				
				arroba++;
			}
			
			if(mail.charAt(i)=='.'){
				punto=true;
			}
		}
		
		if(arroba==1 && punto==true){
			System.out.println("Es correcto");
			
		}
		else{
			System.out.println("No es correcto");
		}
		
	}
	
}
