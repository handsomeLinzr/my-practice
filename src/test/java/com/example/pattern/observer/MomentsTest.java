package com.example.pattern.observer;

import com.example.pattern.observer.moments.Content;
import com.example.pattern.observer.moments.Friend;
import com.example.pattern.observer.moments.Moments;
import org.junit.jupiter.api.Test;

/**
 * @author LZR
 * @date 2020/12/27-19:07
 */
public class MomentsTest {

    @Test
    public void test() {
        Content content = new Content("小明", "我是架构师", "我已经是个架构师了");
        Friend friend = new Friend("小东");
        Moments moments = new Moments();
        Friend lan = new Friend("小兰");
        // 建立关系（被观察者add上观察者）
        moments.addObserver(lan);
        moments.addObserver(friend);
        moments.publishContent(content);
    }

}
