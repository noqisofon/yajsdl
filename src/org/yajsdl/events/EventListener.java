package org.yajsdl.events;


public interface EventListener {
    public boolean incomingEvents(Event event) throws SDLEventException;
}
