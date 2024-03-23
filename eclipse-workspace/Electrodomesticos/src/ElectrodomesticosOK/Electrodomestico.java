package ElectrodomesticosOK;

public abstract class Electrodomestico {
	protected double precioBase, peso;
	protected String color;
	protected char consumoEnergetico;
	
	private final double PRECIOBASE=100, PESO=5;
	protected final String COLOR="blanco";
	protected char CONSUMOENERGETICO='F';
	
	protected Electrodomestico() {
		precioBase = PRECIOBASE;
		peso=PESO;
		color=COLOR;
		consumoEnergetico=CONSUMOENERGETICO;
		precioFinal(peso, consumoEnergetico);
	}
	public Electrodomestico(double _precioBase, double _peso) {
		this.precioBase = _precioBase;
		this.peso = _peso;
		comprobarColor(color);
		consumoEnergetico=CONSUMOENERGETICO;
		precioFinal(peso, consumoEnergetico);
	}
	public Electrodomestico(double _precioBase, double _peso, String _color, char _consumoEnergetico) {
		this.precioBase = _precioBase;
		this.peso = _peso;
		comprobarColor(_color.toLowerCase());
		comprobarConsumoEnergetico(_consumoEnergetico);
		precioFinal(_peso, _consumoEnergetico);
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double _precioBase) {
		this.precioBase = _precioBase;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double _peso) {
		this.peso = _peso;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String _color) {
		this.color = _color;
	}
	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}
	public void setConsumoEnergetico(char _consumoEnergetico) {
		this.consumoEnergetico = _consumoEnergetico;
	}
	
	protected void comprobarConsumoEnergetico(char letra) {
		switch(letra) {
			case 'A': 
				consumoEnergetico = 'A';
				break;
			case 'B': 
				consumoEnergetico = 'B';
				break;
			case 'C': 
				consumoEnergetico = 'C';
				break;
			case 'D': 
				consumoEnergetico = 'D';
				break;
			case 'E': 
				consumoEnergetico = 'E';
				break;
			case 'F': 
				consumoEnergetico = 'F';
				break;
			default: 
				consumoEnergetico = CONSUMOENERGETICO;
				break;
		}
	}
	
	public void comprobarColor(String color) {
		switch(color) {
			case "blanco": 
				color = "blanco";
				break;
			case "negro": 
				color = "negro";
				break;
			case "rojo": 
				color = "rojo";
				break;
			case "azul": 
				color = "azul";
				break;
			case "gris": 
				color = "gris";
				break;
			default: 
				color = COLOR;
				break;
		}
	}
	
	protected void precioFinal (double peso, char letra) {
		switch(letra) {
		case 'A': 
			precioBase += 100;
			break;
		case 'B': 
			precioBase += 80;
			break;
		case 'C': 
			precioBase += 60;
			break;
		case 'D': 
			precioBase += 50;
			break;
		case 'E': 
			precioBase += 30;
			break;
		case 'F': 
			precioBase += 10;
			break;
		}
		if(peso>0 && peso<=19) {
			precioBase += 10;
		}
		if(peso>=20 && peso<=49) {
			precioBase += 50;
		}
		if(peso>=50 && peso<=79) {
			precioBase += 80;
		}
		if(peso>=80) {
			precioBase += 100;
		}
	}
}
