package org.yajsdl.jna;

import com.sun.jna.Structure;


/**
 * <i>native declaration : /usr/include/SDL/SDL_cdrom.h</i><br>
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
public class SDL_CD extends Structure {
    // / < Private drive identifier
    public int           id;
    /**
     * < Current drive status<br>
     * C type : CDstatus
     */
    public int           status;
    /**
     * @{<br> < Number of tracks on disk
     */
    public int           numtracks;
    // / < Current track position
    public int           cur_track;
    // / < Current frame offset within current track
    public int           cur_frame;
    // / C type : SDL_CDtrack[99 + 1]
    public SDL_CDtrack[] track = new SDL_CDtrack[( 99 + 1 )];


    public SDL_CD() {
        super();
        initFieldOrder();
    }


    protected void initFieldOrder() {
        setFieldOrder( new java.lang.String[] { "id", "status", "numtracks", "cur_track", "cur_frame", "track" } );
    }


    /**
     * @param id
     *            < Private drive identifier<br>
     * @param status
     *            < Current drive status<br>
     *            C type : CDstatus<br>
     * @param numtracks
     *            @{<br>
     *            < Number of tracks on disk<br>
     * @param cur_track
     *            < Current track position<br>
     * @param cur_frame
     *            < Current frame offset within current track<br>
     * @param track
     *            C type : SDL_CDtrack[99 + 1]
     */
    public SDL_CD(int id, int status, int numtracks, int cur_track, int cur_frame, SDL_CDtrack track[]) {
        super();
        this.id = id;
        this.status = status;
        this.numtracks = numtracks;
        this.cur_track = cur_track;
        this.cur_frame = cur_frame;
        if ( track.length != this.track.length )
            throw new IllegalArgumentException( "Wrong array size !" );
        this.track = track;
        initFieldOrder();
    }

    public static class ByReference extends SDL_CD implements Structure.ByReference {

    };

    public static class ByValue extends SDL_CD implements Structure.ByValue {

    };
}
