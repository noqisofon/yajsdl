package org.yajsdl.jna;

import com.sun.jna.Structure;


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
public class SDL_SysWMEvent extends Structure {
    // / C type : Uint8
    public byte                                    type;
    // / C type : SDL_SysWMmsg*
    public org.yajsdl.jna.SDL_SysWMmsg.ByReference msg;


    public SDL_SysWMEvent() {
        super();
        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "type", "msg" } );
    }


    /**
     * @param type
     *            C type : Uint8<br>
     * @param msg
     *            C type : SDL_SysWMmsg*
     */
    public SDL_SysWMEvent(byte type, org.yajsdl.jna.SDL_SysWMmsg.ByReference msg) {
        super();
        this.type = type;
        this.msg = msg;
        initFieldOrder();
    }

    public static class ByReference extends SDL_SysWMEvent implements Structure.ByReference {

    };

    public static class ByValue extends SDL_SysWMEvent implements Structure.ByValue {

    };
}
