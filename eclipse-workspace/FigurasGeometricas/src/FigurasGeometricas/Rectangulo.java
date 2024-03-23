package FigurasGeometricas;

public class Rectangulo {
String nombre;
double base, altura;

//Constructor con parámetros
public Rectangulo(String nombre, double base, double altura) {
	this.nombre = nombre;
	this.base = base;
	this.altura = altura;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getBase() {
	return base;
}

public void setBase(double base) {
	this.base = base;
}

public double getAltura() {
	return altura;
}

public void setAltura(double altura) {
	this.altura = altura;
}

//Calculamos perímetro
public double calcularPerimetro() {
    return 2 * (base + altura);
}

public String toString() {
    return "Rectángulo nombre=" + nombre + ", base=" + base + ", altura=" + altura + "";
}

}
