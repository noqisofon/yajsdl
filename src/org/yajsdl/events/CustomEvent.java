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
public class CustomEvent extends Event {
    /**
     *
     */
    CustomEvent(EventType eventType) {
        super( eventType );
    }

    
    /**
     *
     */
    @Override
    public SDL_Event toSource() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
