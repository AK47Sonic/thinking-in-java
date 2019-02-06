package com.sonic.collection.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Fruit ordered
 * 比较规则：
 * 方法参数顺序决定了当前的顺序
 * 如果返回1，则说明当前顺序需要换位
 * 如果返回-1， 则说明保持当前顺序位置不变
 * 如果返回0，则说明两数相等
 *
 * @author Administrator
 * @since 2019/2/6
 */
public class Fruit implements Comparable<Fruit> {
    public Fruit(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "size=" + size +
                '}';
    }

    private int size;

    @Override
    public int compareTo(Fruit o) {

        int diff = this.size - o.size;

        if (diff > 0) return 1;
        else if (diff == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Fruit f1 = new Fruit(10);
        Fruit f2 = new Fruit(20);
        Fruit f3 = new Fruit(15);
//        Fruit[] fruits = new Fruit[]{f1, f2, f3};
//        Arrays.sort(fruits);
//        System.out.println(Arrays.asList(fruits));

        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(f1);
        fruitList.add(f2);
        fruitList.add(f3);
//        Comparator<Fruit> fruitComparator = (o1, o2) -> {
//            int diff = o1.size - o2.size;
//            if (diff > 0) return 1;
//            else if (diff == 0) return 0;
//            else return -1;
//        };
        fruitList.sort((o1, o2) -> {
            int diff = o1.size - o2.size;
            if (diff > 0) return 1;
            else if (diff == 0) return 0;
            else return -1;
        });
        System.out.println(fruitList);

    }

}
