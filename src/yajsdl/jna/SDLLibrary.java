package yajsdl.jna;

import com.sun.jna.Library;
import com.sun.jna.Callback;
import com.sun.jna.Function;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;


public interface SDLLibrary extends Library {
    SDLLibrary INSTANCE = (SDLLibrary)Native.loadLibrary( "SDL", SDLLibrary.class );
    
    
    public interface XEvent {
    }


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Init functions                                                     */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

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
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Active functions                                                   */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static final byte SDL_APPMOUSEFOCUS = 0x01;
    public static final byte SDL_APPINPUTFOCUS = 0x02;
    public static final byte SDL_APPACTIVE     = 0x04;

    /**
     * 
     */
    Uint8 SDL_GetAppState();
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Audio functions                                                    */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static final int AUDIO_U8 = 0x0008;   /**< Unsigned 8-bit samples */
    public static final int AUDIO_S8 = 0x8008;   /**< Signed 8-bit samples */
    public static final int AUDIO_U16LSB = 0x0010;    /**< Unsigned 16-bit samples */
    public static final int AUDIO_S16LSB = 0x8010;    /**< Signed 16-bit samples */
    public static final int AUDIO_U16MSB = 0x1010;    /**< As above, but big-endian byte order */
    public static final int AUDIO_S16MSB = 0x9010;    /**< As above, but big-endian byte order */
    public static final int AUDIO_U16 = AUDIO_U16LSB;
    public static final int AUDIO_S16 = AUDIO_S16LSB;

    public static final int AUDIO_U16SYS = AUDIO_U16LSB;
    public static final int AUDIO_S16SYS = AUDIO_S16LSB;

    /**
     * 
     */
    int SDL_AudioInit(String driver_name);


    /**
     * 
     */
    void SDL_AudioQuit();


    /**
     * 
     */
    String SDL_AudioDriverName(String namebuf, int maxlen);


    /**
     * @see SDL_AudioSpec
     */
    int SDL_OpenAudio(SDL_AudioSpec desired, SDL_AudioSpec obtained);


    public static interface SDL_audiostatus {
        public static final int SDL_AUDIO_STOPPED = 0;
        public static final int SDL_AUDIO_PLAYING = 1;
        public static final int SDL_AUDIO_PAUSED  = 2;
    }


    /**
     * 
     */
    SDL_audiostatus SDL_GetAudioStatus();


    /**
     * 
     */
    void SDL_PauseAudio(int pause_on);


    /**
     * 
     */
    SDL_AudioSpec SDL_LoadWAV_RW(SDL_RWops src, int freesrc, SDL_AudioSpec spec, PointerByReference/* Uint8** */audio_buf, Pointer/* Uint8* */ audio_len);


    /**
     * 
     */
    void SDL_FreeAWV(PointerByReference/* Uint8** */audio_buf);


    /**
     * 
     */
    int SDL_BuildAudioCVT( SDL_AudioCVT cvt,
                           Uint16 src_foramt, Uint8 src_channels, int src_rate,
                           Uint16 dst_foramt, Uint8 dst_channels, int dst_rate );


    /**
     * 
     */
    int SDL_ConvertAudio(SDL_AudioCVT cvt);


    public static final int SDL_MIX_MAXVOLUME = 128;


    /**
     * @param dst
     * @param src
     * @param len
     * @param volume
     */
    void SDL_MixAudio(Pointer/* Uint8* */ dst, Pointer/* const Uint8* */src, Uint32 len, int volume);


    /**
     * 
     */
    void SDL_LockAudio();


    /**
     * 
     */
    void SDL_UnlockAudio();


    /**
     * 
     */
    void SDL_CloseAudio();
    
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name CD ROM functions                                                   */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static final int SDL_MAX_TRACKS = 99;

    public static final byte SDL_AUDIO_TRACK = 0x00;
    public static final byte SDL_DATA_TRACK = 0x04;


    public static interface CDstatus {
        public static final int CD_TRAYEMPTY = 0;
        public static final int CD_STOPPED = 1;
        public static final int CD_PLAYING = 2;
        public static final int CD_PAUSED = 3;
        public static final int CD_ERROR = -1;
    }


    public static final int CD_FPS = 75;


    /**
     * 
     */
    int SDL_CDNumDrives();


    /**
     * 
     */
    String SDL_CDName(int drive);


    /**
     * 
     */
    SDL_CD SDL_CDOpen(int drive);


    /**
     * 
     */
    CDstatus SDL_CDStatus(SDL_CD cdrom);


    /**
     * 
     */
    int SDL_CDPlayTracks(SDL_CD cdrom, int start_track, int start_frame, int ntracks, int nframes);


    /**
     * 
     */
    int SDL_CDPlay(SDL_CD cdrom, int start, int length);


    /**
     *
     */
    int SDL_CDPause(SDL_CD cdrom);


    /**
     * 
     */
    int SDL_CDResume(SDL_CD cdrom);


    /**
     * 
     */
    int SDL_CDStop(SDL_CD cdrom);


    /**
     * 
     */
    int SDL_CDEject(SDL_CD cdrom);


