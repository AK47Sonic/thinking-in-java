package com.sonic.spi;

import java.util.ServiceLoader;

/**
 * SPIMain
 *
 * @author Sonic
 * @since 2019/5/25
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}
