package com.sonic.juc.thread;

/**
 * TODO
 *
 * @author Sonic
 * @since 2019/4/8
 */
public class ThreadRunOneByOne {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println(1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println(2);
        });
        Thread t3 = new Thread(()->{
            System.out.println(3);
        });
        threadStartAndWait(t1);
        threadStartAndWait(t2);
        threadStartAndWait(t3);

    }

    private static void threadStartAndWait(Thread thread) {
        if(Thread.State.NEW.equals(thread.getState())){
            thread.start();
        }
        while(thread.isAlive()){
            synchronized (thread) {
                try {
                    thread.wait(0); //到底是谁调用了notify()？
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
