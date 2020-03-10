package com.niki.designPattern.singleton;

/**
 * 静态内部类
 * JVM保证单利
 * 加载外部类时不会加载内部类，可以实现懒加载
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton07 {

    //控制实例化
    private Singleton07(){

    }

    private static class Singleton07Holder {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    //减小锁粒度
    public static Singleton07 getInstance() {
        return Singleton07Holder.INSTANCE;
    }

    public String work(String name) {
        return name + " is working";
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->
//                    System.out.println(Singleton07.getInstance())
//            ).start();
//        }
//    }
}
