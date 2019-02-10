package com.sonic.lang;

/**
 * PersonAbstract
 *
 * @author Sonic
 * @since 2019/2/10
 */
public class PersonAbstract extends AbstractSee{

    @Override
    public void see() {

    }

    public static void main(String[] args) {
        new PersonAbstract().see();
        new PersonAbstract().print();
        PersonAbstract.print();
    }
}
