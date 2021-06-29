package com.example.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonDemo {

    public static void main(String[] args) {
        Config config = new Config();
//        config.useClusterServers().addNodeAddress(
//                "redis://120.76.130.212:7001",
//                "redis://120.76.130.212:7002",
//                "redis://120.76.130.212:7003",
//                "redis://120.76.130.212:7004",
//                "redis://120.76.130.212:7005",
//                "redis://120.76.130.212:7006");
        config.useSingleServer().setAddress("redis://120.76.130.212:6379");
        RedissonClient redissonClient = Redisson.create(config);
        String name = redissonClient.getBucket("name").getName();
        System.out.println(name);
    }

}
