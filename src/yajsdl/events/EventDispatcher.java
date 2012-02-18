package yajsdl.events;

import java.util.Vector;

import yajsdl.jna.SDLLibrary;
import yajsdl.jna.Uint8;
import yajsdl.jna.ValueType;
//import yajsdl.utils.*;


public class EventDispatcher implements Runnable {


    public EventDispatcher(boolean shouldBeDaemon) {
        this.daemon_ = shouldBeDaemon;
    }


    public void start() {
        this.thread_ = new Thread( this );
        this.thread_.setDaemon( this.daemon_ );
        this.thread_.start();
    }


    public void startAndWait() {
        this.stopped_ = false;

        this.start();
        while ( this.stopped_ == false ) {
            try {
                Thread.sleep( 500 );
            } catch ( Exception e ) {
            }
        }
    }


    public int setEventState(EventState type, EventType state) {
        return this.baseSetEventState( type, state );
    }


    protected int baseSetEventState(EventState type, EventType state) {
        Uint8 ret;
        Uint8 event_type = ValueType.toUint8( type.toByte() );
        int event_state = state.toInteger();

        ret = SDLLibrary.INSTANCE.SDL_EventState( event_type, event_state );
        
        return ret.get();
    }


    private Vector listeners_ = new Vector();
    private Thread thread_;
    private boolean daemon_;
    private volatile boolean stopped_ = false;
    private int handle_poll_event_ = 0;

    private final static boolean DEBUG = false;

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
