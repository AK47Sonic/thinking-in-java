package com.sonic.effectivejava.serializable;

import java.io.*;

/**
 * BrandTest
 *
 * @author Sonic
 * @since 2019/3/17
 */
public class BrandTest {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.buf"))) {
            oos.writeObject(Brand.NIKE);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.buf"))) {
            Brand b = (Brand)ois.readObject();
            print("" + (b == Brand.NIKE)); // 答案显然是false
        }
    }

}
