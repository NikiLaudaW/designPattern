package com.niki.designPattern.singleton;

/**
 * 懒汉式
 * 按需加载，有线程安全问题
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

    //控制实例化
    private Singleton03(){

    }

    public static Singleton03 getInstance() {
        if(INSTANCE == null) {//并发情况会创建多个
            //加剧冲突，休息1ms,有更多的线程会判断为空
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    //第一个和后面的对象不一样
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Singleton03.getInstance())
            ).start();
        }
    }
}
