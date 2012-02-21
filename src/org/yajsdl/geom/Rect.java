/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.geom;

import org.yajsdl.jna.SDL_Rect;


/**
 *
 * @author rihine
 */
public class Rect implements Cloneable {
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
    public Rect(Rect other) {
        this.x_ = other.x_;
        this.y_ = other.y_;
        this.width_ = other.width_;
        this.height_ = other.height_;
    }


    /**
     *
     */
    @Override
    public Rect clone() {
        return new Rect( this );
    }


    /**
     *
     */
    public int getX() { return this.x_; }


    /**
     *
     */
    public int getY() { return this.y_; }


    /**
     *
     */
    public int getWidth() { return this.width_; }


    /**
     *
     */
    public int getHeight() { return this.height_; }


    /**
     * 
     */
    public int getTop() { return this.y_; }


    /**
     * 
     */
    public int getLeft() { return this.x_; }


    /**
     * 
     */
    public int getBottom() { return this.y_ + this.height_; }


    /**
     * 
     */
    public int getRight() { return this.x_ + this.width_; }


    /**
     *
     */
    public boolean contains(int x, int y) {
        return (this.x_ <= x && this.x_ + this.width_ > x)
            && (this.y_ <= y && this.y_ + this.height_ > y);
    }


    /**
     *
     */
    public boolean containsPoint(Point point) {
        return (this.x_ <= point.getX() && this.x_ + this.width_ > point.getX())
            && (this.y_ <= point.getY() && this.y_ + this.height_ > point.getY());
    }


    /**
     *
     */
    public boolean containsRect(Rect rect) {
        return this.getLeft() <= rect.getLeft();
    }


    /**
     * 
     */
    public boolean isEmpty() {
        return this.x_ == 0
            && this.y_ == 0
            && this.width_ == 0
            && this.height_ == 0;
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
