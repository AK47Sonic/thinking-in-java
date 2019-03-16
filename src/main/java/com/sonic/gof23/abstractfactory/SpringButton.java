package com.sonic.gof23.abstractfactory;

/**
 * SpringButton
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("show SpringButton");
    }
}
