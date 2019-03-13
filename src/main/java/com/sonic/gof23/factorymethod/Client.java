package com.sonic.gof23.factorymethod;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/13
 */
public class Client {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new DatabaseLoggerFactory();
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}
