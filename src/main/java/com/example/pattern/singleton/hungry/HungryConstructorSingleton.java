package com.example.pattern.singleton.hungry;

/**
 * @author LZR
 * @date 2020/11/29-17:00
 */
public class HungryConstructorSingleton {

    private HungryConstructorSingleton() {
        if (HUNGRY_CONSTRUCTOR_SINGLETON != null) {
            throw new RuntimeException("不允许重复创建");
        }
    }

    private static final HungryConstructorSingleton HUNGRY_CONSTRUCTOR_SINGLETON = new HungryConstructorSingleton();

    public static HungryConstructorSingleton getInstance() {
        return HUNGRY_CONSTRUCTOR_SINGLETON;
    }

}
