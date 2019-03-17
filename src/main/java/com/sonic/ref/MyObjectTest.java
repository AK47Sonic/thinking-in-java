package com.sonic.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * MyObjectTest
 *
 * @author Sonic
 * @since 2019/3/18
 */
public class MyObjectTest {

    public static void main(String[] args) throws InterruptedException {
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
        byte[] b = new byte[4*1024*860];
        System.out.println("After new byte[]:Soft Get= " + softReference.get());


    }

}
