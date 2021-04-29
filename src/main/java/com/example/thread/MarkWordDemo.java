package com.example.thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class MarkWordDemo {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(()->{
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
        Thread.sleep(2);
        new Thread(()->{
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }

}
