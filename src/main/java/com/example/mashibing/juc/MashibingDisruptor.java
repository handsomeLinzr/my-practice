package com.example.mashibing.juc;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description: Disruptor 练习
 *
 * @author Linzherong
 * @date 2022/3/6 11:19 下午
 */
public class MashibingDisruptor {
    private static final int MAX_MESSAGE_SIZE = 1024;
    private static final int BLOCKING_MAX_MESSAGE_SIZE = 8;
    private static final MashibingDisruptor INSTANCE = new MashibingDisruptor();
    public static void main(String[] args) {
        INSTANCE.disruptorPractice5();
    }

    /**
     * 等待策略练习
     */
    public void disruptorPractice5() {
        Disruptor<MashibingDisruptorMessage> disruptor = new Disruptor<>(
                new MashibingDisruptorMessageFactory(), BLOCKING_MAX_MESSAGE_SIZE, DaemonThreadFactory.INSTANCE,
                ProducerType.MULTI, new BusySpinWaitStrategy());
        disruptor.handleEventsWith(((event, sequence, endOfBatch) -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("收到消息：%s=======>%s========>%s==========>%s（first）\n",
                    Thread.currentThread().getName(),
                    event, sequence, endOfBatch);
        }));
        disruptor.start();
        RingBuffer<MashibingDisruptorMessage> ringBuffer = disruptor.getRingBuffer();
        long i = 0;
        while (true) {
            ringBuffer.publishEvent(((event, sequence, arg0) -> {
                event.setL(arg0);
                System.out.println("发送消息：========》" + arg0);
            }), ++i);
        }
    }

    /**
     * 异常处理练习
     */
    public void disruptorPractice4() {
        // 消息中间件
        Disruptor<MashibingDisruptorMessage> disruptor = new Disruptor<>(
                new MashibingDisruptorMessageFactory(), MAX_MESSAGE_SIZE,
                Executors.defaultThreadFactory(), ProducerType.MULTI, new BlockingWaitStrategy());

        EventHandler<MashibingDisruptorMessage> h1 = (event, sequence, endOfBatch)->{
            if (sequence%7 == 0) {
                throw new RuntimeException(Thread.currentThread().getName() + "=====>到环尾了~~" +  sequence);
            }
            System.out.printf("%s=======>%s========>%s==========>%s（first）\n",
                    Thread.currentThread().getName(),
                    event, sequence, endOfBatch);
        };
        EventHandler<MashibingDisruptorMessage> h2 = (event, sequence, endOfBatch)->{
            if (sequence == 7L) {
                throw new RuntimeException(Thread.currentThread().getName() + "=====>到环尾了~~" +  sequence);
            }
            System.out.printf("%s=======>%s========>%s==========>%s（second）\n",
                    Thread.currentThread().getName(),
                    event, sequence, endOfBatch);
        };
        disruptor.handleEventsWith(h1,h2);
        disruptor.handleExceptionsFor(h1).with(new ExceptionHandler<MashibingDisruptorMessage>() {
            // 处理失败
            @Override
            public void handleEventException(Throwable ex, long sequence, MashibingDisruptorMessage event) {
                ex.printStackTrace();
            }
            // 启动失败
            @Override
            public void handleOnStartException(Throwable ex) {
                ex.printStackTrace();
            }
            // 结束失败
            @Override
            public void handleOnShutdownException(Throwable ex) {
                ex.printStackTrace();
            }
        });
        disruptor.start();

        RingBuffer<MashibingDisruptorMessage> ringBuffer = disruptor.getRingBuffer();
        for (int i = 0; i < 1024; i++) {
            ringBuffer.publishEvent(((event, sequence, arg0) -> event.setL(arg0)), i);
        }
    }

    /**
     * 练习3 生产类型（两种）
     */
    public void disruptorPractice3() {
        ExecutorService service = Executors.newCachedThreadPool();
        // 创建disruptor
        MashibingDisruptorMessageFactory factory = new MashibingDisruptorMessageFactory();
        // 当使用单线程模式，则多线程生产者生产数据会造成最后消费不到5000个消息的情况
        Disruptor<MashibingDisruptorMessage> disruptor = new Disruptor<>(
                factory, MAX_MESSAGE_SIZE,
                Executors.defaultThreadFactory(), ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWith(new EventHandler<MashibingDisruptorMessage>() {
            private int i;
            @Override
            public void onEvent(MashibingDisruptorMessage event, long sequence, boolean endOfBatch) throws Exception {
                System.out.printf("%s=======>%s===========>%s=========>%s=========>%s\n",
                        Thread.currentThread().getName(), event, sequence, endOfBatch, ++i);
            }
        });
        disruptor.start();
        RingBuffer<MashibingDisruptorMessage> ringBuffer = disruptor.getRingBuffer();

        for (int i = 0; i < 50; i++) {
            service.execute(()->{
                for (int j = 0; j < 100; j++) {
                    ringBuffer.publishEvents(new EventTranslatorVararg<MashibingDisruptorMessage>() {
                        @Override
                        public void translateTo(MashibingDisruptorMessage event, long sequence, Object... args) {
                            long l = 0;
                            for (Object arg : args) {
                                l += (Long) arg;
                            }
                            event.setL(l);
                        }
                    }, new Long[]{123L,456L});
                }
            });
        }

//        disruptor.shutdown();
//        service.shutdown();

    }

    /**
     * Lamda表达式写法
     */
    public void disruptorPractice2() {
        // 消息工厂   缓冲环大小   消费者线程工厂(1个消费者对应1个线程)   生产者线程模式   等待策略
        Disruptor<MashibingDisruptorMessage> disruptor = new Disruptor<>(
                new MashibingDisruptorMessageFactory(), MAX_MESSAGE_SIZE, DaemonThreadFactory.INSTANCE,
                ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWith((even, sequence, endOfBatch)->{
            System.out.printf("%s======>%s=======>%s==========>%s\n", Thread.currentThread().getName(), even, sequence, endOfBatch);
        }, (even, sequence, endOfBatch) -> {
            System.out.printf("%s======>%s=======>%s==========>%s\n", Thread.currentThread().getName(), even, sequence, endOfBatch);
        });
        RingBuffer<MashibingDisruptorMessage> ringBuffer = disruptor.getRingBuffer();
        disruptor.start();

        ringBuffer.publishEvent((event, sequence, arg0, arg1, arg2)->{
            event.setL(arg0 + arg1 + arg2);
        }, 1000L, 2000L, 3000L);
        disruptor.shutdown();
    }

    /**
     * 练习1
     */
    public void disruptorPractice1() {
        // 创建 disruptor
        Disruptor<MashibingDisruptorMessage> disruptor = new Disruptor<>(
                new MashibingDisruptorMessageFactory(), MAX_MESSAGE_SIZE, Executors.defaultThreadFactory(),
                ProducerType.MULTI, new BlockingWaitStrategy());

        MashibingDisruptorMessageHandler handler1 = new MashibingDisruptorMessageHandler();
        MashibingDisruptorMessageHandler handler2 = new MashibingDisruptorMessageHandler();
        // 关联消息处理器
        disruptor.handleEventsWith(handler1, handler2);
        // 启动
        disruptor.start();

        // 获取缓存环
        RingBuffer<MashibingDisruptorMessage> ringBuffer = disruptor.getRingBuffer();
        // 获得下一个可分配的位置
        long sequence = ringBuffer.next();
        // 获得可分配位置上的消息体
        MashibingDisruptorMessage message = ringBuffer.get(sequence);
        // 填充消息体
        message.setL(1000L);
        // 发布
        ringBuffer.publish(sequence);
        // 关闭
        disruptor.shutdown();
    }

}
