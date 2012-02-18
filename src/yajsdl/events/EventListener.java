package yajsdl.events;


public interface EventListener {
    public boolean incomingEvents(CustomEvent event) throws SDLEventException;
}
