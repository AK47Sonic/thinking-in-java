package com.sonic.juc.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayListDemo
 *
 * @author Sonic
 * @since 2019/4/13
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String el = iterator.next();
            if ("3".equals(el)) {
                iterator.remove();
            }
        }

        System.out.println("ArrayList: " + arrayList);

    }
}
