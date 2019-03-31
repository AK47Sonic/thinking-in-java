package com.sonic.gof23.bridge;

/**
 * JPGImage
 *
 * @author Sonic
 * @since 2019/3/31
 */
public class JPGImage extends Image{

    public JPGImage(OSImp osImp) {
        this.osImp = osImp;
    }

    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        osImp.doPaint(matrix);
        System.out.println("Convert JPG");
    }
}
