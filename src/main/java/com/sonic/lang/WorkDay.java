package com.sonic.lang;

import java.io.Serializable;

/**
 * WorkDay
 *
 * @author Sonic
 * @since 2019/2/10
 */
public enum WorkDay implements Serializable {

    ONE(1){
        @Override
        void show() {
            System.out.println(getValue());
        }
    },
    TWO(2) {
        @Override
        void show() {
            System.out.println(getValue());
        }
    },
    THREE(3) {
        @Override
        void show() {
            System.out.println(getValue());
        }
    };

    public int getValue() {
        return value;
    }

    private int value;

    WorkDay(int value){
        this.value = value;
    }

    abstract void show();
}
