/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

/**
 * 
 * @author rihine
 */
public interface KeyEventListener extends EventListener {
    /**
     * 
     * @param e
     */
    public void keyReleased(KeyboardEvent e);


    /**
     * 
     * @param e
     */
    public void keyPressed(KeyboardEvent e);
}
