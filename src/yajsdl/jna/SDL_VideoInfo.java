package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_VideoInfo extends Structure {
    int hw_available;
    int wm_available;
    int blit_hw;
    int blit_hw_CC;
    int blit_hw_A;
    int blit_sw;
    int blit_sw_CC;
    int blit_sw_A;
    int blit_fill;
    int video_mem;
    SDL_PixelFormat vfmt;
    int current_w;
    int current_h;
}
