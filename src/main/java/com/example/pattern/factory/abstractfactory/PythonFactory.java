package com.example.pattern.factory.abstractfactory;

/**
 * Description: Python 工厂，生产Python的所有等级结构
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 4:54 下午
 * @since V1.0.0
 */
public class PythonFactory implements IFactory{
    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVide();
    }
}
