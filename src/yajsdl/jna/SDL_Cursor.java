package yajsdl.jna;

import com.sun.jna.Structure;
import com.sun.jna.Pointer;


public class SDL_Cursor extends Structure {
    SDL_Rect area;
    short hot_x, hot_y;
    byte[] data;
    byte[] mask;
    byte[/*2*/] save;
    Pointer/* WMcursor*/ wm_cursor;
}
