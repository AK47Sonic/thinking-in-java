package com.sonic.gof23.bridge;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/31
 */
public class Client {
    public static void main(String[] args) {
        OSImp osImp = new WindowsImp(); //通过反射，动态替换
        Image image = new JPGImage(osImp); //通过反射，动态替换
        image.parseFile("Test");
    }
}
