package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MulIncr {


    static JedisPool jedisPool = JedisConnectionPoolUtils.jedisPool;

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(20, 20, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(30), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                int i = 1;
                return new Thread(r, i++ + "");
            }
        });

        for (int i = 0; i < 40; i++) {
            pool.execute(()->{
                Jedis jedis = jedisPool.getResource();
                Long num = jedis.incr("string");
                System.out.println(num);
                jedis.close();
            });
        }
        pool.shutdown();
    }

}
