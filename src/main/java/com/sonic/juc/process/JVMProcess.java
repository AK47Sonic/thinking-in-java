package com.sonic.juc.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.time.Instant;

/**
 * JVMProcess
 *
 * @author Sonic
 * @since 2019/4/6
 */
public class JVMProcess {

    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String pid = runtimeMXBean.getName().substring(0, runtimeMXBean.getName().indexOf("@"));
        System.out.printf("pid: %s \n", pid);

        System.out.printf("Processors: %s\n ", Runtime.getRuntime().availableProcessors());

        Instant instant = Instant.ofEpochMilli(runtimeMXBean.getStartTime());
//        LocalDate.ofinstant(instant, ZoneId.systemDefault());
//        runtimeMXBean.getUptime();

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.printf("Thread count: %s\n ", threadMXBean.getThreadCount());

        System.exit(0);
    }

}
