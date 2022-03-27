package com.example.mashibing.juc;

import com.lmax.disruptor.EventFactory;

/**
 * Description: 消息工厂
 *
 * @author Linzherong
 * @date 2022/3/8 2:12 下午
 */
public class MashibingDisruptorMessageFactory implements EventFactory<MashibingDisruptorMessage> {
    @Override
    public MashibingDisruptorMessage newInstance() {
        return new MashibingDisruptorMessage();
    }
}
