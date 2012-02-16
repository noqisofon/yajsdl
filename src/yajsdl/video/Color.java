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
import yajsdl.jna.Uint8;


/**
 * SDL で使用する色を表します。
 */
public class Color {
    /**
     * 範囲(0..255)の指定された赤、緑、青を使って、RGB カラーを作成します。
     */
    public Color(byte r, byte g, byte b) {
        this.red_   = r;
        this.green_ = g;
        this.blue_  = b;
        this.alpha_ = 0;

        this.pixcel_format_ = PixelFormat.getDefaultPixelFormat();
    }
    /**
     * 範囲(0..255)の指定された赤、緑、青、およびアルファ値を使って、RGBA カラーを作成します。
     */
    public Color(byte r, byte g, byte b, byte a) {
        this.red_   = r;
        this.green_ = g;
        this.blue_  = b;
        this.alpha_ = a;

        this.pixcel_format_ = PixelFormat.getDefaultPixelFormat();
    }
    /**
     *
     */
    public Color(int rgb) {
        this.red_   = (byte)((rgb >> 16) & 0xff);
        this.green_ = (byte)((rgb >>  8) & 0xff);
        this.blue_  = (byte)(rgb & 0xff);
        this.alpha_ = 0;

        this.pixcel_format_ = PixelFormat.getDefaultPixelFormat();
    }


    /**
     *
     */
    public byte getRed() { return this.red_; }


    /**
     *
     */
    public byte getGreen() { return this.green_; }


    /**
     *
     */
    public byte getBlue() { return this.blue_; }


    /**
     *
     */
    public void setRed(byte red) { this.red_ = red; }


    /**
     *
     */
    public void setGreen(byte green) { this.green_ = green; }


    /**
     *
     */
    public void setBlue(byte blue) { this.blue_ = blue; }


    /**
     * デフォルトの PixelFormat に含まれる色を表す RGB 値を返します。
     */
    public int getRGB() {
        return SDLLibrary.INSTANCE.SDL_MapRGB( this.pixcel_format_.toSource(),
                                               this.red_,
                                               this.green_,
                                               this.blue_ );
    }


    /**
     * デフォルトの PixelFormat に含まれる色を表す RGBA 値を返します。
     */
    public int getRGBA() {
        return SDLLibrary.INSTANCE.SDL_MapRGBA( this.pixcel_format_.toSource(),
                                                this.red_,
                                                this.green_,
                                                this.blue_,
                                                this.alpha_ );
    }


    /**
     * レシーバを SDL_Color オブジェクトに変換して返します。
     */
    public SDL_Color toSource() {
        SDL_Color ret = new SDL_Color();

        ret.r = Uint8.valueOf( this.red_ );
        ret.g = Uint8.valueOf( this.green_ );
        ret.b = Uint8.valueOf( this.blue_ );
        ret.unused = Uint8.valueOf( this.alpha_ );

        return ret;
    }


    private byte red_, green_, blue_, alpha_;
    private PixelFormat pixcel_format_;
}
