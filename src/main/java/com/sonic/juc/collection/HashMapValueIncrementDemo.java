package com.sonic.juc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

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
//            slowApproach(entry, map);
        }
//        System.out.println(map);

        // 注意： Java Concurrent Map 可能未实现 Map.Entry#setValue(Object)方法
        ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();

        skipListMap.put("A", 1);
        skipListMap.put("B", 2);
        skipListMap.put("C", 3);

        demoMap(skipListMap);
        System.out.println(skipListMap);

    }

    private static void demoMap(ConcurrentSkipListMap<String,Integer> skipListMap) {
        for (Map.Entry<String, Integer> entry : skipListMap.entrySet()) {
                        fastApproach(entry);
//            slowApproach(entry, skipListMap);
        }
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
