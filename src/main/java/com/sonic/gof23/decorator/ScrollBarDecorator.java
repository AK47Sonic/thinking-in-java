package com.sonic.gof23.decorator;

/**
 * ScrollBarDecorator
 *
 * @author Sonic
 * @since 2019/4/17
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    public void display() {
        this.setScrollBar();
        super.display();
    }

    private void setScrollBar() {
        System.out.println("setScrollBar");
    }

}
