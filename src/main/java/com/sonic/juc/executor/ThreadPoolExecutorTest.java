package com.sonic.juc.executor;

import java.util.concurrent.*;

/**
 * ThreadPoolExecutorTest
 * 1. runStateOf(0b11100000000000000000000000000011) 返回线程池状态0b11100000000000000000000000000000
 *
 * @author Administrator
 * @since 2019/2/4
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(1, (r) -> {
//            Thread t = new Thread(r);
//            t.setDaemon(true);
//            return t;
//        });

        ExecutorService executorService = new ThreadPoolExecutor(1, 2,
                0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());

        Runnable taskOne = () -> {
            System.out.println("Process taskOne");
        };

        Runnable taskTwo = () -> {
            System.out.println("Process taskTwo");
        };

        Runnable taskThree = () -> {
            System.out.println("Process taskThree");
        };
        executorService.execute(taskOne);
        executorService.execute(taskTwo);
        executorService.execute(taskThree);

        Thread.sleep(2000);
        System.out.println("Sleep down");
        Runnable taskFour = () -> {
            System.out.println("Process taskFour");
        };
        executorService.execute(taskFour);
        System.out.println("Shutdown thread pool");
//        executorService.shutdown();
        boolean closeFlag = executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("closeFlag: " + closeFlag);

        Runnable taskFive = ()->{
            System.out.println("Process taskFive");
        };
        executorService.execute(taskFive);

        executorService.shutdown();

    }
}
