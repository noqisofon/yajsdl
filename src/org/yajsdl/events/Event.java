package org.yajsdl.events;

import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Event;


public abstract class Event {
    /**
     *
     */
    protected Event(EventType eventType) {
        this.type_ = eventType;
    }


    /**
     *
     */
    public abstract SDL_Event toSource();
    
    
    /**
     * 
     */
    public static Event createEventFromSDLEvent(SDL_Event sdl_event) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    /**
     *
     */
    public EventType getEventType() {
        return this.type_;
    }


    private EventType type_;
}
