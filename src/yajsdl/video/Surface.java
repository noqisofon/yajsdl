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

import yajsdl.jna.SDLLibrary;
import yajsdl.jna.SDL_Surface;
import yajsdl.jna.SDL_Color;


/**
 * 
 */
public class Surface {
    /**
     * 
     */
    public Surface(int width, int height, int depth, int flags) {
        PixelFormat pixel_format = PixelFormat.getDefaultPixelFormat();

        content_ = SDLLibrary.INSTANCE.SDL_CreateRGBSurface( flags,
                                                             width, height, depth,
                                                             pixel_format.getRedMask(),
                                                             pixel_format.getGreenMask(),
                                                             pixel_format.getBlueMask(),
                                                             pixel_format.getAlphaMask() );
    }


    /**
     * 8 bit サーフェスのカラーマップの一部を設定します。
     */
    public boolean setColors(Color[] colors, int firstColor, int nColors) {
        int ret = 0;
        SDL_Color[] sdl_colors = new SDL_Color[colors.length];

        for ( int i = 0; i < sdl_colors.length; ++ i ) {
            sdl_colors[i] = colors[i].toSDLColor();
        }

        ret = SDLLibrary.INSTANCE.SDL_SetColors( content_, sdl_colors, firstColor, nColors );

        return ret == 0;
    }


    /**
     * 8 bit サーフェスのパレットの一部を設定します。
     */
    public boolean setPalette(int flags, Color[] colors, int firstColor, int nColors) {
        int ret = 0;
        SDL_Color[] sdl_colors = new SDL_Color[colors.length];

        for ( int i = 0; i < sdl_colors.length; ++ i ) {
            sdl_colors[i] = colors[i].toSDLColor();
        }

        ret = SDLLibrary.INSTANCE.SDL_SetPalette( flags, content_, sdl_colors, firstColor, nColors );

        return ret == 0;
    }


    private SDL_Surface content_;
}
