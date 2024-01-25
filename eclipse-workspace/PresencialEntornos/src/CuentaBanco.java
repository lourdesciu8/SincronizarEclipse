public class CuentaBanco {

	private int saldo;
	private String password;
	
	public CuentaBanco(int saldoInicial, String password) {
	
		this.saldo=saldoInicial;
		this.password=password;
	}	
	
	//Método para retirar dinero
	public int retirar(int cantidad, String pass) {
		//if (password.equals(pass)){
		if (passwordCorrecta (pass)) {
			if(saldo>=cantidad) {
				saldo=saldo-cantidad; 
				return saldo;
			}else 
				return -1;
			}else 
				return -2;
	}
	
	//Método para comprobar que la contraseña sea correcta
	public boolean passwordCorrecta (String pass) {
		return password.equals(pass);
		
	}
}
