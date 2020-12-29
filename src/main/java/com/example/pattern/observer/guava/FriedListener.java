package com.example.pattern.observer.guava;

import com.example.pattern.observer.moments.Content;
import com.google.common.eventbus.Subscribe;

/**
 * Description: 朋友圈事件
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/29 9:48 上午
 * @since V1.0.0
 */
public class FriedListener {

    private String name;

    public FriedListener(String name) {
        this.name = name;
    }

    @Subscribe
    public void subscribe(Content content) {
        System.out.println("=================================================================");
        System.out.println("你好，" + this.name + "!您的朋友 " + content.getPublisher() + " 在" + this.name + "发布了一条标题为" + content.getTitle() + "的动态，内容如下");
        System.out.println(content.getContent());
        System.out.println("请及时处理");
    }

}