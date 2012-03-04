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
package org.yajsdl.video;

import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Color;


/**
 * SDL で使用する色を表します。
 */
public class Color {
    /**
     * 範囲(0..255)の指定された赤、緑、青を使って、RGB カラーを作成します。
     */
    public Color(byte r, byte g, byte b) {
        this.red_ = r;
        this.green_ = g;
        this.blue_ = b;
        this.alpha_ = 0;
    }


    /**
     * 範囲(0..255)の指定された赤、緑、青、およびアルファ値を使って、RGBA カラーを作成します。
     */
    public Color(byte r, byte g, byte b, byte a) {
        this.red_ = r;
        this.green_ = g;
        this.blue_ = b;
        this.alpha_ = a;
    }


    /**
     *
     */
    public Color(int rgb) {
        this.red_ = (byte)( ( rgb >> 16 ) & 0xff );
        this.green_ = (byte)( ( rgb >> 8 ) & 0xff );
        this.blue_ = (byte)( rgb & 0xff );
        this.alpha_ = 0;
    }


    /**
     *
     */
    public byte getRed() {
        return this.red_;
    }


    /**
     *
     */
    public byte getGreen() {
        return this.green_;
    }


    /**
     *
     */
    public byte getBlue() {
        return this.blue_;
    }


    /**
     *
     */
    public void setRed(byte red) {
        this.red_ = red;
    }


    /**
     *
     */
    public void setGreen(byte green) {
        this.green_ = green;
    }


    /**
     *
     */
    public void setBlue(byte blue) {
        this.blue_ = blue;
    }


    /**
     * 指定された PixelFormat オブジェクトに含まれる色を表す RGB 値を返します。
     */
    public int getRGB(PixelFormat pixelFormat) {
        return SDLLibrary.INSTANCE.SDL_MapRGB( pixelFormat.toSource(), this.red_, this.green_, this.blue_ );
    }


    /**
     * 指定されたの PixelFormat オブジェクトに含まれる色を表す RGBA 値を返します。
     */
    public int getRGBA(PixelFormat pixelFormat) {
        return SDLLibrary.INSTANCE
                .SDL_MapRGBA( pixelFormat.toSource(), this.red_, this.green_, this.blue_, this.alpha_ );
    }


    /**
     * レシーバを SDL_Color オブジェクトに変換して返します。
     */
    public SDL_Color toSource() {
        SDL_Color ret = new SDL_Color();

        ret.r = this.red_;
        ret.g = this.green_;
        ret.b = this.blue_;
        ret.unused = this.alpha_;

        return ret;
    }


    /**
     * 
     */
    public int toInt() {
        int ret = 0;
        int r = this.red_ & 0x000000ff;
        int g = this.green_ & 0x000000ff;
        int b = this.blue_ & 0x000000ff;
        int u = this.alpha_ & 0x000000ff;

        g = g << 8;
        b = b << 16;
        u = u << 24;

        ret = r + g + b + u;

        return ret;
    }


    /**
     * 
     */
    public byte[] toByteArray() {
        return new byte[] { this.red_, this.green_, this.blue_, this.alpha_ };
    }

    private byte red_, green_, blue_, alpha_;
}
