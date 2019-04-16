package com.sonic.gof23.composite;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/4/16
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3, folder4;
        folder1 = new Folder("1 folder");
        folder2 = new Folder("2 folder");
        folder3 = new Folder("3 folder");
        folder4 = new Folder("4 folder");

        file1 = new ImageFile("image1");
        file2 = new ImageFile("image2");
        file3 = new TextFile("textFile3");
        file4 = new TextFile("textFile4");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file4);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(file3);
        folder4.add(folder4);

        folder1.killVirus();

    }
}
