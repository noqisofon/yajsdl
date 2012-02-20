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


/**
 *
 * @author rihine
 */
public class SDLInitTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    
    @Before
    public void setUp() throws Exception {
        System.out.println( "------------------------------------------" );
    }

    
    @After
    public void tearDown() throws Exception {
        System.out.println( "------------------------------------------" );
    }


    @Test
    public void notInitSDL() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init 4" );
        ret = SDL.init( 4 );

        System.out.println( ret );
        assertFalse( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLVideo() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_VIDEO" );
        ret = SDL.init( SDL.INIT_VIDEO );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLAudio() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_AUDIO" );
        ret = SDL.init( SDL.INIT_AUDIO );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLCDRom() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_CDROM" );
        ret = SDL.init( SDL.INIT_CDROM );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLEventThread() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_EVENTTHREAD" );
        ret = SDL.init( SDL.INIT_EVENTTHREAD );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLEveryThing() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_EVERYTHING" );
        ret = SDL.init( SDL.INIT_EVERYTHING );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLJoystick() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_JOYSTICK" );
        ret = SDL.init( SDL.INIT_JOYSTICK );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLNoParachute() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_NOPARACHUTE" );
        ret = SDL.init( SDL.INIT_NOPARACHUTE );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void initSDLTimer() throws SDLException {
        boolean ret;

        System.out.println( "SDL.init SDL.INIT_TIMER" );
        ret = SDL.init( SDL.INIT_TIMER );

        assertTrue( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }


    @Test
    public void wasInitVideoAndAudio() throws SDLException {
        boolean ret;

        System.out.println( "SDL.INIT_VIDEO | SDL.INIT_AUDIO" );
        ret = SDL.init( SDL.INIT_VIDEO | SDL.INIT_AUDIO );

        assertTrue( ret );
        
        ret = SDL.wasInit( SDL.INIT_VIDEO );
        assertTrue( ret );
        
        ret = SDL.wasInit( SDL.INIT_AUDIO );
        assertTrue( ret );
        
        ret = SDL.wasInit( SDL.INIT_VIDEO | SDL.INIT_AUDIO );
        assertTrue( ret );
        
        ret = SDL.wasInit( SDL.INIT_VIDEO | SDL.INIT_TIMER );
        assertFalse( ret );
        
        ret = SDL.wasInit( SDL.INIT_TIMER );
        assertFalse( ret );

        System.out.println( "SDL.quit" );
        SDL.quit();
    }
}
