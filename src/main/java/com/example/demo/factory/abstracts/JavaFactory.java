package com.example.demo.factory.abstracts;

/**
 * @author LZR
 * @date 2020/10/10-21:02
 */
public class JavaFactory implements IFactory {
    @Override
    public IVideo video() {
        return new JavaVideo();
    }

    @Override
    public ISource source() {
        return new JavaSource();
    }
}
