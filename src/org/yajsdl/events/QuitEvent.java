/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Event;


/**
 * 
 * @author rihine
 */
public class QuitEvent extends SDLEvent {
    /**
     *
     */
    public QuitEvent() {
        super( EventType.QUIT );
    }


    /**
     *
     */
    @Override
    public SDL_Event toSource() {
        return new SDL_Event( (byte)SDLLibrary.SDL_EventType.SDL_QUIT );
    }

}
