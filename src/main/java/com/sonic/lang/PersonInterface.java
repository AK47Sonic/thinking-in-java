package com.sonic.lang;

/**
 * TODO
 *
 * @author Sonic
 * @since 2019/2/10
 */
public class PersonInterface implements Visible {
    @Override
    public void see() {

    }

    public static void main(String[] args) {
        new PersonInterface().see();
//        PersonInterface.print(); //接口的静态方法不能被继承
//        new PersonInterface().print();
//        Visible.print();
    }
}
