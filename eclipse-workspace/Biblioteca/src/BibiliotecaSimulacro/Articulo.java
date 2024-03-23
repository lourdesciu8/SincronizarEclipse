package BibiliotecaSimulacro;

abstract class Articulo {
    protected String titulo;

    public Articulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
