package com.sonic.gof23.prototype;

import java.io.Serializable;

/**
 * Attachment
 *
 * @author Sonic
 * @since 2019/3/24
 */
public class Attachment implements Serializable, Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("download: " + name);
    }

    @Override
    protected Attachment clone() throws CloneNotSupportedException {
        return (Attachment) super.clone();
    }
}
