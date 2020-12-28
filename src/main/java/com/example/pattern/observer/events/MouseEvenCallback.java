package com.example.pattern.observer.events;

/**
 * Description: 事件回调(自己逻辑)
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/28 4:45 下午
 * @since V1.0.0
 */
public class MouseEvenCallback {

    public void onClick(Event event) {
        System.out.println("===============回调鼠标单击事件=============" + event.getTime());
    }

    public void onDoubleClick(Event event) {
        System.out.println("===============回调鼠标双击事件=============" + event.getTime());
    }

    public void onOver(Event event) {
        System.out.println("===============回调鼠标悬停事件=============" + event.getTime());
    }

    public void onDown(Event event) {
        System.out.println("===============回调鼠标按下事件=============" + event.getTime());
    }

    public void onUp(Event event) {
        System.out.println("===============回调鼠标弹起事件=============" + event.getTime());
    }

    public void onMove(Event event) {
        System.out.println("===============回调鼠标移动事件=============" + event.getTime());
    }

}
