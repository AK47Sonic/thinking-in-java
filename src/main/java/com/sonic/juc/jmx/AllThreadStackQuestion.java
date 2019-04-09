package com.sonic.juc.jmx;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * AllThreadStackQuestion
 *
 * @author Sonic
 * @since 2019/4/9
 */
public class AllThreadStackQuestion {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        for (long allThreadId : allThreadIds) {
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(allThreadId);
            System.out.println(threadInfo);
        }
    }
}
