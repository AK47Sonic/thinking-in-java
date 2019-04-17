package com.sonic.gof23.decorator;

/**
 * ComponentDecorator
 *
 * @author Sonic
 * @since 2019/4/17
 */
public class ComponentDecorator extends Component {

    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
