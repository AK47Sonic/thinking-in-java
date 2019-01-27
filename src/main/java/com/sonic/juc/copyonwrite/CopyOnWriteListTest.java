package com.sonic.juc.copyonwrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteListTest
 *
 * @author Administrator
 * @since 2019/1/27
 */
public class CopyOnWriteListTest {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1, "baba");
                arrayList.remove(2);
                arrayList.remove(3);
//                System.out.println("arrayList: " + arrayList);
            }
        });

        Iterator<String> iterator = arrayList.iterator();
        threadOne.start();
        threadOne.join();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
