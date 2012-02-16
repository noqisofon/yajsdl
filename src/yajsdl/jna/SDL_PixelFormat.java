package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_PixelFormat extends Structure {
    /// C type : SDL_Palette*
    public SDL_Palette.ByReference palette;
    /// C type : Uint8
    public Uint8 BitsPerPixel;
    /// C type : Uint8
    public Uint8 BytesPerPixel;
    /// C type : Uint8
    public Uint8 Rloss;
    /// C type : Uint8
    public Uint8 Gloss;
    /// C type : Uint8
    public Uint8 Bloss;
    /// C type : Uint8
    public Uint8 Aloss;
    /// C type : Uint8
    public Uint8 Rshift;
    /// C type : Uint8
    public Uint8 Gshift;
    /// C type : Uint8
    public Uint8 Bshift;
    /// C type : Uint8
    public Uint8 Ashift;
    /// C type : Uint32
    public Uint32 Rmask;
    /// C type : Uint32
    public Uint32 Gmask;
    /// C type : Uint32
    public Uint32 Bmask;
    /// C type : Uint32
    public Uint32 Amask;
    /**
     * RGB color key information<br>
     * C type : Uint32
     */
    public Uint32 colorkey;
    /**
     * Alpha value information (per-surface alpha)<br>
     * C type : Uint8
     */
    public Uint8 alpha;


    public SDL_PixelFormat() {
        super();
        this.initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "palette",
                                                "BitsPerPixel", "BytesPerPixel",
                                                "Rloss", "Gloss", "Bloss", "Aloss",
                                                "Rshift", "Gshift", "Bshift", "Ashift",
                                                "Rmask", "Gmask", "Bmask", "Amask",
                                                "colorkey", "alpha" } );
    }


    public static class ByReference extends SDL_PixelFormat implements Structure.ByReference {}
    public static class ByValue extends SDL_PixelFormat implements Structure.ByValue {}
}
