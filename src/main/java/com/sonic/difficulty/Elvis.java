package com.sonic.difficulty;

/**
 * Elvis
 *
 * @author Sonic
 * @since 2019/6/1
 */
public class Elvis {

    public static final Elvis ELVIS = new Elvis();

    private Elvis() {
    }

    private static final Boolean LIVING = true;

    private final Boolean alive = LIVING;

    public final Boolean lives() {
        return alive;
    }

    public static void main(String[] args) {
        System.out.println(ELVIS.lives() == null);
//        System.out.println(ELVIS.lives() ? "Hound Dog" : "Heartbreak Hotel");
    }

}
