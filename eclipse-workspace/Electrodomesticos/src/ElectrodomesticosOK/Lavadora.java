package ElectrodomesticosOK;

public class Lavadora extends Electrodomestico {
	protected int carga;
	protected final int CARGA = 5;
	
	public Lavadora(int carga) {
		super();
		this.carga = carga;
		precioFinal();
	}
	
	public Lavadora() {
		super();
		carga = CARGA;
		precioFinal();
	}

	public Lavadora(double _precioBase, double _peso) {
		super(_precioBase, _peso);
		carga = CARGA;
		precioFinal();
	}

	public Lavadora(double _precioBase, double _peso, String _color, char _consumoEnergetico, int carga) {
		super(_precioBase, _peso, _color, _consumoEnergetico);
		this.carga = carga;
		comprobarColor(_color);
		comprobarConsumoEnergetico(_consumoEnergetico);
		precioFinal();
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	protected void precioFinal() {
		if(carga>30) {
			precioBase += 50;
		}	
	}
	
	
}
