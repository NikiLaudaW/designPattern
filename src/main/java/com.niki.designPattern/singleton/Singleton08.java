package com.niki.designPattern.singleton;

/**
 * 枚举单利
 * 不仅解决线程同步，还可以防止反序列化
 * 枚举类没有构造方法
 * 可以使用javac 后 javap校验
 * @author niki-lauda
 * @create 2020-03-10 22:18
 */
public enum Singleton08 {
    INSTANCE;

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
