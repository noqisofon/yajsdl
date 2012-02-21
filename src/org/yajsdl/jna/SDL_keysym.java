package org.yajsdl.jna;
import com.sun.jna.Structure;
/**
 * <i>native declaration : /usr/include/SDL/SDL_keyboard.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_keysym extends Structure {
	/**
	 * < hardware specific scancode<br>
	 * C type : Uint8
	 */
	public byte scancode;
	/**
	 * < SDL virtual keysym<br>
	 * C type : SDLKey
	 */
	public int sym;
	/**
	 * < current key modifiers<br>
	 * C type : SDLMod
	 */
	public int mod;
	/**
	 * < translated character<br>
	 * C type : Uint16
	 */
	public short unicode;
	public SDL_keysym() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"scancode", "sym", "mod", "unicode"});
	}
	/**
	 * @param scancode < hardware specific scancode<br>
	 * C type : Uint8<br>
	 * @param sym < SDL virtual keysym<br>
	 * C type : SDLKey<br>
	 * @param mod < current key modifiers<br>
	 * C type : SDLMod<br>
	 * @param unicode < translated character<br>
	 * C type : Uint16
	 */
	public SDL_keysym(byte scancode, int sym, int mod, short unicode) {
		super();
		this.scancode = scancode;
		this.sym = sym;
		this.mod = mod;
		this.unicode = unicode;
		initFieldOrder();
	}
	public static class ByReference extends SDL_keysym implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_keysym implements Structure.ByValue {
		
	};
}