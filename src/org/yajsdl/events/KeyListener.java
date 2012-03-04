/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

/**
 * 
 * @author rihine
 */
public interface KeyListener extends EventListener {

    public void keyReleased(KeyboardEvent keyboardEvent);


    public void keyPressed(KeyboardEvent keyboardEvent);

}
