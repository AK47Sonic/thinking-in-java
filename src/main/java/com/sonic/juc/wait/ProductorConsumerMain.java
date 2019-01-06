package com.sonic.juc.wait;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * ProductorConsumerMain
 *
 * @auther Sonic
 * @since 2019/1/6
 */
public class ProductorConsumerMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedTransferQueue<>();
        new Thread(new Productor(queue)).start();
        new Thread(new Productor(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
