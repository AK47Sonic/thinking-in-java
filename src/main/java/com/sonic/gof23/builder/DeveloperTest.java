package com.sonic.gof23.builder;

/**
 * DeveloperTest
 *
 * @author Sonic
 * @since 2019/2/11
 */
public class DeveloperTest {

    public static void main(String[] args) {
        Developer sky = new Developer.Builder().setAge(1).setId(1).setName("Sky").build();
        System.out.println("Sky: " + sky);
    }
}
