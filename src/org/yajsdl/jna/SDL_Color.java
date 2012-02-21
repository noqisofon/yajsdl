package org.yajsdl.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;


/**
 * <i>native declaration : /usr/include/SDL/SDL_video.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_Color extends Structure {
	/// C type : Uint8
	public byte r;
	/// C type : Uint8
	public byte g;
	/// C type : Uint8
	public byte b;
	/// C type : Uint8
	public byte unused;
	public SDL_Color() {
		super();
		initFieldOrder();
	}
	/**
	 * @param r C type : Uint8<br>
	 * @param g C type : Uint8<br>
	 * @param b C type : Uint8<br>
	 * @param unused C type : Uint8
	 */
	public SDL_Color(byte r, byte g, byte b, byte unused) {
		super();
		
        this.r = r;
		this.g = g;
		this.b = b;
		this.unused = unused;
		
        initFieldOrder();
	}
    public SDL_Color(Pointer ptr) {
        super( ptr );
        initFieldOrder();
    }
    public SDL_Color(Pointer ptr, int alignment) {
        super( ptr, alignment );
        initFieldOrder();
    }
    public SDL_Color(SDL_Color other) {
        super();
		
        this.r = other.r;
		this.g = other.g;
		this.b = other.b;
		this.unused = other.unused;
		
        initFieldOrder();
    }
    
    
	protected void initFieldOrder() {
		setFieldOrder( new java.lang.String[] { "r", "g", "b", "unused" } );
	}


    public static class ByReference extends SDL_Color implements Structure.ByReference {
        ByReference() {}
        ByReference(SDL_Color other) { super( other.getPointer(), 0 ); }
	}


    public static class ByValue extends SDL_Color implements Structure.ByValue {
        ByValue() {}
        ByValue(SDL_Color other) { super( other.getPointer(), 0 ); }
	}
}