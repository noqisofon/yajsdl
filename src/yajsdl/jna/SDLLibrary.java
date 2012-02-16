package yajsdl.jna;

import com.sun.jna.Library;
import com.sun.jna.Callback;
import com.sun.jna.Function;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;


public interface SDLLibrary extends Library {
    SDLLibrary INSTANCE = (SDLLibrary)Native.loadLibrary( "SDL", SDLLibrary.class );


    /**
     * SDL を初期化します。
     */
    int SDL_Init(int flags);


    /**
     * SDL のサブシステムを初期化します。
     */
    int SDL_InitSubSystem(int flags);
    

    /**
     * SDL をシャットダウンします。
     */
    void SDL_Quit();


    /**
     * SDL のサブシステムをシャットダウンします。
     */
    int SDL_QuitSubSystem(int flags);


    /**
     * SDL のサブシステムが初期化されているかどうかをチェックします。
     */
    int SDL_WasInit(int flags);


    /**
     * SDL のエラーを文字列で取得します。
     */
    String SDL_GetError();


    /// typedef for private surface blitting functions
	public interface SDL_blit extends Callback {
		int apply(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect);
	}


    /**
     * 現在の表示サーフェスへの参照を返します。
     */
    SDL_Surface SDL_GetVideoSurface();


    /**
     * ビデオハードウェアについての情報を持つオブジェクトを返します。
     */
    SDL_VideoInfo SDL_GetVideoInfo();


    /**
     * ビデオドライバの名前を取得します。
     */
    String SDL_VideoDriverName(String namebuf, int maxlen);


    /**
     * 指定されたフォーマットとビデオ初期化フラグに対し、利用可能な画面モードの配列を返します。
     */
    SDL_Rect[] SDL_ListModes(SDL_PixelFormat format, int flags);


    /**
     * ある特定のビデオモードがサポートされているかチェックします。
     */
    int SDL_VideoModeOK(int width, int height, int bpp, Uint32 flags);


    /**
     * 与えられた領域の画面を更新します。
     */
    void SDL_UpdateRect(SDL_Surface screen, Sint32 x, Sint32 y, Uint32 w, Uint32 h);


    /**
     * 与えられた矩形リストに従って画面を更新します。
     */
    void SDL_UpdateRects(SDL_Surface screen, int numrects, SDL_Rect[] rects);


    /**
     * スクリーンバッファを交換します。
     */
    int SDL_Flip(SDL_Surface screen);


    /**
     * 与えられた 8bit サーフェスのカラーマップの一部を設定します。
     */
    int SDL_SetColors(SDL_Surface surface, SDL_Color[] colors, int firstcolor, int ncolors);


    /**
     * 8bit サーフェスのパレットの一部を設定します。
     */
    int SDL_SetPalette(SDL_Surface surface, int flags, SDL_Color[] colors, int firstcolor, int ncolors);


    /**
     * 表示用のカラーガンマ関数を設定します。
     */
    int SDL_SetGamma(float redgamma, float greengamma, float bluegamma);


    /**
     * 表示のためのカラーガンマ値の変換テーブルを取得します。
     */
    int SDL_GetGammaRamp(ShortByReference redtable, ShortByReference greentable, ShortByReference bluetable);


    /**
     * 表示のためのカラーガンマ値の変換テーブルを設定します。
     */
    int SDL_SetGammaRamp(ShortByReference redtable, ShortByReference greentable, ShortByReference bluetable);


    /**
     * RGB カラー値をピクセルフォーマットに写像します。
     */
    int SDL_MapRGB(SDL_PixelFormat fmt, byte r, byte g, byte b);


    /**
     * RGBA カラー値をピクセルフォーマットに写像します。
     */
    int SDL_MapRGBA(SDL_PixelFormat fmt, byte r, byte g, byte b, byte a);


    /**
     * 指定されたピクセルフォーマット内のピクセルから RGB 値を取得します。
     */
    void SDL_GetRGB(int pixel, SDL_PixelFormat fmt, ShortByReference r, ShortByReference g, ShortByReference b);


    /**
     * 指定されたピクセルフォーマット内のピクセルから RGBA 値を取得します。
     */
    void SDL_GetRGBA(int pixel, SDL_PixelFormat fmt, ShortByReference r, ShortByReference g, ShortByReference b, ShortByReference a);


    /**
     * 空の SDL_Surface オブジェクトを作成します。
     */
    SDL_Surface SDL_CreateRGBSurface(int flags, int width, int height, int depth, int Rmask, int Gmask, int Bmask, int Amask);


    /**
     * 空の SDL_Surface オブジェクトを作成します。
     */
    SDL_Surface SDL_CreateRGBSurfaceFrom(/* void* */Pointer pixels, int flags, int width, int height, int depth, int Rmask, int Gmask, int Bmask, int Amask);


    /**
     * SDL_Surface オブジェクトを開放します。
     */
    void SDL_FreeSurface(SDL_Surface surface);


    /**
     * 直接アクセスのためにサーフェスをロックします。
     */
    int SDL_LockSurface(SDL_Surface surface);