    /**
     * 
     */
    void SDL_CDClose(SDL_CD cdrom);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name CPU Info functions                                                 */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    SDL_bool SDL_HasRDTSC();

    /** This function returns true if the CPU has MMX features */
    SDL_bool SDL_HasMMX();

    /** This function returns true if the CPU has MMX Ext. features */
    SDL_bool SDL_HasMMXExt();

    /** This function returns true if the CPU has 3DNow features */
    SDL_bool SDL_Has3DNow();

    /** This function returns true if the CPU has 3DNow! Ext. features */
    SDL_bool SDL_Has3DNowExt();

    /** This function returns true if the CPU has SSE features */
    SDL_bool SDL_HasSSE();

    /** This function returns true if the CPU has SSE2 features */
    SDL_bool SDL_HasSSE2();

    /** This function returns true if the CPU has AltiVec features */
    SDL_bool SDL_HasAltiVec();
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Endians functions                                                  */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static final int SDL_LIL_ENDIAN = 1234;
    public static final int SDL_BIG_ENDIAN = 4321;

    public static final int SDL_BYTEORDER = SDL_LIL_ENDIAN;
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Error functions                                                    */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     *
     */
    void SDL_SetError(String fmt, Object... args);


    /**
     * SDL のエラーを文字列で取得します。
     */
    String SDL_GetError();


    /**
     *
     */
    void SDL_ClearError();


    public static interface SDL_errorcode {
        public static final int SDL_ENOMEM = 0;
        public static final int SDL_EFREAD = 1;
        public static final int SDL_EFWRITE = 2;
        public static final int SDL_EFSEEK = 3;
        public static final int SDL_UNSUPPORTED = 4;
        public static final int SDL_LASTERROR = 5;
    }


    void SDL_Error(SDL_errorcode code);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Events functions                                                   */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static final int SDL_RELEASED = 0;
    public static final int SDL_PRESSED = 1;


    /**
     * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
     * enum values
     */
    public static interface SDL_EventType {
        /**
         * < Unused (do not remove)<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:52</i>
         */
        public static final int SDL_NOEVENT = 0;
        /**
         * < Application loses/gains visibility<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:53</i>
         */
        public static final int SDL_ACTIVEEVENT = 1;
        /**
         * < Keys pressed<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:54</i>
         */
        public static final int SDL_KEYDOWN = 2;
        /**
         * < Keys released<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:55</i>
         */
        public static final int SDL_KEYUP = 3;
        /**
         * < Mouse moved<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:56</i>
         */
        public static final int SDL_MOUSEMOTION = 4;
        /**
         * < Mouse button pressed<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:57</i>
         */
        public static final int SDL_MOUSEBUTTONDOWN = 5;
        /**
         * < Mouse button released<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:58</i>
         */
        public static final int SDL_MOUSEBUTTONUP = 6;
        /**
         * < Joystick axis motion<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:59</i>
         */
        public static final int SDL_JOYAXISMOTION = 7;
        /**
         * < Joystick trackball motion<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:60</i>
         */
        public static final int SDL_JOYBALLMOTION = 8;
        /**
         * < Joystick hat position change<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:61</i>
         */
        public static final int SDL_JOYHATMOTION = 9;
        /**
         * < Joystick button pressed<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:62</i>
         */
        public static final int SDL_JOYBUTTONDOWN = 10;
        /**
         * < Joystick button released<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:63</i>
         */
        public static final int SDL_JOYBUTTONUP = 11;
        /**
         * < User-requested quit<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:64</i>
         */
        public static final int SDL_QUIT = 12;
        /**
         * < System specific event<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:65</i>
         */
        public static final int SDL_SYSWMEVENT = 13;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:66</i>
         */
        public static final int SDL_EVENT_RESERVEDA = 14;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:67</i>
         */
        public static final int SDL_EVENT_RESERVEDB = 15;
        /**
         * < User resized video mode<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:68</i>
         */
        public static final int SDL_VIDEORESIZE = 16;
        /**
         * < Screen needs to be redrawn<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:69</i>
         */
        public static final int SDL_VIDEOEXPOSE = 17;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:70</i>
         */
        public static final int SDL_EVENT_RESERVED2 = 18;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:71</i>
         */
        public static final int SDL_EVENT_RESERVED3 = 19;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:72</i>
         */
        public static final int SDL_EVENT_RESERVED4 = 20;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:73</i>
         */
        public static final int SDL_EVENT_RESERVED5 = 21;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:74</i>
         */
        public static final int SDL_EVENT_RESERVED6 = 22;
        /**
         * < Reserved for future use..<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:75</i>
         */
        public static final int SDL_EVENT_RESERVED7 = 23;
        /**
         * Events SDL_USEREVENT through SDL_MAXEVENTS-1 are for your use<br>
         * Events SDL_USEREVENT through SDL_MAXEVENTS-1 are for your use<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:77</i>
         */
        public static final int SDL_USEREVENT = 24;
        /**
         * This last event is only for bounding internal arrays<br>
         *  It is the number of bits in the event mask datatype -- Uint32<br>
         * This last event is only for bounding internal arrays<br>
         *  It is the number of bits in the event mask datatype -- Uint32<br>
         * <i>native declaration : /usr/include/SDL/SDL_events.h:81</i>
         */
        public static final int SDL_NUMEVENTS = 32;
    };


