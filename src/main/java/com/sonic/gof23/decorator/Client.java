package com.sonic.gof23.decorator;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/4/17
 */
public class Client {

    public static void main(String[] args) {
        Component component = new Window();
        new BlackBorderDecorator(new ScrollBarDecorator(component)).display();
    }
}
