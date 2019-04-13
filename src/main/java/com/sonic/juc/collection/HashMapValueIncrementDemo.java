package com.sonic.juc.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapValueIncrementDemo
 *
 * @author Sonic
 * @since 2019/4/13
 */
public class HashMapValueIncrementDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            fastApproach(entry);
            slowApproach(entry, map);
        }
        System.out.println(map);

    }

    private static void fastApproach(Map.Entry<String, Integer> entry) {
        entry.setValue(entry.getValue() + 1);
    }

    private static void slowApproach(Map.Entry<String, Integer> entry, Map<String, Integer> map) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        value += 1;
        map.put(key, value);
    }

}
