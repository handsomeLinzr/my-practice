package com.example.pattern.observer.moments;

import java.util.Observable;

/**
 * 朋友圈（被观察者）
 * @author LZR
 * @date 2020/12/27-18:35
 */
public class Moments extends Observable {

    private String name = "朋友圈";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 发布朋友圈
    public void publishContent(Content content) {
        System.out.println(content.getPublisher() + "在" + this.name + "发布了动态");
        System.out.println("=================================================================");
        setChanged();
        notifyObservers(content);
    }

}
