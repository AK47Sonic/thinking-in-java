package com.sonic.juc.wait;

/**
 * MultiMonitorLock
 *
 * @author Sonic
 * @since 2019/1/6
 */
public class MultiMonitorLock {

    private static volatile Object resourceA = new Object();
    private static volatile Object resoruceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");
                        synchronized (resoruceB) {
                            System.out.println("threadA get resourceB lock");
                            try {
                                resourceA.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    System.out.println("threadB try get resourceB lock...");
                    synchronized (resoruceB) {
                        System.out.println("threadB get resourceB lock");
                        try {
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");

    }

}
