package com.example.pattern.factory.abstractfactory;

/**
 * Description: JAVA工厂，可以创建JAVA的所有产品等级结构
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 4:45 下午
 * @since V1.0.0
 */
public class JavaFactory implements IFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVide();
    }
}
