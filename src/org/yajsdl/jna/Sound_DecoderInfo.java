package org.yajsdl.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;


/**
 * <i>native declaration : /usr/include/SDL/SDL_sound.h</i><br>
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
public class Sound_DecoderInfo extends Structure {
    /**
     * < File extensions, list ends with NULL.<br>
     * C type : const char**
     */
    public PointerByReference extensions;
    /**
     * < Human readable description of decoder.<br>
     * C type : const char*
     */
    public Pointer            description;
/**
	 * < "Name Of Author \<email@emailhost.dom\>"<br>
	 * C type : const char*
	 */
    public Pointer            author;
    /**
     * < URL specific to this decoder.<br>
     * C type : const char*
     */
    public Pointer            url;


    public Sound_DecoderInfo() {
        super();
        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "extensions", "description", "author", "url" } );
    }


/**
	 * @param extensions < File extensions, list ends with NULL.<br>
	 * C type : const char**<br>
	 * @param description < Human readable description of decoder.<br>
	 * C type : const char*<br>
	 * @param author < "Name Of Author \<email@emailhost.dom\>"<br>
	 * C type : const char*<br>
	 * @param url < URL specific to this decoder.<br>
	 * C type : const char*
	 */
    public Sound_DecoderInfo(PointerByReference extensions, Pointer description, Pointer author, Pointer url) {
        super();
        this.extensions = extensions;
        this.description = description;
        this.author = author;
        this.url = url;
        initFieldOrder();
    }

    public static class ByReference extends Sound_DecoderInfo implements Structure.ByReference {

    };

    public static class ByValue extends Sound_DecoderInfo implements Structure.ByValue {

    };
}
