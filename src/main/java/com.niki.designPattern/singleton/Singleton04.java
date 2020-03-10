package com.niki.designPattern.singleton;

/**
 * 懒汉式
 * 按需加载，解决线程安全问题
 * @author niki-lauda
 * @create 2020-03-10 21:45
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;

    //控制实例化
    private Singleton04(){

    }

    //锁定Singleton04.class，效率下降，每次都会加锁
    public static synchronized Singleton04 getInstance() {
        if(INSTANCE == null) {//并发情况会创建多个
            //加剧冲突，休息1ms,有更多的线程会判断为空
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Singleton04.getInstance())
            ).start();
        }
    }
}
