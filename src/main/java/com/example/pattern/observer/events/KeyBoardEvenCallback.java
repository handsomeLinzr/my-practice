package com.example.pattern.observer.events;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/29 9:42 上午
 * @since V1.0.0
 */
public class KeyBoardEvenCallback {

    public void onKeyUp(Event event) {
        System.out.println("回调键盘弹起事件");
    }

    public void onKeyDown(Event event) {
        System.out.println("回调键盘按下事件");
    }

}
