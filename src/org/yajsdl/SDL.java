//  
//  SDL.java
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
package org.yajsdl;


import org.yajsdl.jna.SDLLibrary;


/**
 * @author rihine
 *
 */
public final class SDL {


    public static final int INIT_TIMER       = 0x00000001;
    public static final int INIT_AUDIO       = 0x00000010;
    public static final int INIT_VIDEO       = 0x00000020;
    public static final int INIT_CDROM       = 0x00000100;
    public static final int INIT_JOYSTICK    = 0x00000200;
    public static final int INIT_NOPARACHUTE = 0x00100000;  /**< Don't catch fatal signals */
    public static final int INIT_EVENTTHREAD = 0x01000000;  /**< Not supported on all OS's */
    public static final int INIT_EVERYTHING  = 0x0000FFFF;


    /**
     * 指定されたフラグを渡して SDL システムを初期化します。
     */
    public static boolean init(int flags) throws SDLException {
        int ret;

        ret = SDLLibrary.INSTANCE.SDL_Init( flags );

        if ( ret != 0 )
            throw new SDLException( SDLLibrary.INSTANCE.SDL_GetError() );

        return true;
    }


    /**
     * 指定されたフラグに対応する SDL サブシステムを初期化します。
     */
    public static boolean initSubSystem(int flags) throws SDLException {
        int ret;

        ret = SDLLibrary.INSTANCE.SDL_InitSubSystem( flags );

        if ( ret != 0 )
            throw new SDLException( SDLLibrary.INSTANCE.SDL_GetError() );

        return true;
    }


    /**
     * 指定されたフラグに対応する SDL サブシステムが初期化されているかどうかの論理和を返します。
     */
    public static boolean wasInit(int flags) {
        return (SDLLibrary.INSTANCE.SDL_WasInit( flags ) & flags) == flags;
    }


    /**
     * SDL ビデオサブシステムが初期化されていれば真を返します。
     */
    public static boolean wasInitVideo() {
        int flags = SDL.INIT_VIDEO;
        int ret = SDLLibrary.INSTANCE.SDL_WasInit( flags );

        return (ret & flags) == flags;
    }


    /**
     * SDL オーディオサブシステムが初期化されていれば真を返します。
     */
    public static boolean wasInitAudio() {
        int flags = SDL.INIT_AUDIO;
        int ret = SDLLibrary.INSTANCE.SDL_WasInit( flags );

        return (ret & flags) == flags;
    }


    /**
     * SDL タイマーサブシステムが初期化されていれば真を返します。
     */
    public static boolean wasInitTimer() {
        int flags = SDL.INIT_TIMER;
        int ret = SDLLibrary.INSTANCE.SDL_WasInit( flags );

        return (ret & flags) == flags;
    }


    /**
     * 以前に初期化した SDL システムをシャットダウンします。
     */
    public static void quit() {
        SDLLibrary.INSTANCE.SDL_Quit();
    }


    /**
     * 指定されたフラグに対応する SDL サブシステムをシャットダウンします。
     */
    public static boolean quitSubSystem(int flags) throws SDLException {
        int ret;

        ret = SDLLibrary.INSTANCE.SDL_QuitSubSystem( flags );

        if ( ret != 0 )
            throw new SDLException( SDLLibrary.INSTANCE.SDL_GetError() );

        return true;
    }
}
