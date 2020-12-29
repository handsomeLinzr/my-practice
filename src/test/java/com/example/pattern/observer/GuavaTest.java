package com.example.pattern.observer;

import com.example.pattern.observer.guava.FriedListener;
import com.example.pattern.observer.guava.GuavaEvent;
import com.example.pattern.observer.guava.MomentsBus;
import com.example.pattern.observer.moments.Content;
import com.example.pattern.observer.moments.Friend;
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

    @Test
    public void test1() {
        Content content = new Content("小李", "这个是好标题", "这也是个好内容!");
        FriedListener friend = new FriedListener("小明");
        FriedListener xiaozhang = new FriedListener("小张");
        MomentsBus momentsBus = new MomentsBus(content);
        momentsBus.addListener(friend);
        momentsBus.addListener(xiaozhang);
        momentsBus.publish();
    }

}
