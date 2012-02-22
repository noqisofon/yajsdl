package org.yajsdl.video;

import com.sun.jna.Pointer;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.yajsdl.jna.SDL_Color;

import org.yajsdl.jna.SDL_Palette;


public class Palette extends AbstractSet<Color> {
    /**
     *
     */
    public Palette() {
        super();
        this.content_ = new HashSet<Color>();
    }
    /**
     *
     */
    public Palette(Collection<? extends Color> collection) {
        super();
        this.content_ = new HashSet<Color>( collection );
    }
    /**
     *
     */
    public Palette(int initialCapacity) {
        super();
        this.content_ = new HashSet<Color>( initialCapacity );
    }
    
    /**
     *
     */
    public Palette(int initialCapacity, float loadFactior) {
        super();
        this.content_ = new HashSet<Color>( initialCapacity, loadFactior );
    }


    /**
     *
     */
    @Override
    public Iterator<Color> iterator() {
        return this.content_.iterator();
    }

    
    /**
     *
     */
    @Override
    public int size() {
        return this.content_.size();
    }


    /**
     * 
     */
    public SDL_Palette toSource() {
        int i = 0;
        SDL_Palette ret = new SDL_Palette();
        SDL_Color[] native_colors = new SDL_Color[this.size()];

        for ( Iterator<Color> it = this.content_.iterator(); it.hasNext(); ) {
            native_colors[i] = it.next().toSource();
            ++ i;
        }
        ret.ncolors = this.size();
        ret.colors = native_colors;

        return ret;
    }


    private HashSet<Color> content_;
}
