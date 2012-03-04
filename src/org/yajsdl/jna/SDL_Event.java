package org.yajsdl.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Union;


/**
 * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that
 * <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a
 * few opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a
 * href="http://rococoa.dev.java.net/">Rococoa</a>, or <a
 * href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_Event extends Union {
    // / C type : Uint8
    public byte                 type;
    // / C type : SDL_ActiveEvent
    public SDL_ActiveEvent      active;
    // / C type : SDL_KeyboardEvent
    public SDL_KeyboardEvent    key;
    // / C type : SDL_MouseMotionEvent
    public SDL_MouseMotionEvent motion;
    // / C type : SDL_MouseButtonEvent
    public SDL_MouseButtonEvent button;
    // / C type : SDL_JoyAxisEvent
    public SDL_JoyAxisEvent     jaxis;
    // / C type : SDL_JoyBallEvent
    public SDL_JoyBallEvent     jball;
    // / C type : SDL_JoyHatEvent
    public SDL_JoyHatEvent      jhat;
    // / C type : SDL_JoyButtonEvent
    public SDL_JoyButtonEvent   jbutton;
    // / C type : SDL_ResizeEvent
    public SDL_ResizeEvent      resize;
    // / C type : SDL_ExposeEvent
    public SDL_ExposeEvent      expose;
    // / C type : SDL_QuitEvent
    public SDL_QuitEvent        quit;
    // / C type : SDL_UserEvent
    public SDL_UserEvent        user;
    // / C type : SDL_SysWMEvent
    public SDL_SysWMEvent       syswm;


    public SDL_Event() {
        super();
    }


    public SDL_Event(Pointer p) {
        super( p );
    }


    public SDL_Event(Pointer p, int alignment) {
        super( p, alignment );
    }


    // / @param syswm C type : SDL_SysWMEvent
    public SDL_Event(SDL_SysWMEvent syswm) {
        super();
        this.syswm = syswm;
        setType( org.yajsdl.jna.SDL_SysWMEvent.class );
    }


    // / @param jaxis C type : SDL_JoyAxisEvent
    public SDL_Event(SDL_JoyAxisEvent jaxis) {
        super();
        this.jaxis = jaxis;
        setType( org.yajsdl.jna.SDL_JoyAxisEvent.class );
    }


    // / @param button C type : SDL_MouseButtonEvent
    public SDL_Event(SDL_MouseButtonEvent button) {
        super();
        this.button = button;
        setType( org.yajsdl.jna.SDL_MouseButtonEvent.class );
    }


    // / @param jhat C type : SDL_JoyHatEvent
    public SDL_Event(SDL_JoyHatEvent jhat) {
        super();
        this.jhat = jhat;
        setType( org.yajsdl.jna.SDL_JoyHatEvent.class );
    }


    // / @param resize C type : SDL_ResizeEvent
    public SDL_Event(SDL_ResizeEvent resize) {
        super();
        this.resize = resize;
        setType( org.yajsdl.jna.SDL_ResizeEvent.class );
    }


    // / @param active C type : SDL_ActiveEvent
    public SDL_Event(SDL_ActiveEvent active) {
        super();
        this.active = active;
        setType( org.yajsdl.jna.SDL_ActiveEvent.class );
    }


    // / @param motion C type : SDL_MouseMotionEvent
    public SDL_Event(SDL_MouseMotionEvent motion) {
        super();
        this.motion = motion;
        setType( org.yajsdl.jna.SDL_MouseMotionEvent.class );
    }


    // / @param jbutton C type : SDL_JoyButtonEvent
    public SDL_Event(SDL_JoyButtonEvent jbutton) {
        super();
        this.jbutton = jbutton;
        setType( org.yajsdl.jna.SDL_JoyButtonEvent.class );
    }


    // / @param jball C type : SDL_JoyBallEvent
    public SDL_Event(SDL_JoyBallEvent jball) {
        super();
        this.jball = jball;
        setType( org.yajsdl.jna.SDL_JoyBallEvent.class );
    }


    // / @param expose C type : SDL_ExposeEvent
    public SDL_Event(SDL_ExposeEvent expose) {
        super();
        this.expose = expose;
        setType( org.yajsdl.jna.SDL_ExposeEvent.class );
    }


    // / @param type C type : Uint8
    public SDL_Event(byte type) {
        super();
        this.type = type;
        setType( java.lang.Byte.TYPE );
    }


    // / @param quit C type : SDL_QuitEvent
    public SDL_Event(SDL_QuitEvent quit) {
        super();
        this.quit = quit;
        setType( org.yajsdl.jna.SDL_QuitEvent.class );
    }


    // / @param user C type : SDL_UserEvent
    public SDL_Event(SDL_UserEvent user) {
        super();
        this.user = user;
        setType( org.yajsdl.jna.SDL_UserEvent.class );
    }


    // / @param key C type : SDL_KeyboardEvent
    public SDL_Event(SDL_KeyboardEvent key) {
        super();
        this.key = key;
        setType( org.yajsdl.jna.SDL_KeyboardEvent.class );
    }


    /**
     * 
     * @return
     */
    public SDL_Event.ByReference getReference() {
        return new SDL_Event.ByReference( this );
    }

    /**
     *
     */
    public static class ByReference extends SDL_Event implements com.sun.jna.Structure.ByReference {
        ByReference() {}


        ByReference(SDL_Event other) {
            super( other.getPointer(), 0 );
        }
    }

    /**
     *
     */
    public static class ByValue extends SDL_Event implements com.sun.jna.Structure.ByValue {
        ByValue() {}


        ByValue(SDL_Event other) {
            super( other.getPointer(), 0 );
        }
    }
}
