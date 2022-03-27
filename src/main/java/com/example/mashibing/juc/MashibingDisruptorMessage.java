package com.example.mashibing.juc;

/**
 * Description: 消息体
 *
 * @author Linzherong
 * @date 2022/3/8 11:38 上午
 */
public class MashibingDisruptorMessage {

    private long l;

    public void setL(long l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "MashibingDisruptorMessage{" +
                "l=" + l +
                '}';
    }
}
