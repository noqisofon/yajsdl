/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yajsdl.video;

import yajsdl.jna.SDL_Surface;

/**
 *
 * @author rihine
 */
public class Screen extends Surface {
    /**
     *
     */
    private Screen() {
    }
    /**
     *
     */
    private Screen(SDL_Surface other) {
        super( other );
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
            the_screen = new Screen( Surface.baseSetVideoMode( width, height, bpp, flags ) );
        }
        return the_screen;
    }
    
    
    private static Screen the_screen;
}