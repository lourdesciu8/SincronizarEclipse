/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica;

import animalariopractica.exceptions.IncorrectCromosome;
import animalariopractica.exceptions.PesoException;
import java.time.LocalDate;

/**
 *
 * @author lucia
 */
public class Raton {

    private int codigo;
    private final LocalDate nacimiento;
    private int peso;
    private final Sexo sexo;
    private float grados;
    private final Cromosoma cromosoma1;
    private final Cromosoma cromosoma2;
    private String comentario;

    public Raton(int codigo, LocalDate nacimiento, int peso, Sexo sexo, float grados,
            String comentario, Cromosoma cromosoma1, Cromosoma cromosoma2) throws PesoException, IncorrectCromosome {

        this.codigo = codigo;

        if (cromosoma1 != Cromosoma.X || cromosoma1 != Cromosoma.X_MUTADO) {
            throw new IncorrectCromosome("los cromosomas no corresponden al sexo");
        }
        if (sexo == Sexo.HEMBRA) {
            if (cromosoma2 != Cromosoma.X || cromosoma1 != Cromosoma.X_MUTADO) {
                throw new IncorrectCromosome("los cromosomas no corresponden al sexo");
            }
        }
        if (sexo == Sexo.MACHO) {
            if (cromosoma2 != Cromosoma.Y || cromosoma1 != Cromosoma.Y_MUTADO) {
                throw new IncorrectCromosome("los cromosomas no corresponden al sexo");
            }
        }

        this.sexo = sexo;

        this.cromosoma1 = cromosoma1;

        this.cromosoma2 = cromosoma2;
        if (peso < 0 || peso
                > 60) {
            throw new PesoException("el peso debe estar entre 0 y 60");
        }

        this.peso = peso;

        this.grados = grados;

        this.nacimiento = nacimiento;

        this.comentario = comentario;

    }

    public Raton(int codigo, LocalDate nacimiento, int peso, Sexo sexo, float grados,
            String comentario, float percentageMutacion) {

        this.codigo = codigo;
        this.peso = peso;
        this.sexo = sexo;
        this.grados = grados;

        // funcion que devuelve el cromosoma correspondiente segun el sexo 
        this.cromosoma1 = Cromosoma.getMutatedCromosomeFromPercentage(Cromosoma.X, percentageMutacion);
        if (this.sexo.equals(sexo.HEMBRA)) {
            this.cromosoma2 = Cromosoma.getMutatedCromosomeFromPercentage(Cromosoma.X, percentageMutacion);
        } else {
            this.cromosoma2 = Cromosoma.getMutatedCromosomeFromPercentage(Cromosoma.Y, percentageMutacion);
        }

        this.nacimiento = nacimiento;
        this.comentario = comentario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return nacimiento;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public float getGrados() {
        return grados;
    }

    public void setGrados(float grados) {
        this.grados = grados;
    }

    public Cromosoma isCromosoma1() {
        return cromosoma1;
    }

    public Cromosoma isCromosoma2() {
        return cromosoma2;
    }

    public boolean isSteril() {
        boolean steril = false;
        if (this.sexo == sexo.MACHO) {
            if (this.cromosoma1.isMutado()) {
                steril = true;
            }
        } else if (this.sexo == sexo.HEMBRA) {
            if (this.cromosoma1.isMutado() && this.cromosoma2.isMutado()) {
                steril = true;
            }
        }
        return steril;
    }

    public boolean isPoligamic() {

        boolean poligamico = false;

        if (this.sexo == sexo.MACHO) {
            if (this.cromosoma2.isMutado()) {
                poligamico = true;
            }
        }
        return poligamico;

    }

    @Override
    public String toString() {

        return "\n\n Codigo de referencia: " + this.codigo + "\nFecha de nacimiento: " + this.nacimiento
                + "\nSexo: " + this.sexo + "\nGrados: " + this.grados + "\n Cromosoma: " + this.cromosoma1 + "\n Cromosoma: " + this.cromosoma2
                + "\nComentario adicional: " + this.comentario + "\n\n";
    }

}
