package com.sonic.gof23.adapter;

/**
 * CarController
 *
 * @author Sonic
 * @since 2019/3/30
 */
public abstract class CarController {
    public void move() {
        System.out.println("move");
    }

    public abstract void phonate();

    public abstract void twinkle();
}
