package org.yajsdl.events;


import com.sun.jna.Pointer;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Event;
//import yajsdl.utils.*;


public class EventDispatcher implements IEventDispatcher, Runnable {
    /**
     * 
     */
    public EventDispatcher() {
        this.target_ = null;
        this.running_ = false;
    }
    /**
     * 
     * @param target 
     */
    public EventDispatcher(IEventDispatcher target) {
        this.target_ = target;
        this.running_ = false;
    }


    /**
     * 
     * @param eventType
     * @param listener  
     */
    @Override
    public void addEventListener(EventType eventType, EventListener listener) {
        String event_type_name = eventType.name();

        if ( !this.listeners_.containsKey( event_type_name ) ) {
            /*
              ArrayList への Collections.synchronizedList は要らないかもしれない。
              が、一応。
             */
            this.listeners_.put( event_type_name, Collections.synchronizedList( new ArrayList<EventListener>() ) );
        }
        if ( !this.listeners_.get( event_type_name ).contains( listener ) ) {
            this.listeners_.get( event_type_name ).add( listener );
        }
    }


    /**
     * 
     * @param eventType
     * @param listener  
     */
    @Override
    public void removeEventListener(EventType eventType, EventListener listener) {
        String event_type_name = eventType.name();
        
        if ( this.listeners_.get( event_type_name ).contains( listener ) ) {
            this.listeners_.get( event_type_name ).remove( listener );
        }
    }


    /**
     * 
     * @param event
     * @throws SDLEventException  
     */
    public void pushEvent(SDLEvent event) throws SDLEventException {
        this.basePushEvent( event );
    }


    /**
     * 
     * @return 
     */
    public SDLEvent pollEvent() {
        return basePollEvent();
    }


    /**
     * 
     */
    @Override
    public void run() {
        // try {
        SDLEvent event;

        this.running_ = true;

        while ( this.running_ ) {
            event = this.pollEvent();
            if ( event != null ) {
                EventType event_type = event.getEventType();
                
                List<EventListener> listeners = null;
                switch ( event_type ) {
                    case KEY_UP:
                        listeners = this.listeners_.get( event_type.name() );

                        for ( Iterator<EventListener> it = listeners.iterator(); it.hasNext(); ) {
                            EventListener listener = it.next();

                            ((KeyListener)listener).keyReleased( (KeyboardEvent)event );
                        }
                        break;

                    case KEY_DOWN:
                        listeners = this.listeners_.get( event_type.name() );

                        for ( Iterator<EventListener> it = listeners.iterator(); it.hasNext(); ) {
                            EventListener listener = it.next();

                            ((KeyListener)listener).keyPressed( (KeyboardEvent)event );
                        }
                        
                        break;

                    case QUIT:
                        this.running_ = false;
                        break;
                }
                
            }

            event = this.pollEvent();
        }

        // } catch ( SDLEventException se ) {
        //     logger.error( "EventDispatcher#run SDLEventException:", e );
        // } catch ( Exception e ) {
        //     logger.error( "EventDispatcher#run Exception found:", e );
        // }
    }


    /**
     * イベントキューから numEvents 個のイベントを取り出して返します。
     * @param numEvents
     * @return
     * @throws SDLEventException  
     */
    protected SDLEvent[] basePeekEvent(int numEvents) throws SDLEventException {
        int ret;
        SDL_Event[] sdl_events = new SDL_Event[numEvents];
        SDLEvent[] events;

        ret = SDLLibrary.INSTANCE.SDL_PeepEvents( sdl_events,
                                                  numEvents,
                                                  SDLLibrary.SDL_eventaction.SDL_PEEKEVENT,
                                                  0 );
        if ( ret == -1 ) {
            throw new SDLEventException( SDLLibrary.INSTANCE.SDL_GetError() );
        }
        events = new SDLEvent[sdl_events.length];

        for ( int i = 0; i < events.length; ++ i ) {
            events[i] = SDLEvent.create( sdl_events[i] );
        }
        return events;
    }


    /**
     * 
     * @param numEvents
     * @return
     * @throws SDLEventException  
     */
    protected SDLEvent[] baseGetEvent(int numEvents) throws SDLEventException {
        int ret;
        SDL_Event[] sdl_events = new SDL_Event[numEvents];
        SDLEvent[] events;

        ret = SDLLibrary.INSTANCE.SDL_PeepEvents( sdl_events,
                                                  numEvents,
                                                  SDLLibrary.SDL_eventaction.SDL_GETEVENT,
                                                  0 );
        if ( ret == -1 ) {
            throw new SDLEventException( SDLLibrary.INSTANCE.SDL_GetError() );
        }
        events = new SDLEvent[sdl_events.length];

        for ( int i = 0; i < events.length; ++ i ) {
            events[i] = SDLEvent.create( sdl_events[i] );
        }
        return events;
    }
    
    

    /**
     *
     * @return 
     */
    protected SDLEvent baseWaitEvent() {
        int ret;
        SDLEvent ret_event = null;
        SDL_Event sdl_event = new SDL_Event();
        Pointer holder = sdl_event.getPointer();

        ret = SDLLibrary.INSTANCE.SDL_WaitEvent( holder );
        if ( ret == 1 ) {
            ret_event = SDLEvent.create( sdl_event );
        } else if ( ret == 0 ) {
            return null;
        }
        return ret_event;
    }
    
   
    /**
     *
     * @return 
     */
    protected SDLEvent basePollEvent() {
        int ret;
        SDLEvent ret_event;
        SDL_Event sdl_event = new SDL_Event();
        Pointer holder = sdl_event.getPointer();

        ret = SDLLibrary.INSTANCE.SDL_PollEvent( holder );
        /*
          ret が 1 の場合、sdl_event は呼びだす前と呼び出す後ではなにか変化があるはず。
         */
        if ( ret == 1 ) {
            ret_event = SDLEvent.create( sdl_event );
        } else {
            return null;
        }

        return ret_event;
    }


    /**
     *
     * @param event
     * @return
     * @throws SDLEventException  
     */
    protected boolean basePushEvent(SDLEvent event) throws SDLEventException {
        int ret;
        SDL_Event.ByReference sdl_event = event.toSource().getReference();

        ret = SDLLibrary.INSTANCE.SDL_PushEvent( sdl_event );

        if ( ret == 0 ) {
            throw new SDLEventException( SDLLibrary.INSTANCE.SDL_GetError() );
        }
        return true;
    }


    private IEventDispatcher target_;
    private Map<String, List<EventListener>> listeners_ = Collections.synchronizedMap( new HashMap<String, List<EventListener>>() );
    private boolean running_;
}
