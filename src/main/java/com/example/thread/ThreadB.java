package com.example.thread;

public class ThreadB implements Runnable{

    private final Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("ThreadB start");
            lock.notify();
            System.out.println("ThreadB end");
        }
    }
}
