package com.sonic.difficulty;

/**
 * Elvis
 *
 * @author Sonic
 * @since 2019/6/1
 */
public class Elvis {

    public static Elvis ELVIS = new Elvis();
    private static final Boolean LIVING;

    static {
        System.out.println("init");
        LIVING = true;
    }

    private Elvis() {
        System.out.println(":" + LIVING);
    }

    public static Elvis ELVIS2 = new Elvis();

    private final Boolean alive = LIVING;

    public final Boolean lives() {
        return alive;
    }

    public static void main(String[] args) {
        System.out.println("ELVIS:" + ELVIS.lives());
        System.out.println("ELVIS2:" + ELVIS2.lives());
        System.out.println(ELVIS.lives() == null);
//        System.out.println(ELVIS.lives() ? "Hound Dog" : "Heartbreak Hotel");
    }

}
