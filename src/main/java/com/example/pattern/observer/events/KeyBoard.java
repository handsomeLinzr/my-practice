package com.example.pattern.observer.events;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/29 9:24 上午
 * @since V1.0.0
 */
public class KeyBoard extends EventListener{

    public void keyDown() {
        System.out.println("键盘按下");
        trigger(KeyBoardEvents.KEY_DOWN);
    }

    public void keyUp() {
        System.out.println("键盘弹起");
        trigger(KeyBoardEvents.KEY_UP);
    }



}
