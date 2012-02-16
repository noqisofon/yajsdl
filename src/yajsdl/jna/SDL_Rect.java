package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_Rect extends Structure {
    public Sint16 x, y;
    public Uint16 w, h;


    public SDL_Rect() {
        super();
        this.initFieldOrder();
    }
    public SDL_Rect(Sint16 x, Sint16 y, Uint16 w, Uint16 h) {
        super();

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new String[] { "x", "y", "w", "h" } );
    }


    public static class ByReference extends SDL_Rect implements Structure.ByReference {}
    public static class ByValue extends SDL_Rect implements Structure.ByValue {}
}
