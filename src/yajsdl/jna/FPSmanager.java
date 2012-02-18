package yajsdl.jna;

import com.sun.jna.Structure;


/**
 * <i>native declaration : /usr/include/SDL/SDL_framerate.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class FPSmanager extends Structure {
	/// C type : Uint32
	public Uint32 framecount;
	public float rateticks;
	/// C type : Uint32
	public Uint32 lastticks;
	/// C type : Uint32
	public Uint32 rate;
	public FPSmanager() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"framecount", "rateticks", "lastticks", "rate"});
	}
	/**
	 * @param framecount C type : Uint32<br>
	 * @param lastticks C type : Uint32<br>
	 * @param rate C type : Uint32
	 */
	public FPSmanager(Uint32 framecount, float rateticks, Uint32 lastticks, Uint32 rate) {
		super();
		this.framecount = framecount;
		this.rateticks = rateticks;
		this.lastticks = lastticks;
		this.rate = rate;
		initFieldOrder();
	}
	public static class ByReference extends FPSmanager implements Structure.ByReference {
		
	};
	public static class ByValue extends FPSmanager implements Structure.ByValue {
		
	};
}
