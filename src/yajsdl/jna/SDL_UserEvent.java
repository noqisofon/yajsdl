package yajsdl.jna;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_UserEvent extends Structure {
	/**
	 * < SDL_USEREVENT through SDL_NUMEVENTS-1<br>
	 * C type : Uint8
	 */
	public byte type;
	/// < User defined event code
	public int code;
	/**
	 * < User defined data pointer<br>
	 * C type : void*
	 */
	public Pointer data1;
	/**
	 * < User defined data pointer<br>
	 * C type : void*
	 */
	public Pointer data2;
	public SDL_UserEvent() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"type", "code", "data1", "data2"});
	}
	/**
	 * @param type < SDL_USEREVENT through SDL_NUMEVENTS-1<br>
	 * C type : Uint8<br>
	 * @param code < User defined event code<br>
	 * @param data1 < User defined data pointer<br>
	 * C type : void*<br>
	 * @param data2 < User defined data pointer<br>
	 * C type : void*
	 */
	public SDL_UserEvent(byte type, int code, Pointer data1, Pointer data2) {
		super();
		this.type = type;
		this.code = code;
		this.data1 = data1;
		this.data2 = data2;
		initFieldOrder();
	}
	public static class ByReference extends SDL_UserEvent implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_UserEvent implements Structure.ByValue {
		
	};
}