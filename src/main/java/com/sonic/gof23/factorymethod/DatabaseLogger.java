package com.sonic.gof23.factorymethod;

/**
 * DatabaseLogger
 *
 * @author Sonic
 * @since 2019/3/13
 */
public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("Database log");
    }
}
