package com.sonic.juc.wait;

/**
 * WaitNotifyInterupt
 *
 * @auther Sonic
 * @since 2019/1/6
 */
public class WaitNotifyInterupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("---begin---");
                try {
                    synchronized (obj) {
                        obj.wait(0); //没有考虑虚假唤醒
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");


    }

}
