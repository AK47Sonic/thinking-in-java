package com.sonic.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * CheckRefQueue
 *
 * @author Sonic
 * @since 2019/3/18
 */
public class CheckRefQueue implements Runnable {

    private ReferenceQueue<MyObject> softQueue;

    public CheckRefQueue(ReferenceQueue<MyObject> softQueue){
        this.softQueue = softQueue;
    }

    @Override
    public void run() {
        Reference<MyObject> obj = null;
        try {
            obj = (Reference<MyObject>) softQueue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj != null) {
            System.out.println("Object for softReference is " + obj.get());
        }
    }
}
