package com.sonic.juc.locksupport;

import java.lang.management.ManagementFactory;
import java.util.concurrent.locks.LockSupport;

/**
 * ParkBlockerTest
 * "main" #1 prio=5 os_prio=0 tid=0x0000000005362800 nid=0x4bd0 waiting on condition [0x00000000050be000]
 *    java.lang.Thread.State: WAITING (parking)
 *         at sun.misc.Unsafe.park(Native Method)
 *         at java.util.concurrent.locks.LockSupport.park(LockSupport.java:304)
 *         at com.sonic.juc.locksupport.ParkBlockerTest.testPark(ParkBlockerTest.java:16)
 *         at com.sonic.juc.locksupport.ParkBlockerTest.main(ParkBlockerTest.java:21)
 *
 * "main" #1 prio=5 os_prio=0 tid=0x0000000004d72800 nid=0x3864 waiting on condition [0x000000000476f000]
 *    java.lang.Thread.State: WAITING (parking)
 *         at sun.misc.Unsafe.park(Native Method)
 *         - parking to wait for  <0x000000076af2f068> (a com.sonic.juc.locksupport.ParkBlockerTest)
 *         at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
 *         at com.sonic.juc.locksupport.ParkBlockerTest.testPark(ParkBlockerTest.java:24)
 *         at com.sonic.juc.locksupport.ParkBlockerTest.main(ParkBlockerTest.java:29)
 *
 * @author Administrator
 * @since 2019/1/27
 */
public class ParkBlockerTest {

    public void testPark(){
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
//        LockSupport.park();
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        ParkBlockerTest testPark = new ParkBlockerTest();
        testPark.testPark();
    }

}