    /**
     * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
     * enum values
     */
    public static interface SDL_EventMask {
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:88</i>
        public static final int SDL_ACTIVEEVENTMASK = (1 << (SDL_EventType.SDL_ACTIVEEVENT));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:89</i>
        public static final int SDL_KEYDOWNMASK = (1 << (SDL_EventType.SDL_KEYDOWN));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:90</i>
        public static final int SDL_KEYUPMASK = (1 << (SDL_EventType.SDL_KEYUP));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:91</i>
        public static final int SDL_KEYEVENTMASK = (1 << (SDL_EventType.SDL_KEYDOWN)) | (1 << (SDL_EventType.SDL_KEYUP));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:93</i>
        public static final int SDL_MOUSEMOTIONMASK = (1 << (SDL_EventType.SDL_MOUSEMOTION));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:94</i>
        public static final int SDL_MOUSEBUTTONDOWNMASK = (1 << (SDL_EventType.SDL_MOUSEBUTTONDOWN));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:95</i>
        public static final int SDL_MOUSEBUTTONUPMASK = (1 << (SDL_EventType.SDL_MOUSEBUTTONUP));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:96</i>
        public static final int SDL_MOUSEEVENTMASK = (1 << (SDL_EventType.SDL_MOUSEMOTION)) | (1 << (SDL_EventType.SDL_MOUSEBUTTONDOWN)) | (1 << (SDL_EventType.SDL_MOUSEBUTTONUP));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:99</i>
        public static final int SDL_JOYAXISMOTIONMASK = (1 << (SDL_EventType.SDL_JOYAXISMOTION));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:100</i>
        public static final int SDL_JOYBALLMOTIONMASK = (1 << (SDL_EventType.SDL_JOYBALLMOTION));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:101</i>
        public static final int SDL_JOYHATMOTIONMASK = (1 << (SDL_EventType.SDL_JOYHATMOTION));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:102</i>
        public static final int SDL_JOYBUTTONDOWNMASK = (1 << (SDL_EventType.SDL_JOYBUTTONDOWN));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:103</i>
        public static final int SDL_JOYBUTTONUPMASK = (1 << (SDL_EventType.SDL_JOYBUTTONUP));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:104</i>
        public static final int SDL_JOYEVENTMASK = (1 << (SDL_EventType.SDL_JOYAXISMOTION)) | (1 << (SDL_EventType.SDL_JOYBALLMOTION)) | (1 << (SDL_EventType.SDL_JOYHATMOTION)) | (1 << (SDL_EventType.SDL_JOYBUTTONDOWN)) | (1 << (SDL_EventType.SDL_JOYBUTTONUP));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:109</i>
        public static final int SDL_VIDEORESIZEMASK = (1 << (SDL_EventType.SDL_VIDEORESIZE));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:110</i>
        public static final int SDL_VIDEOEXPOSEMASK = (1 << (SDL_EventType.SDL_VIDEOEXPOSE));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:111</i>
        public static final int SDL_QUITMASK = (1 << (SDL_EventType.SDL_QUIT));
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:112</i>
        public static final int SDL_SYSWMEVENTMASK = (1 << (SDL_EventType.SDL_SYSWMEVENT));
    };

    public static final int SDL_ALLEVENTS = 0xFFFFFFFF;


    /**
     * 入力デバイスからのイベントを収集してイベントループを組み上げます。
     */
    void SDL_PumpEvents();


    /**
     * イベントキューをチェックしてイベントの数を返します。
     */
    int SDL_PeepEvents(SDL_Event event, int numevents, SDL_eventaction action, Uint32 mask);


    /**
     * <i>native declaration : /usr/include/SDL/SDL_events.h</i><br>
     * enum values
     */
    public static interface SDL_eventaction {
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:253</i>
        public static final int SDL_ADDEVENT = 0;
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:254</i>
        public static final int SDL_PEEKEVENT = 1;
        /// <i>native declaration : /usr/include/SDL/SDL_events.h:255</i>
        public static final int SDL_GETEVENT = 2;
    };


    /**
     * 
     */
    int SDL_PollEvent(SDL_Event event);


    /**
     * 
     */
    int SDL_WaitEvent(SDL_Event event);


    /**
     * 
     */
    int SDL_PushEvent(SDL_Event event);


    public interface SDL_EventFilter {
        int apply(SDL_Event event);
    }


    /**
     * 
     */
    void SDL_SetEventFilter(SDL_EventFilter filter);


    /**
     * 
     */
    SDL_EventFilter SDL_GetEventFilter();


    public static final int SDL_QUERY   = -1;
    public static final int SDL_IGNORE  =  0;
    public static final int SDL_DISABLE =  0;
    public static final int SDL_ENABLE  =  1;
    

    /**
     * 
     */
    Uint8 SDL_EventState(Uint8 type, int state);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Joystick functions                                                 */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static interface _SDL_Joystick {}


    /**
     * 
     */
    int SDL_NumJoysticks();


