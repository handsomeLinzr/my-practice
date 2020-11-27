package com.example.pattern.factory.abstractfactory;

/**
 * Description: JAVA视频
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 4:51 下午
 * @since V1.0.0
 */
public class JavaVide implements IVideo{
    @Override
    public void play() {
        System.out.println("play JAVA video");
    }
}
