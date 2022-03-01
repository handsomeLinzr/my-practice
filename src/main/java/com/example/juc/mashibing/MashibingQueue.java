package com.example.juc.mashibing;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * Description: 队列
 * put：
 *      offer 返回结果，不会阻塞
 *      add 异常，不会阻塞
 *      put 阻塞
 * get：
 *      peek 获取 空 不会阻塞
 *      poll 拿出 空 不会阻塞
 *      take 阻塞
 *      remove 异常
 * @author Linzherong
 * @date 2022/2/27 11:00 下午
 */
public class MashibingQueue {

    private static final MashibingQueue INSTANCE = new MashibingQueue();
    public static void main(String[] args) {
        INSTANCE.linkedTest();
    }

    /**
     * ArrayBlockingQueue
     */
    private void arrayTest() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        new Thread(()->{
            int i = 0;
            while (true) {
                try {
                    queue.put("===" + i++);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(queue.poll());
            }
        }).start();
    }

    /**
     * Linked 链表
     * Deque 双端队列
     * SynchronousQueue 长度为0
     * TransferQueue 传递
     */
    private void linkedTest() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        new Thread(()->{
            while (true) {
                String take = null;
                try {
                    TimeUnit.SECONDS.sleep(1);
                    take = transferQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("poll=========>" + take);
            }
        }).start();

        new Thread(()->{
            int i = 0;
            while (true) {
                try {
//                    TimeUnit.SECONDS.sleep(1);
                    transferQueue.transfer("存入===》" + i++);
                    System.out.println("=======>存入完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
