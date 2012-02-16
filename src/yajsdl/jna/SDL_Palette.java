package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_Palette extends Structure {
    public int ncolors;
    /// C type : SDL_Color*
    public SDL_Color.ByReference colors;


    public SDL_Palette() {
        super();
        this.initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new String[]{ "ncolors", "colors" } );
    }


    /// @param colors C type : SDL_Color*
    public SDL_Palette(int ncolors, SDL_Color.ByReference colors) {
        super();

        this.ncolors = ncolors;
        this.colors = colors;

        this.initFieldOrder();
    }


    public static class ByReference extends SDL_Palette implements Structure.ByReference {}
    public static class ByValue extends SDL_Palette implements Structure.ByValue {}
}
