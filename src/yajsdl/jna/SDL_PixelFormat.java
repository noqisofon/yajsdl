package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_PixelFormat extends Structure {
    Structure[] palette;
    byte BitsPerPixel;
    byte BytesPerPixel;
    int Rmask, Gmask, Bmask, Amask;
    byte Rshift, Gshift, Bshift, Ashift;
    byte Rloss, Gloss, Bloss, Aloss;
    int colorkey;
    byte alpha;
}
