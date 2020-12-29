package com.example.pattern.observer.guava;

import com.example.pattern.observer.moments.Content;
import com.google.common.eventbus.EventBus;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/29 9:54 上午
 * @since V1.0.0
 */
public class MomentsBus {

    private String name = "朋友圈";

    private EventBus eventBus = new EventBus();

    private Content content;

    public MomentsBus(Content content) {
        this.content = content;
        System.out.println("===============================================================");
        System.out.println(content.getPublisher() + "在" + this.name + "发布了一条动态");
    }

    // 发布消息
    public void addListener(FriedListener momentsListener) {
        eventBus.register(momentsListener);
    }

    public void publish() {
        eventBus.post(content);
    }

}
