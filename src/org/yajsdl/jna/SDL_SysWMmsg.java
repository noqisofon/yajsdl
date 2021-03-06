package org.yajsdl.jna;

import com.sun.jna.Structure;
import com.sun.jna.Union;
import org.yajsdl.jna.SDLLibrary.XEvent;


/**
 * The UNIX custom event structure<br>
 * <i>native declaration : /usr/include/SDL/SDL_syswm.h:65</i><br>
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
public class SDL_SysWMmsg extends Structure {
    // / C type : SDL_version
    public SDL_version version;
    // / C type : SDL_SYSWM_TYPE
    public int         subsystem;
    // / C type : event_union
    public event_union event;

    // / <i>native declaration : /usr/include/SDL/SDL_syswm.h:68</i>
    public static class event_union extends Union {
        // / C type : XEvent
        public XEvent xevent;


        public event_union() {
            super();
        }


        // / @param xevent C type : XEvent
        public event_union(XEvent xevent) {
            super();
            this.xevent = xevent;
            setType( org.yajsdl.jna.SDLLibrary.XEvent.class );
        }

        public static class ByReference extends event_union implements Structure.ByReference {

        };

        public static class ByValue extends event_union implements Structure.ByValue {

        };
    };


    public SDL_SysWMmsg() {
        super();
        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "version", "subsystem", "event" } );
    }


    /**
     * @param version
     *            C type : SDL_version<br>
     * @param subsystem
     *            C type : SDL_SYSWM_TYPE<br>
     * @param event
     *            C type : event_union
     */
    public SDL_SysWMmsg(SDL_version version, int subsystem, event_union event) {
        super();
        this.version = version;
        this.subsystem = subsystem;
        this.event = event;
        initFieldOrder();
    }

    public static class ByReference extends SDL_SysWMmsg implements Structure.ByReference {

    };

    public static class ByValue extends SDL_SysWMmsg implements Structure.ByValue {

    };
}
