package com.sonic.gof23.composite;

/**
 * ImageFile
 *
 * @author Sonic
 * @since 2019/4/16
 */
public class ImageFile extends AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("Not support");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("Not support");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("Not support");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("ImageFile " + name + " killVirus");
    }
}
