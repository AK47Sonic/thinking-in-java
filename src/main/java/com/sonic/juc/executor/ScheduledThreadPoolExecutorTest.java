package com.sonic.juc.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutorTest
 *
 * @author Administrator
 * @since 2019/2/6
 */
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable r = () -> {
            System.out.println("Scheduled task");
        };

        scheduledExecutorService.scheduleAtFixedRate(r, 15, 15, TimeUnit.SECONDS);

    }
}
