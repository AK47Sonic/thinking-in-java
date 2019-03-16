package com.sonic.gof23.abstractfactory;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class Client {
    public static void main(String[] args) {
        SkinFactory skinFactory = new SpringSkinFactory(); //可以通过XML反射动态切换
        Button button = skinFactory.createButton();
        ComboBox comboBox = skinFactory.createComboBox();
        TextField textField = skinFactory.createTextField();
        button.display();
        comboBox.display();
        textField.display();

    }
}
