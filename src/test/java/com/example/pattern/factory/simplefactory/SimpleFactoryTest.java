package com.example.pattern.factory.simplefactory;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/26 2:13 下午
 * @since V1.0.0
 */
public class SimpleFactoryTest {

    @Test
    public void createJavaCourse() {
        ICourse java = CourseSimpleFactory.create("java");
        java.study();
        ICourse python = CourseSimpleFactory.create("python");
        python.study();
    }

    @Test
    public void createPythonCourse() {
        ICourse java = CourseSimpleFactory.create(JavaCourse.class);
        java.study();

        ICourse python = CourseSimpleFactory.create(PythonCourse.class);
        python.study();

    }

}
