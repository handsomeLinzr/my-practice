package com.example.pattern.singleton.hungry;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 5:13 下午
 * @since V1.0.0
 */
public class HungrySingleton {

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

}
