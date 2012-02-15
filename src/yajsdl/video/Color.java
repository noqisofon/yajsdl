//  
//  Color.java
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
import yajsdl.jna.SDL_Color;


/**
 * SDL で使用する色を表します。
 */
public class Color {
    /**
     * 範囲(0..255)の指定された赤、緑、青を使って、RGB カラーを作成します。
     */
    public Color(int r, int g, int b) {
        this.red_   = r & 0xff;
        this.green_ = g & 0xff;
        this.blue_  = b & 0xff;
        this.alpha_ = 0;
    }
    /**
     * 範囲(0..255)の指定された赤、緑、青、およびアルファ値を使って、RGBA カラーを作成します。
     */
    public Color(int r, int g, int b, int a) {
        this.red_   = r & 0xff;
        this.green_ = g & 0xff;
        this.blue_  = b & 0xff;
        this.alpha_ = a & 0xff;
    }
    /**
     *
     */
    public Color(int rgb) {
        this.red_   = (rgb >> 16) & 0xff;
        this.green_ = (rgb >>  8) & 0xff;
        this.blue_  = rgb & 0xff;
        this.alpha_ = 0;
    }


    /**
     *
     */
    public int getRed() { return this.red_; }


    /**
     *
     */
    public int getGreen() { return this.green_; }


    /**
     *
     */
    public int getBlue() { return this.blue_; }


    /**
     *
     */
    public void setRed(int red) { this.red_ = red; }


    /**
     *
     */
    public void setGreen(int green) { this.green_ = green; }


    /**
     *
     */
    public void setBlue(int blue) { this.blue_ = blue; }


    /**
     * デフォルトの PixelFormat に含まれる色を表す RGB 値を返します。
     */
    public int getRGB() {
        return SDLLibrary.INSTANCE.SDL_MapRGB( PixelFormat.getDefaultPixelFormat(),
                                               this.red_,
                                               this.green_,
                                               this.blue_ );
    }


    /**
     * デフォルトの PixelFormat に含まれる色を表す RGBA 値を返します。
     */
    public int getRGBA() {
        return SDLLibrary.INSTANCE.SDL_MapRGBA( PixelFormat.getDefaultPixelFormat(),
                                                this.red_,
                                                this.green_,
                                                this.blue_,
                                                this.alpha_ );
    }


    /**
     * レシーバを SDL_Color オブジェクトに変換して返します。
     */
    public SDL_Color toSDLColor() {
        SDL_Color ret = new SDL_Color();

        ret.r = this.red_;
        ret.g = this.green_;
        ret.b = this.blue_;
        ret.unused = this.alpha_;

        return ret;
    }


    private int red_, green_, blue_, alpha_;
}
