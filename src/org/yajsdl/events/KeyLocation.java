/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

/**
 *
 * @author rihine
 */
public enum KeyLocation {
    STANDARD(0),
    LEFT(1),
    RIGHT(2),
    NUM_PAD(3),;

    
    private KeyLocation(int value) {
        this.value_ = value;
    }


    public int toInt() {
        return this.value_;
    }


    private int value_;
}
