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
    public SDLEventException(Exception e) {
        super( e );
    }
    public SDLEventException(String message) {
        super( message );
    }
}
