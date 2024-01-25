import javax.swing.JOptionPane;

public class CompruebaMailBucleFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Contempla que si tiene una arroba el mail es correcto
		
		String mail;
		boolean arroba=false;
		
		mail=JOptionPane.showInputDialog("Introduce mail");
		
		for(int i=0; i<mail.length(); i++){
		
			if(mail.charAt(i)=='@') {
				
				arroba=true;
			}
		}
		
		if(arroba==true){
			System.out.println("Es correcto");
			
		}
		else{
			System.out.println("No es correcto");
		}
		
	}

}
