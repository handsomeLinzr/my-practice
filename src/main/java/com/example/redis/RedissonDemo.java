package com.example.redis;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedissonDemo {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
//        config.useClusterServers().addNodeAddress(
//                "redis://120.76.130.212:7001",
//                "redis://120.76.130.212:7002",
//                "redis://120.76.130.212:7003",
//                "redis://120.76.130.212:7004",
//                "redis://120.76.130.212:7005",
//                "redis://120.76.130.212:7006");

        // 普通用法
        config.useSingleServer().setAddress("redis://120.76.130.212:6379").setPassword("rong951003").setConnectionMinimumIdleSize(10);
        RedissonClient redissonClient = Redisson.create(config);
//        String name = redissonClient.getBucket("name").getName();
//        RQueue<Object> name2 = redissonClient.getQueue("name");
//        RList<Object> name1 = redissonClient.getList("name");
//        RSet<Object> name3 = redissonClient.getSet("name");
//        RSortedSet<Object> name4 = redissonClient.getSortedSet("name");
//        RMap<Object, Object> name5 = redissonClient.getMap("name");

        // 分布式锁
        RLock rLock = redissonClient.getLock("descOrder");
        boolean status = rLock.tryLock(100, 100, TimeUnit.SECONDS);
        if (status) {
            System.out.println("获得了分布式锁");
            rLock.unlock();
        }

    }

}
