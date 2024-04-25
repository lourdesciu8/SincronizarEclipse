package BibiliotecaSimulacro;

class Libro extends Articulo {
    private String autor;
    private int anoPublicacion;

    public Libro(String titulo, String autor, int anoPublicacion) {
        super(titulo);
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " - Autor: " + autor + " - Año de Publicación: " + anoPublicacion;
    }
}
