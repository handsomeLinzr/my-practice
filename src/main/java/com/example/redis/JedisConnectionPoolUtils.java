package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis 连接池
 */
public class JedisConnectionPoolUtils {

    public static JedisPool jedisPool;
    static {
        // 初始化连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPool = new JedisPool(jedisPoolConfig, "120.76.130.212", 6379, 3000, "rong951003");
    }

    /**
     * 获得连接
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
