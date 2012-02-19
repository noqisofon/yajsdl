//  
//  Surface.java
//  
//  Auther:
//       ned rihine <ned.rihine@gmail.com>
// 
//  Copyright (c) 2012 rihine All rights reserved.
// 
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
// 
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
// 
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
package yajsdl.video;

import java.nio.ByteBuffer;
import com.sun.jna.Pointer;

import yajsdl.Disposable;
import yajsdl.jna.SDLLibrary;
import yajsdl.jna.SDL_Color;
import yajsdl.jna.SDL_Surface;
import yajsdl.jna.SDL_Rect;


/**
 * 
 */
public class Surface implements Disposable {
    /**
     * 
     */
    public Surface() {
    }
    /**
     * 
     */
    public Surface(SDL_Surface other) {
        this.content_ = other;
        this.is_disposed_ = false;
    }
    /**
     * 指定された幅、高さ、色深度、サーフェスフラッグを持つ空のサーフェスを作成します。
     */
    public Surface(int width, int height, int depth, int flags) {
        this.content_ = baseCreateRGBSurface( width, height, depth, flags );
        this.is_disposed_ = false;
    }
    /**
     * 指定された幅、高さ、色深度、サーフェスフラッグを持つサーフェスをピクセルバッファから作成します。
     */
    public Surface(ByteBuffer pixelBuffer, int width, int height, int depth, int flags) {
        this.content_ = baseCreateRGBSurfaceFrom( pixelBuffer, width, height, depth, flags );
        this.is_disposed_ = false;
    }


    /**
     * 8 bit サーフェスのカラーマップの一部を設定します。
     */
    public boolean setColors(Color[] colors, int firstColor, int nColors) {
        return baseSetColors( colors, firstColor, nColors );
    }


    /**
     * 8 bit サーフェスのパレットの一部を設定します。
     */
    public boolean setPalette(int flags, Color[] colors, int firstColor, int nColors) {
        return baseSetPalette( flags, colors, firstColor, nColors );
    }


    /**
     * 
     */
    public SDL_Surface toSource() {
        return this.content_;
    }


    /**
     * 
     */
    public boolean isDisposed() {
        return this.is_disposed_;
    }


    /**
     * 
     */
    public boolean isMustLock() {
        return this.content_.offset != 0 ||
            ( this.content_.flags & (SDLLibrary.SDL_HWSURFACE | SDLLibrary.SDL_ASYNCBLIT | SDLLibrary.SDL_RLEACCEL) ) != 0;
    }
    
    
    /**
     * 
     */
    public boolean isScreen() {
        return false;
    }


    /**
     * 
     */
    public void dispose() {
        if ( this.is_disposed_ != true ) {
            SDLLibrary.INSTANCE.SDL_FreeSurface( this.content_ );
            this.is_disposed_ = true;
        }
    }


    /**
     * 
     */
    protected static SDL_Surface baseCreateRGBSurface(int flags, int width, int height, int depth) {
        PixelFormat pixel_format = PixelFormat.getDefaultPixelFormat();

        return baseCreateRGBSurface( flags,
                                     width, height, depth,
                                     pixel_format.getRedMask(),
                                     pixel_format.getGreenMask(),
                                     pixel_format.getBlueMask(),
                                     pixel_format.getAlphaMask() );
    }
    /**
     * 
     */
    protected static SDL_Surface baseCreateRGBSurface(int flags, int width, int height, int depth, int redMask, int greenMask, int blueMask, int alphaMask) {
        return SDLLibrary.INSTANCE.SDL_CreateRGBSurface( flags,
                                                         width, height, depth,
                                                         redMask, greenMask, blueMask,
                                                         alphaMask );        

        
    }


    /**
     * 
     */
    protected static SDL_Surface baseCreateRGBSurfaceFrom(ByteBuffer pixel_buffer, int flags, int width, int height, int depth) {
        PixelFormat pixel_format = PixelFormat.getDefaultPixelFormat();

        return baseCreateRGBSurfaceFrom( pixel_buffer,
                                         flags,
                                         width, height, depth,
                                         pixel_format.getRedMask(),
                                         pixel_format.getGreenMask(),
                                         pixel_format.getBlueMask(),
                                         pixel_format.getAlphaMask() );
    }
    /**
     * 
     */
    protected static SDL_Surface baseCreateRGBSurfaceFrom(ByteBuffer pixelBuffer,
                                                          int flags,
                                                          int width, int height, int depth,
                                                          int redMask, int greenMask, int blueMask, int alphaMask) {
        Pointer pixel = new Pointer( 0 );
        byte[] temp_bry = new byte[pixelBuffer.limit()];

        pixelBuffer.get( temp_bry );
        pixel.write( 0, temp_bry, 0, temp_bry.length );

        return  SDLLibrary.INSTANCE.SDL_CreateRGBSurfaceFrom( pixel,
                                                              flags,
                                                              width, height, depth,
                                                              redMask, greenMask, blueMask,
                                                              alphaMask );
    }


    /**
     * 
     */
    protected boolean baseSetColors(Color[] colors, int firstColor, int nColors) {
        int ret;
        SDL_Color[] sdl_colors = convertNativeColors( colors );

        ret = SDLLibrary.INSTANCE.SDL_SetColors( content_, sdl_colors, firstColor, nColors );

        return ret == 0;
    }


    /**
     * 
     */
    protected boolean baseSetPalette(int flags, Color[] colors, int firstColor, int nColors) {
        int ret;
        SDL_Color[] sdl_colors = convertNativeColors( colors );

        ret = SDLLibrary.INSTANCE.SDL_SetPalette( this.content_, flags, sdl_colors, firstColor, nColors );

        return ret == 0;
    }


    /**
     * 
     */
    protected void baseUpdateRect(int x, int y, int width, int height) {
        SDLLibrary.INSTANCE.SDL_UpdateRect( content_,
                                             x,
                                             y,
                                             width,
                                             height );
    }


    /**
     * 
     */
    protected void baseUpdateRects(Rect[] rects) {
        SDL_Rect[] sdl_rects = convertNativeRects( rects );

        SDLLibrary.INSTANCE.SDL_UpdateRects( content_, rects.length, sdl_rects );
    }


    /**
     * 
     */
    protected void baseFlip() {
        SDLLibrary.INSTANCE.SDL_Flip( content_ );
    }


    /**
     * 
     */
    private static SDL_Color[] convertNativeColors(Color[] colors) {
        SDL_Color[] sdl_colors = new SDL_Color[colors.length];

        for ( int i = 0; i < sdl_colors.length; ++ i ) {
            sdl_colors[i] = colors[i].toSource();
        }
        return sdl_colors;
    }


    /**
     * 
     */
    private static SDL_Rect[] convertNativeRects(Rect[] rects) {
        SDL_Rect[] sdl_rects = new SDL_Rect[rects.length];

        for ( int i = 0; i < sdl_rects.length; ++ i ) {
            sdl_rects[i] = rects[i].toSource();
        }
        return sdl_rects;
    }
    
    
    static SDL_Surface baseSetVideoMode(int width, int height, int bpp, int flags) {
        return SDLLibrary.INSTANCE.SDL_SetVideoMode( width, height, bpp, flags );
    }


    private SDL_Surface content_;
    private boolean is_disposed_;
}
