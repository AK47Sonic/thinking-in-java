package com.sonic.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;

/**
 * CheckPhantomQueue
 *
 * @author Sonic
 * @since 2019/3/18
 */
public class CheckPhantomQueue implements Runnable {

    private ReferenceQueue<MyObject> referenceQueue;
    private Map map;

    public CheckPhantomQueue(ReferenceQueue<MyObject> referenceQueue, Map map) {
        this.referenceQueue = referenceQueue;
        this.map = map;
    }

    @Override
    public void run() {
        Reference<MyObject> obj = null;
        try {
            obj = (Reference<MyObject>) referenceQueue.remove();
            System.out.println("PhantomReference: " + obj);
            Object value = map.get(obj);
            System.out.println("Clean resource: " + value);
            map.remove(obj);
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
