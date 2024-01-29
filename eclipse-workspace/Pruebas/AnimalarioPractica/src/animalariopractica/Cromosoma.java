/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica;

import animalariopractica.auxiliar.utils.Utils;

/**
 *
 * @author lucia
 */
public enum Cromosoma {
    X, X_MUTADO, Y, Y_MUTADO;

    /**
     *
     * @return
     */
    public boolean isMutado() {
        if (this.equals(X_MUTADO) || this.equals(Y_MUTADO)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * IT RETURNS the cromosoma mutated or not according to the percentage
     *
     * @param cromosome
     * @param percentage a number <= 0 will return the normal cromosome. A number
     * >= 99 will return the mutated cromosoma. Otherwise, it will return the
     * mutated cromosome according to the percentage
     * @return the cromosome mutated or not according to the percentage
     * specified
     */
    public static Cromosoma getMutatedCromosomeFromPercentage(Cromosoma cromosome, float percentage) {
        // COMPROBAR QUE PERCENTAGE ES UN NUMERO ENTRE 0 Y 99
        float num = Utils.randomNumber(100); //num aleatorio entre 0 y 99
        if (num < percentage) {
            return Utils.mutatedCromosome(cromosome);
            
        }

        return cromosome;
    }


}
