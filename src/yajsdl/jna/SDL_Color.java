package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_Color extends Structure {
    public Uint8 r;
    public Uint8 g;
    public Uint8 b;
    public Uint8 unused;


    public SDL_Color() {
        super();

        this.initFieldOrder();
    }
    public SDL_Color(Uint8 r, Uint8 g, Uint8 b) {
        super();

        this.r = r;
        this.g = g;
        this.b = b;
        this.unused = Uint8.valueOf( 0 );

        this.initFieldOrder();
    }
    public SDL_Color(Uint8 r, Uint8 g, Uint8 b, Uint8 a) {
        super();

        this.r = r;
        this.g = g;
        this.b = b;
        this.unused = a;

        this.initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new String[] { "r", "g", "b", "unused" } );
    }


    public static class ByReference extends SDL_Color implements Structure.ByReference {}
    public static class ByValue extends SDL_Color implements Structure.ByValue {}
}
