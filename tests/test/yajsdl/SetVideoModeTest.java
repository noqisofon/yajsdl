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

import yajsdl.SDL;
import yajsdl.SDLException;
import yajsdl.video.Screen;


/**
 *
 * @author rihine
 */
public class SetVideoModeTest {

    @BeforeClass
    public static void setupSDL() throws SDLException {
        SDL.init( SDL.INIT_VIDEO );
    }


    @AfterClass
    public static void tearDownSDL() {
        SDL.quit();
    }


    @Test
    public void notSetVideoMode() {
        Screen screen = Screen.setVideoMode( 0, 0, 0, 0 );
    }
}
