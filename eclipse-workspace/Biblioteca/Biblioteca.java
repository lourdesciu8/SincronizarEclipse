package BibiliotecaSimulacro;

import java.util.ArrayList;


public class Biblioteca {
	private ArrayList<Usuario> usuariosArray=new ArrayList<>();
    private ArrayList<Articulo> articulosArray=new ArrayList<>();


    public Biblioteca() {
	
	}
    
    public Biblioteca(ArrayList<Usuario> usuarios, ArrayList<Articulo> articulos) {
		this.usuariosArray = usuarios;
		this.articulosArray = articulos;
	}


	public void agregarUsuario(Usuario usuario) {
        usuariosArray.add(usuario);
    }

    public void agregarArticulo(Articulo articulo) {
        articulosArray.add(articulo);
    }

    public Usuario getUsuarioPorNombre(String nombre) {
        for (Usuario usu : usuariosArray) {
            if (usu.getNombre().equals(nombre)) {
                return usu;
            }
        }
        return null;
    }
    
    public Articulo getArticuloPorTitulo(String titulo) {
        for (Articulo art : articulosArray) {
            if (art.getTitulo().equals(titulo)) {
                return art;
            }
        }
        return null;
    }
}