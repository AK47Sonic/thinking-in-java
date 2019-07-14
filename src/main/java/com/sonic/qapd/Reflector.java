package com.sonic.qapd;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Reflector ? 不是特别理解
 * HashIteratorshi 是一个非公开的类
 * 访问性 = 类访问性 + 方法访问性
 * public = public + public
 *
 * @author Sonic
 * @since 2019/7/14
 */
public class Reflector {
    public static void main(String[] args) throws Exception {
        Set s = new HashSet();
        s.add("foo");
        Iterator i = s.iterator();
//        System.out.println(i.getClass());
//        Method m = i.getClass().getMethod("hasNext", new Class[0]);

//        m.setAccessible(true);
        Method m = Iterator.class.getMethod("hasNext", new Class[0]);
        System.out.println(m.invoke(i, new Object[0]));
    }
}
