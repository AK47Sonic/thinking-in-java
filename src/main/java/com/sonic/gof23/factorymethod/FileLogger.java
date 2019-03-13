package com.sonic.gof23.factorymethod;

/**
 * TODO
 *
 * @author Sonic
 * @since 2019/3/13
 */
public class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("File logger");
    }
}
