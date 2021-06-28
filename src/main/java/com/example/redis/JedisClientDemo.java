package com.example.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Linzr
 * @version V2.0.0
 * @date 2021/6/28 1:47 下午
 * @since V2.0.0
 */
public class JedisClientDemo {

    public static void main(String[] args) {
        // 从sentinel节点触发
//        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool();
        // 从cluster触发
        Set<HostAndPort> hostAndPortSet = new HashSet<>(3);
        hostAndPortSet.add(new HostAndPort("120.76.130.212", 7001));
        hostAndPortSet.add(new HostAndPort("120.76.130.212", 7002));
        hostAndPortSet.add(new HostAndPort("49.235.61.31", 7004));
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, 6000);
        jedisCluster.set("name", "azhe");
        jedisCluster.set("age", "28");
        jedisCluster.close();
    }

}
