package com.example.thread;

public class Test {
    private static int i = 0;  // 共享变量
    public synchronized static void inc() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;   // 在指令中是先get，再update，再set，中间可能刚好cpu给别人了
    }
    public static void main(String[] args) {
        for (int j = 0; j < 500; j++) {
            new Thread(()->Test.inc()).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);  // 结果小于等于500
    }

    public synchronized void max() {
        // todo
    }

    public void max1() {
        //todo
        synchronized (this) {
            // todo
        }
    }

    public synchronized static void doSome() {
        // todo
    }
    public static void doSome1() {
        synchronized (Test.class) {
            // todo
        }
    }

}
