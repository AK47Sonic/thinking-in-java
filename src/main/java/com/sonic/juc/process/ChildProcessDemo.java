package com.sonic.juc.process;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * ChildProcessDemo
 *
 * @author Sonic
 * @since 2019/4/6
 */
public class ChildProcessDemo {
    public static void main(String[] args) throws IOException {
        //IDEA(主进程) -> 启动 ChildProcessDemo -> Windows 计算器 (calc)
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        if (operatingSystemMXBean.getName().startsWith("Windows")) {
            Runtime.getRuntime().exec("calc");
        }
    }
}
