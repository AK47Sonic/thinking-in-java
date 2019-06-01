package com.sonic.difficulty;

/**
 * ObjectInitializer
 *
 * @author Sonic
 * @since 2019/6/1
 */
public class ObjectInitializer extends ParentObjectInitializer {

    public ObjectInitializer(){
        System.out.println("Construct");
    }

    static int a = getA();

    int b = getB();

    static {
        System.out.println("static code block");
    }

    {
        System.out.println("code block");
    }

    private int getB() {
        System.out.println("getB");
        return 0;
    }

    static int getA(){
        System.out.println("getA");
        return 1;
    }

    public static void main(String[] args) {
//        new ObjectInitializer();
//        System.out.println(ObjectInitializer.a);
//        System.out.println(ParentObjectInitializer.class);
        new ParentObjectInitializer();
    }

}
