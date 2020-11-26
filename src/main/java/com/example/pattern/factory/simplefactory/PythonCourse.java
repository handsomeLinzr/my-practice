package com.example.pattern.factory.simplefactory;

/**
 * Description: Python 课程
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/26 2:10 下午
 * @since V1.0.0
 */
public class PythonCourse implements ICourse{
    @Override
    public void study() {
        System.out.println("learn Python course");
    }
}
