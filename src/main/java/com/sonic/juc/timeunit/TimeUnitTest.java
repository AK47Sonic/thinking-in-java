package com.sonic.juc.timeunit;

import java.util.concurrent.TimeUnit;

/**
 * TimeUnitTest
 *
 * @author Administrator
 * @since 2019/2/5
 */
public class TimeUnitTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(TimeUnit.MINUTES.toMillis(5));

//        TimeUnit.MINUTES.sleep(5);

        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(TimeUnit.SECONDS.convert(1,TimeUnit.MINUTES ));

    }
}
