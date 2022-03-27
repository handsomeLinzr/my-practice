package com.example.mashibing.juc;

import com.lmax.disruptor.EventHandler;

/**
 * Description: Disruptor 消息处理
 *
 * @author Linzherong
 * @date 2022/3/8 2:07 下午
 */
public class MashibingDisruptorMessageHandler implements EventHandler<MashibingDisruptorMessage> {

    @Override
    public void onEvent(MashibingDisruptorMessage event, long sequence, boolean endOfBatch) throws Exception {

        System.out.printf("%s==========>%s===========>%s=======>%s\n",
                Thread.currentThread().getName(),
                event, sequence, endOfBatch);
    }
}
