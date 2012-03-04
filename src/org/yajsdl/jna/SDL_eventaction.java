/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.jna;

/**
 * 
 * @author rihine
 */
enum SDL_eventaction {
    ADDEVENT(SDLLibrary.SDL_eventaction.SDL_ADDEVENT), PEEKEVENT(SDLLibrary.SDL_eventaction.SDL_PEEKEVENT), GETEVENT(
            SDLLibrary.SDL_eventaction.SDL_GETEVENT);

    private SDL_eventaction(int value) {
        this.value_ = value;
    }


    public int toInteger() {
        return this.value_;
    }

    private int value_;
}
