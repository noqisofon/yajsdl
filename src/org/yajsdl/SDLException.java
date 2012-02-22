/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl;


/**
 *
 * @author rihine
 */
public class SDLException extends Exception {
    /**
     *
     * @param e 
     */
    public SDLException(Exception e) {
        super( e );
    }
    /**
     *
     * @param message 
     */
    public SDLException(String message) {
    }
    
}
