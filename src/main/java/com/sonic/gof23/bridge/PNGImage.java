package com.sonic.gof23.bridge;

/**
 * PNGImage
 *
 * @author Sonic
 * @since 2019/3/31
 */
public class PNGImage extends Image{

    public PNGImage(OSImp osImp) {
        this.osImp = osImp;
    }

    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        osImp.doPaint(matrix);
        System.out.println("Convert PNG");
    }
}
