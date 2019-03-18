package com.sonic.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * MyObjectTest
 *
 * @author Sonic
 * @since 2019/3/18
 */
public class MyObjectTest {

    public static void main(String[] args) throws InterruptedException {
        MyObjectTest myObjectTest = new MyObjectTest();
//        myObjectTest.checkSoftReference();
//        myObjectTest.checkWeakReference();
        myObjectTest.checkPhantomReference();

    }

    private void checkPhantomReference() throws InterruptedException {
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> phantomQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, phantomQueue);
        Map<PhantomReference<MyObject>, String> map = new HashMap<>();
        map.put(phantomReference, "db resource");

        Thread thread = new Thread(new CheckPhantomQueue(phantomQueue, map));
        thread.setDaemon(true);
        thread.start();

        myObject = null;

        TimeUnit.SECONDS.sleep(1);
        int i = 1;
        while (true) {
            System.out.println(i + " gc");
            System.gc();
            TimeUnit.SECONDS.sleep(1);
        }

    }

    private void checkWeakReference() throws InterruptedException {
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> weakQueue = new ReferenceQueue<>();
        WeakReference<MyObject> weakReference = new WeakReference<>(myObject, weakQueue);

        Thread thread = new Thread(new CheckRefQueue(weakQueue));
        thread.setDaemon(true);
        thread.start();

        myObject = null;

        System.out.println("Before GC:Weak Get= " + weakReference.get());

        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("After GC:Weak Get= " + weakReference.get());
    }

    private void checkSoftReference() throws InterruptedException {
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> softQueue = new ReferenceQueue<>();
        SoftReference<MyObject> softReference = new SoftReference<>(myObject, softQueue);

        Thread thread = new Thread(new CheckRefQueue(softQueue));
        thread.setDaemon(true);
        thread.start();

        myObject = null;
        TimeUnit.SECONDS.sleep(3);
        System.gc();
        System.out.println("After GC:Soft Get= " + softReference.get());
        System.out.println("分配大块内存");
        byte[] b = new byte[4 * 1024 * 860];
        System.out.println("After new byte[]:Soft Get= " + softReference.get());
    }

}
