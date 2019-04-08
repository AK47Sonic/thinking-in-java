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
        //IDEA(主进程) -> 启动 ChildProcessDemo -> 打开网页
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        if (operatingSystemMXBean.getName().startsWith("Windows")) {
            Process process = Runtime.getRuntime().exec("cmd -loglevel quiet /k start http://www.baidu.com");
//          阻塞有问题？
//            try {
//                process.waitFor();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }
}
