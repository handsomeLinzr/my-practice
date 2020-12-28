package com.example.pattern.observer.events;

import java.lang.reflect.Method;

/**
 * Description: 事件
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/28 3:22 下午
 * @since V1.0.0
 */
public class Event {

    // 事件发起者（事件源）
    private Object source;

    // 事件通知者（事件触发通知谁）
    private Object target;

    // 事件回调
    private Method callback;

    // 事件名称
    private String trigger;

    // 事件发生时间
    private long time;

    public Event(String trigger, Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Method getCallback() {
        return callback;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getTarget() {
        return target;
    }
}
