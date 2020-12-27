package com.example.pattern.observer.moments;

import java.util.Observable;
import java.util.Observer;

/**
 * 朋友（观察者）
 * @author LZR
 * @date 2020/12/27-18:39
 */
public class Friend implements Observer {

    private String name;

    public Friend(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        // 强转获得被观察者和传递的参数
        Moments moments = (Moments)o;
        Content content = (Content)arg;

        System.out.println(name + ",你好，你的朋友在" + moments.getName() +
                "上发送了一个标题为 " + content.getTitle() + " 的动态给你， 内容为:");
        System.out.println(content.getContent());
        System.out.println("===================================================================");
    }
}
