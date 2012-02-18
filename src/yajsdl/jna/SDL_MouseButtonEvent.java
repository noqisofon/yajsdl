package yajsdl.jna;
import com.sun.jna.Structure;
/**
 * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_MouseButtonEvent extends Structure {
	/**
	 * < SDL_MOUSEBUTTONDOWN or SDL_MOUSEBUTTONUP<br>
	 * C type : Uint8
	 */
	public byte type;
	/**
	 * < The mouse device index<br>
	 * C type : Uint8
	 */
	public byte which;
	/**
	 * < The mouse button index<br>
	 * C type : Uint8
	 */
	public byte button;
	/**
	 * < SDL_PRESSED or SDL_RELEASED<br>
	 * C type : Uint8
	 */
	public byte state;
	/**
	 * < The X/Y coordinates of the mouse at press time<br>
	 * C type : Uint16
	 */
	public short x;
	/**
	 * < The X/Y coordinates of the mouse at press time<br>
	 * C type : Uint16
	 */
	public short y;
	public SDL_MouseButtonEvent() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"type", "which", "button", "state", "x", "y"});
	}
	/**
	 * @param type < SDL_MOUSEBUTTONDOWN or SDL_MOUSEBUTTONUP<br>
	 * C type : Uint8<br>
	 * @param which < The mouse device index<br>
	 * C type : Uint8<br>
	 * @param button < The mouse button index<br>
	 * C type : Uint8<br>
	 * @param state < SDL_PRESSED or SDL_RELEASED<br>
	 * C type : Uint8<br>
	 * @param x < The X/Y coordinates of the mouse at press time<br>
	 * C type : Uint16<br>
	 * @param y < The X/Y coordinates of the mouse at press time<br>
	 * C type : Uint16
	 */
	public SDL_MouseButtonEvent(byte type, byte which, byte button, byte state, short x, short y) {
		super();
		this.type = type;
		this.which = which;
		this.button = button;
		this.state = state;
		this.x = x;
		this.y = y;
		initFieldOrder();
	}
	public static class ByReference extends SDL_MouseButtonEvent implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_MouseButtonEvent implements Structure.ByValue {
		
	};
}
