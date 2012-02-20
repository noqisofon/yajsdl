/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.video;

import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Surface;

/**
 *
 * @author rihine
 */
public class Screen extends Surface {

    public static final int SYSTEM_MEMORY = SDLLibrary.SDL_SWSURFACE;
    public static final int VIDEO_MEMORY = SDLLibrary.SDL_HWSURFACE;
    public static final int ASYNC_BLIT = SDLLibrary.SDL_ASYNCBLIT;


    /**
     *
     */
    private Screen() {
    }
    /**
     *
     */
    private Screen(int width, int height, int bpp, int flags) {
        super( Surface.baseSetVideoMode( width, height, bpp, flags ) );
    }


    /**
     * 
     */
    public void updateRect(int x, int y, int width, int height) {
        super.baseUpdateRect( x, y, width, height );
    }


    /**
     * 
     */
    public void flip() {
        super.baseFlip();
    }
    
    
    /**
     * 常に真を返します。
     */
    @Override
    public boolean isScreen() {
        return true;
    }


    /**
     *
     */
    public static Screen setVideoMode(int width, int height, int bpp, int flags) {
        if ( the_screen == null ) {
            the_screen = new Screen( width, height, bpp, flags );
        }
        return the_screen;
    }


    /**
     * 
     */
    public static int videoModeOK(int width, int height, int bpp, int flags) {
        return SDLLibrary.INSTANCE.SDL_VideoModeOK( width, height, bpp, flags );
    }
    
    
    private static Screen the_screen;
}
