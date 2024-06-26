import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class prueba {

	@Test
	public void testRetirar() {
		//Mi saldo inicial es 1500 y le estoy pidiendo retirar 500 euros
		CuentaBanco cuenta=new CuentaBanco(1500, "abc123");
		int resultado= cuenta.retirar(500, "abc123");
		assertEquals(1000,resultado);
	}
	
	@Test
	public void testPasswordCoorecta() {
		//Compruebo que la password es correcta
		CuentaBanco cuenta=new CuentaBanco(1500, "abc123");
		boolean resultado= cuenta.passwordCorrecta("abc123");
		assertTrue(resultado);
	}

}
