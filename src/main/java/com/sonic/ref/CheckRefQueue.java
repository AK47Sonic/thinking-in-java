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

    private ReferenceQueue<MyObject> referenceQueue;

    public CheckRefQueue(ReferenceQueue<MyObject> referenceQueue) {
        this.referenceQueue = referenceQueue;
    }

    @Override
    public void run() {
        Reference<MyObject> obj = null;
        try {
            obj = (Reference<MyObject>) referenceQueue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj != null) {
            System.out.println("===Object is " + obj);
            System.out.println("===Object for Reference is " + obj.get());
        }
    }
}
