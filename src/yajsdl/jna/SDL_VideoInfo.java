package yajsdl.jna;

import com.sun.jna.Structure;


public class SDL_VideoInfo extends Structure {
    /// Conversion Error : hw_available:1 (This runtime does not support bit fields : JNA)
    public Uint32 hw_available;
    /// Conversion Error : wm_available:1 (This runtime does not support bit fields : JNA)
    public Uint32 wm_available;
    /// Conversion Error : UnusedBits1:6 (This runtime does not support bit fields : JNA)
    public Uint32 UnusedBits1;
    /// Conversion Error : UnusedBits2:1 (This runtime does not support bit fields : JNA)
    public Uint32 UnusedBits2;
    /// Conversion Error : blit_hw:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_hw;
    /// Conversion Error : blit_hw_CC:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_hw_CC;
    /// Conversion Error : blit_hw_A:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_hw_A;
    /// Conversion Error : blit_sw:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_sw;
    /// Conversion Error : blit_sw_CC:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_sw_CC;
    /// Conversion Error : blit_sw_A:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_sw_A;
    /// Conversion Error : blit_fill:1 (This runtime does not support bit fields : JNA)
    public Uint32 blit_fill;
    /// Conversion Error : UnusedBits3:16 (This runtime does not support bit fields : JNA)
    public Uint32 UnusedBits3;
    /**
     * < The total amount of video memory (in K)<br>
     * C type : Uint32
     */
    public Uint32 video_mem;
    /**
     * < Value: The format of the video surface<br>
     * C type : SDL_PixelFormat*
     */
    public SDL_PixelFormat.ByReference vfmt;
    /// < Value: The current video mode width
    public int current_w;
    /// < Value: The current video mode height
    public int current_h;


    protected void initFieldOrder() {
        setFieldOrder( new String[] { "hw_available", "wm_available",
                                      "UnusedBits1", "UnusedBits2",
                                      "blit_hw", "blit_hw_CC", "blit_hw_A",
                                      "blit_sw", "blit_sw_CC", "blit_sw_A",
                                      "blit_fill", "UnusedBits3",
                                      "video_mem", "vfmt", "current_w", "current_h" } );
    }


    public SDL_VideoInfo() {
        super();
        this.initFieldOrder();
    }
    /**
     * @param video_mem < The total amount of video memory (in K)<br>
     * C type : Uint32<br>
     * @param vfmt < Value: The format of the video surface<br>
     * C type : SDL_PixelFormat*<br>
     * @param current_w < Value: The current video mode width<br>
     * @param current_h < Value: The current video mode height
     */
    public SDL_VideoInfo(Uint32 video_mem, SDL_PixelFormat.ByReference vfmt, int current_w, int current_h) {
        super();

        this.video_mem = video_mem;
        this.vfmt = vfmt;
        this.current_w = current_w;
        this.current_h = current_h;

        this.initFieldOrder();
    }


    public static class ByReference extends SDL_VideoInfo implements Structure.ByReference {}
    public static class ByValue extends SDL_VideoInfo implements Structure.ByValue {}
}
