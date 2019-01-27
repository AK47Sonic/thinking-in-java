package com.sonic.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * ParkTest
 * 和wait的不同
 * park、unpark方法和wait、notify()方法有一些相似的地方。都是休眠，然后唤醒。但是wait、notify方法有一个不好的地方，就是我们在编程的时候必须能保证wait方法比notify方法先执行。如果notify方法比wait方法晚执行的话，就会导致因wait方法进入休眠的线程接收不到唤醒通知的问题。而park、unpark则不会有这个问题，我们可以先调用unpark方法释放一个许可证，这样后面线程调用park方法时，发现已经许可证了，就可以直接获取许可证而不用进入休眠状态了。
 * 另外，和wait方法不同，执行park进入休眠后并不会释放持有的锁。
 *
 * @author Administrator
 * @since 2019/1/27
 */
public class ParkTest {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Begin park!");
            LockSupport.park();
            System.out.println("End par!");
        });
        threadOne.start();

        Thread.sleep(3000);
        LockSupport.unpark(threadOne);

        System.out.println("Main is over");
    }

}
