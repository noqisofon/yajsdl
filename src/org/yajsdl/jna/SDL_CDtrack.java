package org.yajsdl.jna;

import com.sun.jna.Structure;


/**
 * <i>native declaration : /usr/include/SDL/SDL_cdrom.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_CDtrack extends Structure {
	/**
	 * < Track number<br>
	 * C type : Uint8
	 */
	public byte id;
	/**
	 * < Data or audio track<br>
	 * C type : Uint8
	 */
	public byte type;
	/// C type : Uint16
	public short unused;
	/**
	 * < Length, in frames, of this track<br>
	 * C type : Uint32
	 */
	public int/* Uint32 */ length;
	/**
	 * < Offset, in frames, from start of disk<br>
	 * C type : Uint32
	 */
	public int/* Uint32 */ offset;
	public SDL_CDtrack() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"id", "type", "unused", "length", "offset"});
	}
	/**
	 * @param id < Track number<br>
	 * C type : Uint8<br>
	 * @param type < Data or audio track<br>
	 * C type : Uint8<br>
	 * @param unused C type : Uint16<br>
	 * @param length < Length, in frames, of this track<br>
	 * C type : Uint32<br>
	 * @param offset < Offset, in frames, from start of disk<br>
	 * C type : Uint32
	 */
	public SDL_CDtrack(byte id, byte type, short unused, int/* Uint32 */ length, int/* Uint32 */ offset) {
		super();
		this.id = id;
		this.type = type;
		this.unused = unused;
		this.length = length;
		this.offset = offset;
		initFieldOrder();
	}
	public static class ByReference extends SDL_CDtrack implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_CDtrack implements Structure.ByValue {
		
	};
}