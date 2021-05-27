package com.example.thread;

import java.util.concurrent.ExecutorService;

public class ThreadPoolMonitorTest implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = ThreadPoolMonitor.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolMonitorTest());
        }
        executorService.shutdown();
    }


}
