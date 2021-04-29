package com.example.thread;

public class ThreadA implements Runnable{
    private final Object lock;
    public ThreadA(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("ThreadA start");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA end");
        }
    }
}
