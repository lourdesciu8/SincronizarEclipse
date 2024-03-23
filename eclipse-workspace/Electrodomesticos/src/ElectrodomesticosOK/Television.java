package ElectrodomesticosOK;

public class Television extends Electrodomestico{
	 protected double resolucion;
	 protected boolean sintonizadorTdt;
	 
	 protected final double RESOLUCION = 20;
	 protected final boolean SINTONIZADORTDT = false;
	 
	 public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isSintonizadorTdt() {
		return sintonizadorTdt;
	}

	public void setSintonizadorTdt(boolean sintonizadorTdt) {
		this.sintonizadorTdt = sintonizadorTdt;
	}

	public double getRESOLUCION() {
		return RESOLUCION;
	}

	public boolean isSINTONIZADORTDT() {
		return SINTONIZADORTDT;
	}

	public Television() {
		super();
		resolucion = RESOLUCION; 
		sintonizadorTdt = SINTONIZADORTDT;
		precioFinal();
	 }

	public Television(double _precioBase, double _peso) {
		super(_precioBase, _peso);
		resolucion = RESOLUCION; 
		sintonizadorTdt = SINTONIZADORTDT;
		precioFinal();
	}

	public Television(double _precioBase, double _peso, String _color, char _consumoEnergetico, double resolucion,
			boolean sintonizadorTdt) {
		super(_precioBase, _peso, _color, _consumoEnergetico);
		this.resolucion = resolucion;
		this.sintonizadorTdt = sintonizadorTdt;
		comprobarColor(_color);
		comprobarConsumoEnergetico(_consumoEnergetico);
		precioFinal();
	}
	
	public void precioFinal() {
		if(resolucion>40) {
			precioBase *= 1.3;
		}
		if (sintonizadorTdt) {
			precioBase +=50;
		}
	}
}
