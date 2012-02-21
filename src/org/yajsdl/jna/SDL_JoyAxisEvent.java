package org.yajsdl.jna;
import com.sun.jna.Structure;
/**
 * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_JoyAxisEvent extends Structure {
	/**
	 * < SDL_JOYAXISMOTION<br>
	 * C type : Uint8
	 */
	public byte type;
	/**
	 * < The joystick device index<br>
	 * C type : Uint8
	 */
	public byte which;
	/**
	 * < The joystick axis index<br>
	 * C type : Uint8
	 */
	public byte axis;
	/**
	 * < The axis value (range: -32768 to 32767)<br>
	 * C type : Sint16
	 */
	public short value;
	public SDL_JoyAxisEvent() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"type", "which", "axis", "value"});
	}
	/**
	 * @param type < SDL_JOYAXISMOTION<br>
	 * C type : Uint8<br>
	 * @param which < The joystick device index<br>
	 * C type : Uint8<br>
	 * @param axis < The joystick axis index<br>
	 * C type : Uint8<br>
	 * @param value < The axis value (range: -32768 to 32767)<br>
	 * C type : Sint16
	 */
	public SDL_JoyAxisEvent(byte type, byte which, byte axis, short value) {
		super();
		this.type = type;
		this.which = which;
		this.axis = axis;
		this.value = value;
		initFieldOrder();
	}
	public static class ByReference extends SDL_JoyAxisEvent implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_JoyAxisEvent implements Structure.ByValue {
		
	};
}