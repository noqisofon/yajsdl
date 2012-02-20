package org.yajsdl.events;


public enum EventType {
    NONE,
    ACTIVE,
    KEYDOWN,
    KEYUP,
    MOUSE_MOTION,
    MOUSE_BUTTON_DOWN,
    MOUSE_BUTTON_UP,
    JOYSTICK_AXIS_MOTION,;

    public int toInteger() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
