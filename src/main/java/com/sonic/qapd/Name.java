package com.sonic.qapd;

import java.util.HashSet;
import java.util.Set;

/**
 * Name
 *
 * @author Sonic
 * @since 2019/7/14
 */
public class Name {
    private String first, last;

    public Name(String first, String last) {
        if (first == null || last == null)
            throw new NullPointerException();
        this.first = first;
        this.last = last;
    }

    /**
     * 重载方法的签名规则：（Java 语言规范）
     * 1. @Override 访问性只大于等于父类，比如：protected（父） -> public(子）
     * 2. 返回类型： 如果是原生类型，子类与父类保持一致。 如果是对象型，子类的返回类型可以使父类的派生类
     * 3. 方法参数：子类要保证和父类顺序、数量、类型相同
     * 4. 异常：如果是checked异常， 子类异常允许是父类的子集
     *                              子类的异常列表可以使父类的子集
     *
     */
    public boolean equals(Name o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(s.contains(new Name("Mickey", "Mouse")));
    }
}