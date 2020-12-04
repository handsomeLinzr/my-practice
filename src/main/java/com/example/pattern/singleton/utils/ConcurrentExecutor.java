package com.example.pattern.singleton.utils;

import java.util.concurrent.*;

/**
 * Description: 多线程并发工具类
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 3:17 下午
 * @since V1.0.0
 */
public class ConcurrentExecutor {

    /**
     * @param runHandler 线程处理器
     * @param executorCount 发起的请求数
     * @param concurrentCount 并发执行线程数
     */
    public static void executor(final RunHandler runHandler, int executorCount, int concurrentCount) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(concurrentCount,
                executorCount,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4));
        final Semaphore semaphore = new Semaphore(concurrentCount);
        final CountDownLatch countDownLatch = new CountDownLatch(executorCount);
        for (int i = 0; i < executorCount; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    runHandler.handler();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
    }

    // 内部接口
    public interface RunHandler {
        void handler();
    }

}
