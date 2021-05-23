package com.example.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
        try {
            Thread.sleep(1);  // 释放CPU资源，其他线程获得
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>(13);
    }
}
