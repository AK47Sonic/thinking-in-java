package com.sonic.effectivejava.serializable;

import java.io.*;

/**
 * SerializeTester
 *
 * @author Sonic
 * @since 2019/3/17
 */
public class SerializeTester {
    public static void main(String... strings) throws Exception {
        File file = new File("out.ser");

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        SessionDTO dto = new SessionDTO(1);
        oos.writeObject(dto);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        SessionDTO rdto = (SessionDTO) ois.readObject();

        System.out.println("data : " + rdto.getData()
                + " activation time : " + rdto.getActivationTime());
        ois.close();
    }
}
