package BibiliotecaSimulacro;

class Revista extends Articulo {
    private String mesAnio;

    public Revista(String titulo, String mesAnio) {
        super(titulo);
        this.mesAnio = mesAnio;
    }

    @Override
    public String toString() {
        return "Revista: " + titulo + " - Mes y Año: " + mesAnio;
    }
}