    /**
     * 以前にロックされたサーフェスのロックを解除します。
     */
    void SDL_UnlockSurface(SDL_Surface surface);


    /**
     * BMP ファイルを読み込み、SDL_Surface として返します。
     */
    SDL_Surface SDL_LoadBMP(String file);


    /**
     * SDL_Surface オブジェクトを BMP ファイルとして保存します。
     */
    int SDL_SaveBMP(SDL_Surface surface, String file);


    /**
     * blit 転送可能なサーフェスのカラーキー(透明ピクセル)と、RLE アクセラレーションを設定します。
     */
    int SDL_SetColorKey(SDL_Surface surface, int flag, int key);


    /**
     * サーフェスのアルファ値を調整します。
     */
    int SDL_SetAlpha(SDL_Surface surface, int flag, int alpha);


    /**
     * サーフェスのクリッピング矩形を設定します。
     */
    void SDL_SetClipRect(SDL_Surface surface, SDL_Rect rect);


    /**
     * サーフェスのクリッピング矩形を取得します。
     */
    void SDL_GetClipRect(SDL_Surface surface, Pointer/* SDL_Rect* */ rect);


    /**
     * サーフェスを指定されたフォーマットとして新しいサーフェスに変換し直します。
     */
    SDL_Surface SDL_ConvertSurface(SDL_Surface src, SDL_PixelFormat fmt, int flags);


    /**
     * 転送元サーフェスから転送先サーフェスへ高速 blit を行います。
     */
    int SDL_UpperBlit(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect);


    /**
     * 転送元サーフェスから転送先サーフェスへ高速 blit を行います。
     */
    int SDL_LowerBlit(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect);


    /**
     * サーフェスに指定された色と矩形で高速な塗りつぶしを行います。
     */
    int SDL_FillRect(SDL_Surface dst, SDL_Rect dstrect, int color);


    /**
     * 指定されたサーフェスを表示可能なフォーマットに変換して返します。
     */
    SDL_Surface SDL_DisplayFormat(SDL_Surface surface);


    /**
     * 指定されたサーフェスを表示可能なフォーマットに変換して返します。
     */
    SDL_Surface SDL_DisplayFormatAlpha(SDL_Surface surface);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Mouse Cursor functions                                             */ /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * マウスカーソルを指定した位置に設定します。
     */
    void SDL_WarpMause(int x, int y);


    /**
     * 新しいマウスカーソルを作成して返します。
     */
    SDL_Cursor SDL_CreateCursor(Pointer/* Uint8* */ data, Pointer/* Uint8* */ mask, int w, int h, int hot_x, int hot_y);


    /**
     * SDL_CreateCursor メソッドで作成されたカーソルを開放します。
     */
    void SDL_FreeCursor(SDL_Cursor cursor);


    /**
     * 指定されたマウスカーソルをアクティブなマウスカーソルとして設定します。
     */
    Pointer SDL_SetCursor(SDL_Cursor cursor);


    /**
     * 現在アクティブなマウスカーソルを返します。
     */
    SDL_Cursor SDL_GetCursor();


    /**
     * マウスカーソルを表示するかどうかを設定します。
     */
    int SDL_ShowCursor(int toggle);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Open GL support functions                                          */ /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * OpenGL ライブラリを指定します。
     */
    int SDL_GL_LoadLibrary(String path);


    /**
     * GL 関数のアドレスを取得します。
     */
    Function SDL_GL_GetProcAddress(String procname);


    /**
     * 特殊な SDL/OpenGL 属性の値を取得します。
     */
    int SDL_GL_GetAttribute(SDL_GLattr attr, IntByReference value);


    /**
     * 特殊な SDL/OpenGL 属性の値を設定します。
     */
    int SDL_GL_SetAttribute(SDL_GLattr attr, int value);


    /**
     * OpenGL のフレームバッファを入れ替え、表示を更新します。
     */
    void SDL_GL_SwapBuffers();
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name YUV video surface overlay functions                                */ /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * YUV ビデオオーバレイを生成します。
     */
    SDL_Overlay SDL_CreateYUVOverlay(int width, int height, int format, SDL_Surface display);


    /**
     *
     */
    int SDL_LockYUVOverlay(SDL_Overlay overlay);


    /**
     * 
     */
    void SDL_UnlockYUVOverlay(SDL_Overlay overlay);


    /**
     * 
     */
    int SDL_DisplayYUVOverlay(SDL_Overlay overlay, SDL_Rect dstrect);


    /**
     * 
     */
    void SDL_FreeYUVOverlay(SDL_Overlay overlay);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Window Manager functions                                           */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * 
     */
    void SDL_WM_SetCaption(String title, String icon);


    /**
     * 
     */
    void SDL_WM_GetCaption(PointerByReference title, PointerByReference icon);


    /**
     * 
     */
    void SDL_WM_SetIcon(SDL_Surface icon, byte mask);


    /**
     * 
     */
    int SDL_WM_IconifyWindow();


    /**
     * 
     */
    int SDL_WM_ToggleFullScreen(SDL_Surface surface);


    /**
     * 
     */
    SDL_GrabMode SDL_WM_GrabInput(SDL_GrabMode mode);
    /* @} */


}
