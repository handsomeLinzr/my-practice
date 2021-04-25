package com.example.pattern.process;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 保存处理
 */
public class SaveProcessor extends Thread implements IRequestProcessor{

    private IRequestProcessor nextProcessor;
    private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    private volatile boolean flag = true;

    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {
        // 存放请求到队列
        queue.add(request);
    }

    public void shutdown() {
        this.flag = false;
    }


    @Override
    public void run() {
        // 循环从队列获取
        while (flag) {
            try {
                Request take = queue.take();
                if (null != nextProcessor) {
                    System.out.println("保存处理");
                    nextProcessor.process(take);
                } else {
                    System.out.println(take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
