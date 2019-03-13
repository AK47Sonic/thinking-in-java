package com.sonic.gof23.factorymethod;

/**
 * DatabaseLoggerFactory
 *
 * @author Sonic
 * @since 2019/3/13
 */
public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
