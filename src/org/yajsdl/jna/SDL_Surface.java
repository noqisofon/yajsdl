package org.yajsdl.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;


/**
 * <i>native declaration : /usr/include/SDL/SDL_video.h</i><br>
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
public class SDL_Surface extends Structure {
    /**
     * < Read-only<br>
     * C type : Uint32
     */
    public int                                        /* Uint32 */flags;
    /**
     * < Read-only<br>
     * C type : SDL_PixelFormat*
     */
    public org.yajsdl.jna.SDL_PixelFormat.ByReference format;
    // / < Read-only
    public int                                        w;
    // / < Read-only
    public int                                        h;
    /**
     * < Read-only<br>
     * C type : Uint16
     */
    public short                                      pitch;
    /**
     * < Read-write<br>
     * C type : void*
     */
    public Pointer                                    pixels;
    // / < Private
    public int                                        offset;
    /**
     * Hardware-specific surface info<br>
     * C type : private_hwdata*
     */
    public Pointer                                    hwdata;
    /**
     * clipping information<br>
     * < Read-only<br>
     * C type : SDL_Rect
     */
    public SDL_Rect                                   clip_rect;
    /**
     * < for binary compatibility<br>
     * C type : Uint32
     */
    public int                                        /* Uint32 */unused1;
    /**
     * Allow recursive locks<br>
     * < Private<br>
     * C type : Uint32
     */
    public int                                        /* Uint32 */locked;
    /**
     * info for fast blit mapping to other surfaces<br>
     * < Private<br>
     * C type : SDL_BlitMap*
     */
    public Pointer                                    map;
    /**
     * format version, bumped at every change to invalidate blit maps<br>
     * < Private
     */
    public int                                        format_version;
    /**
     * Reference count -- used when freeing surface<br>
     * < Read-mostly
     */
    public int                                        refcount;


    public SDL_Surface() {
        super();
        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "flags", "format", "w", "h", "pitch", "pixels", "offset", "hwdata",
            "clip_rect", "unused1", "locked", "map", "format_version", "refcount" } );
    }

    public static class ByReference extends SDL_Surface implements Structure.ByReference {

    };

    public static class ByValue extends SDL_Surface implements Structure.ByValue {

    };
}
