package com.example.juc;

import java.util.concurrent.CyclicBarrier;

public class CycliBarrierTest extends Thread{

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CycliBarrierTest());
        new Thread(new DataNanylic(cyclicBarrier, "path1")).start();
        new Thread(new DataNanylic(cyclicBarrier, "path2")).start();
        new Thread(new DataNanylic(cyclicBarrier, "path3")).start();
    }

    @Override
    public void run() {
        System.out.println("分析结束，整合数据成功");
    }
}
