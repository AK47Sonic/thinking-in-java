package com.sonic.ref;

/**
 * MyObject
 *
 * @author Sonic
 * @since 2019/3/18
 */
public class MyObject {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("MyObject's finalize called");
    }

    @Override
    public String toString() {
        return "I am MyObject";
    }
}
