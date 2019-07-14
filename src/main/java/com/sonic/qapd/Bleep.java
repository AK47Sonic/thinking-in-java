package com.sonic.qapd;

/**
 * Bleep
 *
 *  匿名类内部有这个方法，则调用内部类中的方法，如果匿名类中没有找到对应方法，则调用当前类所在的方法。
 *  如果内部类有，当前类也有，但想调用当前类的方法，则最好声明类名.this.XX，强制指定
 *
 * @author Sonic
 * @since 2019/7/14
 */
public class Bleep {
    String name = "Bleep";

    void setName(String name) {
        this.name = name;
    }

    void backgroundSetName() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                setName("Blat"); // 在匿名内部类中this 是Thread对象
//                Bleep.this.setName("Blat");
            }
        };
//        Runnable runnable = new Runnable(){
//            @Override
//            public void run() {
//                setName("Blat"); // Bleep.this.setName("Blat"); 等价
//            }
//        };
//
//        Thread t = new Thread(runnable);

        t.start();
        t.join();
        System.out.println(name);
    }

    public static void main(String[] args) throws InterruptedException {
        new Bleep().backgroundSetName();
    }
}