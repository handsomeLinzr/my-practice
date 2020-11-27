package com.example.pattern.factory.factorymethod;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 1:56 下午
 * @since V1.0.0
 */
public class FactoryMethodTest {

    @Test
    public void create() {
        ICourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.create().study();

        courseFactory = new PythonCourseFactory();
        courseFactory.create().study();

    }

}
