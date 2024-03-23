package BibiliotecaSimulacro;

class Pelicula extends Articulo {
    private String director;
    private int anoPublicacion;

    public Pelicula(String titulo, String director, int anoPublicacion) {
        super(titulo);
        this.director = director;
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public String toString() {
        return "Película: " + titulo + " - Director: " + director + " - Año de Publicación: " + anoPublicacion;
    }
}