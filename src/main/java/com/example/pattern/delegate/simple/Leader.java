package com.example.pattern.delegate.simple;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 经理 充当委派者角色，通过各种情况委派给员工A和员工B工作（也用了策略模式）
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/15 3:55 下午
 * @since V1.0.0
 */
public class Leader implements IEmployee {

    public static final Map<String, IEmployee> EMPLOYEE_MAP = new ConcurrentHashMap<>();

    public Leader() {
        EMPLOYEE_MAP.put("加密", new EmployeeA());
        EMPLOYEE_MAP.put("架构", new EmployeeB());
    }

    @Override
    public void doing(String command) {
        if (EMPLOYEE_MAP.containsKey(command)) {
            EMPLOYEE_MAP.get(command).doing(command);
            return;
        }
        System.out.println("404， 找不到");
    }
}
