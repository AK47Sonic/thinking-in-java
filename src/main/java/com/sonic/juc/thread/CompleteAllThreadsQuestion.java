package com.sonic.juc.thread;

/**
 * CompleteAllThreadsQuestion
 *
 * @author Sonic
 * @since 2019/4/10
 */
public class CompleteAllThreadsQuestion {
    public static void main(String[] args) {
        Thread t1 = new Thread(CompleteAllThreadsQuestion::action, "t1");
        Thread t2 = new Thread(CompleteAllThreadsQuestion::action, "t2");
        Thread t3 = new Thread(CompleteAllThreadsQuestion::action, "t3");

        t1.start();
        t2.start();
        t3.start();
        Thread mainThread = Thread.currentThread();
        ThreadGroup threadGroup = mainThread.getThreadGroup();

        int count = threadGroup.activeCount();
        Thread[] threads = new Thread[count];
        threadGroup.enumerate(threads, true);
        for (Thread thread : threads) {
            System.out.printf("当前活跃线程：%s\n", thread.getName());
        }

    }

    private static void action() {
        System.out.println("Run");
    }

}
