package com.sonic.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * GenericWildcardsTypeDemo
 * 集合类型则表示包含的元素类型是任意子类或超类即可。
 * PECS原则对应于当前类型，接收任意类型的子类型只有null，返回任意类型的超类只有Object
 *
 * 容器对象，需要更抽象类型，Number
 * 输入对象，是具体类型
 *
 * PECS
 * 返回数据（生产者）使用 extends
 * 操作数据（消费者）使用 super
 *
 * @author Sonic
 * @since 2019/2/12
 */
public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {
        //泛型上界通配符
        // Number -> Byte, Short, Integer, Long
        List<Number> numbers = new ArrayList<>();

        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 1));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 1, (byte) 2);

        numbers.addAll(bytes);

        forEach(numbers, System.out::println);

    }

    public static void forEach(Iterable<? extends Number> list, Consumer<Number> consumer) {
        for (Number e : list) {
            consumer.accept(e);
        }
    }

    public static void forEach2(Iterable<? extends Number> list, Consumer<Integer> consumer) {
        for (Serializable e : list) {
//            consumer.accept(e);
        }
    }

}
