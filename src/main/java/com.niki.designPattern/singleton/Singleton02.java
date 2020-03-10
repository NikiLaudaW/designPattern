package com.niki.designPattern.singleton;

/**
 * 饿汉式
 * 类加载到内存后，由JVM保证线程安全，类装载时就实例化一次
 * 简单实用
 * 不管是否使用，都会实例化
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton02 {
    private static final Singleton02 INSTANCE;
    static {
        INSTANCE = new Singleton02();
    }

    //控制实例化
    private Singleton02(){

    }

    public static Singleton02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton02 singleton01 = Singleton02.getInstance();
        Singleton02 singleton02 = Singleton02.getInstance();

        System.out.println("是否是同一个对象:" + (singleton01 == singleton02));

    }
}
