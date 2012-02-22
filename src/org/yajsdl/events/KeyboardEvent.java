/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

import org.yajsdl.jna.SDLLibrary;
import org.yajsdl.jna.SDL_Event;
import org.yajsdl.jna.SDL_KeyboardEvent;


/**
 *
 * @author rihine
 */
public class KeyboardEvent extends SDLEvent {
    /**
     *
     * @param eventType 
     */
    public KeyboardEvent(EventType eventType) {
        super( eventType );
    }
    /**
     *
     * @param eventType
     * @param keyCode
     * @param location  
     */
    public KeyboardEvent(EventType eventType, int keyCode, KeyLocation location) {
        super( eventType );

        this.alt_key_ = false;
        this.char_code_ = 0;
        this.control_key_ = false;
        this.key_code_ = keyCode;
        this.key_location_ = location;
        this.shift_key_ = false;
    }


    /**
     *
     * @return 
     */
    public boolean isPress() { return this.toggle_; }


    /**
     *
     * @return 
     */
    public boolean getAltKey() { return this.alt_key_; }


    /**
     * 
     * @return 
     */
    public char getCharCode() { return this.char_code_; }


    /**
     * 
     * @return 
     */
    public boolean getCtrlKey() { return this.control_key_; }


    /**
     * 
     * @return 
     */
    public int getKeyCode() { return this.key_code_; }


    /**
     * 
     * @return 
     */
    public KeyLocation getKeyLocation() { return this.key_location_; }


    /**
     * 
     * @return 
     */
    public boolean getShiftKey() { return this.shift_key_; }

    
    /**
     *
     */
    @Override
    public SDL_Event toSource() {
        
        SDL_Event ret = new SDL_Event();
        
        return ret;
    }
    
    
    /**
     *
     * @param ke
     * @return  
     */
    public static SDLEvent create(SDL_KeyboardEvent ke) {
        KeyboardEvent ret;
        
        if ( ke.type == SDLLibrary.SDL_EventType.SDL_KEYDOWN ) {
            ret = new KeyboardEvent( EventType.KEYDOWN );
        } else if ( ke.type == SDLLibrary.SDL_EventType.SDL_KEYUP ) {
            ret = new KeyboardEvent( EventType.KEYUP );
        } else {
            return null;
        }

        if ( ke.state == SDLLibrary.SDL_RELEASED ) {
            ret.toggle_ = false;
        } else {
            ret.toggle_ = true;
        }

        ret.char_code_ = (char)ke.keysym.unicode;
        ret.key_code_ = ke.keysym.sym;

        if ( ke.keysym.mod != SDLLibrary.SDLMod.KMOD_NONE ) {
            if ( (ke.keysym.mod & SDLLibrary.KMOD_ALT) == SDLLibrary.KMOD_ALT ) {
                ret.alt_key_ = true;
                if ( (ke.keysym.mod & SDLLibrary.SDLMod.KMOD_LALT) == SDLLibrary.SDLMod.KMOD_LALT ) {
                    ret.key_location_ = KeyLocation.LEFT;
                } else if ( (ke.keysym.mod & SDLLibrary.SDLMod.KMOD_RALT) == SDLLibrary.SDLMod.KMOD_RALT ) {
                    ret.key_location_ = KeyLocation.RIGHT;
                } else {
                    ret.key_location_ = KeyLocation.STANDARD;
                }
            } else {
                ret.alt_key_ = false;
                ret.key_location_ = KeyLocation.STANDARD;
            }

            if ( (ke.keysym.mod & SDLLibrary.KMOD_CTRL) == SDLLibrary.KMOD_CTRL ) {
                ret.control_key_ = true;
                if ( (ke.keysym.mod & SDLLibrary.SDLMod.KMOD_LCTRL) == SDLLibrary.SDLMod.KMOD_LCTRL ) {
                    ret.key_location_ = KeyLocation.LEFT;
                } else if ( (ke.keysym.mod & SDLLibrary.SDLMod.KMOD_RCTRL) == SDLLibrary.SDLMod.KMOD_RCTRL ) {
                    ret.key_location_ = KeyLocation.RIGHT;
                } else {
                    ret.key_location_ = KeyLocation.STANDARD;
                }
            } else {
                ret.control_key_ = false;
                ret.key_location_ = KeyLocation.STANDARD;
            }

            if ( (ke.keysym.mod & SDLLibrary.KMOD_SHIFT) == SDLLibrary.KMOD_SHIFT ) {
                ret.shift_key_ = true;
                if ( (ke.keysym.mod & SDLLibrary.SDLMod.KMOD_LSHIFT) == SDLLibrary.SDLMod.KMOD_LSHIFT ) {
                    ret.key_location_ = KeyLocation.LEFT;
                } else if ( (ke.keysym.mod & SDLLibrary.SDLMod.KMOD_RSHIFT) == SDLLibrary.SDLMod.KMOD_RSHIFT ) {
                    ret.key_location_ = KeyLocation.RIGHT;
                } else {
                    ret.key_location_ = KeyLocation.STANDARD;
                }
            } else {
                ret.shift_key_ = false;
                ret.key_location_ = KeyLocation.STANDARD;
            }
        }

        return ret;
    }


    private boolean toggle_;
    private boolean alt_key_;
    private char char_code_;
    private boolean control_key_;
    private int key_code_;
    private KeyLocation key_location_;
    private boolean shift_key_;

    private SDL_KeyboardEvent content_;
}
