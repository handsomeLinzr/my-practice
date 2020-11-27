package com.example.pattern.factory.factorymethod;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 1:52 下午
 * @since V1.0.0
 */
public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("learn python course");
    }
}
