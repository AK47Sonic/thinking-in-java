package com.sonic.gof23.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Folder
 *
 * @author Sonic
 * @since 2019/4/16
 */
public class Folder extends AbstractFile {

    private String name;
    List<AbstractFile> fileList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {

        return (AbstractFile) fileList.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("Folder killVirus");
        for (AbstractFile abstractFile : fileList) {
            abstractFile.killVirus();
        }

    }
}
