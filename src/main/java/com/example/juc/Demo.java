package com.example.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2021/4/28 5:49 下午
 * @since V1.0.0
 */
public class Demo {
    private static int i = 0;  // 共享变量
    public static void inc() {
        Thread.yield();  // 让出cpu资源
        i ++;
    }
    public static void main(String[] args) throws InterruptedException {

//        for (int j = 0; j < 400; j++) {
//            new Thread(() -> Demo.inc()).start();
//        }
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(i); // 结果为 《=100

//        new Thread(()->{
//            while (i == 0) {
//                System.out.println(1);
//            }
//        }).start();
//        TimeUnit.SECONDS.sleep(1);
//        i ++;
//        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>(13);

        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String s1 = "s1";
            try {
                s1 = exchanger.exchange(s1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"=====>" + s1);
        }, "s1").start();
        new Thread(() -> {
            String s2 = "S2";
            try {
                s2 = exchanger.exchange(s2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"=====>" + s2);
        }, "s2").start();

    }
}
