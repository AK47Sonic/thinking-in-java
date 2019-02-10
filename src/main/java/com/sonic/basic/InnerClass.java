package com.sonic.basic;

/**
 * InnerClass
 *
 * @author Administrator
 * @since 2019/2/4
 */
public class InnerClass {

    private Person p = new Person();

    private Student s = new Student();

    private static int i =10;

    private int age = 30;

    private int j = 20;

    private static void jump() {
        Person person = new Person();
        person.say();
        Student student = new InnerClass().new Student();
        student.eat();
        System.out.println(person.school);
    }

    private void test1(Person p){
        System.out.println(p.name);
        p.say();
        Student student = this.new Student();
        student.eat();
        System.out.println(student.school);
        Person person = new Person();
        person.say();
    }

    private void test2(Student s){
        System.out.println(s.age);
        s.eat();

    }

    class Student{
        private String school;
        private int age = 10;
//        private static String addr = "";
        Student(){

        }

//        public static void watch(){
//
//        }
        public void eat(){
            System.out.println(InnerClass.this.j);
            System.out.println(p);
            System.out.println(i);
            System.out.println(this.age);
            System.out.println(InnerClass.this.age);
        }

    }

    static class Person {
        private String school;
        private String name;
        private static int i = 10;
        private static String addr = "addr";
        Person(){

        }

        private void say(){
            System.out.println(InnerClass.i);
            System.out.println(i);
            System.out.println(this.name);
//            System.out.println(InnerClass.this.j); //错误
            System.out.println(addr);
            jump();
        }

        public static void sleep(){}


    }
}
