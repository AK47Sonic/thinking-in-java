package com.sonic.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * GenericParameterTypeDemo
 *
 * @author Sonic
 * @since 2019/2/11
 */
public class GenericParameterTypeDemo {

    public static void main(String[] args) {
        Container<String> container1 = new Container<>("String");
        Container<Integer> container2 = new Container("String"); //非类型安全
        Container<Integer> container3 = new Container<>(1);
        Container<Integer> container4 = new Container<Integer>(1);

        /**
         * 编译时：为什么不报错？
         * StringBuffer 是 CharSequence 子类
         * String 也是 CharSequence 子类
         * 运行时：类型擦除为Object
         */
        Container2<String> container6 = new Container2<>("String"); //类型安全

        /**
         * 非类型安全的写法，只要是Object的子类都可以存，但由于extends上界，导致构造函数只能传入CharSequence的子类
         * 但是引用类型无法检测出Container2 中具体是哪一个CharSequence的子类，所以不报错 （所以要用<>去避免这个问题）
         * 既然编译时类型检查没有报错，在运行时，类型擦除，自然不会报错
         */
        Container2<StringBuilder> container5 = new Container2("Hello, World"); //非类型安全
        // StringBuilder element = container5.getElement(); //Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.StringBuilder
        // 通过构造器传递参数是String类型，运行时都是Object，所以没有问题
        System.out.println(container5.getElement());

        // 当使用container5对象申明的类型为Container2<StringBuilder> 则E为StringBuilder，所以set(e) E必须是StringBuilder
        container5.set(new StringBuilder("2019"));
        System.out.println(container5.getElement());

        // Java 泛型对象操作时候，看申明对象泛型参数类型操作一定没有问题。加<>更加安全

        add(new ArrayList<>(), "HelloWorld"); // auto-boxing 256 = new Integer(256) <- Integer.valueOf(256)
        add(new ArrayList<>(), 1);

        foreach(Arrays.asList(1, 2, 3), System.out::println);
    }

    private static class Container<E> {
        private E element;

        private Container(E e) {
            this.element = e;
        }
    }

    // 单界限泛型参数类型
    private static class Container2<E extends CharSequence> {
        private E element;

        private Container2(E e) {
            this.element = e;
        }

        public boolean set(E e) {
            this.element = e;
            return true;
        }

        public E getElement() {
            return element;
        }

    }

    // 多界限泛型参数类型

    private static class C {

    }

    private static interface I {

    }

    private static interface I2 {

    }

    /**
     * 多界限泛型参数类型 extends 的第一个类型可以具体类（接口）,单继承
     * 第二或更多参数类型必须是接口
     * 相当于 {@link TemplateClass}
     */
    private static class Template<T extends C & I & I2> {

    }

    private static class TemplateClass extends C implements I, I2 {

    }

    /**
     * 把一个类型的元素添加到集合中
     */
    public static <C extends Collection<E>, E extends Serializable> void add(C target, E element) {
        target.add(element);
    }

    public static <C extends Iterable<E>, E extends Serializable> void foreach(C target, Consumer<E> consumer) {
        for (E e : target) {
            consumer.accept(e);
        }
    }


}
