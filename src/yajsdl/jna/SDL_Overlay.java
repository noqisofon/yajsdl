package yajsdl.jna;

import com.sun.jna.Structure;
import com.sun.jna.Function;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;


public class SDL_Overlay extends Structure {
    /**
     * < Read-only<br>
     * C type : Uint32
     */
    public Uint32 format;
    /// < Read-only
    public int w;
    /// < Read-only
    public int h;
    /// < Read-only
    public int planes;
    /**
     * < Read-only<br>
     * C type : Uint16*
     */
    public Pointer pitches;
    /**
     * < Read-write<br>
     * C type : Uint8**
     */
    public PointerByReference pixels;
    /**
     * @{<br>
     * C type : private_yuvhwfuncs*
     */
    public Pointer hwfuncs;
    /// C type : private_yuvhwdata*
    public Pointer hwdata;
    /// Conversion Error : hw_overlay:1 (This runtime does not support bit fields : JNA)
    public Uint32 hw_overlay;
    /// Conversion Error : UnusedBits:31 (This runtime does not support bit fields : JNA)
    public Uint32 UnusedBits;


    public SDL_Overlay() {
        super();
        initFieldOrder();
    }


    /**
     * @param format < Read-only<br>
     * C type : Uint32<br>
     * @param w < Read-only<br>
     * @param h < Read-only<br>
     * @param planes < Read-only<br>
     * @param pitches < Read-only<br>
     * C type : Uint16*<br>
     * @param pixels < Read-write<br>
     * C type : Uint8**<br>
     * @param hwfuncs @{<br>
     * C type : private_yuvhwfuncs*<br>
     * @param hwdata C type : private_yuvhwdata*
     */
    public SDL_Overlay(Uint32 format, int w, int h, int planes, Pointer pitches, PointerByReference pixels, Pointer hwfuncs, Pointer hwdata) {
        super();

        this.format = format;
        this.w = w;
        this.h = h;
        this.planes = planes;
        this.pitches = pitches;
        this.pixels = pixels;
        this.hwfuncs = hwfuncs;
        this.hwdata = hwdata;

        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new String[] { "format", "w", "h", "planes", "pitches", "pixels", "hwfuncs", "hwdata", "hw_overlay", "UnusedBits" } );
    }


    public static class ByReference extends SDL_Overlay implements Structure.ByReference {}
    public static class ByValue extends SDL_Overlay implements Structure.ByValue {}
}
