package com.sonic.juc.wait;

/**
 * NotifyAndNotifyAll
 *
 * @author Sonic
 * @since 2019/1/6
 */
public class NotifyAndNotifyAll {

    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
//                    resourceA.notify();
                    resourceA.notifyAll();
                }
                System.out.println("threadC is over");
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

//        threadA.join();
//        threadB.join();
//        threadC.join();

        System.out.println("main over");

    }

}