    /**
     * 
     */
    String SDL_JoystickName(int device_index);


    /**
     * 
     */
    SDL_Joystick SDL_JoystickOpen(int device_index);


    /**
     * 
     */
    int SDL_JoystickOpened(int device_index);


    /**
     * 
     */
    int SDL_JoystickIndex(SDL_Joystick joystick);


    /**
     * 
     */
    int SDL_JoystickNumAxes(SDL_Joystick joystick);


    /**
     * 
     */
    int SDL_JoystickNumBalls(SDL_Joystick joystick);


    /**
     * 
     */
    int SDL_JoystickNumButtons(SDL_Joystick joystick);


    /**
     * 
     */
    void SDL_JoystickUpdate();


    /**
     * 
     */
    int SDL_JoystickEventState(int state);


    /**
     * 
     */
    Sint16 SDL_JoystickGetAxis(SDL_Joystick joystick, int axis);


    public static final int SDL_HAT_CENTERED  = 0x00;
    public static final int SDL_HAT_UP        = 0x01;
    public static final int SDL_HAT_RIGHT     = 0x02;
    public static final int SDL_HAT_DOWN      = 0x04;
    public static final int SDL_HAT_LEFT      = 0x08;
    public static final int SDL_HAT_RIGHTUP   = (SDL_HAT_RIGHT | SDL_HAT_UP);
    public static final int SDL_HAT_RIGHTDOWN = (SDL_HAT_RIGHT | SDL_HAT_DOWN);
    public static final int SDL_HAT_LEFTUP    = (SDL_HAT_LEFT | SDL_HAT_UP);
    public static final int SDL_HAT_LEFTDOWN  = (SDL_HAT_LEFT | SDL_HAT_DOWN);


    /**
     * 
     */
    Uint8 SDL_JoystickGetHat(SDL_Joystick joystick, int hat);


    /**
     *
     */
    int SDL_JoystickGetBall(SDL_Joystick joystick, int ball, Pointer/* int* */ dx, Pointer/* int* */ dy);


    /**
     * 
     */
    Uint8 SDL_JoystickGetButton(SDL_Joystick joystick, int button);


    /**
     * 
     */
    void SDL_JoystickClose(SDL_Joystick joystick);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Keyboard functions                                                 */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static final int SDL_ALLHOTKEYS = 0xFFFFFFFF;


    /**
     *
     */
    int SDL_EnbleUNICODE(int enable);


    public static final int SDL_DEFAULT_REPEAT_DELAY = 500;
    public static final int SDL_DEFAULT_INTERVAL     =  30;


    /**
     * 
     */
    int SDL_EnableKeyRepeat(int delay, int interval);


    /**
     * 
     */
    int SDL_GetKeyRepeat(Pointer/* int* */ delay, int interval);


    /**
     *
     */
    Pointer/* Uint8* */ SDL_GetKeyState(Pointer/* int* */ numkeys);


    /**
     *
     */
    SDLMod SDL_GetModState(Pointer/* int* */ numkeys);


    /**
     * 
     */
    void SDL_SetModeState(SDLMod modstate);


