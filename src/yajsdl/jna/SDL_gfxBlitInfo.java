package yajsdl.jna;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * <i>native declaration : /usr/include/SDL/SDL_gfxBlitFunc.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_gfxBlitInfo extends Structure {
	/// C type : Uint8*
	public Pointer s_pixels;
	public int s_width;
	public int s_height;
	public int s_skip;
	/// C type : Uint8*
	public Pointer d_pixels;
	public int d_width;
	public int d_height;
	public int d_skip;
	/// C type : void*
	public Pointer aux_data;
	/// C type : SDL_PixelFormat*
	public yajsdl.jna.SDL_PixelFormat.ByReference src;
	/// C type : Uint8*
	public Pointer table;
	/// C type : SDL_PixelFormat*
	public yajsdl.jna.SDL_PixelFormat.ByReference dst;
	public SDL_gfxBlitInfo() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"s_pixels", "s_width", "s_height", "s_skip", "d_pixels", "d_width", "d_height", "d_skip", "aux_data", "src", "table", "dst"});
	}
	public static class ByReference extends SDL_gfxBlitInfo implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_gfxBlitInfo implements Structure.ByValue {
		
	};
}
