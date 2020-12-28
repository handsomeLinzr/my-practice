package com.example.pattern.observer.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 时间监听器
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/28 3:24 下午
 * @since V1.0.0
 */
public class EventListener {

    // 装事件的容器
    private Map<String, Event> eventMap = new HashMap<>();

    private static String methodFirstFlag = "on";

    // 注册事件
    public void addListener(String trigger, Object target) {
        try {
            addListener(trigger,
                        target,
                        target.getClass().getMethod(methodFirstFlag + toUpperFirstCase(trigger), Event.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addListener(String trigger, Object target, Method method) {
        eventMap.put(trigger, new Event(target, method));
    }

    // 首字母大写
    private String toUpperFirstCase(String trigger) {
        char[] chars = trigger.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    // 根据事件名执行
    public void trigger(String trigger) {
        if (eventMap.containsKey(trigger)) {
            trigger(eventMap.get(trigger));
        }
    }

    // 执行
    public void trigger(Event event) {
        // 设置事件源和时间触发时间
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        // 执行回调方法
        try {
            if (event.getCallback() != null) {
                event.getCallback().invoke(event.getTarget(), event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
