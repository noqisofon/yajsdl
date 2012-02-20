/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.video;

import org.yajsdl.jna.SDL_Rect;

/**
 *
 * @author rihine
 */
public class Rect {
    /**
     *
     */
    public Rect() {
        this.x_ = 0;
        this.y_ = 0;
        this.width_ = 0;
        this.height_ = 0;
    }
    /**
     *
     */
    public Rect(int x, int y, int width, int height) {
        this.x_ = x;
        this.y_ = y;
        this.width_ = width;
        this.height_ = height;
    }

    
    /**
     *
     */
    public SDL_Rect toSource() {
        return new SDL_Rect( (short)this.x_, (short)this.y_, (short)this.width_, (short)this.height_ );
    }
    
    
    private int x_;
    private int y_;
    private int width_;
    private int height_;
}
