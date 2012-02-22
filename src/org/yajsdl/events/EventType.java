package org.yajsdl.events;

import org.yajsdl.jna.SDLLibrary;


public enum EventType {
    NONE(SDLLibrary.SDL_EventType.SDL_NOEVENT),
    ACTIVE(SDLLibrary.SDL_EventType.SDL_ACTIVEEVENT),
    KEYDOWN(SDLLibrary.SDL_EventType.SDL_KEYDOWN),
    KEYUP(SDLLibrary.SDL_EventType.SDL_KEYUP),
    MOUSE_MOTION(SDLLibrary.SDL_EventType.SDL_MOUSEMOTION),
    MOUSE_BUTTON_DOWN(SDLLibrary.SDL_EventType.SDL_MOUSEBUTTONDOWN),
    MOUSE_BUTTON_UP(SDLLibrary.SDL_EventType.SDL_MOUSEBUTTONUP),
    JOYSTICK_AXIS_MOTION(SDLLibrary.SDL_EventType.SDL_JOYAXISMOTION),
    JOYSTICK_BALL_MOTION(SDLLibrary.SDL_EventType.SDL_JOYBALLMOTION),

    QUIT(SDLLibrary.SDL_EventType.SDL_QUIT),;


    private EventType(int value) {
        this.value_ = value;
    }


    public int toInt() {
        return this.value_;
    }


    private int value_;
}
