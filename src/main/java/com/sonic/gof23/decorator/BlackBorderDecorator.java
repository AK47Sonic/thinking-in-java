package com.sonic.gof23.decorator;

/**
 * BlackBorderDecorator
 *
 * @author Sonic
 * @since 2019/4/17
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void display() {
        this.setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("setBlackBorder");
    }
}
