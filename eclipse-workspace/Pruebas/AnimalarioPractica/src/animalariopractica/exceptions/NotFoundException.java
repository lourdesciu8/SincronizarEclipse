/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalariopractica.exceptions;

/**
 *
 * @author lucia
 */
//CUANDO NO SE ENCUENTRA EL RATON AL BUSCAR POR CODIGO
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

}
