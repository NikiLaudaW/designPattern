package com.niki.designPattern.singleton;

/**
 * 懒汉式
 * 按需加载，不能解决线程安全问题
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton05 {
    private static Singleton05 INSTANCE;

    //控制实例化
    private Singleton05(){

    }

    //减小锁粒度
    public static Singleton05 getInstance() {
        if(INSTANCE == null) {//并发情况会创建多个
            //加剧冲突，休息1ms,有更多的线程会判断为空
            synchronized (Singleton05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Singleton05.getInstance())
            ).start();
        }
    }
}
