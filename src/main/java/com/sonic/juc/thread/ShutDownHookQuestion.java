package com.sonic.juc.thread;

/**
 * ShutDownHookQuestion
 *
 * @author Sonic
 * @since 2019/4/9
 */
public class ShutDownHookQuestion {

    //ctrl -c或者 kill -15 但如果用kill -9 那是没办法触发的
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Done");
        }));
    }

}
