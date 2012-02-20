package org.yajsdl.events;

import java.util.Iterator;
import java.util.Vector;
import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Event;
//import yajsdl.utils.*;


public class EventDispatcher implements Runnable {


    /**
     *
     */
    public EventDispatcher(boolean shouldBeDaemon) {
        this.daemon_ = shouldBeDaemon;
    }


    /**
     *
     */
    public void start() {
        this.thread_ = new Thread( this );
        this.thread_.setDaemon( this.daemon_ );
        this.thread_.start();
    }


    /**
     *
     */
    public void startAndWait() {
        this.stopped_ = false;

        this.start();
        while ( this.stopped_ == false ) {
            try {
                Thread.sleep( 500 );
            } catch ( Exception e ) {
            }
        }
    }

    
    /**
     *
     */
    public void run() {
        try {
            Event event = waitEvent();
            while ( event != null ) {

                if ( event != null ) {
                    synchronized ( this.listeners_ ) {
                        
                        for ( Iterator<EventListener> it = this.listeners_.iterator(); it.hasNext(); ) {
                            it.next().incomingEvents( event );
                        }
                    }
                } else {
                    Log.debug( "EventDispatcher#run event is null." );
                }
            }
        } catch ( SDLEventException see ) {
            Log.error( "EventDispatcher#run SDLException:", see );
        } catch ( Exception e ) {
            Log.error( "EventDispatcher#run Exception found:", e );
        }
        this.stopped_ = true;
        Log.debug( "EventDispatcher is quitting." );
    }


    /**
     * 
     */
    public Event pollEvent() {
        Log.debug( "EventDispatcher#pollEvent inside ..." );

        Event event = this.basePollEvent();

        if ( event != null ) {
            Log.debug( "EventDispatcher#pollEvent returning non null" );

            return event;
        }
        return null;
    }


    /**
     * 
     */
    public boolean pushEvent(Event event) {
        //if ( event instanceof UserEvent ) {
        try {
            this.basePushEvent( event );
        } catch ( SDLEventException see ) {
            return false;
        }
        return true;
        //}
        //Log.debug( "EventDispatcher only pushes SDLUserEvents." );

        //return false;
    }


    /**
     *
     */
    public int setEventState(EventState type, EventType state) {
        return this.baseSetEventState( type, state );
    }


    /**
     *
     */
    public boolean registerEventListener(EventListener listener) {
        if ( !this.listeners_.contains( listener ) ) {
            this.listeners_.add( listener );

            return true;
        }
        return false;
    }


    /**
     *
     */
    public boolean unregisterEventListener(EventListener listener) {
        if ( this.listeners_.contains( listener ) ) {
            this.listeners_.remove( listener );

            return true;
        }
        return false;
    }


    /**
     *
     */
    protected int baseSetEventState(EventState type, EventType state) {
        byte ret;
        byte event_type = type.toByte();
        int event_state = state.toInteger();

        ret = SDLLibrary.INSTANCE.SDL_EventState( event_type, event_state );
        
        return ret;
    }
    

    /**
     *
     */
    protected Event waitEvent() {
        int ret;
        SDL_Event sdl_event = new SDL_Event();
        Event ret_event = null;

        ret = SDLLibrary.INSTANCE.SDL_WaitEvent( sdl_event );
        if ( ret == 1 ) {
            ret_event = Event.createEventFromSDLEvent( sdl_event );
        } else if ( ret == 0 ) {
            return null;
        }
        return ret_event;
    }
    
   
    /**
     *
     */
    protected Event basePollEvent() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    /**
     *
     */
    protected boolean basePushEvent(Event event) throws SDLEventException {
        int ret;
        SDL_Event sdl_event = event.toSource();

        ret = SDLLibrary.INSTANCE.SDL_PushEvent( sdl_event );

        if ( ret == 0 )
            throw new SDLEventException( SDLLibrary.INSTANCE.SDL_GetError() );

        return true;
    }


    private Vector<EventListener> listeners_ = new Vector<EventListener>();
    private Thread thread_;
    private boolean daemon_;
    private volatile boolean stopped_ = false;
    private int handle_poll_event_ = 0;

    private final static boolean DEBUG = false;
}
