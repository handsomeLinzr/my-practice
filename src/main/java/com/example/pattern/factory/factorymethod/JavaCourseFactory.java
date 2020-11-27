package com.example.pattern.factory.factorymethod;

/**
 * Description: JAVA 课程工厂
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 1:54 下午
 * @since V1.0.0
 */
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
