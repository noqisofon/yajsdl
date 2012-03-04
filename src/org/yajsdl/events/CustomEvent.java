/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

import org.yajsdl.jna.SDL_Event;


/**
 * 
 * @author rihine
 */
public class CustomEvent extends SDLEvent {
    /**
     *
     */
    CustomEvent(EventType eventType) {
        super( eventType );
    }


    /**
     * 
     * @return
     */
    @Override
    public SDL_Event toSource() {
        throw new UnsupportedOperationException( "Not supported yet." );
    }

}
