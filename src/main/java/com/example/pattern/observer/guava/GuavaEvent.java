package com.example.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author LZR
 * @date 2020/12/28-23:42
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        System.out.println("执行 " + str);
    }

}
