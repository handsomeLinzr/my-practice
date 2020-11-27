package com.example.pattern.factory.simplefactory;

/**
 * Description: 简单工厂，多个对象塞在一个工厂
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/26 2:04 下午
 * @since V1.0.0
 */
public class CourseSimpleFactory {
    public static ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCourse();
        }
        throw new RuntimeException("error");
    }

    public static ICourse create(Class<? extends ICourse> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("error");
    }

}
