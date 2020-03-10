package com.niki.designPattern.singleton;

/**
 * 饿汉式
 * 类加载到内存后，由JVM保证线程安全，类装载时就实例化一次
 * 简单实用
 * 不管是否使用，都会实例化
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    //控制实例化
    private Singleton01(){

    }

    public String work(String name) {
        return name + " is working";
    }

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton01 singleton02 = Singleton01.getInstance();

        System.out.println("是否是同一个对象:" + (singleton01 == singleton02));

    }
}
