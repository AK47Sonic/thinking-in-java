package com.sonic.gof23.adapter;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/30
 */
public class Client {
    public static void main(String[] args) {
        CarController carController = new PoliceCarAdapter(); //可以通过反射动态切换
        carController.move();
        carController.phonate();
        carController.twinkle();
    }
}
