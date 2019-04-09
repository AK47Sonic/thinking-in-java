package com.sonic.juc.jmx;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;

/**
 * AllThreadInfoQuestion
 *
 * @author Sonic
 * @since 2019/4/9
 */
public class AllThreadInfoQuestion {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();

        for (long allThreadId : allThreadIds) {
//            ThreadInfo threadInfo = threadMXBean.getThreadInfo(allThreadId);
//            System.out.println(threadInfo);
            long threadAllocatedBytes = threadMXBean.getThreadAllocatedBytes(allThreadId);
            System.out.println(allThreadId + " KB: " + threadAllocatedBytes/1024);
        }
    }
}
