package com.sonic.gof23.factorymethod;

/**
 * FileLoggerFactory
 *
 * @author Sonic
 * @since 2019/3/13
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
