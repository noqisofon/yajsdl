package org.yajsdl.events;

import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Event;


public abstract class SDLEvent {
    /**
     *
     */
    public SDLEvent() {
        this.type_ = EventType.NONE;
        this.consumed_ = false;
    }
    /**
     *
     * @param eventType 
     */
    public SDLEvent(EventType eventType) {
        this.type_ = eventType;
        this.consumed_ = false;
    }


    /**
     *
     * @return 
     */
    public abstract SDL_Event toSource();


    /**
     *
     * @return 
     */
    public EventType getEventType() {
        return this.type_;
    }
    
    
    /**
     * SDL_Event オブジェクトから SDLEvent オブジェクトを作成して返します。
     * @param sdl_event
     * @return  
     */
    public static SDLEvent create(SDL_Event sdl_event) {
        SDLEvent ret;

        switch ( sdl_event.type ) {
            case SDLLibrary.SDL_EventType.SDL_KEYUP:
                ret = KeyboardEvent.create( sdl_event.key );
                break;

            case SDLLibrary.SDL_EventType.SDL_KEYDOWN:
                ret = KeyboardEvent.create( sdl_event.key );
                break;
                
            default:
                ret = null;
                break;
        }

        return ret;
    }


    /**
     * 
     */
    protected void consume() {
    }


    /**
     * 
     * @return 
     */
    protected boolean isConsume() {
        return this.consumed_;
    }


    private EventType type_;
    private boolean consumed_;
}
