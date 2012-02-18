package yajsdl.jna;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * <i>native declaration : /usr/include/SDL/SDL_mouse.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_Cursor extends Structure {
	/**
	 * < The area of the mouse cursor<br>
	 * C type : SDL_Rect
	 */
	public SDL_Rect area;
	/**
	 * < The "tip" of the cursor<br>
	 * C type : Sint16
	 */
	public short hot_x;
	/**
	 * < The "tip" of the cursor<br>
	 * C type : Sint16
	 */
	public short hot_y;
	/**
	 * < B/W cursor data<br>
	 * C type : Uint8*
	 */
	public Pointer data;
	/**
	 * < B/W cursor mask<br>
	 * C type : Uint8*
	 */
	public Pointer mask;
	/**
	 * < Place to save cursor area<br>
	 * C type : Uint8*[2]
	 */
	public Pointer[] save = new Pointer[(2)];
	/**
	 * < Window-manager cursor<br>
	 * C type : WMcursor*
	 */
	public Pointer wm_cursor;
	public SDL_Cursor() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"area", "hot_x", "hot_y", "data", "mask", "save", "wm_cursor"});
	}
	/**
	 * @param area < The area of the mouse cursor<br>
	 * C type : SDL_Rect<br>
	 * @param hot_x < The "tip" of the cursor<br>
	 * C type : Sint16<br>
	 * @param hot_y < The "tip" of the cursor<br>
	 * C type : Sint16<br>
	 * @param data < B/W cursor data<br>
	 * C type : Uint8*<br>
	 * @param mask < B/W cursor mask<br>
	 * C type : Uint8*<br>
	 * @param save < Place to save cursor area<br>
	 * C type : Uint8*[2]<br>
	 * @param wm_cursor < Window-manager cursor<br>
	 * C type : WMcursor*
	 */
	public SDL_Cursor(SDL_Rect area, short hot_x, short hot_y, Pointer data, Pointer mask, Pointer save[], Pointer wm_cursor) {
		super();
		this.area = area;
		this.hot_x = hot_x;
		this.hot_y = hot_y;
		this.data = data;
		this.mask = mask;
		if (save.length != this.save.length) 
			throw new IllegalArgumentException("Wrong array size !");
		this.save = save;
		this.wm_cursor = wm_cursor;
		initFieldOrder();
	}
	public static class ByReference extends SDL_Cursor implements Structure.ByReference {
		
	};
	public static class ByValue extends SDL_Cursor implements Structure.ByValue {
		
	};
}
