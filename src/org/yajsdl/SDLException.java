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
	 */
    private static final long serialVersionUID = 8507567623097231871L;


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
    public SDLException(String message) {}

}
