package com.example.pattern.observer.events;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/28 3:43 下午
 * @since V1.0.0
 */
public class Mouse extends EventListener{

    MouseEvenCallback mouseEvenCallback = new MouseEvenCallback();

    // 单击
    public void click() {
        System.out.println("==============鼠标单击================");
        trigger(MouseEvents.CLICK);
    }

    // 双击
    public void doubleClick() {
        System.out.println("==============鼠标双击================");
        trigger(MouseEvents.DOUBLE_CLICK);
    }

    // 移动
    public void move() throws NoSuchMethodException {
        System.out.println("==============鼠标移动================");

    }

    // 弹起
    public void up() {
        System.out.println("==============鼠标弹起================");
        trigger(MouseEvents.UP);
    }

    // 按下
    public void down() {
        System.out.println("==============鼠标按下================");
    }

    // 悬停
    public void over() {
        System.out.println("==============鼠标悬停================");
    }

}
