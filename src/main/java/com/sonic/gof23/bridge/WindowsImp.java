package com.sonic.gof23.bridge;

/**
 * WindowsImp
 *
 * @author Sonic
 * @since 2019/3/31
 */
public class WindowsImp implements OSImp{
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("Windows");
    }
}