    /**
     * 
     */
    String SDL_GetKeyName(SDLKey key);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Keysym functions                                                   */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static interface SDLKey {
        /** @name ASCII mapped keysyms
         *  The keyboard syms have been cleverly chosen to map to ASCII
         */
        /*@{*/
        public static final int SDLK_UNKNOWN        = 0;
        public static final int SDLK_FIRST      = 0;
        public static final int SDLK_BACKSPACE      = 8;
        public static final int SDLK_TAB        = 9;
        public static final int SDLK_CLEAR      = 12;
        public static final int SDLK_RETURN     = 13;
        public static final int SDLK_PAUSE      = 19;
        public static final int SDLK_ESCAPE     = 27;
        public static final int SDLK_SPACE      = 32;
        public static final int SDLK_EXCLAIM        = 33;
        public static final int SDLK_QUOTEDBL       = 34;
        public static final int SDLK_HASH       = 35;
        public static final int SDLK_DOLLAR     = 36;
        public static final int SDLK_AMPERSAND      = 38;
        public static final int SDLK_QUOTE      = 39;
        public static final int SDLK_LEFTPAREN      = 40;
        public static final int SDLK_RIGHTPAREN     = 41;
        public static final int SDLK_ASTERISK       = 42;
        public static final int SDLK_PLUS       = 43;
        public static final int SDLK_COMMA      = 44;
        public static final int SDLK_MINUS      = 45;
        public static final int SDLK_PERIOD     = 46;
        public static final int SDLK_SLASH      = 47;
        public static final int SDLK_0          = 48;
        public static final int SDLK_1          = 49;
        public static final int SDLK_2          = 50;
        public static final int SDLK_3          = 51;
        public static final int SDLK_4          = 52;
        public static final int SDLK_5          = 53;
        public static final int SDLK_6          = 54;
        public static final int SDLK_7          = 55;
        public static final int SDLK_8          = 56;
        public static final int SDLK_9          = 57;
        public static final int SDLK_COLON      = 58;
        public static final int SDLK_SEMICOLON      = 59;
        public static final int SDLK_LESS       = 60;
        public static final int SDLK_EQUALS     = 61;
        public static final int SDLK_GREATER        = 62;
        public static final int SDLK_QUESTION       = 63;
        public static final int SDLK_AT         = 64;
        /* 
           Skip uppercase letters
        */
        public static final int SDLK_LEFTBRACKET    = 91;
        public static final int SDLK_BACKSLASH      = 92;
        public static final int SDLK_RIGHTBRACKET   = 93;
        public static final int SDLK_CARET      = 94;
        public static final int SDLK_UNDERSCORE     = 95;
        public static final int SDLK_BACKQUOTE      = 96;
        public static final int SDLK_a          = 97;
        public static final int SDLK_b          = 98;
        public static final int SDLK_c          = 99;
        public static final int SDLK_d          = 100;
        public static final int SDLK_e          = 101;
        public static final int SDLK_f          = 102;
        public static final int SDLK_g          = 103;
        public static final int SDLK_h          = 104;
        public static final int SDLK_i          = 105;
        public static final int SDLK_j          = 106;
        public static final int SDLK_k          = 107;
        public static final int SDLK_l          = 108;
        public static final int SDLK_m          = 109;
        public static final int SDLK_n          = 110;
        public static final int SDLK_o          = 111;
        public static final int SDLK_p          = 112;
        public static final int SDLK_q          = 113;
        public static final int SDLK_r          = 114;
        public static final int SDLK_s          = 115;
        public static final int SDLK_t          = 116;
        public static final int SDLK_u          = 117;
        public static final int SDLK_v          = 118;
        public static final int SDLK_w          = 119;
        public static final int SDLK_x          = 120;
        public static final int SDLK_y          = 121;
        public static final int SDLK_z          = 122;
        public static final int SDLK_DELETE     = 127;
        /* End of ASCII mapped keysyms */
        /*@}*/

        /** @name International keyboard syms */
        /*@{*/
        public static final int SDLK_WORLD_0        = 160;      /* 0xA0 */
        public static final int SDLK_WORLD_1        = 161;
        public static final int SDLK_WORLD_2        = 162;
        public static final int SDLK_WORLD_3        = 163;
        public static final int SDLK_WORLD_4        = 164;
        public static final int SDLK_WORLD_5        = 165;
        public static final int SDLK_WORLD_6        = 166;
        public static final int SDLK_WORLD_7        = 167;
        public static final int SDLK_WORLD_8        = 168;
        public static final int SDLK_WORLD_9        = 169;
        public static final int SDLK_WORLD_10       = 170;
        public static final int SDLK_WORLD_11       = 171;
        public static final int SDLK_WORLD_12       = 172;
        public static final int SDLK_WORLD_13       = 173;
        public static final int SDLK_WORLD_14       = 174;
        public static final int SDLK_WORLD_15       = 175;
        public static final int SDLK_WORLD_16       = 176;
        public static final int SDLK_WORLD_17       = 177;
        public static final int SDLK_WORLD_18       = 178;
        public static final int SDLK_WORLD_19       = 179;
        public static final int SDLK_WORLD_20       = 180;
        public static final int SDLK_WORLD_21       = 181;
        public static final int SDLK_WORLD_22       = 182;
        public static final int SDLK_WORLD_23       = 183;
        public static final int SDLK_WORLD_24       = 184;
        public static final int SDLK_WORLD_25       = 185;
        public static final int SDLK_WORLD_26       = 186;
        public static final int SDLK_WORLD_27       = 187;
        public static final int SDLK_WORLD_28       = 188;
        public static final int SDLK_WORLD_29       = 189;
        public static final int SDLK_WORLD_30       = 190;
        public static final int SDLK_WORLD_31       = 191;
        public static final int SDLK_WORLD_32       = 192;
        public static final int SDLK_WORLD_33       = 193;
        public static final int SDLK_WORLD_34       = 194;
        public static final int SDLK_WORLD_35       = 195;
        public static final int SDLK_WORLD_36       = 196;
        public static final int SDLK_WORLD_37       = 197;
        public static final int SDLK_WORLD_38       = 198;
        public static final int SDLK_WORLD_39       = 199;
        public static final int SDLK_WORLD_40       = 200;
        public static final int SDLK_WORLD_41       = 201;
        public static final int SDLK_WORLD_42       = 202;
        public static final int SDLK_WORLD_43       = 203;
        public static final int SDLK_WORLD_44       = 204;
        public static final int SDLK_WORLD_45       = 205;
        public static final int SDLK_WORLD_46       = 206;
        public static final int SDLK_WORLD_47       = 207;
        public static final int SDLK_WORLD_48       = 208;
        public static final int SDLK_WORLD_49       = 209;
        public static final int SDLK_WORLD_50       = 210;
        public static final int SDLK_WORLD_51       = 211;
        public static final int SDLK_WORLD_52       = 212;
        public static final int SDLK_WORLD_53       = 213;
        public static final int SDLK_WORLD_54       = 214;
        public static final int SDLK_WORLD_55       = 215;
        public static final int SDLK_WORLD_56       = 216;
        public static final int SDLK_WORLD_57       = 217;
        public static final int SDLK_WORLD_58       = 218;
        public static final int SDLK_WORLD_59       = 219;
        public static final int SDLK_WORLD_60       = 220;
        public static final int SDLK_WORLD_61       = 221;
        public static final int SDLK_WORLD_62       = 222;
        public static final int SDLK_WORLD_63       = 223;
        public static final int SDLK_WORLD_64       = 224;
        public static final int SDLK_WORLD_65       = 225;
        public static final int SDLK_WORLD_66       = 226;
        public static final int SDLK_WORLD_67       = 227;
        public static final int SDLK_WORLD_68       = 228;
        public static final int SDLK_WORLD_69       = 229;
        public static final int SDLK_WORLD_70       = 230;
        public static final int SDLK_WORLD_71       = 231;
        public static final int SDLK_WORLD_72       = 232;
        public static final int SDLK_WORLD_73       = 233;
        public static final int SDLK_WORLD_74       = 234;
        public static final int SDLK_WORLD_75       = 235;
        public static final int SDLK_WORLD_76       = 236;
        public static final int SDLK_WORLD_77       = 237;
        public static final int SDLK_WORLD_78       = 238;
        public static final int SDLK_WORLD_79       = 239;
        public static final int SDLK_WORLD_80       = 240;
        public static final int SDLK_WORLD_81       = 241;
        public static final int SDLK_WORLD_82       = 242;
        public static final int SDLK_WORLD_83       = 243;
        public static final int SDLK_WORLD_84       = 244;
        public static final int SDLK_WORLD_85       = 245;
        public static final int SDLK_WORLD_86       = 246;
        public static final int SDLK_WORLD_87       = 247;
        public static final int SDLK_WORLD_88       = 248;
        public static final int SDLK_WORLD_89       = 249;
        public static final int SDLK_WORLD_90       = 250;
        public static final int SDLK_WORLD_91       = 251;
        public static final int SDLK_WORLD_92       = 252;
        public static final int SDLK_WORLD_93       = 253;
        public static final int SDLK_WORLD_94       = 254;
        public static final int SDLK_WORLD_95       = 255;      /* 0xFF */
        /*@}*/

        /** @name Numeric keypad */
        /*@{*/
        public static final int SDLK_KP0        = 256;
        public static final int SDLK_KP1        = 257;
        public static final int SDLK_KP2        = 258;
        public static final int SDLK_KP3        = 259;
        public static final int SDLK_KP4        = 260;
        public static final int SDLK_KP5        = 261;
        public static final int SDLK_KP6        = 262;
        public static final int SDLK_KP7        = 263;
        public static final int SDLK_KP8        = 264;
        public static final int SDLK_KP9        = 265;
        public static final int SDLK_KP_PERIOD      = 266;
        public static final int SDLK_KP_DIVIDE      = 267;
        public static final int SDLK_KP_MULTIPLY    = 268;
        public static final int SDLK_KP_MINUS       = 269;
        public static final int SDLK_KP_PLUS        = 270;
        public static final int SDLK_KP_ENTER       = 271;
        public static final int SDLK_KP_EQUALS      = 272;
        /*@}*/

        /** @name Arrows + Home/End pad */
        /*@{*/
        public static final int SDLK_UP         = 273;
        public static final int SDLK_DOWN       = 274;
        public static final int SDLK_RIGHT      = 275;
        public static final int SDLK_LEFT       = 276;
        public static final int SDLK_INSERT     = 277;
        public static final int SDLK_HOME       = 278;
        public static final int SDLK_END        = 279;
        public static final int SDLK_PAGEUP     = 280;
        public static final int SDLK_PAGEDOWN       = 281;
        /*@}*/

        /** @name Function keys */
        /*@{*/
        public static final int SDLK_F1         = 282;
        public static final int SDLK_F2         = 283;
        public static final int SDLK_F3         = 284;
        public static final int SDLK_F4         = 285;
        public static final int SDLK_F5         = 286;
        public static final int SDLK_F6         = 287;
        public static final int SDLK_F7         = 288;
        public static final int SDLK_F8         = 289;
        public static final int SDLK_F9         = 290;
        public static final int SDLK_F10        = 291;
        public static final int SDLK_F11        = 292;
        public static final int SDLK_F12        = 293;
        public static final int SDLK_F13        = 294;
        public static final int SDLK_F14        = 295;
        public static final int SDLK_F15        = 296;
        /*@}*/

        /** @name Key state modifier keys */
        /*@{*/
        public static final int SDLK_NUMLOCK        = 300;
        public static final int SDLK_CAPSLOCK       = 301;
        public static final int SDLK_SCROLLOCK      = 302;
        public static final int SDLK_RSHIFT     = 303;
        public static final int SDLK_LSHIFT     = 304;
        public static final int SDLK_RCTRL      = 305;
        public static final int SDLK_LCTRL      = 306;
        public static final int SDLK_RALT       = 307;
        public static final int SDLK_LALT       = 308;
        public static final int SDLK_RMETA      = 309;
        public static final int SDLK_LMETA      = 310;
        public static final int SDLK_LSUPER     = 311;      /**< Left "Windows" key */
        public static final int SDLK_RSUPER     = 312;      /**< Right "Windows" key */
        public static final int SDLK_MODE       = 313;      /**< "Alt Gr" key */
        public static final int SDLK_COMPOSE        = 314;      /**< Multi-key compose key */
        /*@}*/

        /** @name Miscellaneous function keys */
        /*@{*/
        public static final int SDLK_HELP       = 315;
        public static final int SDLK_PRINT      = 316;
        public static final int SDLK_SYSREQ     = 317;
        public static final int SDLK_BREAK      = 318;
        public static final int SDLK_MENU       = 319;
        public static final int SDLK_POWER      = 320;      /**< Power Macintosh power key */
        public static final int SDLK_EURO       = 321;      /**< Some european keyboards */
        public static final int SDLK_UNDO       = 322;      /**< Atari keyboard has Undo */
        /*@}*/

        /* Add any other keys here */

        public static final int SDLK_LAST = 323;
    }


