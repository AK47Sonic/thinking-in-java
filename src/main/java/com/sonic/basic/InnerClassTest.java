package com.sonic.basic;

/**
 * InnerClassTest
 *
 * @author Sonic
 * @since 2019/2/10
 */
public class InnerClassTest {
    public static void main(String[] args) {
        InnerClass.Person person = new InnerClass.Person();

        InnerClass.Student student = new InnerClass().new Student();
        student.eat();
    }
}
