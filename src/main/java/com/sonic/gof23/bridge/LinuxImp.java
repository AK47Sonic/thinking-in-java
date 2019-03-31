package com.sonic.gof23.bridge;

/**
 * LinuxImp
 *
 * @author Sonic
 * @since 2019/3/31
 */
public class LinuxImp implements OSImp {
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("Linux");
    }
}
