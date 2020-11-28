package com.example.pattern.singleton.hungry;

/**
 * @author LZR
 * @date 2020/11/28-22:38
 */
public class HungryStaticSingleton {
    private HungryStaticSingleton() {}
    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;
    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }
    public static HungryStaticSingleton getInstance() {
        return HUNGRY_STATIC_SINGLETON;
    }
}
