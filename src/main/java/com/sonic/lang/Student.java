package com.sonic.lang;

/**
 * Student
 * 先调用父类构造再调用子类构造，没有申明默认会调用super();
 *
 * @author Sonic
 * @since 2019/2/10
 */
public class Student extends Person {

    private int age;

//    public Student() {
//        super();
//        System.out.println("Student");
//    }

    public Student(int age){
//        super(1);
    }

    public static void main(String[] args) {
        new Student(1);
    }
}
