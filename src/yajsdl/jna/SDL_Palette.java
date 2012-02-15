package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_Palette extends Structure {
    int ncolors;
    /*SDL_Color* */Structure[] colors;
}
