/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

import org.yajsdl.SDLException;


/**
 * 
 * @author rihine
 */
public class SDLEventException extends SDLException {
    private static final long serialVersionUID = 6963928771327413933L;


    /**
	 * 
	 */
    public SDLEventException(Exception e) {
        super( e );
    }


    public SDLEventException(String message) {
        super( message );
    }
}
