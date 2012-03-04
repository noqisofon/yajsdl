package org.yajsdl.events;

public enum EventState {
    QUERY(-1), IGNORE(0), DISABLE(0), ENABLE(1);

    private EventState(int value) {
        this.value_ = value;
    }


    public byte toByte() {
        return (byte)this.value_;
    }


    public int toInt() {
        return this.value_;
    }

    private int value_;
}
