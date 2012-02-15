package yajsdl.jna;

import com.sun.jna.Structure;
import com.sun.jna.Pointer;


public class SDL_Surface extends Structure {
    int flags;
    SDL_PixelFormat format;
    int w, h;
    short pitch;
    Pointer/* void* */ pixels;
    int offset;

    Pointer/* struct private_hwdata* */ hwdata;

    SDL_Rect clip_rect;
    int unused1;

    int locked;

    SDL_BlitMap map;

    int format_version;

    int refcount;
}
