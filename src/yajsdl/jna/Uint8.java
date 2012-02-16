/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yajsdl.jna;


/**
 *
 * @author rihine
 */
public final class Uint8 {
    protected Uint8(byte value) {
        this.value_ = value;
    }


    public static Uint8 valueOf(int value) {
        return new Uint8( (byte)( value & 0xff ) );
    }


    private byte value_;
}
