package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DistributeLock {

    /**
     * 获取锁
     * @param lockName 锁名称
     * @param acquireTimeout 获取超时
     * @param lockTimeout 锁超时
     * @return
     */
    public String acquireLock(String lockName, long acquireTimeout, long lockTimeout) {
        Jedis jedis = null;
        try {
            jedis = JedisConnectionPoolUtils.getJedis();
            String lock = "lock:" + lockName;
            int timeout = (int) lockTimeout/1000;
            long acquireTime = System.currentTimeMillis() + acquireTimeout;
            String identifier = UUID.randomUUID().toString();

            while (System.currentTimeMillis() < acquireTime) {
                if (jedis.setnx(lock, identifier) == 1) {
                    // 获得锁
                    jedis.expire(lock, timeout);
                    return identifier;
                }

                // 判断锁是否有超时设置
                if (jedis.ttl(lock) == -1) {
                    jedis.expire(lock, timeout);
                }

                // 睡100ms再次尝试获取锁
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return null;
    }


    /**
     * 释放锁
     * @param lockName 锁名称
     * @param identifier 锁值
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        Jedis jedis = null;
        boolean isRelease = false;
        try {
            jedis = JedisConnectionPoolUtils.getJedis();
            String lock = "lock:" + lockName;
            // 循环解锁，避免解锁意外失败
            while (true) {
                jedis.watch(lock);
                if (identifier.equals(jedis.get(lock))) {
                    Transaction transaction = jedis.multi();
                    transaction.del(lock);
                    if (transaction.exec().isEmpty()) {
                        // 解锁失败，重试
                        continue;
                    }
                    jedis.unwatch();
                    isRelease = true;
                    break;
                } else {
                    // 已经不是自己的锁
                    throw new RuntimeException("unable to release other lock!");
                }
            }
        } finally {
            jedis.close();
        }
        return isRelease;
    }

}
