package com.sonic.gof23.abstractfactory;

/**
 * SkinFactory
 *
 * @author Sonic
 * @since 2019/3/16
 */
public interface SkinFactory {
    Button createButton();

    TextField createTextField();

    ComboBox createComboBox();
}
