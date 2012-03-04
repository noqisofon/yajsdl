package org.yajsdl.jna;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;


/**
 * <i>native declaration : /usr/include/SDL/SDL_syswm.h</i><br>
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that
 * <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a
 * few opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a
 * href="http://rococoa.dev.java.net/">Rococoa</a>, or <a
 * href="http://jna.dev.java.net/">JNA</a>.
 */
public class SDL_SysWMinfo extends Structure {
    // / C type : SDL_version
    public SDL_version version;
    // / C type : SDL_SYSWM_TYPE
    public int         subsystem;
    // / C type : info_union
    public info_union  info;

    // / <i>native declaration : /usr/include/SDL/SDL_syswm.h:80</i>
    public static class info_union extends Union {
        // / C type : x11_struct
        public x11_struct x11;

        // / <i>native declaration : /usr/include/SDL/SDL_syswm.h:81</i>
        public static class x11_struct extends Structure {
            /**
             * < The X11 display<br>
             * C type : Display*
             */
            public Pointer                                                  display;
            /**
             * < The X11 display window<br>
             * C type : Window
             */
            public NativeLong                                               window;
            /**
             * @{<br> C type : lock_func_callback
             */
            public SDL_SysWMinfo.info_union.x11_struct.lock_func_callback   lock_func;
            // / C type : unlock_func_callback
            public SDL_SysWMinfo.info_union.x11_struct.unlock_func_callback unlock_func;
            /**
             * @{<br> < The X11 fullscreen window<br>
             *        C type : Window
             */
            public NativeLong                                               fswindow;
            /**
             * < The X11 managed input window<br>
             * C type : Window
             */
            public NativeLong                                               wmwindow;
            /**
             * @{<br> < The X11 display to which rendering is done<br>
             *        C type : Display*
             */
            public Pointer                                                  gfxdisplay;

            // / <i>native declaration : /usr/include/SDL/SDL_syswm.h</i>
            public interface lock_func_callback extends Callback {
                void apply();
            };

            // / <i>native declaration : /usr/include/SDL/SDL_syswm.h</i>
            public interface unlock_func_callback extends Callback {
                void apply();
            };


            public x11_struct() {
                super();
                initFieldOrder();
            }


            protected void initFieldOrder() {
                setFieldOrder( new java.lang.String[] { "display", "window", "lock_func", "unlock_func", "fswindow",
                    "wmwindow", "gfxdisplay" } );
            }


            /**
             * @param display
             *            < The X11 display<br>
             *            C type : Display*<br>
             * @param window
             *            < The X11 display window<br>
             *            C type : Window<br>
             * @param lock_func
             *            @{<br>
             *            C type : lock_func_callback<br>
             * @param unlock_func
             *            C type : unlock_func_callback<br>
             * @param fswindow
             *            @{<br>
             *            < The X11 fullscreen window<br>
             *            C type : Window<br>
             * @param wmwindow
             *            < The X11 managed input window<br>
             *            C type : Window<br>
             * @param gfxdisplay
             *            @{<br>
             *            < The X11 display to which rendering is done<br>
             *            C type : Display*
             */
            public x11_struct(Pointer display, NativeLong window,
                    SDL_SysWMinfo.info_union.x11_struct.lock_func_callback lock_func,
                    SDL_SysWMinfo.info_union.x11_struct.unlock_func_callback unlock_func, NativeLong fswindow,
                    NativeLong wmwindow, Pointer gfxdisplay) {
                super();
                this.display = display;
                this.window = window;
                this.lock_func = lock_func;
                this.unlock_func = unlock_func;
                this.fswindow = fswindow;
                this.wmwindow = wmwindow;
                this.gfxdisplay = gfxdisplay;
                initFieldOrder();
            }

            public static class ByReference extends x11_struct implements Structure.ByReference {

            };

            public static class ByValue extends x11_struct implements Structure.ByValue {

            };
        };


        public info_union() {
            super();
        }


        // / @param x11 C type : x11_struct
        public info_union(x11_struct x11) {
            super();
            this.x11 = x11;
            setType( x11_struct.class );
        }

        public static class ByReference extends info_union implements Structure.ByReference {

        };

        public static class ByValue extends info_union implements Structure.ByValue {

        };
    };


    public SDL_SysWMinfo() {
        super();
        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "version", "subsystem", "info" } );
    }


    /**
     * @param version
     *            C type : SDL_version<br>
     * @param subsystem
     *            C type : SDL_SYSWM_TYPE<br>
     * @param info
     *            C type : info_union
     */
    public SDL_SysWMinfo(SDL_version version, int subsystem, info_union info) {
        super();
        this.version = version;
        this.subsystem = subsystem;
        this.info = info;
        initFieldOrder();
    }

    public static class ByReference extends SDL_SysWMinfo implements Structure.ByReference {

    };

    public static class ByValue extends SDL_SysWMinfo implements Structure.ByValue {

    };
}
