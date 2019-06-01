package com.sonic.difficulty;

/**
 * ParentObjectInitializer
 *
 * @author Sonic
 * @since 2019/6/1
 */
public class ParentObjectInitializer {

    public ParentObjectInitializer(){
        System.out.println("ParentObjectInitializer Construct");
    }

    static int c = getC();

    int d = getD();

    static {
        System.out.println("ParentObjectInitializer static code block");
    }

    {
        System.out.println("ParentObjectInitializer code block");
    }

    private int getD() {
        System.out.println("ParentObjectInitializer getD");
        return 0;
    }

    static int getC(){
        System.out.println("ParentObjectInitializer getC");
        return 1;
    }
}
