package com.example.pattern.factory.simplefactory;

/**
 * Description: JAVA课程
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/26 2:08 下午
 * @since V1.0.0
 */
public class JavaCourse implements ICourse{
    @Override
    public void study() {
        System.out.println("learn java course");
    }
}
