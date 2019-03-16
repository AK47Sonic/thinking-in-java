package com.sonic.gof23.abstractfactory;

/**
 * SpringTextField
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("show SpringTextField");
    }
}
