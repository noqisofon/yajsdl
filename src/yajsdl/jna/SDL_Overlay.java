package yajsdl.jna;

import com.sun.jna.Structure;
import com.sun.jna.Function;
import com.sun.jna.Pointer;


public class SDL_Overlay extends Structure {
    int format;
    int w, h;
    int planes;
    short[] pitches;
    byte[][] pixels;

    Function[]/* struct private_yuvhwfuncs */ hwfuncs;
    Pointer/* struct private_yuvhwdata* */ hwdata;

    int hw_overlay;
    int Unusedbits;
}
