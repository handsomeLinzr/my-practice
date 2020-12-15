package com.example.pattern.delegate.simple;

/**
 * Description: 员工A
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/15 3:56 下午
 * @since V1.0.0
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("I AM EMPLOYEE A, I AM LONG FOR 加密");
    }
}
