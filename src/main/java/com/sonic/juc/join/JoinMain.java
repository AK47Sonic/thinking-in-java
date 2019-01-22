package com.sonic.juc.join;

/**
 * JoinMain
 *
 * @author Sonic
 * @since 2019/1/7
 */
public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over!");

            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo over!");

            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        threadOne.join();
        threadTwo.join();

        System.out.println("all child thread over!");

    }
}