    public static interface SDLMod {
        public static final int KMOD_NONE  = 0x0000;
        public static final int KMOD_LSHIFT= 0x0001;
        public static final int KMOD_RSHIFT= 0x0002;
        public static final int KMOD_LCTRL = 0x0040;
        public static final int KMOD_RCTRL = 0x0080;
        public static final int KMOD_LALT  = 0x0100;
        public static final int KMOD_RALT  = 0x0200;
        public static final int KMOD_LMETA = 0x0400;
        public static final int KMOD_RMETA = 0x0800;
        public static final int KMOD_NUM   = 0x1000;
        public static final int KMOD_CAPS  = 0x2000;
        public static final int KMOD_MODE  = 0x4000;
        public static final int KMOD_RESERVED = 0x8000;
    }

    public static final int KMOD_CTRL  = (SDLMod.KMOD_LCTRL | SDLMod.KMOD_RCTRL);
    public static final int KMOD_SHIFT = (SDLMod.KMOD_LSHIFT | SDLMod.KMOD_RSHIFT);
    public static final int KMOD_ALT   = (SDLMod.KMOD_LALT | SDLMod.KMOD_RALT);
    public static final int KMOD_META  = (SDLMod.KMOD_LMETA | SDLMod.KMOD_RMETA);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Load *.so File functions                                           */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * 
     */
    Pointer/* void* */ SDL_LoadObject(String/* const char* */ sofile);


