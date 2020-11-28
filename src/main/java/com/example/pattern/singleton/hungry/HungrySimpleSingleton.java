package com.example.pattern.singleton.hungry;

/**
 * @author LZR
 * @date 2020/11/28-17:09
 */
public class HungrySimpleSingleton {
    private HungrySimpleSingleton() {}
    private static final HungrySimpleSingleton HUNGRY_SIMPLE_SINGLETON = new HungrySimpleSingleton();
    public static HungrySimpleSingleton getInstance() {
        return HUNGRY_SIMPLE_SINGLETON;
    }
}
