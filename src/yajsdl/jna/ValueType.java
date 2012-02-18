/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yajsdl.jna;

/**
 *
 * @author rihine
 */
public final class ValueType {
    public static Uint8 toUint8(byte value) {
        return new uint8( value );
    }
    
    
    public static Sint32 toSint32(int value) {
        return new sint32( value );
    }
    
    
    public static Uint32 toUint32(int value) {
        return new uint32( value );
    }

    private static class sint32 implements Sint32 {

        public sint32(int value) {
            this.value_ = value;
        }

        public int get() { return this.value_; }

        public void set(int value) { this.value_ = value; }
        
        
        private int value_;
    }
    
    
    private static class uint32 implements Uint32 {

        public uint32(int value) {
            this.value_ = value;
        }

        public int get() { return this.value_; }

        public void set(int value) { this.value_ = value; }
        
        
        private int value_;
    }
    
    
    private static class uint8 implements Uint8 {
        uint8(byte value) {
            this.value_ = value;
        }
        
        
        public byte get() { return this.value_; }
        public void set(byte value) { this.value_ = value; }
        
        
        private byte value_;
    }
}