    /**
     * 
     */
    Pointer/* void* */ SDL_LoadFunction(Pointer/* void* */ handle, String/* const char* */ name);


    /**
     * 
     */
    void SDL_UnloadObject(Pointer/* void* */ handle);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Main functions                                                     */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    // /**
    //  * Windows 用。
    //  */
    // void SDL_SetModuleHandle(Pointer/* void* */ hInst);


    // /**
    //  * Windows 用。
    //  */
    // int SDL_RegisterApp(String/* char* */ name, Uint32 style, Pointer/* void* */ hInst);


    // /**
    //  * Windows 用。
    //  */
    // void SDL_UnregisterApp();
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Mouse Cursor functions                                             */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static interface WMcursor {}


    /**
     * 
     */
    Uint8 SDL_GetMouseState(IntByReference x, IntByReference y);


    /**
     * 
     */
    Uint8 SDL_GetRelativeMouseState(IntByReference x, IntByReference y);


    /**
     * マウスカーソルを指定した位置に設定します。
     */
    void SDL_WarpMause(Uint16 x, Uint16 y);


    /**
     * 新しいマウスカーソルを作成して返します。
     */
    SDL_Cursor SDL_CreateCursor(ByteByReference/* Uint8* */ data, ByteByReference/* Uint8* */ mask, int w, int h, int hot_x, int hot_y);


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


    public static final int SDL_BUTTON_LEFT      = 1;
    public static final int SDL_BUTTON_MIDDLE    = 2;
    public static final int SDL_BUTTON_RIGHT     = 3;
    public static final int SDL_BUTTON_WHEELUP   = 4;
    public static final int SDL_BUTTON_WHEELDOWN = 5;
    public static final int SDL_BUTTON_X1        = 6;
    public static final int SDL_BUTTON_X2        = 7;
    public static final int SDL_BUTTON_LMASK     = 1 << (SDL_BUTTON_LEFT - 1);
    public static final int SDL_BUTTON_MMASK     = 1 << (SDL_BUTTON_MIDDLE - 1);
    public static final int SDL_BUTTON_RMASK     = 1 << (SDL_BUTTON_RIGHT - 1);
    public static final int SDL_BUTTON_X1MASK    = 1 << (SDL_BUTTON_X1 - 1);
    public static final int SDL_BUTTON_X2MASK    = 1 << (SDL_BUTTON_X2 - 1);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Mutex functions                                                    */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static interface SDL_mutex {}


    /**
     * 
     */
    SDL_mutex SDL_CreateMutex();


    public static interface SDL_LockableMutex extends SDL_mutex {
        int SDL_LockMutex(/*SDL_mutex m*/);
        int SDL_UnlockMutex(/*SDL_mutex m*/);
    }


