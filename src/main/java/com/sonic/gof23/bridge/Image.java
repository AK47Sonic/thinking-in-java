package com.sonic.gof23.bridge;

/**
 * Image
 *
 * @author Sonic
 * @since 2019/3/31
 */
public abstract class Image {
    protected OSImp osImp = null;

    public abstract void parseFile(String fileName);
}
