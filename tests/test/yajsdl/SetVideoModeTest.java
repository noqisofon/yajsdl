/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.yajsdl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.yajsdl.SDL;
import org.yajsdl.SDLException;
import org.yajsdl.jna.SDL_Surface;
import org.yajsdl.video.Screen;


/**
 *
 * @author rihine
 */
public class SetVideoModeTest {

    @Before
    public void setupSDL() throws SDLException {
        SDL.init( SDL.INIT_VIDEO );
    }


    @After
    public void tearDownSDL() {
        SDL.quit();
    }


    @Test
    public void notSetVideoMode() {
        assertEquals( Screen.videoModeOK( 0, 0, 0, 0 ), 0 );
        Screen screen = Screen.setVideoMode( 0, 0, 0, 0 );
        SDL_Surface content = screen.toSource();

        assertNotNull( content );

        System.out.format( "screen.width = %d\n", content.w );
        System.out.format( "screen.height = %d\n", content.h );
        System.out.format( "screen.flags = %x\n", content.flags );
        System.out.format( "screen.pitch = %d\n", content.pitch );
        System.out.format( "screen.locked = %d\n", content.locked );
        System.out.format( "screen.format_version = %d\n", content.format_version );

        assertTrue( screen.isScreen() );
    }
}
