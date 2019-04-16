package com.sonic.gof23.composite;

/**
 * AbstractFile
 *
 * @author Sonic
 * @since 2019/4/15
 */
public abstract class AbstractFile {

    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();

}
