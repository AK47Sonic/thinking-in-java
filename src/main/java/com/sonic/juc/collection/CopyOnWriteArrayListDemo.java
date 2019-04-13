package com.sonic.juc.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayListDemo
 *
 * @author Sonic
 * @since 2019/4/13
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String el = iterator.next();
            if ("3".equals(el)) {
                // CopyOnWriteArrayList 迭代器的remove会抛出UnsupportedOperationException
                arrayList.remove(el);
            }
        }
        System.out.println("arrayList: " + arrayList);

    }
}
