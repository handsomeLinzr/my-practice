package com.example.pattern.observer;

import com.example.pattern.observer.guava.GuavaEvent;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;

/**
 * @author LZR
 * @date 2020/12/28-23:44
 */
public class GuavaTest {

    @Test
    public void test() {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        System.out.println("开始执行");
        eventBus.post("你好");
    }

}
