package com.niki.designPattern.singleton;

/**
 * 双重检查
 * 按需加载，解决线程安全问题
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton06 {
    private static volatile Singleton06 INSTANCE;//保证可见性

    //控制实例化
    private Singleton06(){

    }

    //减小锁粒度
    public static Singleton06 getInstance() {
        if(INSTANCE == null) {//并发情况会创建多个
            //加剧冲突，休息1ms,有更多的线程会判断为空
            synchronized (Singleton06.class) {
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Singleton06.getInstance())
            ).start();
        }
    }
}
