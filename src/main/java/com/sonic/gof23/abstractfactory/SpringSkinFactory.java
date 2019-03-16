package com.sonic.gof23.abstractfactory;

/**
 * SpringSkinFactory
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
