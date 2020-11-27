package com.example.pattern.factory.factorymethod;

/**
 * Description: Python 课程工厂
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 1:55 下午
 * @since V1.0.0
 */
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
