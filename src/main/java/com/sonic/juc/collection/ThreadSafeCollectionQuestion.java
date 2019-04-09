package com.sonic.juc.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * ThreadSafeCollectionQuestion
 *
 * @author Sonic
 * @since 2019/4/10
 */
public class ThreadSafeCollectionQuestion {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Java 9 工厂方法， 返回 Immutable对象
        list = List.of(1, 2, 3, 4, 5);
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
        Map<Object, Object> map = Map.of(1, "A");

        //以上实现都是不可变对象， 不过第一个除外，第一个可以set值

        //通过 Collections#sychronized* 方法返回
        //Wrapper[装饰者] 设计模式（所有的方式都被 synchronized 互斥)
        list = Collections.synchronizedList(list);
        set = Collections.synchronizedSet(set);
        map = Collections.synchronizedMap(map);

       list = new CopyOnWriteArrayList<>(list);
        set = new CopyOnWriteArraySet<>(set);
        map = new ConcurrentHashMap<>(map);

    }

}
