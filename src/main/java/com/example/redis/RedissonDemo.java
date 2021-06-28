package com.example.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedissonDemo {

    public static void main(String[] args) {

        Set<HostAndPort> hostAndPorts = new HashSet<>(3);
        hostAndPorts.add(new HostAndPort("120.76.130.212", 7001));
        hostAndPorts.add(new HostAndPort("120.76.130.212", 7002));
        hostAndPorts.add(new HostAndPort("49.235.61.31", 7004));
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts, 6000);

        String name = jedisCluster.get("name");
        System.out.println(name);

        String hobby = jedisCluster.get("hobby");
        System.out.println(hobby);

    }

}
