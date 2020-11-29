package com.example.pattern.singleton.hungry;

/**
 * @author LZR
 * @date 2020/11/29-17:00
 */
public class HungryConstructorSingleton {

    private HungryConstructorSingleton() {
        StackTraceElement stackTraceElement = (Thread.currentThread().getStackTrace())[2];
        if (!HungryConstructorSingleton.class.getName().equals(stackTraceElement.getClassName()) ||
                !"<clinit>".equals(stackTraceElement.getMethodName())) {
            throw new RuntimeException("不允许");
        }
    }

    private static final HungryConstructorSingleton HUNGRY_CONSTRUCTOR_SINGLETON = new HungryConstructorSingleton();

    public static HungryConstructorSingleton getInstance() {
        return HUNGRY_CONSTRUCTOR_SINGLETON;
    }

}
