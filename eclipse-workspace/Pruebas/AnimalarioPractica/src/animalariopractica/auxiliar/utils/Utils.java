/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica.auxiliar.utils;

import animalariopractica.Cromosoma;

/**
 *
 * @author dayannakatherine
 */
public class Utils {
        public static float randomNumber(float rangoMax) {

        float num = (float) Math.random() * rangoMax;

        return num;
    }

    public static Cromosoma mutatedCromosome(Cromosoma cromosome) {
        if (cromosome.equals(cromosome.X)) {
            return Cromosoma.X_MUTADO;

        } else {
            return Cromosoma.Y_MUTADO;
        }

    }
    
    
}
