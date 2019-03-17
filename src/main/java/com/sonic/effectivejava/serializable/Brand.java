package com.sonic.effectivejava.serializable;

import java.io.*;

/**
 * Brand
 *
 * @author Sonic
 * @since 2019/3/17
 */
class Brand implements Serializable {
    private int val;
    private Brand(int val) {
        this.val = val;
    }

    // 两个枚举值
    public static final Brand NIKE = new Brand(0);
    public static final Brand ADDIDAS = new Brand(1);

    /**
     * https://blog.csdn.net/lirx_tech/article/details/51303966
     *
     * i. 调用该方法之前会先调用readObject反序列化得到对象；
     * ii. 接着，如果该方法存在则会自动调用该方法；
     * iii. 在该方法中可以正常通过this访问到刚才反序列化得到的对象的内容；
     * iv. 然后可以根据这些内容进行一定处理返回一个对象；
     * vi. 该对象将作为ObjectInputStream的readObject的返回值（即该对象将作为对象输入流的最终输入）；
     *
     */
    private Object readResolve() throws ObjectStreamException {
        if (val == 0) {
            return NIKE;
        }
        if (val == 1) {
            return ADDIDAS;
        }
        return null;
    }

}