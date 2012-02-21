/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.geom;


/**
 *
 * @author rihine
 */
public class Point implements Cloneable {


    /**
     *
     */
    public Point() {
        this.x_ = 0;
        this.y_ = 0;
    }
    /**
     *
     */
    public Point(int x, int y) {
        this.x_ = x;
        this.y_ = y;
    }
    /**
     *
     */
    public Point(Point other) {
        this.x_ = other.x_;
        this.y_ = other.y_;
    }


    /**
     * 
     */
    @Override
    public Point clone() {
        return new Point( this );
    }


    /**
     * 
     */
    public Point add(Point v) {
        return new Point( this.x_ + v.x_, this.y_ + v.y_ );
    }


    /**
     * 
     */
    public boolean equals(Point other) {
        return this.x_ == other.x_ && this.y_ == other.y_;
    }


    /**
     * 
     */
    public void offset(int dx, int dy) {
        this.x_ += dx;
        this.y_ += dy;
    }


    /**
     *
     */
    public int length() {
        return (int)Math.sqrt( this.x_ * this.x_ + this.y_ * this.y_ );
    }


    /**
     *
     */
    public int getX() { return this.x_; }

    
    /**
     *
     */
    public int getY() { return this.y_; }


    private int x_;
    private int y_;
}
