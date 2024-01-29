/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica;

import animalariopractica.exceptions.ExceptionPoblacion;
import animalariopractica.exceptions.NoSpaceException;
import animalariopractica.exceptions.NotFoundException;

/**
 *
 * @author lucia
 */
public class PoblacionRatones {

    private final String nombre;
    private final String responsable;
    private final int numDias;
    protected Raton[] ratones; 
    private int numRatones = 0;
    

    public PoblacionRatones(String nombre, String responsable, int numDias, int numRat) throws ExceptionPoblacion {

        if (numDias < 0 || numDias >= 270) {
            throw new ExceptionPoblacion("el numero de dias introducido no es correcto, no se puede crear la poblacion");
        }
        this.nombre = nombre;
        this.responsable = responsable;
        this.numDias = numDias; 
        this.ratones = new Raton[numRat]; //tamaño del array sera de los ratones que se introduzcan por te clado
        for (int i = 0; i < this.ratones.length; i++) {
            ratones[i] = null;
        }

    }

    public PoblacionRatones() {
        this.nombre = "";
        this.responsable = "";
        this.numDias = 0;
        this.numRatones = 0;
        this.ratones = new Raton[numRatones];

    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public int getNumDias() {
        return numDias;
    }

    public Raton[] getRatones() {  
        return this.ratones;
    }

    public void setRatones(Raton[] ratones) {
        this.ratones = ratones;
    }

    public int getNumRatones() {
        return numRatones;
    }

    public void setNumRatones(int numRatones) {
        this.numRatones = numRatones;
    }
 
    //METODOS
    public void addRaton(Raton r) throws NoSpaceException {
        if (numRatones == this.ratones.length) {
            throw new NoSpaceException("No hay suficiente espacio ");
        } else {
            ratones[numRatones] = r;
            numRatones++;
        }
    }

    public void deleteRaton(int ratonBorrar) throws NotFoundException {
        int i;
        for (i = 0; i < numRatones; i++) {
            if (ratones[i].getCodigo() == ratonBorrar) {
                ratones[i] = null;
            }
            numRatones--;  
        }
            for (int j = i; j < ratones.length-1; j++) {
               ratones[j] = ratones[j+1];        //mueve todo una posicion adelante despues de borrar
                if(j==ratones.length -1){ 
                    this.ratones[j]=null;
                }
            }
                       
    
        if (i == ratones.length) {
            throw new NotFoundException("No se ha encontrado ningun raton con ese codigo");
        }
     
    }

    public Raton searchRaton(int codigo) throws NotFoundException {
        int i;
        for (i = 0; i < numRatones; i++) {
            if (ratones[i].getCodigo() == codigo) {
                return ratones[i];
            }
        }
        if (i == ratones.length) {
            throw new NotFoundException("No se ha encontrado ningun raton con ese codigo");
        }
        return null;
    }
    
 @Override
    public String toString() {

        return "Nombre Poblacion: " + this.nombre + "\nResponsable: " + this.responsable + "\nNumero de dias:  " + this.numDias
                + "\nNumero de ratones: " + this.numRatones;
    }

}
