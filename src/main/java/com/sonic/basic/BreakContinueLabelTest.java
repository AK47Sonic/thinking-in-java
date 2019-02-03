package com.sonic.basic;

/**
 * BreakContinueLabelTest
 *
 * @author Administrator
 * @since 2019/2/3
 */
public class BreakContinueLabelTest {

    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            System.out.println("Pass " + i + ":");
            for (int j = 0; j < 20; j++) {
                if (j == 10)
//                    break outer;
                    continue outer;
                System.out.println(j + " ");
            }
            System.out.println("This will not print");
        }
        System.out.println("Loops complete.");
    }

}
