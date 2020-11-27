package com.example.pattern.factory.abstractfactory;

/**
 * Description: python 视频
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 4:57 下午
 * @since V1.0.0
 */
public class PythonVide implements IVideo{
    @Override
    public void play() {
        System.out.println("play python video");
    }
}
