package com.example.thread;

public class SynchronizedDemo implements Runnable{
    int x = 100;

    public synchronized void m1() {
        x = 1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x=" + x);
    }

    public synchronized void m2() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = 2000;
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(()->sd.m1()).start();  // t1
        new Thread(()->sd.m2()).start();  // t2
        sd.m2();
        System.out.println("Main x=" + sd.x);

        // x=1000
        // Main x=2000
        // t1先先获得锁，执行t1操作，然后 t2获得锁，x=2000，最后主线程再进入m2，最后输出

    }
    @Override
    public void run() {
        m1();
    }
}