    /**
     * 
     */
    int SDL_mutexP(SDL_mutex mutex);


    /**
     * 
     */
    int SDL_mutexV(SDL_mutex mutex);


    /**
     *
     */
    void SDL_DestroyMutex(SDL_mutex mutex);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name semephone functions                                                */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static interface SDL_sem {}


    /**
     *
     */
    SDL_sem SDL_CreateSemaphore(Uint32 initial_value);


    /**
     *
     */
    void SDL_DestroySemaphore(SDL_sem sem);


    /**
     *
     */
    int SDL_SemWait(SDL_sem sem);


    /**
     * 
     */
    int SDL_SemTryWait(SDL_sem sem);


    /**
     * 
     */
    int SDL_SemWaitTimeout(SDL_sem sem, Uint32 ms);


    /**
     * 
     */
    int SDL_SemPost(SDL_sem sem);


    /**
     * 
     */
    Uint32 SDL_SemValue(SDL_sem sem);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Open GL support functions                                          */ /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static final int GL_GLEXT_VERSION = 29;


    public static final int GL_UNSIGNED_BYTE_3_3_2           = 0x8032;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4        = 0x8033;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1        = 0x8034;
    public static final int GL_UNSIGNED_INT_8_8_8_8          = 0x8035;
    public static final int GL_UNSIGNED_INT_10_10_10_2       = 0x8036;
    public static final int GL_RESCALE_NORMAL                = 0x803A;
    public static final int GL_TEXTURE_BINDING_3D            = 0x806A;
    public static final int GL_PACK_SKIP_IMAGES              = 0x806B;
    public static final int GL_PACK_IMAGE_HEIGHT             = 0x806C;
    public static final int GL_UNPACK_SKIP_IMAGES            = 0x806D;
    public static final int GL_UNPACK_IMAGE_HEIGHT           = 0x806E;
    public static final int GL_TEXTURE_3D                    = 0x806F;
    public static final int GL_PROXY_TEXTURE_3D              = 0x8070;
    public static final int GL_TEXTURE_DEPTH                 = 0x8071;
    public static final int GL_TEXTURE_WRAP_R                = 0x8072;
    public static final int GL_MAX_3D_TEXTURE_SIZE           = 0x8073;
    public static final int GL_UNSIGNED_BYTE_2_3_3_REV       = 0x8362;
    public static final int GL_UNSIGNED_SHORT_5_6_5          = 0x8363;
    public static final int GL_UNSIGNED_SHORT_5_6_5_REV      = 0x8364;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV    = 0x8365;
    public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV    = 0x8366;
    public static final int GL_UNSIGNED_INT_8_8_8_8_REV      = 0x8367;
    public static final int GL_UNSIGNED_INT_2_10_10_10_REV   = 0x8368;
    public static final int GL_BGR                           = 0x80E0;
    public static final int GL_BGRA                          = 0x80E1;
    public static final int GL_MAX_ELEMENTS_VERTICES         = 0x80E8;
    public static final int GL_MAX_ELEMENTS_INDICES          = 0x80E9;
    public static final int GL_CLAMP_TO_EDGE                 = 0x812F;
    public static final int GL_TEXTURE_MIN_LOD               = 0x813A;
    public static final int GL_TEXTURE_MAX_LOD               = 0x813B;
    public static final int GL_TEXTURE_BASE_LEVEL            = 0x813C;
    public static final int GL_TEXTURE_MAX_LEVEL             = 0x813D;
    public static final int GL_LIGHT_MODEL_COLOR_CONTROL     = 0x81F8;
    public static final int GL_SINGLE_COLOR                  = 0x81F9;
    public static final int GL_SEPARATE_SPECULAR_COLOR       = 0x81FA;
    public static final int GL_SMOOTH_POINT_SIZE_RANGE       = 0x0B12;
    public static final int GL_SMOOTH_POINT_SIZE_GRANULARITY = 0x0B13;
    public static final int GL_SMOOTH_LINE_WIDTH_RANGE       = 0x0B22;
    public static final int GL_SMOOTH_LINE_WIDTH_GRANULARITY = 0x0B23;
    public static final int GL_ALIASED_POINT_SIZE_RANGE      = 0x846D;
    public static final int GL_ALIASED_LINE_WIDTH_RANGE      = 0x846E;

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
    /** @name caondition variable functions                                      */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public static interface SDL_cond {}


    /**
     * 
     */
    SDL_cond SDL_CreateCond();


    /**
     * 
     */
    void SDL_DestroyCond(SDL_cond cond);


    /**
     * 
     */
    int SDL_CondSignal(SDL_cond cond);


    /**
     * 
     */
    int SDL_CondBroadcast(SDL_cond cond);


    /**
     * 
     */
    int SDL_CondWait(SDL_cond cond, SDL_mutex mut);


    /**
     * 
     */
    int SDL_CondWaitTimeout(SDL_cond cond, SDL_mutex mut, Uint32 ms);
    /* @} */


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /** @name Video functions                                                    */  /* @{ */
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

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
     *
     */
    SDL_Surface  SDL_SetVideoMode(int width, int height, int bpp, Uint32 flags);


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
