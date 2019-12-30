package com.sonic.gof23.singleton;

import java.io.*;

/**
 * TestGetSameObj
 *
 * @author Sonic
 * @since 2019/12/30
 */
public class TestGetSameObj {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton instance = HungrySingleton.getInstance();
        File temp = new File("temp");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(temp));
        outputStream.writeObject(instance);
        outputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(temp));
        HungrySingleton instance2 = (HungrySingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(instance == instance2);
    }
}
