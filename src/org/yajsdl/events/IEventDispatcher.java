/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yajsdl.events;

/**
 * 
 * @author rihine
 */
public interface IEventDispatcher {
    /**
     * 指定されたイベントリスナーをイベントディスパッチャーオブジェクトに登録し、イベントリスナーがイベントの通知を受け取れるようにします。
     * 
     * @param eventType
     * @param listener
     */
    void addEventListener(EventType eventType, EventListener listener);


    /**
     * 指定されたイベントリスナーをイベントディスパッチャーから削除します。
     * 
     * @param eventType
     * @param listener
     */
    void removeEventListener(EventType eventType, EventListener listener);
}
