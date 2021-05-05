package com.example.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DataNanylic implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String path;

    public DataNanylic(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("分析数据：" + path);
        try {
            cyclicBarrier.await();  // 开始等待其他 cyclicBarrier 对象的线程数到齐再执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
